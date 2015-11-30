package main.java.dao;

import main.java.Entities.Ticket;
import main.java.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
        Query query = em.createQuery("from Ticket where userId = " + user.getId());
        return (ArrayList<Ticket>) query.getResultList();
    }

    public ArrayList<Ticket> getTickets() {
        Query query = em.createQuery("from Ticket");
        return (ArrayList<Ticket>) query.getResultList();
    }
}
