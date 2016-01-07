package chuggaChugga.data;

import org.joda.time.LocalDateTime;

public class PathPart {
    private String departureStation;
    private String arrivalStation;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String train;

    private PathPart(Builder builder) {
        departureStation = builder.departureStation;
        arrivalStation = builder.arrivalStation;
        departureDateTime = builder.departureDateTime;
        arrivalDateTime = builder.arrivalDateTime;
        train = builder.train;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PathPart copy) {
        Builder builder = new Builder();
        builder.departureStation = copy.departureStation;
        builder.arrivalStation = copy.arrivalStation;
        builder.departureDateTime = copy.departureDateTime;
        builder.arrivalDateTime = copy.arrivalDateTime;
        builder.train = copy.train;
        return builder;
    }

    public static final class Builder {
        private String departureStation;
        private String arrivalStation;
        private LocalDateTime departureDateTime;
        private LocalDateTime arrivalDateTime;
        private String train;

        private Builder() {
        }

        public Builder withDepartureStation(String val) {
            departureStation = val;
            return this;
        }

        public Builder withArrivalStation(String val) {
            arrivalStation = val;
            return this;
        }

        public Builder withDepartureDateTime(LocalDateTime val) {
            departureDateTime = val;
            return this;
        }

        public Builder withArrivalDateTime(LocalDateTime val) {
            arrivalDateTime = val;
            return this;
        }

        public Builder withTrain(String val) {
            train = val;
            return this;
        }

        public PathPart build() {
            return new PathPart(this);
        }
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getTrain() {
        return train;
    }
}

