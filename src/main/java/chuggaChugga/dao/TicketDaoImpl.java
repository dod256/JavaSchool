package chuggaChugga.dao;

import chuggaChugga.model.Ticket;
import chuggaChugga.model.Train;
import chuggaChugga.model.User;
import chuggaChugga.data.TicketRequest;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao{
    //todo: refactor


    public boolean tryToPurhaseTicket(TicketRequest request) {
       /* EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Train train = em.find(Train.class, request.getTrainId());
        if (train.getNumberOfFreeSeats() == 0) {
            //todo: add logging! (current train have not free seats any more)
            //and throw exception!!!
            transaction.commit();
            return false;
        }
        DateTime departureDateTime = new DateTime(train.getDepartureDate());
        departureDateTime = departureDateTime.plus(train.getDepartureStation().getArrival().getTime());
        if (!DateTime.now().plusMinutes(10).isBefore(departureDateTime)) {
            //todo: add logging! (it's tool late to buy ticket at this train)
            transaction.commit();
            return false;
        }

        ArrayList<Ticket> tickets = (ArrayList<Ticket>) getTicketsByUser(new User(request.getUserDto()));
        for (Ticket ticket: tickets) {
            if (ticket.getTrain().equals(train)) {
                //todo: add logging! (user already have ticket at this train)
                transaction.commit();
                return false;
            }
        }

        Ticket ticket = Ticket.newBuilder().withUser(new User(request.getUserDto()))
                .withDepartureStation(request.getDepartureStation())
                .withArrivalStation(request.getArrivalStation())
                .withTrain(train)
                .build();

        em.persist(ticket);
        train.setNumberOfFreeSeats(train.getNumberOfFreeSeats() - 1);

        transaction.commit();*/
        return true;
    }

    public List<Ticket> getTicketsByUser(User user) {
        //Query query = em.createQuery("from Ticket where userId = " + user.getId());
        //return query.getResultList();
        return null;
    }


    public List<Ticket> getTicketByTrain(int trainId) {
        /*Query query = em.createQuery("from Ticket where trainId = " + trainId);
        return query.getResultList();*/
        return null;
    }
}
