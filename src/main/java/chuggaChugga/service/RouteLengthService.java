package chuggaChugga.service;

import org.springframework.stereotype.Service;


public interface RouteLengthService {
    void addRouteLength(int length);
    int getFreeRouteId();
}
