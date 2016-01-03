package chuggaChugga.servlet;

import chuggaChugga.model.RouteStation;
import chuggaChugga.model.Train;
import chuggaChugga.data.Route;
import chuggaChugga.data.TrainRoute;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddRouteToTrainServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String routeIdString = req.getParameter("routeId");
        OperationResultMessage message =
                ValidatorImpl.checkNumber(routeIdString);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
            return;
        }
        int id = Integer.parseInt(routeIdString);
        Route route =
                RouteService.getRouteById(id);
        Train.Builder trainBuilder = (Train.Builder)
                req.getSession().getAttribute("trainBuilder");
        ArrayList<RouteStation> routeStations =
                route.getRouteStations();
        trainBuilder = trainBuilder
                .withDepartureStation(routeStations.get(0))
                .withArrivalStation(routeStations
                        .get(routeStations.size() - 1));

        TrainRoute trainRoute = TrainRoute.newBuilder()
                .withTrain(trainBuilder.build())
                .withRoute(route)
                .build();
        TrainService.createTrain(trainRoute);

        req.getSession().setAttribute("operationResultMessage",
                new OperationResultMessage("success", "Train created"));
        res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
    }

}
