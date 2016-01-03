package service;

import model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void addUser(User user);

    public User getUserByEmail(String email);
}
