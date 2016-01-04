package chuggaChugga.dao;

import chuggaChugga.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    void addUser(User user);
    User getUser(int id);
    User getUserByEmail(String email);
    List<User> getUsers();
}
