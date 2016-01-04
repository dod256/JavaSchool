package chuggaChugga.servlet;

import chuggaChugga.data.NewRouteImpl;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.service.RouteServiceImpl;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
*  Response for creating routes
* */
public class CreateRouteServlet extends HttpServlet {
/*
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ArrayList<String> stationList = new ArrayList<String>();
        ArrayList<Integer> onWheelList = new ArrayList<Integer>();
        ArrayList<Integer> waitingTimeList = new ArrayList<Integer>();
        int len = ((ArrayList<String>) req.getSession().getAttribute("newRouteStationList")).size();
        for(int i = 1; i <= len + 1; i++) {
                    stationList.add(req.getParameter("station" + i));
                if (i == 1) {
                    onWheelList.add(0);
                    waitingTimeList.add(0);
                } else {
                    onWheelList.add(Integer.valueOf(req.getParameter("station" + i + "OnWheel")));
                    waitingTimeList.add(Integer.valueOf(req.getParameter("station" + i + "WaitingTime")));
                }
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        DateTime time = formatter.parseDateTime(req.getParameter("time"));
        NewRouteImpl newRouteImpl = NewRouteImpl.newBuilder()
                .withStation(stationList)
                .withOnWheel(onWheelList)
                .withWaitingTime(waitingTimeList)
                .withDepartureTime(time)
                .build();
        RouteServiceImpl.createRoute(newRouteImpl);
        boolean tryToCreateRoute = true;
        if (tryToCreateRoute) {
            req.getSession().setAttribute("operationResultMessage",
                    new OperationResultMessage("success", "Route created"));
        } else {
            req.getSession().setAttribute("operationResultMessage",
                    new OperationResultMessage("danger", "Couldn't create route"));
        }
        res.sendRedirect("/WEB-INF/pages/showMessage.jsp");

    }*/
}
