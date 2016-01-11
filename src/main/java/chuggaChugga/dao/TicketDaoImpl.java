package chuggaChugga.dao;

import chuggaChugga.model.TicketDataSet;
import chuggaChugga.model.TrainDataSet;
import chuggaChugga.model.UserDataSet;
import chuggaChugga.data.TicketRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public boolean tryToPurchaseTicket(TicketRequest request) {
        Session session = sessionFactory.openSession();

        TrainDataSet train = request.getTrain();

        if (train.getCost() > request.getUser().getBalance()) {
            //todo: add logging! (not enough money)
            session.close();
            return false;
        }

        if (train.getNumberOfFreeSeats() == 0) {
            //todo: add logging! (current train have not free seats any more)
            //and throw exception!!!
            session.close();
            return false;
        }
        DateTime departureDateTime = new DateTime(train.getDepartureDate());
        departureDateTime = departureDateTime.plus(train.getDepartureStation().getArrival().getTime());
        if (!DateTime.now().plusMinutes(10).isBefore(departureDateTime)) {
            //todo: add logging! (it's tool late to buy ticket at this train)
            session.close();
            return false;
        }

        ArrayList<TicketDataSet> tickets =
                (ArrayList<TicketDataSet>) getTicketsByUser(UserDataSet.newBuilder(request.getUser()).build());
        for (TicketDataSet ticket: tickets) {
            if (ticket.getTrain().equals(train)) {
                //todo: add logging! (user already have ticket at this train)
                session.close();
                return false;
            }
        }

        TicketDataSet ticket = TicketDataSet.newBuilder().withUser(UserDataSet.newBuilder(request.getUser()).build())
                .withDepartureStation(request.getDepartureStation())
                .withArrivalStation(request.getArrivalStation())
                .withTrain(train)
                .build();

        session.save(ticket);
        session.flush();
        session.close();
        return true;
    }

    public List<TicketDataSet> getTicketsByUser(UserDataSet user) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(TicketDataSet.class);

        return (List<TicketDataSet>) criteria
                .add(Restrictions.eq("user", user))
                .list();
    }


    public List<TicketDataSet> getTicketByTrain(TrainDataSet train) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(TicketDataSet.class);
        return (List<TicketDataSet>) criteria
                .add(Restrictions.eq("train", train))
                .list();
    }
}
