package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a Location.
 */
@Entity(name = "Location")
@Table(name = "grb_locations")
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "LOCATION_DESCRIPTION")
    private String locationDescription;

    /**
     * Instantiates a new Location.
     */
    public Location() {
    }

    /**
     * Instantiates a new Location.
     *
     * @param locationDescription the location description
     */
    public Location(String locationDescription) {
        this.locationDescription = locationDescription;
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
     * Gets location description.
     *
     * @return the location description
     */
    public String getLocationDescription() {
        return locationDescription;
    }

    /**
     * Sets location description.
     *
     * @param locationDescription the location description
     */
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", locationDescription='" + locationDescription + '\'' +
                '}';
    }

}
