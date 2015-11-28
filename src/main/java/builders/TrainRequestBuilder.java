package main.java.builders;

import main.java.data.TrainRequest;
import org.joda.time.DateTime;

public class TrainRequestBuilder {
    private String departureStation;
    private String arrivalStation;
    private DateTime date;

    public TrainRequestBuilder setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
        return this;
    }

    public TrainRequestBuilder setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
        return this;
    }

    public TrainRequestBuilder setDate(DateTime date) {
        this.date = date;
        return this;
    }

    public TrainRequest createTimetableDto() {
        return new TrainRequest(departureStation, arrivalStation, date);
    }
}