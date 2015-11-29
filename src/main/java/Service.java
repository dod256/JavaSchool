package main.java;

import main.java.Entities.Station;
import main.java.Entities.User;
import main.java.dao.StationDao;
import main.java.dao.UserDao;
import main.java.data.Route;
import main.java.data.RouteRequest;
import main.java.data.TrainRequest;
import main.java.Entities.Train;
import main.java.data.TrainRoute;
import main.java.services.RouteService;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Service {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");

    protected static EntityManager em = emf.createEntityManager();

    private static UserDao userDao = new UserDao(em);
    private static StationDao stationDao = new StationDao(em);

    public static void addStation(Station station) {
        stationDao.addStation(station);
    }
    public static Station getStation(String name) {
        return stationDao.getStation(name);
    }
    public static ArrayList<Station> getAllStations() {return stationDao.getAllStations();}

    public static ArrayList<User> getUsers() { return userDao.getUsers(); }

    public static void addUser(User user) { userDao.addUser(user); }

    public static User getUser(String email) { return userDao.getUser(email); }

    //ToDo add logic (mocked temprorary)
    public static ArrayList<Train> getTrains(TrainRequest trainRequest) {
        ArrayList<Train> trainList = new ArrayList<Train>();
        trainList.add(Train.newBuilder()
                .withName("First, bitch")
                .withDepartureStation(1)
                .withArrivalStation(3)
                .withDepartureDate(DateTime.now())
                .withNumberOfSeats(1)
                .build());
        return trainList;
    }

    //ToDo: please use RouteService.getRoutes() instead of it
    public static ArrayList<Route> getRoutes(RouteRequest request) {
        return RouteService.getRoutes(request);
    }

    //ToDo: please use RouteService.getRouteById() instead of it
    public static Route getRouteById(int routeId) {
        return RouteService.getRouteById(routeId);
    }

    //ToDo: please use RouteService.getAllRoutes() instead of it
    public static ArrayList<Route> getAllRoutes() {
        /*ArrayList<Route> routeList = new ArrayList<Route>();
        routeList.add(Route.newBuilder()
                            .withRouteId(1)
                            .withStations(getAllStations())
                            .build());
        return routeList;*/
        return RouteService.getAllRoutes();
    }


    //ToDo add logic third priority!
    public static void addTrain(TrainRoute trainRoute) {
        //make some magic
    }


}
