package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

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
    private List<UniformOrder> orders = new ArrayList<>();

    /**
     * Instantiates a new Player.
     */
    public Player() {
    }

    /**
     * Instantiates a new Player.
     *
     * @param playerFirstName    the player first name
     * @param playerLastName     the player last name
     * @param playerSiteLocation the player site location
     * @param playerAgeGroup     the player age group
     */
    public Player(String playerFirstName, String playerLastName,
                  int playerSiteLocation, String playerAgeGroup) {
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
    public List<UniformOrder> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<UniformOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerFirstName='" + playerFirstName + '\'' +
                ", playerLastName='" + playerLastName + '\'' +
                ", playerSiteLocation=" + playerSiteLocation +
                ", playerAgeGroup='" + playerAgeGroup + '\'' +
                ", user=" + user +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                playerSiteLocation == player.playerSiteLocation &&
                Objects.equals(playerFirstName, player.playerFirstName) &&
                Objects.equals(playerLastName, player.playerLastName) &&
                Objects.equals(playerAgeGroup, player.playerAgeGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerFirstName, playerLastName, playerSiteLocation, playerAgeGroup);
    }
}
