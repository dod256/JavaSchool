package chuggaChugga.dao;

import chuggaChugga.domain.UserDataSet;

import java.util.List;


public interface UserDao {
    void addUser(UserDataSet user);
    void updateUser(UserDataSet user);
    UserDataSet getUser(int id);
    UserDataSet getUserByEmail(String email);
    List<UserDataSet> getUsers();
}
