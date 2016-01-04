package chuggaChugga.servlet;

import chuggaChugga.data.TrainRequest;
import chuggaChugga.data.TrainTimetable;
import chuggaChugga.service.TrainServiceImpl;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindTrainServlet extends HttpServlet {

        @Autowired
        TrainServiceImpl trainService;

        public void doPost(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
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
                TrainTimetable trainTimetable = trainService.getTrains(trainRequest);
                req.getSession().setAttribute("trainTimetable", trainTimetable);
                res.sendRedirect("/WEB-INF/pages//TrainTimetable.jsp");
        }
}
