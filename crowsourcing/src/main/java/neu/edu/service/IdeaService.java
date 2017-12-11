package neu.edu.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.idea.FundingCreation;
import neu.edu.controller.idea.IdeaCreation;
import neu.edu.controller.idea.ServiceCreation;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.CreatorDao;
import neu.edu.dao.FundingDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.ServiceDetailDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Category;
import neu.edu.entity.Creator;
import neu.edu.entity.Funding;
import neu.edu.entity.Idea;
import neu.edu.entity.ServiceDetail;

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
	

}
