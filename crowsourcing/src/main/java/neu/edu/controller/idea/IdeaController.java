package neu.edu.controller.idea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.service.IdeaService;
import neu.edu.service.UserService;

@RequestMapping("/idea")
@Controller
public class IdeaController {

	
	@Autowired
	IdeaService ideaService;
	@Autowired
	UserService userService;
	@RequestMapping(path="/{emailId}/submit",method=RequestMethod.POST)
	public ResponseEntity<?> createIdea(@RequestBody IdeaCreation ideaCreation,@PathVariable("emailId")String emailId) {
		ResponseEntity responseEntity=new ResponseEntity<>("idea not created or not allowed",HttpStatus.UNPROCESSABLE_ENTITY);
		System.out.println("email Id"+emailId);
		if(userService.isUserCreator(emailId)) {
			ideaService.addIdea(ideaCreation,emailId);
		 responseEntity=new ResponseEntity<>("idea created ",HttpStatus.OK);
		}
		return responseEntity;
		
	}
	@RequestMapping(path="/{category}",method=RequestMethod.GET)
	public ResponseEntity<?> getIdea(@PathVariable("category")String category) {
		ResponseEntity responseEntity=new ResponseEntity<>("ideas available for you or that category",HttpStatus.UNPROCESSABLE_ENTITY);
		System.out.println("category"+category);
			List<IdeaCreation> ideaCreations=ideaService.getIdea(category);
			if(!ideaCreations.isEmpty())
		 responseEntity=new ResponseEntity<>(ideaCreations,HttpStatus.OK);
		return responseEntity;
		
	}
	@RequestMapping(path="/{emailId}/myideas",method=RequestMethod.GET)
	public ResponseEntity<?> getMyIdea(@PathVariable("emailId")String emailId) {
		ResponseEntity responseEntity=new ResponseEntity<>("ideas available for you or that category",HttpStatus.UNPROCESSABLE_ENTITY);
		System.out.println("category"+emailId);
			List<IdeaCreation> ideaCreations=ideaService.getMyIdea(emailId);
			if(!ideaCreations.isEmpty())
		 responseEntity=new ResponseEntity<>(ideaCreations,HttpStatus.OK);
		return responseEntity;
		
	}

}
