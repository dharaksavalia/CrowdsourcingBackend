package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.funder.FunderCreation;
import neu.edu.controller.funder.PurchasesCreation;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.FundersDao;
import neu.edu.dao.FundingDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.PurchasesDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Funders;
import neu.edu.entity.Funding;
import neu.edu.entity.Idea;
import neu.edu.entity.Purchases;
import neu.edu.entity.User;

@Service
public class FunderService {
	private String SUPERUSEREMAIL="a@a.com";//guest can login using this
@Autowired
PurchasesDao purchasesDao;
@Autowired
UserDao userDao;
@Autowired
FundersDao funderDao;
@Autowired
FundingDao fundingDao;
@Autowired
IdeaDao ideaDao;



public boolean fundThisIdeas(FunderCreation funderCreation, String emailId) {
	// TODO Auto-generated method stub
	if(!UnitsAvaliable(funderCreation))return false;
	for(Integer fundingId:funderCreation.getCategoryIds()) {
		DecreaseUnitsAddAmount(fundingId);
		storePurchases(emailId,fundingId);
	}
	storeCardDetails(emailId,funderCreation);
	return true;
}
public boolean fundThisIdeas(FunderCreation funderCreation) {
	// TODO Auto-generated method stub
	String emailId=null;
	fundThisIdeas(funderCreation,emailId);
	return false;
}
@Transactional
public boolean UnitsAvaliable(FunderCreation funderCreation) {
	
	for(Integer i:funderCreation.getCategoryIds()) {
		if(fundingDao.getOne(i).getMaxUser()<0) {
			return false;
		}
	}
	return true;
	
}
@Transactional
public void DecreaseUnitsAddAmount(Integer i) {
		Funding funding=fundingDao.getOne(i);
		Idea idea=funding.getIdea();
		idea.setReceivedFund(idea.getReceivedFund()+funding.getAmount());
		funding.setMaxUser(funding.getMaxUser()-1);
		idea=ideaDao.save(idea);
		funding.setIdea(idea);
		fundingDao.save(funding);	
	
}
@Transactional
public void storePurchases(String emailId,Integer fundingId) {
	if(emailId==null) {
	emailId=SUPERUSEREMAIL;	
	}
	Funding funding=fundingDao.getOne(fundingId);
	User user=userDao.findByEmailId(emailId).get(0);
	
	Purchases purchases=new Purchases();
	purchases.setFunding(funding);
	purchases.setFunders(user.getFunders());
	purchasesDao.save(purchases);
	
}
@Transactional
public void storeCardDetails(String emailId,FunderCreation funderCreation) {
	User user=userDao.findByEmailId(emailId).get(0);
	Funders funders=user.getFunders();
	funders.setCardNo(funderCreation.getCardNo());
	funders.setCvv(funderCreation.getCvv());
	funders.setFunderAddress(funderCreation.getFunderAddress());
	funders.setExpDate(funderCreation.getExpDate());
	funders.setFunderName(funderCreation.getFundName());
	funderDao.save(funders);
}
@Transactional
public List<PurchasesCreation> getIdea(String emailId) {
	// TODO Auto-generated method stub
	List<PurchasesCreation>purchasesCreations=new ArrayList<>();
	List<User>users=userDao.findByEmailId(emailId);
	for(Purchases purchases:users.get(0).getFunders().getPurchaseses()) {
		PurchasesCreation purchasesCreation=new PurchasesCreation();
		purchasesCreation.setAmount(purchases.getFunding().getAmount());
		purchasesCreation.setName(purchases.getFunding().getIdea().getName());
		purchasesCreations.add(purchasesCreation);
	}
	return purchasesCreations;
}


}
