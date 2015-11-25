package main.dao;

import main.User;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class UserDao {

    public ArrayList<User> getUsers() {
        return users;
    }

    private ArrayList<User> users;

    public UserDao() {
        users = new ArrayList<User>();
        users.add(new User("qwe", "qwe", "admin", "admin", new DateTime(100)));
        users.add(new User("qwe@qwe.qwe", "ewq", "qwe", "rty", new DateTime(100)));
        users.add(new User("asd@asd.com", "dsa", "asd", "fgh", new DateTime(100)));
        users.add(new User("zxc@zxc.com", "cxz", "zxc", "vbn", new DateTime(100)));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean findUser(String email) {
        for(User user : users) {
            if (email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String email) {
        for(User user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }
}
