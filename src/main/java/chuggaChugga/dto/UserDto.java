package chuggaChugga.dto;

import chuggaChugga.model.UserDataSet;
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
    private int balance;

    public UserDto(){}

    private UserDto(Builder builder) {
        id = builder.id;
        email = builder.email;
        firstName = builder.firstName;
        lastName = builder.lastName;
        password = builder.password;
        birthdate = builder.birthdate;
        userTypeId = builder.userTypeId;
        balance = builder.balance;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(UserDto copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.email = copy.email;
        builder.firstName = copy.firstName;
        builder.lastName = copy.lastName;
        builder.password = copy.password;
        builder.birthdate = copy.birthdate;
        builder.userTypeId = copy.userTypeId;
        builder.balance = copy.balance;
        return builder;
    }

    public static Builder newBuilder(UserDataSet copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.email = copy.getEmail();
        builder.firstName = copy.getFirstName();
        builder.lastName = copy.getLastName();
        builder.password = copy.getPassword();
        builder.birthdate = copy.getBirthDate();
        builder.userTypeId = copy.getUserTypeId();
        builder.balance = copy.getBalance();
        return builder;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public boolean checkPassword(String password) { return password.equals(this.password); }

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

    public static final class Builder {
        private int id;
        private String email;
        private String firstName;
        private String lastName;
        private String password;
        private DateTime birthdate;
        private int userTypeId;
        private int balance;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withBalance(int val) {
            balance = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public Builder withBirthdate(DateTime val) {
            birthdate = val;
            return this;
        }

        public Builder withUserTypeId(int val) {
            userTypeId = val;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}
