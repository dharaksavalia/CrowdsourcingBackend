package neu.edu.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.service.UserService;
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@Valid @RequestBody UserCreation userCreation) {
		System.out.println(userCreation.toString());
		ResponseEntity<?> responseEntity = new ResponseEntity<>("User Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.createUser(userCreation)) {
			System.out.println("Post");
			responseEntity = new ResponseEntity<>(userCreation.getEmailId(), HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(path="/{emailId}/creator")
	public ResponseEntity<?> makeMeCreator(@PathVariable("emailId") String emailId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Creator failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.makeUserCreator(emailId)) {
			System.out.println("Post");
			responseEntity = new ResponseEntity<>("You are creator", HttpStatus.OK);
		}
		return responseEntity;
	}
	@RequestMapping(path="/{emailId}/startup/{category}")
	public ResponseEntity<?> makeMeStartup(@PathVariable("emailId") String emailId,@PathVariable("category")String Category) {
		System.out.println("Stratup "+emailId);
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Cannot make you startup",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if (userService.makeUserStartup(emailId,Category)) {
			System.out.println("inside");
			responseEntity = new ResponseEntity<>("You are Startup", HttpStatus.OK);
		}
		return responseEntity;
	}
	@RequestMapping(path="/{emailId}/funder")
	public ResponseEntity<?> makeMeFunder(@PathVariable("emailId") String emailId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Cannot make you funder",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.makeUserFunder(emailId)) {
			System.out.println("inside");
			responseEntity = new ResponseEntity<>("You are funder", HttpStatus.OK);
		}
		return responseEntity;
	}
	@RequestMapping(path="/{emailId}/admin")
	public ResponseEntity<?> makeAdmin(@PathVariable("emailId") String emailId){
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Admin",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.makeAdmin(emailId)) {
			System.out.println("inside");
			responseEntity = new ResponseEntity<>("Admin Made", HttpStatus.OK);
		}
		return responseEntity;
	}
	 
	
	
}

