package main.java.service;

import main.java.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserService {
    private EntityManager em;

    public UserService(EntityManager em) {
        this.em = em;
    }

    public void addUser(User user) {
        em.persist(user);
    }

    public boolean findUser(String email) {
        User user = em.find(User.class, email);
        return user != null;
    }

    public User getUser(String email) {
        if (findUser(email)) {return em.find(User.class, email);}
        return null;
    }

    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("SELECT a FROM User a", User.class);
        return query.getResultList();
    }
}
