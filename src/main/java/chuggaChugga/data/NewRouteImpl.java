package chuggaChugga.data;

import java.util.ArrayList;

public class NewRouteImpl implements NewRoute {

    private final ArrayList<NewRouteStation> routeStations;

    private NewRouteImpl(Builder builder) {
        routeStations = builder.routeStations;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public ArrayList<NewRouteStation> getRouteStations() {
        return routeStations;
    }

    @Override
    public String toString() {
        return "NewRouteImpl{" +
                "routeStations=" + routeStations +
                '}';
    }

    public static final class Builder {
        private ArrayList<NewRouteStation> routeStations;

        private Builder() {
        }

        public Builder withRouteStations(ArrayList<NewRouteStation> val) {
            routeStations = val;
            return this;
        }

        public ArrayList<NewRouteStation> getRouteStations() {
            return this.routeStations;
        }

        public Builder withNewRouteStation(NewRouteStation val) {
            ArrayList<NewRouteStation> newList = new ArrayList<>(routeStations);
            newList.add(val);
            routeStations = newList;
            return this;
        }




        public NewRouteImpl build() {
            return new NewRouteImpl(this);
        }
    }

    /*
    * newRoute by this
    *
    * builder to add new newroutestation at List
    * */
}
