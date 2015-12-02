package main.java;

import main.java.data.TicketRequest;
import main.java.dto.UserDto;
import main.java.services.StationService;
import main.java.services.TicketService;
import main.java.services.UserService;
import org.joda.time.DateTime;

public class Main {
    public static void main(String[] args){

        System.out.println(StationService.getTimetable(StationService.getStation("Moscow"), new DateTime().withDate(2015, 12, 1)));


        /*TicketRequest request = TicketRequest.newBuilder().withTrainId(2)
                .withArrivalStation("Salavat")
                .withDepartureStation("Tver")
                .withUserDto(new UserDto(UserService.getUserByEmail("alena.koroteeva@me"))).build();
        System.out.println(TicketService.tryToByTicket(request));*/
    }
}
