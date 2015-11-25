package main;

import org.joda.time.DateTime;

import java.util.Date;

public class User {

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName; }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String password) { return password.equals(this.password); }

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private DateTime birthDate;

    public User(String email, String password, String firstName, String lastName, DateTime birthDate) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    User(){}
}
