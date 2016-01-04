package chuggaChugga.dao;

import chuggaChugga.model.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainDaoImpl implements TrainDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;


    public void addTrain(Train train) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.save(train);
        transaction.commit();
        session.close();
    }


    public int getTrainTableSize() {
        /*
        TypedQuery<Train> query = em.createQuery("SELECT a FROM Train a", Train.class);
        return query.getResultList().size();*/
        return 0;
    }

    //todo: rewrite
    public List<Train> getAllTrains() {
        //return em.createQuery("SELECT a FROM Train a", Train.class).getResultList();
        return null;
    }

    public Train getTrain(int id) {
     //   return em.find(Train.class, id);
        return null;
    }
}
