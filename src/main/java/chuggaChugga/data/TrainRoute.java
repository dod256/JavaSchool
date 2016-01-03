package chuggaChugga.data;

import com.google.common.base.MoreObjects;
import chuggaChugga.model.Train;

public class TrainRoute {

    private Train train;
    private Route route;

    private TrainRoute(Builder builder) {
        route = builder.route;
        train = builder.train;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TrainRoute copy) {
        Builder builder = new Builder();
        builder.route = copy.route;
        builder.train = copy.train;
        return builder;
    }


    public static final class Builder {
        private Route route;
        private Train train;

        private Builder() {
        }

        public Builder withRoute(Route val) {
            route = val;
            return this;
        }

        public Builder withTrain(Train val) {
            train = val;
            return this;
        }

        public TrainRoute build() {
            return new TrainRoute(this);
        }
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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
                .add("route", route)
                .add("train", train)
                .toString();
    }
}
