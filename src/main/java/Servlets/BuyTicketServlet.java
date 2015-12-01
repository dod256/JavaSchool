package main.java.Servlets;

import main.java.Entities.Ticket;
import main.java.Entities.Train;
import main.java.Entities.User;
import main.java.services.RouteService;
import main.java.services.TicketService;
import main.java.services.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BuyTicketServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null) {
            res.sendRedirect("loginPage.jsp");
            return;
        }
        int trainId = Integer.parseInt(req.getParameter("trainId"));
        Train train = TrainService.getTrain(trainId);
        int routeNumberOfDepartureStation = 0;
        int routeNumberOfArrivalStation = 0;
        if (req.getSession().getAttribute("departureStation") == null) {
            routeNumberOfDepartureStation = 1;
            //ToDo think about getting Route length
            routeNumberOfArrivalStation = RouteService.getRouteById(train.getDepartureStation().getRouteId()).getRouteStations().size();
        }
        Ticket ticket = Ticket.newBuilder().withUser((User) req.getSession().getAttribute("currentUser"))
                .withTrain(train)
                .withRouteNumberOfDepartureStation(routeNumberOfDepartureStation)
                .withRouteNumberOfArrivalStation(routeNumberOfArrivalStation)
                .build();
        TicketService.addTicket(ticket);
        res.sendRedirect("ticketAdded.jsp");
    }

}
