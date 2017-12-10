package neu.edu.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

		ResponseEntity<?> responseEntity = new ResponseEntity<>("User Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		UserModel userProfile = null;
		if ((userProfile = userService.createUser(userCreation)) != null) {
			responseEntity = new ResponseEntity<>(userProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
}
