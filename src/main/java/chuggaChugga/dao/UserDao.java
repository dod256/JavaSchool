package chuggaChugga.dao;

import chuggaChugga.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends Dao{

    public void addUser(User user);

    public User getUser(int id);

    public User getUserByEmail(String email);


    public List<User> getUsers();
}
