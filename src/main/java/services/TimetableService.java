package main.java.services;

import main.java.Entities.Timetable;
import main.java.dao.TimetableDao;

public class TimetableService extends Service {

    private static TimetableDao timetableDao = new TimetableDao(em);

    public static void addTimetable(Timetable timetable) {
        timetableDao.addTimetable(timetable);
    }

}
