package chuggaChugga.data;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;

public class Path {

    public class PathPart {
        private String departureStation;

        public String getDepartureStation() {
            return departureStation;
        }

        public String getArrivalStation() {
            return arrivalStation;
        }

        public LocalDateTime getDepartureDateTime() {
            return departureDateTime;
        }

        public LocalDateTime getArrivalDatetime() {
            return arrivalDatetime;
        }

        public String getTrain() {
            return train;
        }

        private String arrivalStation;
        private LocalDateTime departureDateTime;
        private LocalDateTime arrivalDatetime;
        private String train;

    }

    public ArrayList<PathPart> getPath() {
        return path;
    }

    private ArrayList<PathPart> path;
}
