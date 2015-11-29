package main.java.dao;

import main.java.Entities.RouteStation;
import main.java.Entities.User;

import javax.persistence.EntityManager;
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


}