package main.java.builders;

import main.java.Entities.Train;
import main.java.data.Route;
import main.java.data.TrainRoute;

public class TrainRouteBuilder {
    private Train train;
    private Route route;

    public TrainRouteBuilder setTrain(Train train) {
        this.train = train;
        return this;
    }

    public TrainRouteBuilder setRoute(Route route) {
        this.route = route;
        return this;
    }

    public TrainRoute createTrainRoute() {
        return new TrainRoute(train, route);
    }
}