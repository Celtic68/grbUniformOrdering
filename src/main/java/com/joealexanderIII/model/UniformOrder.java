package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A class to represent a Uniform Order.
 */
@Entity(name = "UniformOrder")
@Table(name = "grb_uniform_order")
public class UniformOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "JERSEY_SIZE")
    private Integer jerseySize;

    @Column(name = "JERSEY_NUMBER")
    private Integer jerseyNumber;

    @Column(name = "PANTS_SIZE")
    private Integer pantsSize;

    @Column(name = "PANTS_STYLE")
    private Integer pantsStyle;

    @Column(name = "HAT_SIZE")
    private Integer hatSize;

    @Column(name = "SHOE_SIZE")
    private Integer shoeSize;

    @Column(name = "TSHIRT_SIZE")
    private Integer tShirtSize;

    @Column(name = "SHORTS_SIZE")
    private Integer shortsSize;

    @Column(name = "SEASON")
    private Integer season;

    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @ManyToOne
    private Player player;

    /**
     * Instantiates a new Uniform order.
     */
    public UniformOrder() {
    }

    /**
     * Instantiates a new Uniform order.
     *
     * @param jerseySize   the jersey size
     * @param jerseyNumber the jersey number
     * @param pantsSize    the pants size
     * @param pantsStyle   the pants style
     * @param hatSize      the hat size
     * @param shoeSize     the shoe size
     * @param tShirtSize   the t shirt size
     * @param shortsSize   the shorts size
     * @param season       the season
     * @param dateCreated  the date created
     */
    public UniformOrder(Integer jerseySize, Integer jerseyNumber,
                        Integer pantsSize, Integer pantsStyle, Integer hatSize, Integer shoeSize, Integer tShirtSize,
                        Integer shortsSize, Integer season, LocalDateTime dateCreated) {
        this.jerseySize = jerseySize;
        this.jerseyNumber = jerseyNumber;
        this.pantsSize = pantsSize;
        this.pantsStyle = pantsStyle;
        this.hatSize = hatSize;
        this.shoeSize = shoeSize;
        this.tShirtSize = tShirtSize;
        this.shortsSize = shortsSize;
        this.season = season;
        this.dateCreated = dateCreated;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets jersey size.
     *
     * @return the jersey size
     */
    public Integer getJerseySize() {
        return jerseySize;
    }

    /**
     * Sets jersey size.
     *
     * @param jerseySize the jersey size
     */
    public void setJerseySize(Integer jerseySize) {
        this.jerseySize = jerseySize;
    }

    /**
     * Gets jersey number.
     *
     * @return the jersey number
     */
    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * Sets jersey number.
     *
     * @param jerseyNumber the jersey number
     */
    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * Gets pants size.
     *
     * @return the pants size
     */
    public Integer getPantsSize() {
        return pantsSize;
    }

    /**
     * Sets pants size.
     *
     * @param pantsSize the pants size
     */
    public void setPantsSize(Integer pantsSize) {
        this.pantsSize = pantsSize;
    }

    /**
     * Gets pants style.
     *
     * @return the pants style
     */
    public Integer getPantsStyle() {
        return pantsStyle;
    }

    /**
     * Sets pants style.
     *
     * @param pantsStyle the pants style
     */
    public void setPantsStyle(Integer pantsStyle) {
        this.pantsStyle = pantsStyle;
    }

    /**
     * Gets hat size.
     *
     * @return the hat size
     */
    public Integer getHatSize() {
        return hatSize;
    }

    /**
     * Sets hat size.
     *
     * @param hatSize the hat size
     */
    public void setHatSize(Integer hatSize) {
        this.hatSize = hatSize;
    }

    /**
     * Gets shoe size.
     *
     * @return the shoe size
     */
    public Integer getShoeSize() {
        return shoeSize;
    }

    /**
     * Sets shoe size.
     *
     * @param shoeSize the shoe size
     */
    public void setShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }

    /**
     * Gets shirt size.
     *
     * @return the shirt size
     */
    public Integer gettShirtSize() {
        return tShirtSize;
    }

    /**
     * Sets shirt size.
     *
     * @param tShirtSize the t shirt size
     */
    public void settShirtSize(Integer tShirtSize) {
        this.tShirtSize = tShirtSize;
    }

    /**
     * Gets shorts size.
     *
     * @return the shorts size
     */
    public Integer getShortsSize() {
        return shortsSize;
    }

    /**
     * Sets shorts size.
     *
     * @param shortsSize the shorts size
     */
    public void setShortsSize(Integer shortsSize) {
        this.shortsSize = shortsSize;
    }

    /**
     * Gets season.
     *
     * @return the season
     */
    public Integer getSeason() {
        return season;
    }

    /**
     * Sets season.
     *
     * @param season the season
     */
    public void setSeason(Integer season) {
        this.season = season;
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
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "UniformOrder{" +
                "orderId=" + orderId +
                ", jerseySize=" + jerseySize +
                ", jerseyNumber=" + jerseyNumber +
                ", pantsSize=" + pantsSize +
                ", pantsStyle=" + pantsStyle +
                ", hatSize=" + hatSize +
                ", shoeSize=" + shoeSize +
                ", tShirtSize=" + tShirtSize +
                ", shortsSize=" + shortsSize +
                ", season=" + season +
                ", dateCreated=" + dateCreated +
                ", player=" + player +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniformOrder that = (UniformOrder) o;
        return orderId == that.orderId &&
                Objects.equals(jerseySize, that.jerseySize) &&
                Objects.equals(jerseyNumber, that.jerseyNumber) &&
                Objects.equals(pantsSize, that.pantsSize) &&
                Objects.equals(pantsStyle, that.pantsStyle) &&
                Objects.equals(hatSize, that.hatSize) &&
                Objects.equals(shoeSize, that.shoeSize) &&
                Objects.equals(tShirtSize, that.tShirtSize) &&
                Objects.equals(shortsSize, that.shortsSize) &&
                Objects.equals(season, that.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, jerseySize, jerseyNumber, pantsSize, pantsStyle, hatSize, shoeSize, tShirtSize, shortsSize, season);
    }
}
