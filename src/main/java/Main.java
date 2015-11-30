package main.java;


import main.java.Entities.Ticket;
import main.java.Entities.Train;
import main.java.services.TicketService;
import main.java.services.TrainService;
import main.java.services.UserService;

public class Main {
    public static void main(String[] args){
        //System.out.println(TicketService.getTicketsByUser(UserService.getUserByEmail("david.koroteev@me")));
        System.out.println(TrainService.getAllTrains());
        TicketService.addTicket(Ticket.newBuilder()
                .withUser(UserService.getUserByEmail("andrey.mischenko@me"))
                .withTrain(TrainService.getTrain(1))
                .withRouteNumberOfArrivalStation(2)
                .withRouteNumberOfDepartureStation(1)
                .build());

        System.out.println(TicketService.getTicketsByUser(UserService.getUserByEmail("andrey.mischenko@me")));
    }


}
