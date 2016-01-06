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

    public static final class Builder {
        private String station;
        private int daysOnWheel;
        private LocalTime arrivalTime;
        private LocalTime waitingTime;

        public Builder() {
        }

        public Builder station(String val) {
            station = val;
            return this;
        }

        public Builder daysOnWheel(int val) {
            daysOnWheel = val;
            return this;
        }

        public Builder arrivalTime(LocalTime val) {
            arrivalTime = val;
            return this;
        }

        public Builder waitingTime(LocalTime val) {
            waitingTime = val;
            return this;
        }

        public NewRouteStation build() {
            return new NewRouteStation(this);
        }
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
}
