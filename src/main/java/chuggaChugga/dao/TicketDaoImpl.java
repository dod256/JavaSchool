package chuggaChugga.dao;

import chuggaChugga.domain.TicketDataSet;
import chuggaChugga.domain.TrainDataSet;
import chuggaChugga.domain.UserDataSet;
import chuggaChugga.data.TicketRequest;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(TicketDaoImpl.class);

    public boolean tryToPurchaseTicket(TicketRequest request) {
        Session session = sessionFactory.openSession();

        TrainDataSet train = request.getTrain();

        if (train.getCost() > request.getUser().getBalance()) {
            logger.error("User " + request.getUser() + " could not purchase ticket because he have not enough money");
            session.close();
            return false;
        }

        if (train.getNumberOfFreeSeats() == 0) {
            logger.error("User " + request.getUser() + " could not purchase ticket because train "
                    + request.getTrain() + "have not got enough free seats any more");
            session.close();
            return false;
        }
        DateTime departureDateTime = new DateTime(train.getDepartureDate());
        departureDateTime = departureDateTime.plus(train.getDepartureStation().getArrival().getTime());
        if (!DateTime.now().plusMinutes(10).isBefore(departureDateTime)) {
            logger.error("User " + request.getUser() + " could not purchase ticket because train "+ train.toString() +
                "ill arrive less then by 10 minutes");
            session.close();
            return false;
        }

        ArrayList<TicketDataSet> tickets =
                (ArrayList<TicketDataSet>) getTicketsByUser(UserDataSet.newBuilder(request.getUser()).build());
        for (TicketDataSet ticket: tickets) {
            if (ticket.getTrain().equals(train)) {
                logger.error("User " + request.getUser() + " already have ticket on this train");
                session.close();
                return false;
            }
        }

        TicketDataSet ticket = TicketDataSet.newBuilder().withUser(UserDataSet.newBuilder(request.getUser()).build())
                .withDepartureStation(request.getDepartureStation())
                .withArrivalStation(request.getArrivalStation())
                .withTrain(train)
                .withPurchaseDate(Date.valueOf(LocalDate.now()))
                .build();

        session.save(ticket);
        session.flush();
        session.close();
        return true;
    }

    @Override
    public List<TicketDataSet> getAllTicket() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(TicketDataSet.class);

        return (List<TicketDataSet>) criteria.list();
    }

    public List<TicketDataSet> getTicketsByUser(UserDataSet user) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(TicketDataSet.class);

        return (List<TicketDataSet>) criteria
                .add(Restrictions.eq("user", user))
                .list();
    }

    @Override
    public List<TicketDataSet> getTicketsByUserFromPeriod(UserDataSet user, Date firstDate, Date secondDate) {
        Session session = sessionFactory.openSession();
        String s = "select * from ticket " +
                "where userid = " + user.getId() + " and purchaseDate >= \""+ firstDate +
                "\" and purchaseDate <= \"" + secondDate + "\" ;";
        SQLQuery query = session.createSQLQuery(s);
        query.addEntity(TicketDataSet.class);
        return (ArrayList<TicketDataSet>)query.list();
    }


    public List<TicketDataSet> getTicketByTrain(TrainDataSet train) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(TicketDataSet.class);
        return (List<TicketDataSet>) criteria
                .add(Restrictions.eq("train", train))
                .list();
    }
}
