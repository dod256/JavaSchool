package main;

import org.joda.time.DateTime;

import java.util.Date;

public class User {

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    private String email;
    private String name;
    private String surname;
    private DateTime birthDate;

    public User(String email, String name, String surname, DateTime birthDate) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    User(){}
}
