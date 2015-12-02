package main.java.Servlets;

import main.java.Entities.Ticket;
import main.java.Entities.Train;
import main.java.Entities.User;
import main.java.data.TicketRequest;
import main.java.dto.UserDto;
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


        String departureStation = req.getParameter("departureStation");
        String arrivalStation = req.getParameter("arrivalStation");

        TicketRequest ticketRequest = TicketRequest.newBuilder()
                .withTrainId(trainId)
                .withUserDto((UserDto) req.getSession().getAttribute("currentUser"))
                //ToDo uncomment
                //.withArrivalStation(departureStation)
                //.withDepartureStation(arrivalStation)
                .build();
        boolean tryToBuy = TicketService.tryToByTicket(ticketRequest);

        res.sendRedirect("ticketAdded.jsp");
    }

}
