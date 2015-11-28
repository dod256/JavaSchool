package main.java.Entities;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class User {

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName; }

    public DateTime getBirthDate() {
        return new DateTime(birthDate);
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String password) { return password.equals(this.password); }

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Date birthDate;

    public User(String email, String password, String firstName, String lastName, DateTime birthDate) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = new Date(birthDate.getMillis());
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = new Date(birthDate.getMillis());
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
