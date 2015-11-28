package main.java;

import main.java.Entities.Station;
import main.java.Entities.User;
import main.java.builders.TrainBuilder;
import main.java.dao.StationDao;
import main.java.dao.UserDao;
import main.java.data.Route;
import main.java.data.RouteRequest;
import main.java.data.TrainRequest;
import main.java.Entities.Train;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Service {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");

    private static EntityManager em = emf.createEntityManager();

    private static UserDao userDao = new UserDao(em);
    private static StationDao stationDao = new StationDao(em);

    public static void addStation(Station station) {
        stationDao.addStation(station);
    }

    public static ArrayList<User> getUsers() { return userDao.getUsers(); }

    public static void addUser(User user) { userDao.addUser(user); }


    public static User getUser(String email) { return userDao.getUser(email); }

    //ToDo add logic
    public static ArrayList<Train> getTrains(TrainRequest trainRequest) {
        ArrayList<Train> trainList = new ArrayList<Train>();
        trainList.add(new TrainBuilder()
                .setName("First, bitch")
                .setDepartureStation("Spb")
                .setArrivalStation("Msk")
                .setDepartureTime(DateTime.now())
                .setArrivalTime(DateTime.now())
                .setNumberOfSeats(1)
                .createTrainDto());
        return trainList;
    }

    //ToDo add logic
    public static ArrayList<Route> getRoutes(RouteRequest request) {
        return null;
    }

    //ToDo add logic
    public static ArrayList<Route> getAllRoutes() {
        return null;
    }


}
