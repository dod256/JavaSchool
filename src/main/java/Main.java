package main.java;


import main.java.services.StationService;
import main.java.services.TrainService;
import org.joda.time.DateTime;

public class Main {
    public static void main(String[] args){
        DateTime time = new DateTime().withDate(2015,11,12);
        System.out.println(time.plusHours(25));


        System.out.println(new DateTime( TrainService.getTrain(1).getDepartureDate()));
        System.out.println(StationService.getTimetable(StationService.getStation("StPetersburg"),
               new DateTime().withDate(2013,7,20)));
    }


}
