package chuggaChugga.dao;

import chuggaChugga.model.TimetableDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class TimetableDaoImpl implements TimetableDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addTimetable(TimetableDataSet timetable) {
        Session session = sessionFactory.openSession();
        session.save(timetable);
        session.close();
    }
}
