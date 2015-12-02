package main.java.services;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Service {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ChuggaChugga");
    protected static EntityManager em = emf.createEntityManager();


}
