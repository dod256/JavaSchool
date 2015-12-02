package main.java;

import main.java.data.TrainRequest;
import main.java.services.StationService;
import main.java.services.TrainService;
import org.joda.time.DateTime;

public class Main {
    public static void main(String[] args){
        //System.out.println(StationService.getTimetable(StationService.getStation("Moscow"), new DateTime().withDate(2013, 7, 19)));

        //System.out.println("----------------------------------------------------------");

        TrainRequest request = TrainRequest.newBuilder().withArrivalStation("Salavat")
                .withDepartureStation("Tver").withDate(new DateTime().withDate(2013, 7, 20)).build();
        System.out.println(TrainService.getTrains(request));
    }
}
