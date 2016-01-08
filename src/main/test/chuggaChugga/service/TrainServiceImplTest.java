package chuggaChugga.service;

import chuggaChugga.data.Route;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.model.RouteStationDataSet;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.model.TrainDataSet;
import junit.framework.TestCase;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Time;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class TrainServiceImplTest extends TestCase {

    TrainDto trainDto;
    StationDataSet stationMsk;
    StationDataSet stationTver;
    StationDataSet stationSpb;

    public TrainServiceImplTest() {
        generate();
    }

    public void generate() {
        TrainDataSet train = TrainDataSet.newBuilder()
                .withDepartureDate(new LocalDate(2016, 1, 1)).build();

        stationMsk = StationDataSet.newBuilder().withName("MSK").build();
        stationSpb = StationDataSet.newBuilder().withName("SPB").build();
        stationSpb = StationDataSet.newBuilder().withName("Tver").build();
        RouteStationDataSet msk = RouteStationDataSet.newBuilder()
                .withArrival(new Time(12,1,0))
                .withRouteId(1)
                .withDayCount(2)
                .withStation(stationMsk)
                .withStationNumber(2)
                .withWaitingTime(new Time(0, 10, 0))
                .build();

        RouteStationDataSet spb = RouteStationDataSet.newBuilder()
                .withArrival(new Time(10, 1, 0))
                .withRouteId(1)
                .withDayCount(0)
                .withStation(stationSpb)
                .withStationNumber(1)
                .withWaitingTime(new Time(1, 23, 0))
                .build();

        RouteStationDataSet tver = RouteStationDataSet.newBuilder()
                .withArrival(new Time(23, 20, 0))
                .withRouteId(1)
                .withDayCount(0)
                .withStation(stationSpb)
                .withStationNumber(1)
                .withWaitingTime(new Time(2, 0, 0))
                .build();

        ArrayList<StationDataSet> stations = new ArrayList<>();
        stations.add(stationMsk);
        stations.add(stationSpb);
        stations.add(stationTver);
        ArrayList<RouteStationDataSet> routeStations = new ArrayList<>();
        routeStations.add(msk);
        routeStations.add(spb);
        routeStations.add(tver);

        Route route = Route.newBuilder()
                .withStations(stations)
                .withRouteId(1)
                .withRouteStations(routeStations)
                .build();

        trainDto = new TrainDto(train, route);
    }

    @Test
    public void testGetArrivalDateTimeFirstStation() throws Exception {
        TrainServiceImpl trainService = new TrainServiceImpl();
        assertEquals(trainService.getArrivalDateTime(trainDto, stationMsk), new LocalDateTime(2016, 1, 3, 12, 1, 0));
    }

    @Test
    public void testGetArrivalDateTimeLastStation() throws Exception {
        TrainServiceImpl trainService = new TrainServiceImpl();
        assertEquals(trainService.getArrivalDateTime(trainDto, stationSpb), new LocalDateTime(2016, 1, 1, 10, 1, 0));
    }

    @Test
    public void testGetDepartureDateTimeFirstStation() throws Exception {
        TrainServiceImpl trainService = new TrainServiceImpl();
        assertEquals(trainService.getDepartureDateTime(trainDto, stationMsk), new LocalDateTime(2016, 1, 3, 12, 11, 0));
    }

    @Test
    public void testGetDepartureDateTimeLastStation() throws Exception {
        TrainServiceImpl trainService = new TrainServiceImpl();
        assertEquals(trainService.getDepartureDateTime(trainDto, stationSpb), new LocalDateTime(2016, 1, 1, 11, 24, 0));
    }

    @Test
    public void testGetArrivalDateTimeMiddleStation() throws Exception {
        TrainServiceImpl trainService = new TrainServiceImpl();
        assertEquals(trainService.getArrivalDateTime(trainDto, stationTver), new LocalDateTime(2016, 1, 1, 23, 20, 0));
    }

    @Test
    public void testGetDepartureDateTimeWithDayTransition() throws Exception {
        TrainServiceImpl trainService = new TrainServiceImpl();
        assertEquals(trainService.getDepartureDateTime(trainDto, stationSpb), new LocalDateTime(2016, 1, 2, 1, 20, 0));
    }

}