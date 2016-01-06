package chuggaChugga.data;

import chuggaChugga.model.TrainDataSet;
import com.google.common.base.MoreObjects;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

public class TrainRouteTime {
    private TrainDataSet train;
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
        private TrainDataSet train;
        private LocalTime departureTime;

        private Builder() {
        }

        public Builder withArrivalTime(LocalTime val) {
            arrivalTime = val;
            return this;
        }

        public Builder withTrain(TrainDataSet val) {
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


    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getDepartureTimeString() {
        return departureTime.toString(DateTimeFormat.shortTime());
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public TrainDataSet getTrain() {
        return train;
    }

    public void setTrain(TrainDataSet train) {
        this.train = train;
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
