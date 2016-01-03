package chuggaChugga.data;

import com.google.common.base.MoreObjects;
import chuggaChugga.model.Train;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class TrainRouteTime {
    private Train train;
    private DateTime departureTime;
    private DateTime arrivalTime;

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
        private DateTime arrivalTime;
        private Train train;
        private DateTime departureTime;

        private Builder() {
        }

        public Builder withArrivalTime(DateTime val) {
            arrivalTime = val;
            return this;
        }

        public Builder withTrain(Train val) {
            train = val;
            return this;
        }

        public Builder withDepartureTime(DateTime val) {
            departureTime = val;
            return this;
        }

        public TrainRouteTime build() {
            return new TrainRouteTime(this);
        }
    }

    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalTimeString() {
        return arrivalTime.toString(DateTimeFormat.shortTime());
    }


    public void setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public DateTime getDepartureTime() {
        return departureTime;
    }

    public String getDepartureTimeString() {
        return departureTime.toString(DateTimeFormat.shortTime());
    }

    public void setDepartureTime(DateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
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
