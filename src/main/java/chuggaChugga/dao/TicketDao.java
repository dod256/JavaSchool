package chuggaChugga.dao;

import chuggaChugga.data.TicketRequest;
import chuggaChugga.domain.TicketDataSet;
import chuggaChugga.domain.TrainDataSet;
import chuggaChugga.domain.UserDataSet;

import java.util.List;


public interface TicketDao {
    List<TicketDataSet> getTicketsByUser(UserDataSet user);
    List<TicketDataSet> getTicketByTrain(TrainDataSet train);
    boolean tryToPurchaseTicket(TicketRequest request);
}
