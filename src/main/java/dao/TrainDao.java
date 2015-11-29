package main.java.dao;

import main.java.Entities.Train;
import main.java.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class TrainDao implements Dao {

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

    public int getTrainTableSize() {
        TypedQuery<Train> query = em.createQuery("SELECT a FROM Train a", Train.class);
        return query.getResultList().size();
    }

    public ArrayList<Train> getAllTrains() {
        return (ArrayList<Train>) em.createQuery("SELECT a FROM Train a", Train.class).getResultList();
    }
}
