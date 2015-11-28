package main.java;

import org.joda.time.DateTime;

public class UserBuilder {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private DateTime birthDate;

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public User createUser() {
        return new User(email, password, firstName, lastName, birthDate);
    }
}
