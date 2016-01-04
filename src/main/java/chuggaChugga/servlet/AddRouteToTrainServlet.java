package chuggaChugga.servlet;

import javax.servlet.http.HttpServlet;

public class AddRouteToTrainServlet extends HttpServlet {
/*
    @Autowired
    TrainService trainService;

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
                RouteServiceImpl.getRouteById(id);
        TrainDataSet.Builder trainBuilder = (TrainDataSet.Builder)
                req.getSession().getAttribute("trainBuilder");
        ArrayList<RouteStationDataSet> routeStations =
                route.getRouteStations();
        trainBuilder = trainBuilder
                .withDepartureStation(routeStations.get(0))
                .withArrivalStation(routeStations
                        .get(routeStations.size() - 1));

        TrainRoute trainRoute = TrainRoute.newBuilder()
                .withTrain(trainBuilder.build())
                .withRoute(route)
                .build();
        trainService.createTrain(trainRoute);

        req.getSession().setAttribute("operationResultMessage",
                new OperationResultMessage("success", "TrainDataSet created"));
        res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
    }
*/
}
