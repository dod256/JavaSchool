package main.java.dao;

import main.java.Entities.User;
import main.java.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;

public class UserDao {

    private EntityManager em;
    private UserService service;

    public UserDao(EntityManager em) {
        this.em = em;
        this.service = new UserService(em);
    }

    public void addUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        service.addUser(user);
        transaction.commit();
    }

    public User getUser(String email) {
        return service.getUser(email);
    }

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) service.getUsers();
    }
}