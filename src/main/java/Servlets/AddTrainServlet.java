package main.java.Servlets;


import main.java.Entities.Train;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTrainServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DateTime date = DateTime.parse(req.getParameter("date"));
        int numberOfSeats = Integer.parseInt(req.getParameter("numberOfSeats"));
        int cost = Integer.parseInt(req.getParameter("cost"));
        String name = req.getParameter("name");
        Train.Builder trainBuilder = Train.newBuilder().withCost(cost)
                .withNumberOfSeats(numberOfSeats)
                .withNumberOfFreeSeats(numberOfSeats)
                .withDepartureDate(date)
                .withName(name);
        req.getSession().setAttribute("trainBuilder", trainBuilder);
        res.sendRedirect("addRouteToTrain.jsp");
    }
}
