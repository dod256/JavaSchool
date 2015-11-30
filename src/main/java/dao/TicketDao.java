package main.java.dao;

import main.java.Entities.Ticket;
import main.java.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;

public class TicketDao implements Dao {
    private EntityManager em;

    public TicketDao(EntityManager em) {
        this.em = em;
    }

    public void addTicket(Ticket ticket) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket);
        transaction.commit();
    }


    public ArrayList<Ticket> getTicketsByUser(User user) {
        return (ArrayList<Ticket>) user.getTickets();
    }
}
