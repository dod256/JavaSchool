package main.java.dao;

import main.java.Entities.Train;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TrainDao {

    private EntityManager em;

    public TrainDao(EntityManager em) {
        this.em = em;
    }

    public void addTrain(Train train) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(train);
        transaction.commit();
    }



}
