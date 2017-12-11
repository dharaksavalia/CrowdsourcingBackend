package neu.edu.controller.idea;

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
}
