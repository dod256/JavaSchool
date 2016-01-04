package chuggaChugga.service;

import chuggaChugga.data.TicketRequest;
import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.model.Ticket;

import java.util.ArrayList;

public interface TicketService {
    ArrayList<TicketDto> getTicketsByUser(UserDto userDto);
    boolean tryToPurhaseTicket(TicketRequest request);
    ArrayList<Ticket> getTicketByTrain(int trainId);
}
