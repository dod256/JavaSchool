package main.java.data;

import org.joda.time.DateTime;

public class TrainRequest {

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

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public DateTime getDate() {
        return date;
    }

    private String departureStation;
    private String arrivalStation;
    private DateTime date;


    public static final class Builder {
        private String arrivalStation;
        private String departureStation;
        private DateTime date;

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

        public Builder withDate(DateTime val) {
            date = val;
            return this;
        }

        public TrainRequest build() {
            return new TrainRequest(this);
        }
    }
}
