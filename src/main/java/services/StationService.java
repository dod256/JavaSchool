package main.java.services;


import main.java.Entities.Station;
import main.java.dao.StationDao;

import java.util.ArrayList;

public class StationService extends Service {

    private static StationDao stationDao = new StationDao(em);

    public static void addStation(Station station) {
        stationDao.addStation(station);
    }
    public static Station getStation(String name) {
        return stationDao.getStation(name);
    }
    public static ArrayList<Station> getAllStations() {return stationDao.getAllStations();}

}
