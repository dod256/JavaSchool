package main.java.data;

import com.google.common.base.MoreObjects;
import main.java.dto.UserDto;

public class TicketRequest {

    private UserDto userDto;
    private int trainId;
    private String departureStation;
    private String arrivalStation;

    private TicketRequest(Builder builder) {
        arrivalStation = builder.arrivalStation;
        userDto = builder.userDto;
        trainId = builder.trainId;
        departureStation = builder.departureStation;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TicketRequest copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.userDto = copy.userDto;
        builder.trainId = copy.trainId;
        builder.departureStation = copy.departureStation;
        return builder;
    }


    public static final class Builder {
        private String arrivalStation;
        private UserDto userDto;
        private int trainId;
        private String departureStation;

        private Builder() {
        }

        public Builder withArrivalStation(String val) {
            arrivalStation = val;
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

        public Builder withDepartureStation(String val) {
            departureStation = val;
            return this;
        }

        public TicketRequest build() {
            return new TicketRequest(this);
        }
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
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
                .add("arrivalStation", arrivalStation)
                .add("userDto", userDto)
                .add("trainId", trainId)
                .add("departureStation", departureStation)
                .toString();
    }
}
