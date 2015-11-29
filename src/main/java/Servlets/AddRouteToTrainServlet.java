package main.java.Servlets;

import main.java.Entities.Train;
import main.java.Service;
import main.java.data.Route;
import main.java.data.TrainRoute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddRouteToTrainServlet extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("routeId"));
        Route route = Service.getRouteById(id);
        Train train = (Train) req.getSession().getAttribute("newTrain");
        TrainRoute trainRoute = TrainRoute.newBuilder()
                .withTrain(train)
                .withRoute(route)
                .build();
        req.getSession().setAttribute("trainRoute", trainRoute);
        res.sendRedirect("trainAdded.jsp");
    }

}
