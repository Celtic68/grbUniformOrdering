package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a Baseball Season.
 */
@Entity(name = "Season")
@Table(name = "grb_seasons")

public class Season {

    @Id
    @Column(name = "SEASON_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "SEASON_DESCRIPTION")
    private String seasonDescription;

    /**
     * Instantiates a new Season.
     */
    public Season() {
    }

    /**
     * Instantiates a new Season.
     *
     * @param seasonDescription the season description
     */
    public Season(String seasonDescription) {
        this.seasonDescription = seasonDescription;
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
     * Gets season description.
     *
     * @return the season description
     */
    public String getSeasonDescription() {
        return seasonDescription;
    }

    /**
     * Sets season description.
     *
     * @param seasonDescription the season description
     */
    public void setSeasonDescription(String seasonDescription) {
        this.seasonDescription = seasonDescription;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", seasonDescription='" + seasonDescription + '\'' +
                '}';
    }

}
