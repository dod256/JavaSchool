package chuggaChugga.servlet;

import chuggaChugga.model.Station;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.service.StationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
* Response for creating new stations
* */
public class AddStationServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        OperationResultMessage message = ValidatorImpl.checkName(name);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
            return;
        }
        StationService.addStation(Station.newBuilder().withName(name).build());
        req.getSession().setAttribute("operationResultMessage",
                new OperationResultMessage("success", "Station added"));
        res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
    }

}
