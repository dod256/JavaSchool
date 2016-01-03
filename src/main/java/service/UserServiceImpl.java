package service;

import dao.UserDao;
import model.User;
import dao.UserDaoImpl;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/*
*  Implements logic connected to users
*
* */
@Service
@Transactional
 public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() { return userDao.getUsers(); }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserByEmail(String email) { return userDao.getUserByEmail(email); }

}
