package chuggaChugga.dao;

import chuggaChugga.model.Timetable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class TimetableDaoImpl implements TimetableDao {

    public void addTimetable(Timetable timetable) {
    /*    EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(timetable);
        transaction.commit();*/
    }

}
