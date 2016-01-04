package chuggaChugga.data;

import com.google.common.base.MoreObjects;
import chuggaChugga.model.TrainDataSet;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class TrainArrivalTime {
    private DateTime arrivalTime;
    private TrainDataSet train;

    private TrainArrivalTime(Builder builder) {
        arrivalTime = builder.arrivalTime;
        train = builder.train;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TrainArrivalTime copy) {
        Builder builder = new Builder();
        builder.arrivalTime = copy.arrivalTime;
        builder.train = copy.train;
        return builder;
    }

    public static final class Builder {
        private DateTime arrivalTime;
        private TrainDataSet train;

        private Builder() {
        }

        public Builder withArrivalTime(DateTime val) {
            arrivalTime = val;
            return this;
        }

        public Builder withTrain(TrainDataSet val) {
            train = val;
            return this;
        }

        public TrainArrivalTime build() {
            return new TrainArrivalTime(this);
        }
    }

    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalTimeString() { return arrivalTime.toString(DateTimeFormat.shortTime()); }

    public TrainDataSet getTrain() {
        return train;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrivalTime", arrivalTime)
                .add("train", train)
                .toString();
    }
}
