package data;

public class RouteRequest {

    private String departureStation;
    private String arrivalStation;

    private RouteRequest(Builder builder) {
        arrivalStation = builder.arrivalStation;
        departureStation = builder.departureStation;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(RouteRequest copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.departureStation = copy.departureStation;
        return builder;
    }


    public static final class Builder {
        private String arrivalStation;
        private String departureStation;

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

}
