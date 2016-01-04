package chuggaChugga.dao;

import chuggaChugga.model.Ticket;
import chuggaChugga.model.Train;
import chuggaChugga.model.User;
import chuggaChugga.data.TicketRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao{

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public boolean tryToPurhaseTicket(TicketRequest request) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Train train = (Train) session.get(Train.class, request.getTrainId());
        if (train.getNumberOfFreeSeats() == 0) {
            //todo: add logging! (current train have not free seats any more)
            //and throw exception!!!
            transaction.commit();
            session.close();
            return false;
        }
        DateTime departureDateTime = new DateTime(train.getDepartureDate());
        departureDateTime = departureDateTime.plus(train.getDepartureStation().getArrival().getTime());
        if (!DateTime.now().plusMinutes(10).isBefore(departureDateTime)) {
            //todo: add logging! (it's tool late to buy ticket at this train)
            transaction.commit();
            session.close();
            return false;
        }

        ArrayList<Ticket> tickets = (ArrayList<Ticket>) getTicketsByUser(new User(request.getUserDto()));
        for (Ticket ticket: tickets) {
            if (ticket.getTrain().equals(train)) {
                //todo: add logging! (user already have ticket at this train)
                transaction.commit();
                session.close();
                return false;
            }
        }

        Ticket ticket = Ticket.newBuilder().withUser(new User(request.getUserDto()))
                .withDepartureStation(request.getDepartureStation())
                .withArrivalStation(request.getArrivalStation())
                .withTrain(train)
                .build();

        session.save(ticket);
        train.setNumberOfFreeSeats(train.getNumberOfFreeSeats() - 1);

        transaction.commit();
        session.close();
        return true;
    }

    public List<Ticket> getTicketsByUser(User user) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Ticket.class);

        return (List<Ticket>) criteria
                .add(Restrictions.eq("user", user))
                .list();
    }


    public List<Ticket> getTicketByTrain(int trainId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Ticket.class);
        return (List<Ticket>) criteria
                .add(Restrictions.eq("train", trainId))
                .list();
    }
}
