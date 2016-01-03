package chuggaChugga.dao;

import chuggaChugga.model.Station;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

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
        return (Station) em.createQuery("from Station where name = '" + name + "'")
                            .getResultList()
                            .get(0);
    }

    public ArrayList<Station> getAllStations() {
        TypedQuery<Station> query = em.createQuery("SELECT a FROM Station a", Station.class);
        return (ArrayList<Station>) query.getResultList();
    }


}
