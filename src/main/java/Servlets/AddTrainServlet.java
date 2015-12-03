package main.java.Servlets;


import main.java.Entities.Train;
import main.java.helper.OperationResultMessage;
import main.java.helper.ValidatorImpl;
import main.java.services.StationService;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Response for filling general info about train
* */
public class AddTrainServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String dateString = req.getParameter("date");
        OperationResultMessage message = ValidatorImpl.checkDate(dateString);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        DateTime date = DateTime.parse(dateString);
        String numberOfSeatsString = req.getParameter("numberOfSeats");
        message = ValidatorImpl.checkNumber(numberOfSeatsString);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        int numberOfSeats = Integer.parseInt(numberOfSeatsString);
        String costString = req.getParameter("cost");
        message = ValidatorImpl.checkNumber(costString);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        int cost = Integer.parseInt(costString);

        String name = req.getParameter("name");

        message = ValidatorImpl.generalCheck(name);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }

        Train.Builder trainBuilder = Train.newBuilder().withCost(cost)
                .withNumberOfSeats(numberOfSeats)
                .withNumberOfFreeSeats(numberOfSeats)
                .withDepartureDate(date)
                .withName(name);
        req.getSession().setAttribute("trainBuilder", trainBuilder);
        req.getSession().setAttribute("stationList", StationService.getAllStations());
        res.sendRedirect("addRouteToTrain.jsp");
    }
}
