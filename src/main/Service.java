package main;

import main.dao.UserDao;

import java.util.ArrayList;

public class Service {

    static private UserDao userDao = new UserDao();

    static public ArrayList<User> getUsers() { return userDao.getUsers(); }
}
