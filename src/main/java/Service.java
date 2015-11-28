package main.java;

import main.java.builders.TrainDtoBuilder;
import main.java.dao.UserDao;
import main.java.dto.TimetableDto;
import main.java.dto.TrainDto;
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
    public static ArrayList<TrainDto> getTrains(TimetableDto timetableDto) {
        ArrayList<TrainDto> trainList = new ArrayList<TrainDto>();
        trainList.add(new TrainDtoBuilder()
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
