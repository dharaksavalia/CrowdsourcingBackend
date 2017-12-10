package neu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;
import neu.edu.dao.UserDao;

@Service
public class UserService {
@Autowired
UserDao userDao;

public UserModel createUser(UserCreation userCreation) {
	// TODO Auto-generated method stub
	return null;
}

}
