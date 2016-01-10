package chuggaChugga.service;

import chuggaChugga.dao.TicketDao;
import chuggaChugga.dao.UserDao;
import chuggaChugga.model.TicketDataSet;
import chuggaChugga.model.TrainDataSet;
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
    @Autowired
    private UserService userService;

    public ArrayList<TicketDto> getTicketsByUser(UserDto userDto) {
        UserDataSet user = UserDataSet.newBuilder(userDto).build();
        ArrayList<TicketDataSet> ticketList = (ArrayList<TicketDataSet>) ticketDao.getTicketsByUser(user);
        ArrayList<TicketDto> ticketDtoList = new ArrayList<>();
        for(TicketDataSet ticket : ticketList) {
            ticketDtoList.add(new TicketDto(ticket));
        }
        return ticketDtoList;
    }

    public boolean tryToPurchaseTicket(TicketRequest request) {
        boolean result = ticketDao.tryToPurchaseTicket(request);

        if (result) {
            int newBalance = request.getUser().getBalance() - request.getTrain().getCost();
            userService.updateUser(UserDto.newBuilder(request.getUser()).withBalance(newBalance).build());//todo: check if work!
            int seats = request.getTrain().getNumberOfFreeSeats();
            request.getTrain().setNumberOfFreeSeats(seats - 1);
        }
        return result;
    }

    public ArrayList<TicketDataSet> getTicketByTrain(TrainDataSet train) {
        return (ArrayList<TicketDataSet>) ticketDao.getTicketByTrain(train);
    }
}
