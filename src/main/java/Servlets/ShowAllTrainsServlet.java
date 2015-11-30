package main.java.Servlets;

import main.java.Entities.Train;
import main.java.data.TrainRequest;
import main.java.services.TrainService;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllTrainsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Train> trainList = TrainService.getAllTrains();
        req.getSession().setAttribute("trainList", trainList);
        res.sendRedirect("/TrainTimetable.jsp");
    }


}
