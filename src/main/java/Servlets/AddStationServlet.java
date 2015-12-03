package main.java.Servlets;

import main.java.Entities.Station;
import main.java.helper.OperationResultMessage;
import main.java.helper.Validator;
import main.java.services.StationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStationServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        OperationResultMessage message = Validator.checkName(name);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        StationService.addStation(Station.newBuilder().withName(name).build());
        req.getSession().setAttribute("operationResultMessage", new OperationResultMessage("success", "Station added"));
        res.sendRedirect("showMessage.jsp");
    }

}
