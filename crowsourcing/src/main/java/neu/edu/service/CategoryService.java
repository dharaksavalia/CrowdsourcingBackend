package neu.edu.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.dao.CategoryDao;
import neu.edu.entity.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	
	@Transactional
	public boolean addCategory(String category) {
		// TODO Auto-generated method stub
		if(findACategory(category)==null) {
			Category category1=new Category();
			category1.setCatergoryName(category);
			System.out.println("category");
			categoryDao.save(category1);
			return true;
		}
		return false;
	}
	@Transactional
	public Category findACategory(String category) {
		for(Category category1:categoryDao.findAll()) {
			if(category1.getCatergoryName().equals(category))
				return category1;
		}
		return null;
	}
	@Transactional
	public boolean deleteACategory(String categoryName) {
		Category category=findACategory(categoryName);
		if(category!=null) {
			categoryDao.delete(category);
			return true;
		}
	return false;
	}

}
