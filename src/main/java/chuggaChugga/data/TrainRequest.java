package chuggaChugga.data;

import org.joda.time.LocalDate;

public class TrainRequest {

    private String departureStation;
    private String arrivalStation;
    private LocalDate date;

    private TrainRequest(Builder builder) {
        arrivalStation = builder.arrivalStation;
        departureStation = builder.departureStation;
        date = builder.date;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TrainRequest copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.departureStation = copy.departureStation;
        builder.date = copy.date;
        return builder;
    }

    public static final class Builder {
        private String arrivalStation;
        private String departureStation;
        private LocalDate date;

        private Builder() {
        }

        public Builder withArrivalStation(String val) {
            arrivalStation = val;
            return this;
        }

        public Builder withDepartureStation(String val) {
            departureStation = val;
            return this;
        }

        public Builder withDate(LocalDate val) {
            date = val;
            return this;
        }

        public TrainRequest build() {
            return new TrainRequest(this);
        }
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public LocalDate getDate() {
        return date;
    }


}
