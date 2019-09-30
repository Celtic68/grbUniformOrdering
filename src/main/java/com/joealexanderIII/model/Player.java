package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a Player.
 */
@Entity(name = "Player")
@Table(name = "grb_player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "PLAYER_FIRST_NAME")
    private String playerFirstName;

    @Column(name = "PLAYER_LAST_NAME")
    private String playerLastName;

    @Column(name = "SITE_LOCATION")
    private int playerSiteLocation;

    @Column(name = "AGE_GROUP")
    private String playerAgeGroup;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UniformOrder> orders = new HashSet<>();

    /**
     * Instantiates a new Player.
     */
    public Player() {
    }

    /**
     * Instantiates a new Player.
     *
     * @param id                 the id
     * @param userId             the user id
     * @param playerFirstName    the player first name
     * @param playerLastName     the player last name
     * @param playerSiteLocation the player site location
     * @param playerAgeGroup     the player age group
     */
    public Player(int id, int userId, String playerFirstName, String playerLastName,
                  int playerSiteLocation, String playerAgeGroup) {
        this.id = id;
        this.userId = userId;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerSiteLocation = playerSiteLocation;
        this.playerAgeGroup = playerAgeGroup;
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
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets player first name.
     *
     * @return the player first name
     */
    public String getPlayerFirstName() {
        return playerFirstName;
    }

    /**
     * Sets player first name.
     *
     * @param playerFirstName the player first name
     */
    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    /**
     * Gets player last name.
     *
     * @return the player last name
     */
    public String getPlayerLastName() {
        return playerLastName;
    }

    /**
     * Sets player last name.
     *
     * @param playerLastName the player last name
     */
    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    /**
     * Gets player site location.
     *
     * @return the player site location
     */
    public int getPlayerSiteLocation() {
        return playerSiteLocation;
    }

    /**
     * Sets player site location.
     *
     * @param playerSiteLocation the player site location
     */
    public void setPlayerSiteLocation(int playerSiteLocation) {
        this.playerSiteLocation = playerSiteLocation;
    }

    /**
     * Gets player age group.
     *
     * @return the player age group
     */
    public String getPlayerAgeGroup() {
        return playerAgeGroup;
    }

    /**
     * Sets player age group.
     *
     * @param playerAgeGroup the player age group
     */
    public void setPlayerAgeGroup(String playerAgeGroup) {
        this.playerAgeGroup = playerAgeGroup;
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

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public Set<UniformOrder> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(Set<UniformOrder> orders) {
        this.orders = orders;
    }
}
