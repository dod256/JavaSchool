package main.java.services;

import main.java.Entities.User;
import main.java.dao.UserDao;

import java.util.ArrayList;

public class UserService extends Service {

    private static UserDao userDao = new UserDao(em);

    public static ArrayList<User> getUsers() { return userDao.getUsers(); }

    public static void addUser(User user) { userDao.addUser(user); }

    public static User getUser(String email) { return userDao.getUser(email); }

}
