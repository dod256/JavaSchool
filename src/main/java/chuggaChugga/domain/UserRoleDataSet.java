package chuggaChugga.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserRole")
public class UserRoleDataSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name="userId")
    private UserDataSet user;
    private String userRole;

    private UserRoleDataSet(Builder builder) {
        id = builder.id;
        user = builder.user;
        userRole = builder.userRole;
    }

    public UserRoleDataSet() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private UserDataSet user;
        private String userRole;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withUser(UserDataSet val) {
            user = val;
            return this;
        }

        public Builder withUserRole(String val) {
            userRole = val;
            return this;
        }

        public UserRoleDataSet build() {
            return new UserRoleDataSet(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDataSet getUser() {
        return user;
    }

    public void setUser(UserDataSet user) {
        this.user = user;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
