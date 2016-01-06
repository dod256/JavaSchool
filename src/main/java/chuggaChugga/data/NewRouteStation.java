package chuggaChugga.data;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

public class NewRouteStation {
    private String station;
    private int daysOnWheel;
    private LocalTime arrivalTime;
    private LocalTime waitingTime;

    private NewRouteStation(Builder builder) {
        station = builder.station;
        daysOnWheel = builder.daysOnWheel;
        arrivalTime = builder.arrivalTime;
        waitingTime = builder.waitingTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getStation() {
        return station;
    }

    public int getDaysOnWheel() {
        return daysOnWheel;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalTimeString() {
        return arrivalTime.toString(DateTimeFormat.longTime());
    }

    public LocalTime getWaitingTime() {
        return waitingTime;
    }

    public String getWaitingTimeString() {
        return waitingTime.toString(DateTimeFormat.longTime());
    }

    public static final class Builder {
        private String station;
        private int daysOnWheel;
        private LocalTime arrivalTime;
        private LocalTime waitingTime;

        private Builder() {
        }

        public Builder withStation(String val) {
            station = val;
            return this;
        }

        public Builder withDaysOnWheel(int val) {
            daysOnWheel = val;
            return this;
        }

        public Builder withArrivalTime(LocalTime val) {
            arrivalTime = val;
            return this;
        }

        public Builder withWaitingTime(LocalTime val) {
            waitingTime = val;
            return this;
        }

        public NewRouteStation build() {
            return new NewRouteStation(this);
        }
    }
}
