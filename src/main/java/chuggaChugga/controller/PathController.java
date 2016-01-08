package chuggaChugga.controller;

import chuggaChugga.data.Path;
import chuggaChugga.data.PathPart;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.service.StationService;
import chuggaChugga.service.TrainService;
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

    @Autowired
    TrainService trainService;

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
        ArrayList<StationDataSet> stations = stationService.getAllStationsOrderedById();
        int numberOfStations = stations.size();
        int start = stationService.getStationByName(departureStation).getId() - 1;
        int finish = stationService.getStationByName(arrivalStation).getId() - 1;
        int maxNumberOfTransfer = 5;
        LocalDateTime[][] arrival = new LocalDateTime[maxNumberOfTransfer][numberOfStations];
        int[][] from = new int[maxNumberOfTransfer][numberOfStations];
        PathPart[][] fromTrain = new PathPart[maxNumberOfTransfer][numberOfStations];
        for(int i = 0; i < numberOfStations; i++) {
            if (i == start) {
                arrival[0][i] = LocalDateTime.now();
                continue;
            }
            TrainDto train = trainService.getEarliestTrain(
                    stations.get(start - 1).getName(),
                    stations.get(i).getName(),
                    arrival[0][i]);
            arrival[0][i] = trainService.getDateTime(train, stations.get(i));
        }
        for(int numberOfTransfer = 1; numberOfTransfer <= maxNumberOfTransfer; numberOfTransfer++) {
            for(int fromStation = 0; fromStation < numberOfStations; fromStation++) {
                for(int toStation = 0; toStation < numberOfStations; toStation++) {
                    if (fromStation == toStation){
                        continue;
                    }
                    TrainDto train = trainService.getEarliestTrain(
                            stations.get(fromStation).getName(),
                            stations.get(toStation).getName(),
                            arrival[numberOfTransfer - 1][fromStation]);
                    LocalDateTime arrivalToFinish = trainService.getDateTime(train, stations.get(toStation));
                    if (arrival[numberOfTransfer][toStation] == null ||
                            arrivalToFinish.isBefore(arrival[numberOfTransfer][toStation])) {
                        arrival[numberOfTransfer][toStation] = arrivalToFinish;
                        from[numberOfTransfer][toStation] = fromStation;
                        fromTrain[numberOfTransfer][toStation] = PathPart.newBuilder()
                                .withDepartureStation(stations.get(toStation).getName())
                                //.withDepartureDateTime()
                                .withArrivalStation(stations.get(fromStation).getName())
                                .withArrivalDateTime(trainService.getDateTime(train, stations.get(toStation)))
                                .withTrain(train.getName())
                                .build();
                    }
                }
            }
        }
        Path answer = new Path();
        int currentStation = finish;
        int currentTransfer = 0;
        while (currentTransfer <= maxNumberOfTransfer && arrival[currentTransfer][finish] == null) {
            currentTransfer++;
        }
        if (arrival[currentTransfer][finish] == null) {
            return null;
        }
        for(int i = currentTransfer + 1; i < maxNumberOfTransfer; i++) {
            if (arrival[i][finish] == null) {
                continue;
            }
            if (arrival[i][finish].isBefore(arrival[currentTransfer][finish])) {
                currentTransfer = i;
            }
        }
        for(int i = currentTransfer; i >= 0; i--) {
            answer.addPart(fromTrain[i][currentStation]);
            currentStation = from[i][currentStation];
        }
        answer.reverse();
        return answer;
    }

    private Path findCheapest(String departureStation, String arrivalStation) {
        return null;
    }
}
