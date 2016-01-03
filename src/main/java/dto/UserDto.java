package dto;

import model.User;
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

    private UserDto(Builder builder) {
        id = builder.id;
        email = builder.email;
        firstName = builder.firstName;
        lastName = builder.lastName;
        password = builder.password;
        birthdate = builder.birthdate;
        userTypeId = builder.userTypeId;
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
        return builder;
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

    public static final class Builder {
        private int id;
        private String email;
        private String firstName;
        private String lastName;
        private String password;
        private DateTime birthdate;
        private int userTypeId;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
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
