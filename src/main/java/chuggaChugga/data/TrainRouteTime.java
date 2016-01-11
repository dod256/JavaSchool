package chuggaChugga.data;

import chuggaChugga.dto.TrainDto;
import chuggaChugga.model.TrainDataSet;
import com.google.common.base.MoreObjects;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

public class TrainRouteTime {
    private TrainDto train;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    private TrainRouteTime(Builder builder) {
        arrivalTime = builder.arrivalTime;
        train = builder.train;
        departureTime = builder.departureTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TrainRouteTime copy) {
        Builder builder = new Builder();
        builder.arrivalTime = copy.arrivalTime;
        builder.train = copy.train;
        builder.departureTime = copy.departureTime;
        return builder;
    }


    public static final class Builder {
        private LocalTime arrivalTime;
        private TrainDto train;
        private LocalTime departureTime;

        private Builder() {
        }

        public Builder withArrivalTime(LocalTime val) {
            arrivalTime = val;
            return this;
        }

        public Builder withTrain(TrainDto val) {
            train = val;
            return this;
        }

        public Builder withDepartureTime(LocalTime val) {
            departureTime = val;
            return this;
        }

        public TrainRouteTime build() {
            return new TrainRouteTime(this);
        }
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalTimeString() {
        return arrivalTime.toString(DateTimeFormat.shortTime());
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getDepartureTimeString() {
        return departureTime.toString(DateTimeFormat.shortTime());
    }

    public TrainDto getTrain() {
        return train;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrivalTime", arrivalTime)
                .add("train", train)
                .add("departureTime", departureTime)
                .toString();
    }
}
