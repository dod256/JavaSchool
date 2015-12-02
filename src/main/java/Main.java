package main.java;

import main.java.data.TicketRequest;
import main.java.dto.UserDto;
import main.java.services.TicketService;
import main.java.services.UserService;

public class Main {
    public static void main(String[] args){
        TicketRequest request = TicketRequest.newBuilder().withTrainId(2)
                .withArrivalStation("Salavat")
                .withDepartureStation("Tver")
                .withUserDto(new UserDto(UserService.getUserByEmail("alena.koroteeva@me"))).build();
        System.out.println(TicketService.tryToByTicket(request));
    }
}
