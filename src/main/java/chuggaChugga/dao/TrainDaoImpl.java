package chuggaChugga.dao;

import chuggaChugga.domain.StationDataSet;
import chuggaChugga.domain.TrainDataSet;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class TrainDaoImpl implements TrainDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void addTrain(TrainDataSet train) {
        Session session = sessionFactory.openSession();
        session.save(train);
        session.close();
    }

    @Override
    public void updateTrain(TrainDataSet train) {
        Session session = sessionFactory.openSession();
        session.update(train);
        session.flush();
        session.close();
    }

    public int getTrainTableSize() {
        return sessionFactory
                    .openSession()
                    .createCriteria(TrainDataSet.class)
                    .list()
                    .size();
    }

    public List<TrainDataSet> getAllTrains() {
        return (List<TrainDataSet>) sessionFactory
                    .openSession()
                    .createCriteria(TrainDataSet.class)
                    .list();
    }

    @Override
    public List<TrainDataSet> getAllTrainsWhichPassStation(StationDataSet station) {
        Session session = sessionFactory.openSession();
        String s = "select train.* from train inner join (select * from routestation where " +
                "routestation.stationId =" + station.getId() + ") as A on train.routeId = A.routeId;";
        SQLQuery query = session.createSQLQuery(s);
        query.addEntity(TrainDataSet.class);
        List<TrainDataSet> trainList = query.list();
        session.close();
        return trainList;
    }

    public TrainDataSet getTrain(int id) {
        return (TrainDataSet) sessionFactory.openSession()
                    .createCriteria(TrainDataSet.class)
                    .add(Restrictions.eq("id", id))
                    .uniqueResult();
    }
}
