package chuggaChugga.service;

import chuggaChugga.dto.StationDistanceDto;

import java.util.ArrayList;

public interface StationDistanceService {
    void addOrUpdateDistance(StationDistanceDto distance);
    StationDistanceDto findDistance(String firstStation, String secondStation);
    ArrayList<StationDistanceDto> findAllDistances(String station);
}
