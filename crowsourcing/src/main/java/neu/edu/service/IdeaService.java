package neu.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.bid.BidCreation;
import neu.edu.controller.funder.PurchasesCreation;
import neu.edu.controller.idea.FundingCreation;
import neu.edu.controller.idea.IdeaCreation;
import neu.edu.controller.idea.ServiceCreation;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.CreatorDao;
import neu.edu.dao.FundingDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.ServiceDetailDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Bids;
import neu.edu.entity.Category;
import neu.edu.entity.Creator;
import neu.edu.entity.Funders;
import neu.edu.entity.Funding;
import neu.edu.entity.Idea;
import neu.edu.entity.Purchases;
import neu.edu.entity.ServiceDetail;
import neu.edu.entity.User;

@Service
public class IdeaService {
	@Autowired
	IdeaDao ideaDao;
	@Autowired
	FundingDao fundingDao;
	@Autowired
	ServiceDetailDao serviceDetailDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	UserDao userDao;
	@Autowired 
	CreatorDao creatorDao;
	@Transactional
	public boolean addIdea(IdeaCreation ideaCreation,String emailId) {
		// TODO Auto-generated method stub
		Idea idea=new Idea();
		idea.setName(ideaCreation.getName());
		idea.setDescription(ideaCreation.getDescription());
		idea.setIdeaDate(ideaCreation.getEndDate());
		idea.setTotalFund(ideaCreation.getTotalFunds());
		Creator creator=userDao.findByEmailId(emailId).get(0).getCreator();
		idea.setCreator(creator);
		List<Category>categorys=categoryDao.findByCatergoryName(ideaCreation.getCategory());
		System.out.println(idea.toString());
		System.out.println(ideaCreation.toString());
		if(categorys.size()>0)
		idea.setCategory(categorys.get(0));
		else return false;
		idea=ideaDao.save(idea);
		for(FundingCreation fundCreations:ideaCreation.getFundingCreations()) {
			Funding funding=new Funding();
			funding.setAmount(fundCreations.getAmount());
			funding.setMaxUser(fundCreations.getMaxUsers());
			funding.setUnit(fundCreations.getUnit());
			funding.setIdea(idea);
			fundingDao.save(funding);
		}
		for(ServiceCreation serviceCreations:ideaCreation.getServiceCreations()) {
			ServiceDetail service=new ServiceDetail();
			service.setIdea(idea);
			service.setMaxBidAmount(serviceCreations.getMaxBid());
			service.setServiceDes(serviceCreations.getDescription());
			service.setServiceEndDate(serviceCreations.getEndDate());
			serviceDetailDao.save(service);
			
		}
		Date date=new Date();
		creator.setLastIdeaDate(date.getTime());
		creatorDao.save(creator);
	return true;
	}
	@Transactional
	public List<IdeaCreation> getIdea(String category) {
		// TODO Auto-generated method stub
		List<IdeaCreation> ideaCreation=new ArrayList();
		List <Category>categories=categoryDao.findByCatergoryName(category);
		Category categoryEntity=null;
		if(!categories.isEmpty())
		categoryEntity=categories.get(0);
		List<IdeaCreation>ideacreations=new ArrayList<>();
		if(categoryEntity!=null)
		for(Idea idea:categoryEntity.getIdeas()) {
			IdeaCreation ideacreation=new IdeaCreation();
			ideacreation.setCategory(idea.getCategory().getCatergoryName());
			ideacreation.setEndDate(idea.getIdeaDate());
			ideacreation.setDescription(idea.getDescription());
			ideacreation.setName(idea.getName());
			ideacreation.setIdeaId(idea.getIdeaId());
			ArrayList<FundingCreation>fundingCreations=new ArrayList<>();
			for(Funding funding:idea.getFundings()) {
				FundingCreation fundcreation=new FundingCreation();
				fundcreation.setAmount(funding.getAmount());
				fundcreation.setMaxUsers(((funding.getMaxUser())));
				fundcreation.setUnit(funding.getUnit());
				fundcreation.setFundingId(funding.getFundingId());
				fundingCreations.add(fundcreation);
				
			}
			ideacreation.setFundingCreations(fundingCreations);
			ArrayList<ServiceCreation>ServiceCreations=new ArrayList<>();
			for(ServiceDetail servicedetail:idea.getServiceDetails()) {
				ServiceCreation servicecreation=new ServiceCreation();
				servicecreation.setDescription(servicedetail.getServiceDes());
				servicecreation.setServiceId(servicedetail.getServiceId());
				servicecreation.setEndDate(servicedetail.getServiceEndDate());
				servicecreation.setMaxBid(servicedetail.getMaxBidAmount());
				ServiceCreations.add(servicecreation);
			}
			ideacreation.setServiceCreations(ServiceCreations);
			ideacreations.add(ideacreation);
		}
		return ideacreations;

	}
	public List<IdeaCreation> getMyIdea(String emailId) {
		// TODO Auto-generated method stub
		List<IdeaCreation>ideacreations=new ArrayList<>();
		List<User>users=userDao.findByEmailId(emailId);
		if(!users.isEmpty())
		for(Idea idea:users.get(0).getCreator().getIdeas()) {
			IdeaCreation ideacreation=new IdeaCreation();
			ideacreation.setCategory(idea.getCategory().getCatergoryName());
			ideacreation.setEndDate(idea.getIdeaDate());
			ideacreation.setDescription(idea.getDescription());
			ideacreation.setName(idea.getName());
			ideacreation.setIdeaId(idea.getIdeaId());
			ArrayList<FundingCreation>fundingCreations=new ArrayList<>();
			for(Funding funding:idea.getFundings()) {
				FundingCreation fundcreation=new FundingCreation();
				fundcreation.setAmount(funding.getAmount());
				fundcreation.setMaxUsers(((funding.getMaxUser())));
				fundcreation.setUnit(funding.getUnit());
				fundcreation.setFundingId(funding.getFundingId());
				fundingCreations.add(fundcreation);
				
			}
			ideacreation.setFundingCreations(fundingCreations);
			ArrayList<ServiceCreation>ServiceCreations=new ArrayList<>();
			for(ServiceDetail servicedetail:idea.getServiceDetails()) {
				ServiceCreation servicecreation=new ServiceCreation();
				servicecreation.setDescription(servicedetail.getServiceDes());
				servicecreation.setServiceId(servicedetail.getServiceId());
				servicecreation.setEndDate(servicedetail.getServiceEndDate());
				servicecreation.setMaxBid(servicedetail.getMaxBidAmount());
				ServiceCreations.add(servicecreation);
			}
			ideacreation.setServiceCreations(ServiceCreations);
			ideacreations.add(ideacreation);
		}
		return ideacreations;
	}
	public List<BidCreation> getBidding(String emailId, Integer serviceId) {
		ServiceDetail serviceDetail= serviceDetailDao.findOne(serviceId);
		ArrayList<BidCreation>bidCreations=new ArrayList<>();
		for(Bids bid:serviceDetail.getBidses()) {
			BidCreation bidCreation=new BidCreation();
			bidCreation.setBidAmount(bid.getBidAmount());
			bidCreation.setDescription(bid.getDescription());
			bidCreation.setTimeRequired(bid.getTimeRequired());
			bidCreation.setBidId(bid.getBidId());
			bidCreations.add(bidCreation);
		}
		return bidCreations;
	}
	public List<PurchasesCreation> getFunding(String emailId) {
		// TODO Auto-generated method stub
		List<PurchasesCreation>fundings=new ArrayList<>();
		for(User user:userDao.findByEmailId(emailId)) {
			for(Idea idea :user.getCreator().getIdeas()) {
				for(Funding funding:idea.getFundings()) {
					for(Purchases purchases:funding.getPurchaseses()) {
						PurchasesCreation purchasesCreation=new PurchasesCreation();
						purchasesCreation.setName(purchases.getFunders().getFunderName());
						purchasesCreation.setAmount(purchases.getFunding().getAmount());
						fundings.add(purchasesCreation);
					}
				}
			}
		}
		return fundings;
	}
	
	

}
