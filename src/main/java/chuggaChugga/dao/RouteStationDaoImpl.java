package chuggaChugga.dao;

import chuggaChugga.model.RouteStation;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RouteStationDaoImpl implements RouteStationDao {
    //todo:refactor

   // private SessionFactory sessionFactory;


    public List<RouteStation> getRouteStationsById(int routeId) {
    //    Query query = em.createQuery("from RouteStation where routeId = " + routeId);
    //    return query.getResultList();
        return null;
    }

    public List<RouteStation> getAllRouteStations() {
        //return em.createQuery("from RouteStation").getResultList();
        return null;
    }

    public void addRouteStation(RouteStation station) {
        /*EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(station);
        transaction.commit();*/
    }
}
