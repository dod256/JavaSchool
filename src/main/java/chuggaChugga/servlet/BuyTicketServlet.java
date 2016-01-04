package chuggaChugga.servlet;

import chuggaChugga.data.TicketRequest;
import chuggaChugga.dto.UserDto;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.service.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Response for buying the tickets
* */
public class BuyTicketServlet extends HttpServlet {

   /* public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null) {
            res.sendRedirect("/WEB-INF/pages/login.jsp");
            return;
        }

        int trainId = Integer.parseInt(req.getParameter("trainId"));


        String departureStation = req.getParameter("departureStation");
        String arrivalStation = req.getParameter("arrivalStation");

        TicketRequest ticketRequest = TicketRequest.newBuilder()
                .withTrainId(trainId)
                .withUserDto((UserDto) req.getSession().getAttribute("currentUser"))
                .withArrivalStation(departureStation)
                .withDepartureStation(arrivalStation)
                .build();
        boolean tryToBuy = TicketServiceImpl.tryToPurhaseTicket(ticketRequest);

        if (tryToBuy) {
            req.getSession().setAttribute("operationResultMessage", new OperationResultMessage("success", "Ticket purhased"));
        } else {
            req.getSession().setAttribute("operationResultMessage", new OperationResultMessage("danger", "Couldn't purhase ticket"));
        }
        res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
    }
*/
}