package main.java.data;

import org.joda.time.DateTime;

public class RouteRequest {

    private String departureStation;
    private String arrivalStation;
    private DateTime firstTime;
    private DateTime secondTime;



    private RouteRequest(Builder builder) {
        arrivalStation = builder.arrivalStation;
        departureStation = builder.departureStation;
        firstTime = builder.firstTime;
        secondTime = builder.secondTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(RouteRequest copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.departureStation = copy.departureStation;
        builder.firstTime = copy.firstTime;
        builder.secondTime = copy.secondTime;
        return builder;
    }


    public static final class Builder {
        private String arrivalStation;
        private String departureStation;
        private DateTime firstTime;
        private DateTime secondTime;

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

        public Builder withFirstTime(DateTime val) {
            firstTime = val;
            return this;
        }

        public Builder withSecondTime(DateTime val) {
            secondTime = val;
            return this;
        }

        public RouteRequest build() {
            return new RouteRequest(this);
        }
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public DateTime getFirstTime() {
        return firstTime;
    }

    public DateTime getSecondTime() {
        return secondTime;
    }

}
