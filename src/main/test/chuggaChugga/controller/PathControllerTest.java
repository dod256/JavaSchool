package chuggaChugga.controller;

import chuggaChugga.data.TrainArrivalTime;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.StationService;
import chuggaChugga.service.StationServiceImpl;
import chuggaChugga.service.TrainService;
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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PathControllerTest extends TestCase {

    @Mock
    private TrainService trainService;

    @Mock
    private RouteService routeService;


    @Mock
    private StationService stationService;

    @InjectMocks
    private PathController pathController = new PathController();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noTrainTest() throws Exception {
        StationDataSet first = StationDataSet.newBuilder().withId(1).withName("Msk").build();
        StationDataSet second = StationDataSet.newBuilder().withId(2).withName("Spb").build();

        ArrayList<StationDataSet> stationDataSetList = new ArrayList<>();
        stationDataSetList.add(first);
        stationDataSetList.add(second);

        when(trainService.getEarliestTrain(any(), any(), any())).thenReturn(null);
        when(trainService.getArrivalDateTime(any(), any())).thenReturn(null);
        when(trainService.getDepartureDateTime(any(), any())).thenReturn(null);
        when(stationService.getAllStationsOrderedById()).thenReturn(stationDataSetList);
        when(stationService.getStationByName("Msk")).thenReturn(first);
        when(stationService.getStationByName("Spb")).thenReturn(second);

        assertEquals(pathController.findFastest("Msk", "Spb"), null);

    }
}