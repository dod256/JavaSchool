package main.java.services;

import main.java.Entities.User;
import main.java.dao.UserDao;
import main.java.dto.UserDto;

import java.util.ArrayList;

/*
*  Implements logic connected to users
*
* */
public class UserService extends Service {

    private static UserDao userDao = new UserDao(em);

    public static ArrayList<User> getUsers() { return userDao.getUsers(); }

    public static void addUser(UserDto userDto) {
        User user = new User(userDto);
        userDao.addUser(user);
    }

    public static User getUserByEmail(String email) { return userDao.getUserByEmail(email); }

}
