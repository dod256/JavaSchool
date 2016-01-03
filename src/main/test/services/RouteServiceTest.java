package main.test.services;


import chuggaChugga.data.RouteRequest;
import org.junit.Test;

public class RouteServiceTest {
    @Test
    public void testGetRoutes() throws Exception {
        RouteRequest routeRequest = RouteRequest.newBuilder().withArrivalStation("B").withDepartureStation("A").build();
    }
}