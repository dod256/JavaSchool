package main.java.Entities;

public enum UserType {
    ADMIN(1), CUSTOMER(2);

    private int id;

    UserType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
