package dao;

import model.User;

import java.util.List;

public interface UserDao extends Dao{

    public void addUser(User user);

    public User getUser(int id);

    public User getUserByEmail(String email);


    public List<User> getUsers();
}
