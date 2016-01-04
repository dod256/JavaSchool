package chuggaChugga.dao;

import chuggaChugga.data.TicketRequest;
import chuggaChugga.model.Ticket;
import chuggaChugga.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TicketDao {
    List<Ticket> getTicketsByUser(User user);
    List<Ticket> getTicketByTrain(int trainId);
    boolean tryToPurhaseTicket(TicketRequest request);
}
