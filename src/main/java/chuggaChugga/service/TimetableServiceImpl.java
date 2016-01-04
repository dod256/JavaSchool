package chuggaChugga.service;

import chuggaChugga.dao.TimetableDao;
import chuggaChugga.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
*  Implements connection between trains and routes in DB
*
* */

@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private TimetableDao timetableDao;

    public void addTimetable(Timetable timetable) {
        timetableDao.addTimetable(timetable);
    }

}
