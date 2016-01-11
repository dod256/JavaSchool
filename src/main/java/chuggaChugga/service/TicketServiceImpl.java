package chuggaChugga.service;

import chuggaChugga.dao.TicketDao;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.domain.TicketDataSet;
import chuggaChugga.domain.TrainDataSet;
import chuggaChugga.domain.UserDataSet;
import chuggaChugga.data.TicketRequest;
import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import org.joda.time.LocalDateTime;
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
    @Autowired
    private TrainService trainService;
    @Autowired
    private StationService stationService;
    @Autowired
    private RouteService routeService;

    public ArrayList<TicketDto> getTicketsByUser(UserDto userDto) {
        UserDataSet user = UserDataSet.newBuilder(userDto).build();
        ArrayList<TicketDataSet> ticketList = (ArrayList<TicketDataSet>) ticketDao.getTicketsByUser(user);
        ArrayList<TicketDto> ticketDtoList = new ArrayList<>();
        for(TicketDataSet ticket : ticketList) {
            TrainDto train = new TrainDto(ticket.getTrain(), routeService.getRouteById(ticket.getTrain().getRouteId()));
            LocalDateTime departure = trainService.getDepartureDateTime(train,
                    stationService.getStationByName(ticket.getDepartureStation()));
            LocalDateTime arrival = trainService.getDepartureDateTime(train,
                    stationService.getStationByName(ticket.getArrivalStation()));
            ticketDtoList.add(new TicketDto(ticket, departure, arrival));
        }
        return ticketDtoList;
    }

    public boolean tryToPurchaseTicket(TicketRequest request) {
        boolean result = ticketDao.tryToPurchaseTicket(request);

        if (result) {
            int newBalance = request.getUser().getBalance() - request.getTrain().getCost();
            userService.updateUser(UserDto.newBuilder(request.getUser()).withBalance(newBalance).build());
            int seats = request.getTrain().getNumberOfFreeSeats();
            TrainDataSet train = request.getTrain();
            train.setNumberOfFreeSeats(seats - 1);
            trainService.updateTrain(train);
        }
        return result;
    }

    public ArrayList<TicketDataSet> getTicketByTrain(TrainDataSet train) {
        return (ArrayList<TicketDataSet>) ticketDao.getTicketByTrain(train);
    }
}
