package chuggaChugga.dao;

import chuggaChugga.domain.StationDataSet;
import chuggaChugga.domain.StationDistanceDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.ArrayList;

@Repository
public class StationDistanceDaoImpl implements StationDistanceDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void addDistance(StationDistanceDataSet stationDistance) {
        Session session = sessionFactory.openSession();
        session.persist(stationDistance);
        session.persist(StationDistanceDataSet.newBuilderReverse(stationDistance).build());
        session.close();
    }

    @Override
    public void updateDistance(StationDistanceDataSet stationDistance) {
        Session session = sessionFactory.openSession();
        session.update(stationDistance);
        session.flush();
        session.close();
    }

    @Override
    public StationDistanceDataSet findDistance(StationDataSet firstStation, StationDataSet secondStation) {
        return (StationDistanceDataSet) sessionFactory
                .openSession()
                .createCriteria(StationDistanceDataSet.class)
                .add(Restrictions.eq("firstStation", firstStation))
                .add(Restrictions.eq("secondStation", secondStation))
                .uniqueResult();
    }

    @Override
    public ArrayList<StationDistanceDataSet> findAllDistances(StationDataSet station) {
        return (ArrayList<StationDistanceDataSet>) sessionFactory
                .openSession()
                .createCriteria(StationDistanceDataSet.class)
                .add(Restrictions.eq("firstStation", station))
                .list();

    }
}
