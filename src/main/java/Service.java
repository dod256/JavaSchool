package main.java;

import main.java.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Service {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");

    private static EntityManager em = emf.createEntityManager();

    private static UserDao userDao = new UserDao(em);

    public static ArrayList<User> getUsers() { return userDao.getUsers(); }

    public static void addUser(User user) { userDao.addUser(user); }

    public static boolean findUser(String email) { return userDao.findUser(email); }

    public static User getUser(String email) { return userDao.getUser(email); }


}
