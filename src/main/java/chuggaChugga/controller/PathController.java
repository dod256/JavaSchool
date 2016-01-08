package chuggaChugga.controller;

import chuggaChugga.data.Path;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.service.StationService;
import org.joda.time.LocalDateTime;
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
        //Sort by id
        int numberOfStations = stations.size();
        int start = stationService.getStationByName(departureStation).getId();
        int finish = stationService.getStationByName(arrivalStation).getId();
        int maxNumberOfTransfer = 5;
        LocalDateTime[][] arrival = new LocalDateTime[maxNumberOfTransfer][numberOfStations + 1];
        int[][] from = new int[maxNumberOfTransfer][numberOfStations + 1];
        for(int i = 0; i < arrival.length; i++) {
            arrival[i] = null;
        }
        //Fill first step
        for(int numberOfTransfer = 1; numberOfTransfer <= maxNumberOfTransfer; numberOfTransfer++) {
            for(int fromStation = 1; fromStation <= numberOfStations; fromStation++) {
                for(int toStation = 1; toStation <= numberOfStations; toStation++) {
                    if (fromStation == toStation){
                        continue;
                    }
                    //TrainDto train = trainService.getEarliestTrain(stations.get(fromStation - 1), stations.get(toStation - 1), arrival[numberOfTransfer - 1][fromStation]);
                    LocalDateTime arrivalToFinish = null;//=train.getArrivalStationTime() + date????
                    if (arrivalToFinish.isBefore(arrival[numberOfTransfer][toStation])) {
                        arrival[numberOfTransfer][toStation] = arrivalToFinish;
                        from[numberOfTransfer][finish] = fromStation;
                    }
                }
            }
        }
        return null;
    }

    private Path findCheapest(String departureStation, String arrivalStation) {
        return null;
    }
}
