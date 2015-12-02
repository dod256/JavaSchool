package main.java.services;

import main.java.Entities.Ticket;
import main.java.Entities.Train;
import main.java.Entities.User;
import main.java.dao.TicketDao;
import main.java.dto.TicketDto;
import main.java.dto.UserDto;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;

public class TicketService extends Service {
    private static TicketDao ticketDao = new TicketDao(em);

    public static void addTicket(Ticket ticket) {
        ticketDao.addTicket(ticket);
    }

    public static ArrayList<TicketDto> getTicketsByUser(UserDto userDto) {
        User user = User.newBuilder()
                .withUserTypeId(userDto.getId())
                .withEmail(userDto.getEmail())
                .withFirstName(userDto.getFirstName())
                .withLastName(userDto.getLastName())
                .withPassword(userDto.getPassword())
                .withBirthdate(new Date(userDto.getBirthdate().getMillis()))
                .withId(userDto.getId())
                .build();
        ArrayList<Ticket> ticketList = ticketDao.getTicketsByUser(user);
        ArrayList<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
        for(Ticket ticket : ticketList) {
            ticketDtoList.add(new TicketDto(ticket));
        }
        return ticketDtoList;
    }

    public static ArrayList<Ticket> getAllTickets() {
        return ticketDao.getTickets();
    }

    public static boolean isUserHadTicket(UserDto userDto, int trainId) {
        ArrayList<TicketDto> tickets = getTicketsByUser(userDto);
        Train train = TrainService.getTrain(trainId);
        for (TicketDto ticket: tickets) {
            if (ticket.getTrain().getId() == train.getId()) {
                return true;
            }
        }
        return false;
    }

}
