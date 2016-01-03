package dao;

import model.RouteLength;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;

public class RouteLengthDao implements Dao {
    private EntityManager em;

    public RouteLengthDao(EntityManager em) {
        this.em = em;
    }

    public void addRouteLength(RouteLength routeLength) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(routeLength);
        transaction.commit();
    }

    public ArrayList<RouteLength> getAllRouteLength() {
        return (ArrayList<RouteLength>) em.createQuery("from RouteLength").getResultList();
    }


}
