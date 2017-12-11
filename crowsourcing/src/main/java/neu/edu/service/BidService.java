package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.bid.BidCreation;
import neu.edu.dao.BidDao;
import neu.edu.dao.ServiceDetailDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Bids;
import neu.edu.entity.ServiceDetail;
import neu.edu.entity.User;

@Service
public class BidService {
	@Autowired
	ServiceDetailDao serviceDetailDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BidDao bidDao;
	@Transactional
	public boolean placeABid(String emailId, Integer serviceId, BidCreation bidCreation) {
		// TODO Auto-generated method stub
		List<User>users=userDao.findByEmailId(emailId);
		if(!users.isEmpty()) {
			if(users.get(0).getStartup()!=null) {
				ServiceDetail serviceDetail=serviceDetailDao.findOne(serviceId);
				if(serviceDetail!=null) {
					if(bidCreation.getBidAmount()<=serviceDetail.getMaxBidAmount()) {
						if(bidCreation.getTimeRequired()<=bidCreation.getTimeRequired()) {
							Bids bid=new Bids();
							bid.setBidAmount(bidCreation.getBidAmount());
							bid.setTimeRequired(bidCreation.getTimeRequired());
							bid.setDescription(bidCreation.getDescription());
							bid.setServiceDetail(serviceDetail);
							bid.setStartup(users.get(0).getStartup());
							bidDao.save(bid);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public List<BidCreation> getAccepted(String emailId) {
		// TODO Auto-generated method stub
		List<BidCreation>BidCreation=new ArrayList<>();
		
		for(Bids bid:bidDao.findByStartup(userDao.findByEmailId(emailId).get(0).getStartup())) {
			if(bid.getStatus()!=null)
			if(bid.getStatus().equals("Yes")) {
			BidCreation bidCreation=new BidCreation();
			bidCreation.setBidAmount(bid.getBidAmount());
			bidCreation.setBidId(bid.getBidId());
			bidCreation.setDescription(bid.getDescription());
			bidCreation.setTimeRequired(bid.getTimeRequired());
			BidCreation.add(bidCreation);
		}
		}
		return BidCreation;
	}

}
