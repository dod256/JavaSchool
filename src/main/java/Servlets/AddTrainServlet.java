package main.java.Servlets;

import main.java.builders.TrainBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTrainServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        TrainBuilder trainBuilder = new TrainBuilder();
        res.sendRedirect("addRouteToTrain.jsp");
    }
}
