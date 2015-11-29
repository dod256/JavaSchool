package main.java.services;

import main.java.Entities.Train;
import main.java.dao.TrainDao;
import main.java.data.TrainRequest;
import main.java.data.TrainRoute;

import java.util.ArrayList;

public class TrainService extends Service {

    private static TrainDao trainDao = new TrainDao(em);

    //todo:addLogic
    public static ArrayList<Train> getTrains(TrainRequest trainRequest) {
        return null;
    }

    //ToDo add logic third priority!
    public static void createTrain(TrainRoute trainRoute) {

    }

}
