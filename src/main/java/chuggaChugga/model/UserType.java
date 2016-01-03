package chuggaChugga.model;


/*
* Represent UserType table from the DB
* */
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
