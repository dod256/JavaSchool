package chuggaChugga.dao;

import chuggaChugga.model.UserDataSet;

import java.util.List;


public interface UserDao {
    void addUser(UserDataSet user);
    UserDataSet getUser(int id);
    UserDataSet getUserByEmail(String email);
    List<UserDataSet> getUsers();
}
