package chuggaChugga.service;

import chuggaChugga.model.Timetable;
import chuggaChugga.dao.TimetableDao;

/*
*  Implements connection between trains and routes in DB
*
* */
public class TimetableService extends Service {

    private static TimetableDao timetableDao = new TimetableDao(em);

    public static void addTimetable(Timetable timetable) {
        timetableDao.addTimetable(timetable);
    }

}
