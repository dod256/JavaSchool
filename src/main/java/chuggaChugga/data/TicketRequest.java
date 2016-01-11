package chuggaChugga.data;

import chuggaChugga.model.TrainDataSet;
import com.google.common.base.MoreObjects;
import chuggaChugga.dto.UserDto;

public class TicketRequest {

    private UserDto userDto;
    private TrainDataSet train;
    private String departureStation;
    private String arrivalStation;

    private TicketRequest(Builder builder) {
        arrivalStation = builder.arrivalStation;
        userDto = builder.userDto;
        train = builder.train;
        departureStation = builder.departureStation;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TicketRequest copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.userDto = copy.userDto;
        builder.train = copy.train;
        builder.departureStation = copy.departureStation;
        return builder;
    }

    public static final class Builder {
        private String arrivalStation;
        private UserDto userDto;
        private TrainDataSet train;
        private String departureStation;

        private Builder() {
        }

        public Builder withArrivalStation(String val) {
            arrivalStation = val;
            return this;
        }

        public Builder withUser(UserDto val) {
            userDto = val;
            return this;
        }

        public Builder withTrain(TrainDataSet val) {
            train = val;
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

    public String getDepartureStation() {
        return departureStation;
    }

    public TrainDataSet getTrain() {
        return train;
    }

    public UserDto getUser() {
        return userDto;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrivalStation", arrivalStation)
                .add("userDto", userDto)
                .add("train", train)
                .add("departureStation", departureStation)
                .toString();
    }
}
