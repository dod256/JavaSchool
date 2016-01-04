package chuggaChugga.dao;

import chuggaChugga.model.RouteLength;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RouteLengthDaoImpl implements RouteLengthDao {

    public void addRouteLength(RouteLength routeLength) {
        /*EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(routeLength);
        transaction.commit();*/
    }

    public List<RouteLength> getAllRouteLength() {
       // return em.createQuery("from RouteLength").getResultList();
        return null;
    }


}
