package neu.edu.controller.bid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.service.BidService;
@Controller
@RequestMapping("/bid")
public class BidController {
	@Autowired
	BidService bidService;
	@RequestMapping(path="/{username}/emailId/{serviceId}",method=RequestMethod.POST)
	public ResponseEntity<?> placeAbid(@PathVariable("username")String emailId,@PathVariable("serviceId")Integer serviceId,@RequestBody BidCreation bidCreation){
			ResponseEntity<?> resposeEntity=new ResponseEntity<>("Not able to bit",
					HttpStatus.UNPROCESSABLE_ENTITY);
			if(bidService.placeABid(emailId,serviceId,bidCreation)) {
				resposeEntity=new ResponseEntity<>("bidding successful",HttpStatus.OK);
			}
			
			return resposeEntity;
			
		}
	@RequestMapping(path="/{username}/emailId/accepted",method=RequestMethod.POST)
	public ResponseEntity<?> getAcceptedBid(@PathVariable("username")String emailId){
		ResponseEntity<?> resposeEntity=new ResponseEntity<>("unable to locate bids",
				HttpStatus.UNPROCESSABLE_ENTITY);
		List<BidCreation> bidCreations=bidService.getAccepted(emailId); 
			if(!bidCreations.isEmpty())
			resposeEntity=new ResponseEntity<>(bidCreations,HttpStatus.OK);
		
		return resposeEntity;
		
	}
	@RequestMapping(path="/{bidId}/awardBid",method=RequestMethod.GET)
	public ResponseEntity<?> getMyServiceAward(@PathVariable("bidId")Integer bidId) {
		ResponseEntity responseEntity=new ResponseEntity<>("ideas available for you or that category",HttpStatus.UNPROCESSABLE_ENTITY);
		bidService.awardBid(bidId);
		return responseEntity;	
	}
	
}
