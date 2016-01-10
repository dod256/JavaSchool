package chuggaChugga.controller;

import chuggaChugga.data.*;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.model.RouteStationDataSet;
import chuggaChugga.model.TrainDataSet;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.StationService;
import chuggaChugga.service.TicketService;
import chuggaChugga.service.TrainService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class TrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    TicketService ticketService;

    @Autowired
    RouteService routeService;

    @Autowired
    StationService stationService;

    @RequestMapping(value = "/addRouteToTrain.form", method = RequestMethod.POST)
    public String addRoute(@RequestParam("routeId") String routeId, HttpSession session) {
        OperationResultMessage message =
                ValidatorImpl.checkNumber(routeId);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        int id = Integer.parseInt(routeId);
        Route route =
                routeService.getRouteById(id);
        TrainDataSet.Builder trainBuilder = (TrainDataSet.Builder)
                session.getAttribute("trainBuilder");
        ArrayList<RouteStationDataSet> routeStations =
                route.getRouteStations();
        trainBuilder = trainBuilder
                .withRouteId(id)
                .withDepartureStation(routeStations.get(0))
                .withArrivalStation(routeStations
                        .get(routeStations.size() - 1));

        TrainRoute trainRoute = TrainRoute.newBuilder()
                .withTrain(trainBuilder.build())
                .withRoute(route)
                .build();
        trainService.createTrain(trainRoute);

        session.setAttribute("operationResultMessage",
                new OperationResultMessage("success", "Train created"));
        return "showMessage";
    }

    @RequestMapping(value = "/showAllRoutesForTrain.form", method = RequestMethod.POST)
    public String showAllRoutes(HttpSession session) {
        ArrayList<Route> routeList = routeService.getAllRoutes();
        session.setAttribute("routeList", routeList);
        return "addRouteToTrain";
    }

    @RequestMapping(value = "/showRoutesForTrain.form", method = RequestMethod.POST)
    public String showRoutes(
            @RequestParam("departureStation") String departureStation,
            @RequestParam("arrivalStation") String arrivalStation,
            HttpSession session) {
        RouteRequest request = RouteRequest.newBuilder()
                .withDepartureStation(departureStation)
                .withArrivalStation(arrivalStation)
                .build();
        ArrayList<Route> routeList = routeService.getRoutes(request);

        session.setAttribute("routeList", routeList);
        return "addRouteToTrain";
    }

    @RequestMapping(value = "/showPassengers.form", method = RequestMethod.POST)
    public String showPassengers(@RequestParam("trainId") String trainIdString, HttpSession session) {
        int trainId = Integer.parseInt(trainIdString);
        ArrayList<UserDto> passengerList = trainService.getPassengers(trainId);
        session.setAttribute("passengerList", passengerList);
        return "showPassengers";
    }

    @RequestMapping(value = "/setAddTrainAction.form", method = RequestMethod.POST)
    public String addAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("trainManagerAction", actionType);
        return "trainManager";
    }

    @RequestMapping(value = "/setShowAllTrainsAction.form", method = RequestMethod.POST)
    public String showAllAction(@RequestParam("actionType") String actionType, HttpSession session) {
        ArrayList<TrainDto> trainDtoList = trainService.getAllTrains();
        session.setAttribute("trainList", trainDtoList);
        session.setAttribute("trainManagerAction", actionType);
        return "trainManager";
    }

    @RequestMapping(value = "/addTrain.form", method = RequestMethod.POST)
    public String addTrain(
            @RequestParam("date") String dateString,
            @RequestParam("cost") String costString,
            @RequestParam("name") String name,
            @RequestParam("numberOfSeats") String numberOfSeatsString,
            HttpSession session) {
        OperationResultMessage message = ValidatorImpl.checkDate(dateString);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        LocalDate date = LocalDate.parse(dateString);
        message = ValidatorImpl.checkNumber(numberOfSeatsString);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        int numberOfSeats = Integer.parseInt(numberOfSeatsString);
        message = ValidatorImpl.checkNumber(costString);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        int cost = Integer.parseInt(costString);

        message = ValidatorImpl.generalCheck(name);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }

        TrainDataSet.Builder trainBuilder = TrainDataSet.newBuilder().withCost(cost)
                .withNumberOfSeats(numberOfSeats)
                .withNumberOfFreeSeats(numberOfSeats)
                .withDepartureDate(date)
                .withName(name);
        session.setAttribute("trainBuilder", trainBuilder);
        session.setAttribute("stationList", stationService.getAllStations());
        return "addRouteToTrain";
    }

    @RequestMapping(value = "/findTrainTimetable.form", method = RequestMethod.POST)
    public String findTrainTimetable(
            @RequestParam("departureStation") String departureStation,
            @RequestParam("arrivalStation") String arrivalStation,
            @RequestParam("date") String dateString,
            HttpSession session) {
        session.setAttribute("departureStation", departureStation);
        session.setAttribute("arrivalStation", arrivalStation);
        LocalDate date = LocalDate.parse(dateString);
        TrainRequest trainRequest = TrainRequest.newBuilder()
                .withDepartureStation(departureStation)
                .withArrivalStation(arrivalStation)
                .withDate(date)
                .build();
        TrainTimetable trainTimetable = trainService.getTrains(trainRequest);
        session.setAttribute("trainTimetable", trainTimetable);
        return "trainTimetable";
    }

    @RequestMapping(value = "/purchaseTicket.form", method = RequestMethod.POST)
    public String purchaseTicket(
            @RequestParam("trainId") String trainIdString,
            HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "login";
        }

        int trainId = Integer.parseInt(trainIdString);

       TicketRequest ticketRequest = TicketRequest.newBuilder()
                .withTrain(trainService.getTrain(trainId))
                .withUser((UserDto) session.getAttribute("currentUser"))
                .withArrivalStation((String) session.getAttribute("arrivalStation"))
                .withDepartureStation((String) session.getAttribute("departureStation"))
                .build();
        boolean tryToBuy = ticketService.tryToPurchaseTicket(ticketRequest);

        if (tryToBuy) {
            session.setAttribute("operationResultMessage", new OperationResultMessage("success", "Ticket purhased"));
        } else {
            session.setAttribute("operationResultMessage", new OperationResultMessage("danger", "Couldn't purhase ticket"));
        }
        return "showMessage";
    }
}
