package main.java.dao;

import main.java.Entities.Station;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StationDao implements Dao {
    private EntityManager em;

    public StationDao(EntityManager em) {
        this.em = em;
    }

    public void addStation(Station station) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(station);
        transaction.commit();
    }

    public Station getStation(String name) {
        return em.find(Station.class, name);
    }
 //   public void todo: add getter!!

}
