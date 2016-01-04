package chuggaChugga.service;

import chuggaChugga.dao.TicketDao;
import chuggaChugga.model.TicketDataSet;
import chuggaChugga.model.UserDataSet;
import chuggaChugga.data.TicketRequest;
import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/*
*  Implements logic connected to tickets
*
* */

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    public ArrayList<TicketDto> getTicketsByUser(UserDto userDto) {
        UserDataSet user = new UserDataSet(userDto);
        ArrayList<TicketDataSet> ticketList = (ArrayList<TicketDataSet>) ticketDao.getTicketsByUser(user);
        ArrayList<TicketDto> ticketDtoList = new ArrayList<>();
        for(TicketDataSet ticket : ticketList) {
            ticketDtoList.add(new TicketDto(ticket));
        }
        return ticketDtoList;
    }

    public boolean tryToPurhaseTicket(TicketRequest request) {
        return ticketDao.tryToPurhaseTicket(request);
    }


    public ArrayList<TicketDataSet> getTicketByTrain(int trainId) {
        return (ArrayList<TicketDataSet>) ticketDao.getTicketByTrain(trainId);
    }
}
