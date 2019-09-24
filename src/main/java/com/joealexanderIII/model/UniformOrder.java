package com.joealexanderIII.model;

import java.time.LocalDateTime;

/**
 * A class to represent a Uniform Order.
 */
public class UniformOrder {

    private int orderId;
    private int playerId;
    private int jerseySize;
    private int jerseyNumber;
    private int pantsSize;
    private int pantsStyle;
    private int hatSize;
    private int shoeSize;
    private int tShirtSize;
    private int shortsSize;
    private int season;
    private LocalDateTime dateCreated;

    /**
     * Instantiates a new Uniform order.
     */
    public UniformOrder() {
    }

    /**
     * Instantiates a new Uniform order.
     *
     * @param orderId      the order id
     * @param playerId     the player id
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
    public UniformOrder(int orderId, int playerId, int jerseySize, int jerseyNumber,
                        int pantsSize, int pantsStyle, int hatSize, int shoeSize, int tShirtSize,
                        int shortsSize, int season, LocalDateTime dateCreated) {
        this.orderId = orderId;
        this.playerId = playerId;
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
     * Gets player id.
     *
     * @return the player id
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Sets player id.
     *
     * @param playerId the player id
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * Gets jersey size.
     *
     * @return the jersey size
     */
    public int getJerseySize() {
        return jerseySize;
    }

    /**
     * Sets jersey size.
     *
     * @param jerseySize the jersey size
     */
    public void setJerseySize(int jerseySize) {
        this.jerseySize = jerseySize;
    }

    /**
     * Gets jersey number.
     *
     * @return the jersey number
     */
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * Sets jersey number.
     *
     * @param jerseyNumber the jersey number
     */
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * Gets pants size.
     *
     * @return the pants size
     */
    public int getPantsSize() {
        return pantsSize;
    }

    /**
     * Sets pants size.
     *
     * @param pantsSize the pants size
     */
    public void setPantsSize(int pantsSize) {
        this.pantsSize = pantsSize;
    }

    /**
     * Gets pants style.
     *
     * @return the pants style
     */
    public int getPantsStyle() {
        return pantsStyle;
    }

    /**
     * Sets pants style.
     *
     * @param pantsStyle the pants style
     */
    public void setPantsStyle(int pantsStyle) {
        this.pantsStyle = pantsStyle;
    }

    /**
     * Gets hat size.
     *
     * @return the hat size
     */
    public int getHatSize() {
        return hatSize;
    }

    /**
     * Sets hat size.
     *
     * @param hatSize the hat size
     */
    public void setHatSize(int hatSize) {
        this.hatSize = hatSize;
    }

    /**
     * Gets shoe size.
     *
     * @return the shoe size
     */
    public int getShoeSize() {
        return shoeSize;
    }

    /**
     * Sets shoe size.
     *
     * @param shoeSize the shoe size
     */
    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    /**
     * Gets shirt size.
     *
     * @return the shirt size
     */
    public int gettShirtSize() {
        return tShirtSize;
    }

    /**
     * Sets shirt size.
     *
     * @param tShirtSize the t shirt size
     */
    public void settShirtSize(int tShirtSize) {
        this.tShirtSize = tShirtSize;
    }

    /**
     * Gets shorts size.
     *
     * @return the shorts size
     */
    public int getShortsSize() {
        return shortsSize;
    }

    /**
     * Sets shorts size.
     *
     * @param shortsSize the shorts size
     */
    public void setShortsSize(int shortsSize) {
        this.shortsSize = shortsSize;
    }

    /**
     * Gets season.
     *
     * @return the season
     */
    public int getSeason() {
        return season;
    }

    /**
     * Sets season.
     *
     * @param season the season
     */
    public void setSeason(int season) {
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
}
