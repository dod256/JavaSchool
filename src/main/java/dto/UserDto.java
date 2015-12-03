package main.java.dto;

import main.java.Entities.User;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class UserDto {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private DateTime birthdate;
    private int userTypeId;

    public UserDto(){}

    public UserDto(User user) {
        id = user.getId();
        email = user.getEmail();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        password = user.getPassword();
        birthdate = user.getBirthDate();
        userTypeId = user.getUserTypeId();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public DateTime getBirthDate() {
        return birthdate;
    }

    public String getBirthDateString() {
        return birthdate.toString(DateTimeFormat.longDate());
    }

    public int getUserTypeId() {
        return userTypeId;
    }

}
