package main.java.data;

import main.java.Entities.Train;

public class TrainRoute {

    private Train train;
    private Route route;

    public Train getTrain() {
        return train;
    }

    public Route getRoute() {
        return route;
    }

    public TrainRoute(Train train, Route route) {
        this.train = train;
        this.route = route;
    }
}
