package main.java;

import main.java.Entities.User;
import main.java.builders.TrainBuilder;
import main.java.dao.UserDao;
import main.java.dto.TimetableDto;
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

    public static ArrayList<User> getUsers() { return userDao.getUsers(); }

    public static void addUser(User user) { userDao.addUser(user); }

    public static boolean findUser(String email) { return userDao.findUser(email); }

    public static User getUser(String email) { return userDao.getUser(email); }

    //ToDo add logic
    public static ArrayList<Train> getTrains(TimetableDto timetableDto) {
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

}
