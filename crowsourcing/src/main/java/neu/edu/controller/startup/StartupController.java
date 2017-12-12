package neu.edu.controller.startup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.controller.creator.CreatorCreation;
import neu.edu.service.StartupService;
/**
 * 
 * @author Dharak
 *Still yet to implement funtionality
 */
@RequestMapping("/startup")
@Controller
public class StartupController {
	@Autowired
	StartupService startupService;
	@RequestMapping("/{startupId}/delete")
	public ResponseEntity<?> deleteCategory(@PathVariable("startupId")Integer category){
		ResponseEntity<?> resposeEntity=new ResponseEntity<>("category deletion Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if(startupService.delete(category)) {
			resposeEntity=new ResponseEntity<>("startup deleted",HttpStatus.OK);
		}
		return resposeEntity;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getCreator(){
		ResponseEntity<?> resposeEntity=new ResponseEntity<>("cannot get creator",
				HttpStatus.UNPROCESSABLE_ENTITY);
		List<CreatorCreation>creatorCreation=startupService.getStartups();
		if(!creatorCreation.isEmpty())resposeEntity=new ResponseEntity<>(creatorCreation,
				HttpStatus.OK);
		return resposeEntity;
	}
	@RequestMapping("/{categoryId}/disable/{Reason}")
	public ResponseEntity<?> disCreator(@PathVariable("categoryId")Integer category,@PathVariable("Reason")String Reason){
		ResponseEntity<?> resposeEntity=new ResponseEntity<>("category deletion Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if(startupService.disable(category,Reason)) {
			resposeEntity=new ResponseEntity<>("category deleted",HttpStatus.OK);
		}
		return resposeEntity;
	}
	
}
