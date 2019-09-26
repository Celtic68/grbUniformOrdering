package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a User Role.
 */
@Entity(name = "Role")
@Table(name = "grb_user_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ROLE")
    private String userRole;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param id       the id
     * @param userName the user name
     * @param userRole the user role
     */
    public Role(int id, String userName, String userRole) {
        this.id = id;
        this.userName = userName;
        this.userRole = userRole;
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
}
