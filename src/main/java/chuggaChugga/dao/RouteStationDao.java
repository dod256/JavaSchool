package chuggaChugga.dao;

import chuggaChugga.model.RouteStation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;

public class RouteStationDao implements Dao {
    private EntityManager em;

    public RouteStationDao(EntityManager em) {
        this.em = em;
    }

    public ArrayList<RouteStation> getRouteStationsBy(int routeId) {
        Query query = em.createQuery("from RouteStation where routeId = " + routeId);
        return (ArrayList<RouteStation>) query.getResultList();
    }

    public ArrayList<RouteStation> getAllRouteStations() {
        return (ArrayList<RouteStation>) em.createQuery("from RouteStation").getResultList();
    }

    public void addRouteStation(RouteStation station) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(station);
        transaction.commit();
    }
}
