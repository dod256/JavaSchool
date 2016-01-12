package chuggaChugga.dao;

import chuggaChugga.data.TicketRequest;
import chuggaChugga.domain.TicketDataSet;
import chuggaChugga.domain.TrainDataSet;
import chuggaChugga.domain.UserDataSet;

import java.sql.Date;
import java.util.List;

public interface TicketDao {
    List<TicketDataSet> getTicketsByUser(UserDataSet user);
    List<TicketDataSet> getTicketsByUserFromPeriod(UserDataSet user, Date firstDate, Date secondDate);
    List<TicketDataSet> getTicketByTrain(TrainDataSet train);
    boolean tryToPurchaseTicket(TicketRequest request);
    List<TicketDataSet> getAllTicket();
}
