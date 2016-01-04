package chuggaChugga.dao;

import chuggaChugga.model.Station;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StationDaoImpl implements StationDao {

    public void addStation(Station station) {
        /*
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(station);
        transaction.commit();*/
    }

    public Station getStation(String name) {
        /*return (Station) em.createQuery("from Station where name = '" + name + "'")
                            .getResultList()
                            .get(0);*/
        return null;
    }

    public List<Station> getAllStations() {
        /*TypedQuery<Station> query = em.createQuery("SELECT a FROM Station a", Station.class);
        return query.getResultList();*/
        return null;
    }


}
