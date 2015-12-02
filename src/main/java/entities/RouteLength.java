package main.java.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RouteLength {
    @Id
    private int id;
    private int routeLength;

    public RouteLength(int routeLength) {
        this.routeLength = routeLength;
    }

    public RouteLength() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(int routeLength) {
        this.routeLength = routeLength;
    }
}
