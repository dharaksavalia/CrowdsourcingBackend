package neu.edu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;
import neu.edu.dao.PersonDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Person;
import neu.edu.entity.User;

@Service
public class UserService {
@Autowired
UserDao userDao;
@Autowired
PersonDao personDao;

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

}
