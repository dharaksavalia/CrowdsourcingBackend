package neu.edu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.CreatorDao;
import neu.edu.dao.PersonDao;
import neu.edu.dao.StartupDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Category;
import neu.edu.entity.Creator;
import neu.edu.entity.Person;
import neu.edu.entity.Startup;
import neu.edu.entity.User;

@Service
public class UserService {
@Autowired
UserDao userDao;
@Autowired
PersonDao personDao;
@Autowired
CreatorDao creatorDao;
@Autowired
CategoryDao categoryDao;
@Autowired
StartupDao startupDao;
@Transactional
public boolean createUser(UserCreation userCreation) {
	// TODO Auto-generated method stub
	if(isUserPresent(userCreation.getEmailId())) {
		return false;
	}
	Person person=new Person();
	person.setFirstName(userCreation.getFirstName());
	person.setLastName(userCreation.getLastName());
	personDao.save(person);
	System.out.println(person.getFirstName());
	if(person!=null) {
		User user=new User();
		user.setPerson(personDao.findByFirstNameAndLastName(userCreation.getFirstName(), userCreation.getLastName()).get(0));
		user.setEmailId(userCreation.getEmailId());
		user.setPassword(userCreation.getPassword());
		user=userDao.save(user);
		if(user!=null) {
			return true;
		}
	}
	
	return false;
}
@Transactional
public Boolean isUserPresent(String emailId) {
	
	if(getUser(emailId)==null) return false;
	else return true;
}
@Transactional
public User getUser(String emailId) {
	List<User> users;
	users=userDao.findByEmailId(emailId);
	if(users.size()>0)return users.get(0);
	else return null;
}
@Transactional
public boolean makeUserCreator(String emailId) {
	// TODO Auto-generated method stub
	User user=getUser(emailId);
	if(user.getCreator()==null) {
		Creator creator=new Creator();
		creator=creatorDao.save(creator);
		if(creator.getCreatorId()!=null) {
			user.setCreator(creator);
			userDao.save(user);
			return true;
		}
	}
	return false;
}
@Transactional
public boolean makeUserStartup(String emailId, String categoryName) {
	System.out.println(emailId+categoryName);
	for(Category category1:categoryDao.findByCatergoryName(categoryName)) {
		if(category1.getCatergoryName().equals(categoryName)) {
			if(isUserPresent(emailId)) {
				User user=userDao.findByEmailId(emailId).get(0);
				Startup startup=new Startup();
				startup.setCategory(category1);
				startup=startupDao.save(startup);
				user.setStartup(startup);
				System.out.println("startup Id"+startup.getStartupId());
				user=userDao.save(user);
				if(user!=null)return true;
			}
		}
	}
	return false;

}
}
