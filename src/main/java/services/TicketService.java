package main.java.services;

import main.java.Entities.Ticket;
import main.java.Entities.User;
import main.java.dao.TicketDao;
import main.java.data.TicketRequest;
import main.java.dto.TicketDto;
import main.java.dto.UserDto;
import java.util.ArrayList;

/*
*  Implements logic connected to tickets
*
* */
public class TicketService extends Service {
    private static TicketDao ticketDao = new TicketDao(em);

    public static ArrayList<TicketDto> getTicketsByUser(UserDto userDto) {
        User user = new User(userDto);
        ArrayList<Ticket> ticketList = ticketDao.getTicketsByUser(user);
        ArrayList<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
        for(Ticket ticket : ticketList) {
            ticketDtoList.add(new TicketDto(ticket));
        }
        return ticketDtoList;
    }

    public static boolean tryToPurhaseTicket(TicketRequest request) {
        return ticketDao.tryToPurhaseTicket(request);
    }


    public static ArrayList<Ticket> getTicketByTrain(int trainId) {
        return ticketDao.getTicketByTrain(trainId);
    }
}
