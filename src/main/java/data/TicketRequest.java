package main.java.data;

import com.google.common.base.MoreObjects;
import main.java.dto.UserDto;

public class TicketRequest {

    private UserDto userDto;
    private int trainId;
    private int routeNumberOfDepartureStation;
    private int routeNumberOfArrivalStation;

    private TicketRequest(Builder builder) {
        routeNumberOfArrivalStation = builder.routeNumberOfArrivalStation;
        userDto = builder.userDto;
        trainId = builder.trainId;
        routeNumberOfDepartureStation = builder.routeNumberOfDepartureStation;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TicketRequest copy) {
        Builder builder = new Builder();
        builder.routeNumberOfArrivalStation = copy.routeNumberOfArrivalStation;
        builder.userDto = copy.userDto;
        builder.trainId = copy.trainId;
        builder.routeNumberOfDepartureStation = copy.routeNumberOfDepartureStation;
        return builder;
    }


    public static final class Builder {
        private int routeNumberOfArrivalStation;
        private UserDto userDto;
        private int trainId;
        private int routeNumberOfDepartureStation;

        private Builder() {
        }

        public Builder withRouteNumberOfArrivalStation(int val) {
            routeNumberOfArrivalStation = val;
            return this;
        }

        public Builder withUserDto(UserDto val) {
            userDto = val;
            return this;
        }

        public Builder withTrainId(int val) {
            trainId = val;
            return this;
        }

        public Builder withRouteNumberOfDepartureStation(int val) {
            routeNumberOfDepartureStation = val;
            return this;
        }

        public TicketRequest build() {
            return new TicketRequest(this);
        }
    }

    public int getRouteNumberOfArrivalStation() {
        return routeNumberOfArrivalStation;
    }

    public void setRouteNumberOfArrivalStation(int routeNumberOfArrivalStation) {
        this.routeNumberOfArrivalStation = routeNumberOfArrivalStation;
    }

    public int getRouteNumberOfDepartureStation() {
        return routeNumberOfDepartureStation;
    }

    public void setRouteNumberOfDepartureStation(int routeNumberOfDepartureStation) {
        this.routeNumberOfDepartureStation = routeNumberOfDepartureStation;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("routeNumberOfArrivalStation", routeNumberOfArrivalStation)
                .add("userDto", userDto)
                .add("trainId", trainId)
                .add("routeNumberOfDepartureStation", routeNumberOfDepartureStation)
                .toString();
    }
}
