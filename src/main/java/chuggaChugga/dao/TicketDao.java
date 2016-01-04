package chuggaChugga.dao;

import chuggaChugga.data.TicketRequest;
import chuggaChugga.model.TicketDataSet;
import chuggaChugga.model.UserDataSet;

import java.util.List;


public interface TicketDao {
    List<TicketDataSet> getTicketsByUser(UserDataSet user);
    List<TicketDataSet> getTicketByTrain(int trainId);
    boolean tryToPurhaseTicket(TicketRequest request);
}
