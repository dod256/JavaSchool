package main.java;

import main.java.data.NewRoute;
import main.java.services.RouteService;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        //System.out.println(StationService.getTimetable(StationService.getStation("Moscow"), new DateTime().withDate(2015, 12, 1)));


        /*TicketRequest request = TicketRequest.newBuilder().withTrainId(2)
                .withArrivalStation("Salavat")
                .withDepartureStation("Tver")
                .withUserDto(new UserDto(UserService.getUserByEmail("alena.koroteeva@me"))).build();
        System.out.println(TicketService.tryToByTicket(request));

        ArrayList<Integer> waitingTime = new ArrayList<Integer>();
        ArrayList<Integer> onWheel = new ArrayList<Integer>();
        ArrayList<String> stations = new ArrayList<String>();
        waitingTime.add(0);
        waitingTime.add(10);
        waitingTime.add(20);

        onWheel.add(0);
        onWheel.add(40);
        onWheel.add(30);

        stations.add("Tver");
        stations.add("Ufa");
        stations.add("Omsk");

        NewRoute newRoute = NewRoute.newBuilder().withDepartureTime(new DateTime().withTime(10,0,0,0)).withOnWheel(onWheel).withStation(stations).withWaitingTime(waitingTime).build();

        RouteService.createRoute(newRoute);*/
    }
}
