package main.java.Entities;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class User {

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Date birthdate;
    private int userTypeId;

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }


    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName; }

    public DateTime getBirthDate() {
        return new DateTime(birthdate);
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String password) { return password.equals(this.password); }

    public User(String email, String password, String firstName, String lastName, DateTime birthDate) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = new Date(birthDate.getMillis());
        this.userTypeId = 1;
    }

    public void setBirthDate(Date birthDate) {
        this.birthdate = birthDate;
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
