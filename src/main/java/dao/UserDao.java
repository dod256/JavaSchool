package main.java.dao;

import main.java.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class UserDao implements Dao {

    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public void addUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    public User getUser(String email) {
        return em.find(User.class, email);
    }

    public ArrayList<User> getUsers() {
        TypedQuery<User> query = em.createQuery("SELECT a FROM User a", User.class);
        return (ArrayList<User>) query.getResultList();
    }
}
