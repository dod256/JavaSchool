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
        users.add(new User("qwe", "admin", "admin", new DateTime(100)));
        users.add(new User("qwe@qwe.qwe", "qwe", "rty", new DateTime(100)));
        users.add(new User("asd@asd.com", "asd", "fgh", new DateTime(100)));
        users.add(new User("zxc@zxc.com", "zxc", "vbn", new DateTime(100)));
    }
}
