package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import neu.edu.controller.user.UserCreation;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.CreatorDao;
import neu.edu.dao.FundersDao;
import neu.edu.dao.PersonDao;
import neu.edu.dao.StartupDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Category;
import neu.edu.entity.Creator;
import neu.edu.entity.Funders;
import neu.edu.entity.Person;
import neu.edu.entity.Startup;
import neu.edu.entity.User;

@Service
public class UserService implements UserDetailsService{
	String ADMIN="Yes";
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
@Autowired
FundersDao fundersDao;
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
			if(userCreation.getFunders()!=null)
			if(userCreation.getFunders().equals("Yes")) {
				makeUserFunder(userCreation.getEmailId());
			}
			if(userCreation.getStartup()!=null)
			if(userCreation.getStartup().equals("Yes")) {
				makeUserStartup(userCreation.getEmailId(),userCreation.getCategory());
			}
			if(userCreation.getStartup()!=null)
			if(userCreation.getCreator().equals("Yes")) {
				makeUserCreator(userCreation.getEmailId());
			}
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

public boolean makeUserFunder(String emailId) {
	// TODO Auto-generated method stub
	User user=getUser(emailId);
	if(user.getFunders()==null) {
		Funders funder=new Funders();
		funder=fundersDao.save(funder);
		if(funder.getFunderId()!=null) {
			user.setFunders(funder);
			userDao.save(user);
			return true;
		}
	}
	return false;
}
public boolean makeAdmin(String emailId) {
	// TODO Auto-generated method stub
	User user=userDao.findByEmailId(emailId).get(0);
	user.setAdmin(ADMIN);
	user=userDao.save(user);
	if(user!=null) {
		return true;
	}
	return false;
}
public boolean isUserCreator(String emailId) {
	// TODO Auto-generated method stub
	User user;
	List users=userDao.findByEmailId(emailId);
	if(users.size()>0) {
		System.out.println("able to find user");
		user=(User)users.get(0);
	}else return false;
	if(user!=null) {
		if(user.getCreator()!=null) {
			return true;
		}
	}
	return false;
}
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	
	List<User> users = userDao.findByEmailId(username);
	 System.out.println("username="+username);
	  if(users.isEmpty()) {
          throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
      }
	  User user=users.get(0);
	  List<GrantedAuthority> authorities = new ArrayList<>();
	  if(user.getAdmin()!=null) {
			authorities.add(new SimpleGrantedAuthority("Admin"));

	  }
	  if(user.getCreator()!=null) {
			authorities.add(new SimpleGrantedAuthority("Creator"));

	  }
	  if(user.getCreator()!=null) {
			authorities.add(new SimpleGrantedAuthority("Startup"));

	  }
	  if(user.getCreator()!=null) {
			authorities.add(new SimpleGrantedAuthority("Funder"));

	  }	
	
  UserDetails userDetails = new org.springframework.security.core.userdetails.
          User(user.getEmailId(), user.getPassword(), authorities);

	return userDetails;
	
}
}
