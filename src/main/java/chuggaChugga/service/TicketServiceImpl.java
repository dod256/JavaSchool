package chuggaChugga.service;

import chuggaChugga.dao.TicketDao;
import chuggaChugga.model.Ticket;
import chuggaChugga.model.User;
import chuggaChugga.dao.TicketDaoImpl;
import chuggaChugga.data.TicketRequest;
import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
*  Implements logic connected to tickets
*
* */

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    public ArrayList<TicketDto> getTicketsByUser(UserDto userDto) {
        User user = new User(userDto);
        ArrayList<Ticket> ticketList = (ArrayList<Ticket>) ticketDao.getTicketsByUser(user);
        ArrayList<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
        for(Ticket ticket : ticketList) {
            ticketDtoList.add(new TicketDto(ticket));
        }
        return ticketDtoList;
    }

    public boolean tryToPurhaseTicket(TicketRequest request) {
        return ticketDao.tryToPurhaseTicket(request);
    }


    public ArrayList<Ticket> getTicketByTrain(int trainId) {
        return (ArrayList<Ticket>) ticketDao.getTicketByTrain(trainId);
    }
}
