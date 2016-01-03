package chuggaChugga.model;

import com.google.common.base.MoreObjects;
import chuggaChugga.dto.UserDto;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


/*
* Represent User table from the DB
* */
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Date birthdate;
    private int userTypeId;

    public User (UserDto userDto) {
        this.id = userDto.getId();
        this.email = userDto.getEmail();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.password = userDto.getPassword();
        this.birthdate = new Date(userDto.getBirthDate().getMillis());
        this.userTypeId = userDto.getUserTypeId();
    }

    private User(Builder builder) {
        birthdate = builder.birthdate;
        email = builder.email;
        firstName = builder.firstName;
        lastName = builder.lastName;
        password = builder.password;
        userTypeId = builder.userTypeId;
        id = builder.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(User copy) {
        Builder builder = new Builder();
        builder.birthdate = copy.birthdate;
        builder.email = copy.email;
        builder.firstName = copy.firstName;
        builder.lastName = copy.lastName;
        builder.password = copy.password;
        builder.userTypeId = copy.userTypeId;
        builder.id = copy.id;
        return builder;
    }


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

    public static final class Builder {
        private Date birthdate;
        private String email;
        private String firstName;
        private String lastName;
        private String password;
        private int userTypeId;
        private int id;

        private Builder() {
        }

        public Builder withBirthdate(Date val) {
            birthdate = val;
            return this;
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

        public Builder withUserTypeId(int val) {
            userTypeId = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("birthdate", birthdate)
                .add("email", email)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("password", password)
                .add("userTypeId", userTypeId)
                .toString();
    }
}
