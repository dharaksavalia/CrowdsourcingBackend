package neu.edu.controller.category;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.service.CategoryService;
@RequestMapping("/category")
@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@RequestMapping("/{category}")
	public ResponseEntity<?> createCategory(@PathVariable("category")String category){
		
		ResponseEntity<?> resposeEntity=new ResponseEntity<>("category creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if(categoryService.addCategory(category)) {
			resposeEntity=new ResponseEntity<>("category created",HttpStatus.OK);
		}
		return resposeEntity;
	}
	@RequestMapping("/delete/{category}")
public ResponseEntity<?> deleteCategory(@PathVariable("category")String category){
		ResponseEntity<?> resposeEntity=new ResponseEntity<>("deletion failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if(categoryService.deleteACategory(category)) {
			resposeEntity=new ResponseEntity<>("deleted category",HttpStatus.OK);
		}
		
		return resposeEntity;
		
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getCategory(){
		
		ResponseEntity<?> resposeEntity=new ResponseEntity<>("category not available",
				HttpStatus.UNPROCESSABLE_ENTITY);
		List<String>categories=categoryService.getCategory();
		if(!categories.isEmpty())
			resposeEntity=new ResponseEntity<>(categories,HttpStatus.OK);
		
		return resposeEntity;
	}
}
