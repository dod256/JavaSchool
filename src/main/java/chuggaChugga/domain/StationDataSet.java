package chuggaChugga.domain;

import javax.persistence.*;

/*
* Represent Station table from the DB
* */
@Entity
@Table(name = "Station")
public class StationDataSet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;

    public StationDataSet() {}

    private StationDataSet(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(StationDataSet copy) {
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

        public StationDataSet build() {
            return new StationDataSet(this);
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


    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StationDataSet that = (StationDataSet) o;

        if (id != that.id) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
