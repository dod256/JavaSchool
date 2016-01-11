package chuggaChugga.data;

import java.time.LocalDateTime;

public class TicketForReport {
    private final String userFirstName;
    private final String userLastName;
    private final String trainName;
    private final String departureStation;
    private final String arrivalStation;
    private final int cost;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    private TicketForReport(Builder builder) {
        userFirstName = builder.userFirstName;
        userLastName = builder.userLastName;
        trainName = builder.trainName;
        departureStation = builder.departureStation;
        arrivalStation = builder.arrivalStation;
        cost = builder.cost;
        departureDate = builder.departureDate;
        arrivalDate = builder.arrivalDate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String userFirstName;
        private String userLastName;
        private String trainName;
        private String departureStation;
        private String arrivalStation;
        private int cost;
        private LocalDateTime departureDate;
        private LocalDateTime arrivalDate;

        private Builder() {
        }

        public Builder withUserFirstName(String val) {
            userFirstName = val;
            return this;
        }

        public Builder withUserLastName(String val) {
            userLastName = val;
            return this;
        }

        public Builder withTrainName(String val) {
            trainName = val;
            return this;
        }

        public Builder withDepartureStation(String val) {
            departureStation = val;
            return this;
        }

        public Builder withArrivalStation(String val) {
            arrivalStation = val;
            return this;
        }

        public Builder withCost(int val) {
            cost = val;
            return this;
        }

        public Builder withDepartureDate(LocalDateTime val) {
            departureDate = val;
            return this;
        }

        public Builder withArrivalDate(LocalDateTime val) {
            arrivalDate = val;
            return this;
        }

        public TicketForReport build() {
            return new TicketForReport(this);
        }
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public int getCost() {
        return cost;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "TicketForReport{" +
                "userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", trainName='" + trainName + '\'' +
                ", departureStation='" + departureStation + '\'' +
                ", arrivalStation='" + arrivalStation + '\'' +
                ", cost=" + cost +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
