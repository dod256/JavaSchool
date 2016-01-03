package chuggaChugga.service;

import chuggaChugga.dao.UserDao;
import chuggaChugga.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/*
*  Implements logic connected to users
*
* */

 public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    public List<User> getUsers() { return userDao.getUsers(); }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserByEmail(String email) { return userDao.getUserByEmail(email); }

}
