package main.java.services;

import main.java.Entities.RouteStation;
import main.java.Entities.Timetable;
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

    public static void createTrain(TrainRoute trainRoute) {
        trainDao.addTrain(trainRoute.getTrain());

        Train trainWithId = Train.newBuilder(trainRoute.getTrain()).withId(trainDao.getTrainTableSize()).build();

        for (RouteStation routeStation : trainRoute.getRoute().getRouteStations()) {
            Timetable.Builder timetableBuilder = Timetable.newBuilder();
            timetableBuilder.withTrain(trainWithId).withRouteStation(routeStation);

            TimetableService.addTimetable(timetableBuilder.build());
        }
    }



}
