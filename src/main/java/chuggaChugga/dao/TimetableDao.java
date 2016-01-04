package chuggaChugga.dao;

import chuggaChugga.model.Timetable;
import org.springframework.stereotype.Repository;


public interface TimetableDao {
    void addTimetable(Timetable timetable);
}
