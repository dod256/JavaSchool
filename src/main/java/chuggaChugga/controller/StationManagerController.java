package chuggaChugga.controller;

import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.model.Station;
import chuggaChugga.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class StationManagerController {

    @Autowired
    StationService stationService;

    @RequestMapping(value = "/setAddStationAction.form", method = RequestMethod.POST)
    public String addAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("stationList", stationService.getAllStations());
        session.setAttribute("currentManagerAction", actionType);
        return "stationManager";
    }

    @RequestMapping(value = "/setShowAllStationsAction.form", method = RequestMethod.POST)
    public String showAllAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("stationList", stationService.getAllStations());
        session.setAttribute("currentManagerAction", actionType);
        return "stationManager";
    }

    @RequestMapping(value = "/setFindStationAction.form", method = RequestMethod.POST)
    public String findAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("stationList", stationService.getAllStations());
        session.setAttribute("currentManagerAction", actionType);
        return "stationManager";
    }

    @RequestMapping(value = "/addStation.form", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, HttpSession session) {
        OperationResultMessage message = ValidatorImpl.checkName(name);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
        } else {
            stationService.addStation(Station.newBuilder().withName(name).build());
            session.setAttribute("operationResultMessage",
                    new OperationResultMessage("success", "Station added"));
        }
        return "showMessage";
    }
}
