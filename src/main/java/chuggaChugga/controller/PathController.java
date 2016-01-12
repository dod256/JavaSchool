package chuggaChugga.controller;

import chuggaChugga.data.Path;
import chuggaChugga.data.PathPart;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.domain.StationDataSet;
import chuggaChugga.helper.Constants;
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

import static chuggaChugga.helper.Constants.MAX_NUMBER_OF_TRANSFERS;

@Controller
public class PathController extends MyController {

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
        return "pathInfo";
    }

    public Path findFastest(String departureStation, String arrivalStation) {
        ArrayList<StationDataSet> stations = stationService.getAllStationsOrderedById();
        int numberOfStations = stations.size();
        int start = stationService.getStationByName(departureStation).getId() - 1;
        int finish = stationService.getStationByName(arrivalStation).getId() - 1;
        LocalDateTime[][] arrival = new LocalDateTime[MAX_NUMBER_OF_TRANSFERS][numberOfStations];
        int[][] from = new int[MAX_NUMBER_OF_TRANSFERS][numberOfStations];
        PathPart[][] fromTrain = new PathPart[MAX_NUMBER_OF_TRANSFERS][numberOfStations];
        arrival[0][start] = LocalDateTime.now();
        for(int i = 0; i < numberOfStations; i++) {
            if (i == start) {
                continue;
            }
            TrainDto train = trainService.getEarliestTrain(
                    stations.get(start),
                    stations.get(i),
                    arrival[0][start]);
            if (train == null) {
                continue;
            }
            arrival[0][i] = trainService.getArrivalDateTime(train, stations.get(i));
            if (arrival[0][i] != null) {
                fromTrain[0][i] = PathPart.newBuilder()
                        .withDepartureStation(stations.get(start).getName())
                        .withDepartureDateTime(trainService.getDepartureDateTime(train, stations.get(start)))
                        .withArrivalStation(stations.get(i).getName())
                        .withArrivalDateTime(trainService.getArrivalDateTime(train, stations.get(i)))
                        .withTrain(train.getName())
                        .build();
            }
        }
        for(int numberOfTransfer = 1; numberOfTransfer < MAX_NUMBER_OF_TRANSFERS; numberOfTransfer++) {
            for(int fromStation = 0; fromStation < numberOfStations; fromStation++) {
                if (arrival[numberOfTransfer - 1][fromStation] == null) {
                    continue;
                }
                for(int toStation = 0; toStation < numberOfStations; toStation++) {
                    if (fromStation == toStation ){
                        continue;
                    }
                    TrainDto train = trainService.getEarliestTrain(
                            stations.get(fromStation),
                            stations.get(toStation),
                            arrival[numberOfTransfer - 1][fromStation]);
                    if (train == null) {
                        continue;
                    }
                    LocalDateTime arrivalToFinish = trainService.getArrivalDateTime(train, stations.get(toStation));
                    if (arrival[numberOfTransfer][toStation] == null ||
                            arrivalToFinish.isBefore(arrival[numberOfTransfer][toStation])) {
                        arrival[numberOfTransfer][toStation] = arrivalToFinish;
                        from[numberOfTransfer][toStation] = fromStation;
                        fromTrain[numberOfTransfer][toStation] = PathPart.newBuilder()
                                .withDepartureStation(stations.get(fromStation).getName())
                                .withDepartureDateTime(trainService.getDepartureDateTime(train, stations.get(fromStation)))
                                .withArrivalStation(stations.get(toStation).getName())
                                .withArrivalDateTime(trainService.getArrivalDateTime(train, stations.get(toStation)))
                                .withTrain(train.getName())
                                .build();
                    }
                }
            }
        }
        Path answer = new Path();
        int currentStation = finish;
        int currentTransfer = 0;
        while (currentTransfer < MAX_NUMBER_OF_TRANSFERS && arrival[currentTransfer][finish] == null) {
            currentTransfer++;
        }
        if (currentTransfer == MAX_NUMBER_OF_TRANSFERS) {
            return null;
        }
        for(int i = currentTransfer + 1; i < MAX_NUMBER_OF_TRANSFERS; i++) {
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
}
