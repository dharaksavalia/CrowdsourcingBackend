package neu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.dao.UserDao;

@Service
public class UserService {
@Autowired
UserDao userDao;

}
