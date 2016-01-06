package chuggaChugga.service;

import chuggaChugga.data.Route;
import chuggaChugga.data.StationTimetable;
import chuggaChugga.data.TrainArrivalTime;
import chuggaChugga.model.RouteStationDataSet;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.model.TrainDataSet;
import junit.framework.TestCase;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Time;
import java.util.ArrayList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StationServiceImplTest extends TestCase {

    @Mock
    private TrainService trainService;

    @Mock
    private RouteService routeService;


    @InjectMocks
    private StationService stationService = new StationServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTimetable() throws Exception {
        StationDataSet first = StationDataSet.newBuilder().withId(1).withName("Msk").build();
        StationDataSet second = StationDataSet.newBuilder().withId(2).withName("Spb").build();

        RouteStationDataSet departure = RouteStationDataSet.newBuilder().withArrival(new Time(4,0,0))
                .withDayCount(0).withId(1).withOnWheel(new Time(123)).withRouteId(1)
                .withStation(first)
                .withStationNumber(1)
                .withDayCount(0)
                .withWaitingTime(new Time(1111)).build();

        RouteStationDataSet arrival = RouteStationDataSet.newBuilder().withArrival(new Time(5,0,0))
                .withDayCount(1).withId(2).withOnWheel(new Time(1237)).withRouteId(1)
                .withStation(second)
                .withStationNumber(2)
                .withDayCount(1)
                .withWaitingTime(new Time(1111))
                .build();

        ArrayList<RouteStationDataSet> routeStationDataSetList = new ArrayList<>();
        routeStationDataSetList.add(departure);
        routeStationDataSetList.add(arrival);

        ArrayList<StationDataSet> stationDataSetList = new ArrayList<>();
        stationDataSetList.add(first);
        stationDataSetList.add(second);


        ArrayList<TrainDataSet> trains = new ArrayList<>();
        TrainDataSet train = TrainDataSet.newBuilder()
                .withId(1)
                .withName("tutu")
                .withArrivalStation(arrival)
                .withCost(100)
                .withDepartureStation(departure)
                .withNumberOfFreeSeats(100)
                .withNumberOfSeats(100)
                .withDepartureDate(new LocalDate().withYear(2016).withMonthOfYear(1).withDayOfMonth(1))
                .build();

        trains.add(train);

        Route route = Route.newBuilder().withRouteId(1).withRouteStations(routeStationDataSetList).withStations(stationDataSetList).build();
        ArrayList<Route> routes = new ArrayList<>();
        routes.add(route);

        when(trainService.getAllTrains()).thenReturn(trains);
        when(routeService.getAllRoutes()).thenReturn(routes);

        LocalDate departureDate = new LocalDate().withYear(2016).withMonthOfYear(1).withDayOfMonth(1);
        LocalDate arrivalDate = new LocalDate().withYear(2016).withMonthOfYear(1).withDayOfMonth(2);

        ArrayList<TrainArrivalTime> firstRes = new ArrayList<>();
        firstRes.add(TrainArrivalTime.newBuilder().withArrivalTime(new LocalTime(4, 0, 0)).withTrain(train).build());
        ArrayList<TrainArrivalTime> secondRes = new ArrayList<>();
        secondRes.add(TrainArrivalTime.newBuilder().withArrivalTime(new LocalTime(5,0,0)).withTrain(train).build());


        assertEquals(stationService.getTimetable(first, departureDate).getTrainArrivalTimes(), firstRes);
        assertEquals(stationService.getTimetable(second, arrivalDate).getTrainArrivalTimes(), secondRes);
        assertEquals(stationService.getTimetable(first, arrivalDate).getTrainArrivalTimes(), new ArrayList<TrainArrivalTime>());
    }
}