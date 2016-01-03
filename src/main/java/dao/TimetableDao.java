package dao;

import model.Timetable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TimetableDao implements Dao {
    private EntityManager em;

    public TimetableDao(EntityManager em) {
        this.em = em;
    }

    public void addTimetable(Timetable timetable) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(timetable);
        transaction.commit();
    }

}
