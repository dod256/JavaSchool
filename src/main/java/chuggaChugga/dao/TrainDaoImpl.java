package chuggaChugga.dao;

import chuggaChugga.model.Train;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainDaoImpl implements TrainDao {


    public void addTrain(Train train) {
        /*
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(train);
        transaction.commit();*/
    }

    //todo: rewrite
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
