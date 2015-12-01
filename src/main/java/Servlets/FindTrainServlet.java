package main.java.Servlets;

import main.java.data.TrainRequest;
import main.java.Entities.Train;
import main.java.services.TrainService;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FindTrainServlet extends HttpServlet {

        public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                String departureStation = req.getParameter("departureStation");
                String arrivalStation = req.getParameter("arrivalStation");
                req.getSession().setAttribute("departureStation", departureStation);
                req.getSession().setAttribute("arrivalStation", arrivalStation);
                DateTime date = DateTime.parse(req.getParameter("date"));
                TrainRequest trainRequest = TrainRequest.newBuilder()
                        .withDepartureStation(departureStation)
                        .withArrivalStation(arrivalStation)
                        .withDate(date)
                        .build();
                ArrayList<Train> trainList = TrainService.getTrains(trainRequest);
                req.getSession().setAttribute("trainList", trainList);
                res.sendRedirect("/TrainTimetable.jsp");
        }
}
