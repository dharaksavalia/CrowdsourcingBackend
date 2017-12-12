package neu.edu.controller.funder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.controller.idea.IdeaCreation;
import neu.edu.service.FunderService;
import neu.edu.service.IdeaService;

@RequestMapping("/funder")
@Controller
public class FunderController {
	@Autowired
	FunderService funderService;
	@Autowired
	IdeaService ideaService;
	@RequestMapping(path="/{emailId}/emailId",method=RequestMethod.POST)
	public ResponseEntity<?> FundeIdea(@RequestBody FunderCreation funderCreation,@PathVariable("emailId")String emailId) {
		ResponseEntity responseEntity=new ResponseEntity<>("was not able to fund",HttpStatus.UNPROCESSABLE_ENTITY);
		if(funderService.fundThisIdeas(funderCreation,emailId)) {
			
		 responseEntity=new ResponseEntity<>("was able fund",HttpStatus.OK);
		}
		return responseEntity;
		
	}
	@RequestMapping(path="/guest",method=RequestMethod.POST)
	public ResponseEntity<?> FundeIdeaByGuest(@RequestBody FunderCreation funderCreation) {
		ResponseEntity responseEntity=new ResponseEntity<>("was not able to fund",HttpStatus.UNPROCESSABLE_ENTITY);
		if(funderService.fundThisIdeas(funderCreation)) {
			
		 responseEntity=new ResponseEntity<>("was able fund",HttpStatus.OK);
		}
		return responseEntity;
		
	}
	@RequestMapping(path="/{emailId}/myPurchases")
	public ResponseEntity<?> getIdea(@PathVariable("emailId")String emailId) {
		ResponseEntity responseEntity=new ResponseEntity<>("was not able to fund",HttpStatus.UNPROCESSABLE_ENTITY);
		List<PurchasesCreation>purchasesCreations=funderService.getIdea(emailId); 
		if(!purchasesCreations.isEmpty()) {	
		 responseEntity=new ResponseEntity<>(purchasesCreations,HttpStatus.OK);
		}
		return responseEntity;
		
	}
	@RequestMapping(path="/{emailId}/getFunding",method=RequestMethod.GET)
	public ResponseEntity<?> getMyFunding(@PathVariable("emailId")String emailId) {
		ResponseEntity responseEntity=new ResponseEntity<>("ideas available for you or that category",HttpStatus.UNPROCESSABLE_ENTITY);
		System.out.println("category"+emailId);
			List<PurchasesCreation> fundings=ideaService.getFunding(emailId);
			if(!fundings.isEmpty())
		 responseEntity=new ResponseEntity<>(fundings,HttpStatus.OK);
		return responseEntity;
		
	}
}
