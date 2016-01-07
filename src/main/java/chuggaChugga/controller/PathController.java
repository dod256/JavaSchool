package chuggaChugga.controller;

import chuggaChugga.data.Path;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class PathController {

    @Autowired
    StationService stationService;

    @RequestMapping(value = "/selectPathType.form", method = RequestMethod.POST)
    public String selectPathType(
            @RequestParam("pathType") String pathType,
            HttpSession session) {
        session.setAttribute("pathType", pathType);
        session.setAttribute("stationList", stationService.getAllStations());
        return "pathManager";
    }

    @RequestMapping(value = "/findPath.form", method = RequestMethod.POST)
    public String findPath(
            @RequestParam("departureStation") String departureStation,
            @RequestParam("arrivalStation") String arrivalStation,
            @RequestParam("pathType") String pathType,
            HttpSession session) {
        if ("fastest".equals(pathType)) {
            session.setAttribute("path", findFastest(departureStation, arrivalStation));
        }
        if ("cheapest".equals(pathType)) {
            session.setAttribute("path", findCheapest(departureStation, arrivalStation));
        }
        session.removeAttribute("pathType");
        return "pathInfo";
    }

    private Path findFastest(String departureStation, String arrivalStation) {
        ArrayList<StationDataSet> stations = stationService.getAllStations();
        int numberOfStations = stations.size();
        int start = stationService.getStationByName(departureStation).getId();
        int finish = stationService.getStationByName(arrivalStation).getId();
        for(int numberOfTransfer = 0; numberOfTransfer < 4; numberOfTransfer++) {
            
        }
        return null;
    }

    private Path findCheapest(String departureStation, String arrivalStation) {
        return null;
    }
}
