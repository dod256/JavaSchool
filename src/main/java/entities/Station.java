package main.java.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {

    private int id;
    @Id
    private String name;

    public Station() {}

    private Station(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Station copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        return builder;
    }

    public static final class Builder {
        private int id;
        private String name;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Station build() {
            return new Station(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
