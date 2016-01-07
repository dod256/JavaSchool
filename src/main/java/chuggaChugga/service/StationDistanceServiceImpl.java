package chuggaChugga.service;

import chuggaChugga.dao.StationDistanceDao;
import chuggaChugga.dto.StationDistanceDto;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.model.StationDistanceDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class StationDistanceServiceImpl implements StationDistanceService {

    @Autowired
    StationDistanceDao stationDistanceDao;
    @Autowired
    StationService stationService;

    @Override
    public void addOrUpdateDistance(StationDistanceDto distance) {
        StationDataSet first = stationService.getStationByName(distance.getFirstStation());
        StationDataSet second = stationService.getStationByName(distance.getSecondStation());
        StationDistanceDataSet dataSet = stationDistanceDao.findDistance(first, second);
        StationDataSet firstStation = stationService.getStationByName(distance.getFirstStation());
        StationDataSet secondStation = stationService.getStationByName(distance.getSecondStation());
        if (dataSet == null) {
            stationDistanceDao.addDistance(StationDistanceDataSet.newBuilder()
                    .withDistance(distance.getDistance())
                    .withFirstStation(firstStation)
                    .withSecondStation(secondStation)
                    .build());
        } else {
            dataSet.setDistance(distance.getDistance());
            stationDistanceDao.updateDistance(dataSet);
            StationDistanceDataSet reverse = stationDistanceDao.findDistance(secondStation, firstStation);
            reverse.setDistance(distance.getDistance());
            stationDistanceDao.updateDistance(reverse);
        }
    }

    @Override
    public StationDistanceDto findDistance(String firstStation, String secondStation) {
        StationDistanceDataSet dataSet = stationDistanceDao
                        .findDistance(stationService.getStationByName(firstStation), stationService.getStationByName(secondStation));
        if (dataSet == null) {
            return StationDistanceDto.newBuilder().withDistance(-1)
                    .withFirstStation(firstStation)
                    .withSecondStation(secondStation)
                    .build();
        } else {
            return StationDistanceDto.newBuilder().build();
        }
    }

    @Override
    public ArrayList<StationDistanceDto> findAllDistances(String station) {
        ArrayList<StationDistanceDto> result = new ArrayList<>();
        for (StationDistanceDataSet distance: stationDistanceDao.findAllDistances(stationService.getStationByName(station))) {
            result.add(StationDistanceDto.newBuilder(distance).build());
        }
        return result;
    }
}
