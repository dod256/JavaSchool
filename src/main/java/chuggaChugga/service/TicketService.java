package chuggaChugga.service;

import chuggaChugga.data.TicketForReport;
import chuggaChugga.data.TicketRequest;
import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.domain.TicketDataSet;
import chuggaChugga.domain.TrainDataSet;
import java.sql.Date;
import java.util.ArrayList;

public interface TicketService {
    ArrayList<TicketDto> getTicketsByUser(UserDto userDto);
    boolean tryToPurchaseTicket(TicketRequest request);
    ArrayList<TicketDataSet> getTicketByTrain(TrainDataSet train);
    ArrayList<TicketForReport> getTicketsReport(Date firstDate, Date secondDate);
}
