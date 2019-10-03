package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Objects;

/**
 * A class to represent a User Role.
 */
@Entity(name = "Role")
@Table(name = "grb_user_roles")
public class Role {

    @Id
    @GeneratedValue(generator = "foreigngen")
    @GenericGenerator(name="foreigngen", strategy = "foreign",
            parameters = @Parameter(name = "property", value="user"))
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ROLE")
    private String userRole;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param userName the user name
     * @param userRole the user role
     */
    public Role(String userName, String userRole) {
        this.userName = userName;
        this.userRole = userRole;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user role.
     *
     * @return the user role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets user role.
     *
     * @param userRole the user role
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(userName, role.userName) &&
                Objects.equals(userRole, role.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userRole);
    }
}
