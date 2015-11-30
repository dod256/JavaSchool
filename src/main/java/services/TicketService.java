package main.java.services;

import main.java.Entities.Ticket;
import main.java.Entities.Train;
import main.java.Entities.User;
import main.java.dao.TicketDao;
import java.util.ArrayList;

public class TicketService extends Service {
    private static TicketDao ticketDao = new TicketDao(em);

    public static void addTicket(Ticket ticket) {
        ticketDao.addTicket(ticket);
    }

    public static ArrayList<Ticket> getTicketsByUser(User user) {
        return ticketDao.getTicketsByUser(user);
    }

    public static ArrayList<Ticket> getAllTickets() {
        return ticketDao.getTickets();
    }

    public static boolean isUserHadTicket(User user, int trainId) {
        ArrayList<Ticket> tickets = getTicketsByUser(user);
        Train train = TrainService.getTrain(trainId);
        for (Ticket ticket: tickets) {
            if (ticket.getTrain().equals(train)) {
                return true;
            }
        }
        return false;
    }

}
