package main.java.builders;

import main.java.dto.TimetableDto;
import org.joda.time.DateTime;

public class TimetableDtoBuilder {
    private String departureStation;
    private String arrivalStation;
    private DateTime date;

    public TimetableDtoBuilder setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
        return this;
    }

    public TimetableDtoBuilder setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
        return this;
    }

    public TimetableDtoBuilder setDate(DateTime date) {
        this.date = date;
        return this;
    }

    public TimetableDto createTimetableDto() {
        return new TimetableDto(departureStation, arrivalStation, date);
    }
}