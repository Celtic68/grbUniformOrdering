package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a User.
 */
@Entity(name = "User")
@Table(name = "grb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_FIRST_NAME")
    private String userFirstName;

    @Column(name = "USER_LAST_NAME")
    private String userLastName;

    @Column(name = "USER_ADDRESS_1")
    private String userAddress1;

    @Column(name = "USER_ADDRESS_2")
    private String userAddress2;

    @Column(name = "USER_CITY")
    private String userCity;

    @Column(name = "USER_STATE")
    private String userState;

    @Column(name = "USER_ZIP")
    private String userZip;

    @Column(name = "USER_PHONE")
    private long userPhone;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Player> players = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id            the id
     * @param userName      the user name
     * @param userPassword  the user password
     * @param userFirstName the user first name
     * @param userLastName  the user last name
     * @param userAddress1  the user address 1
     * @param userAddress2  the user address 2
     * @param userCity      the user city
     * @param userState     the user state
     * @param userZip       the user zip
     * @param userPhone     the user phone
     * @param userEmail     the user email
     * @param dateCreated   the date created
     */
    public User(int id, String userName, String userPassword, String userFirstName, String userLastName,
                String userAddress1, String userAddress2, String userCity, String userState,
                String userZip, long userPhone, String userEmail, LocalDateTime dateCreated) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAddress1 = userAddress1;
        this.userAddress2 = userAddress2;
        this.userCity = userCity;
        this.userState = userState;
        this.userZip = userZip;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.dateCreated = dateCreated;
    }

    /**
     * Instantiates a new User.
     *
     * @param userName      the user name
     * @param userPassword  the user password
     * @param userFirstName the user first name
     * @param userLastName  the user last name
     * @param userAddress1  the user address 1
     * @param userAddress2  the user address 2
     * @param userCity      the user city
     * @param userState     the user state
     * @param userZip       the user zip
     * @param userPhone     the user phone
     * @param userEmail     the user email
     * @param dateCreated   the date created
     */
    public User(String userName, String userPassword, String userFirstName, String userLastName,
                String userAddress1, String userAddress2, String userCity, String userState,
                String userZip, long userPhone, String userEmail, LocalDateTime dateCreated) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAddress1 = userAddress1;
        this.userAddress2 = userAddress2;
        this.userCity = userCity;
        this.userState = userState;
        this.userZip = userZip;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.dateCreated = dateCreated;
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
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets user first name.
     *
     * @return the user first name
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * Sets user first name.
     *
     * @param userFirstName the user first name
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    /**
     * Gets user last name.
     *
     * @return the user last name
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * Sets user last name.
     *
     * @param userLastName the user last name
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    /**
     * Gets user address 1.
     *
     * @return the user address 1
     */
    public String getUserAddress1() {
        return userAddress1;
    }

    /**
     * Sets user address 1.
     *
     * @param userAddress1 the user address 1
     */
    public void setUserAddress1(String userAddress1) {
        this.userAddress1 = userAddress1;
    }

    /**
     * Gets user address 2.
     *
     * @return the user address 2
     */
    public String getUserAddress2() {
        return userAddress2;
    }

    /**
     * Sets user address 2.
     *
     * @param userAddress2 the user address 2
     */
    public void setUserAddress2(String userAddress2) {
        this.userAddress2 = userAddress2;
    }

    /**
     * Gets user city.
     *
     * @return the user city
     */
    public String getUserCity() {
        return userCity;
    }

    /**
     * Sets user city.
     *
     * @param userCity the user city
     */
    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    /**
     * Gets user state.
     *
     * @return the user state
     */
    public String getUserState() {
        return userState;
    }

    /**
     * Sets user state.
     *
     * @param userState the user state
     */
    public void setUserState(String userState) {
        this.userState = userState;
    }

    /**
     * Gets user zip.
     *
     * @return the user zip
     */
    public String getUserZip() {
        return userZip;
    }

    /**
     * Sets user zip.
     *
     * @param userZip the user zip
     */
    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    /**
     * Gets user phone.
     *
     * @return the user phone
     */
    public long getUserPhone() {
        return userPhone;
    }

    /**
     * Sets user phone.
     *
     * @param userPhone the user phone
     */
    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email.
     *
     * @param userEmail the user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets date created.
     *
     * @return the date created
     */
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets date created.
     *
     * @param dateCreated the date created
     */
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets players.
     *
     * @return the players
     */
    public Set<Player> getPlayers() {
        return players;
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userAddress1='" + userAddress1 + '\'' +
                ", userAddress2='" + userAddress2 + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userState='" + userState + '\'' +
                ", userZip='" + userZip + '\'' +
                ", userPhone=" + userPhone +
                ", userEmail='" + userEmail + '\'' +
                ", dateCreated=" + dateCreated +
                ", players=" + players +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                userPhone == user.userPhone &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userAddress1, user.userAddress1) &&
                Objects.equals(userAddress2, user.userAddress2) &&
                Objects.equals(userCity, user.userCity) &&
                Objects.equals(userState, user.userState) &&
                Objects.equals(userZip, user.userZip) &&
                Objects.equals(userEmail, user.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPassword, userFirstName, userLastName, userAddress1, userAddress2, userCity, userState, userZip, userPhone, userEmail, dateCreated);
    }
}
