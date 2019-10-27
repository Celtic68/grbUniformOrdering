package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a Location.
 */
@Entity(name = "AgeGroup")
@Table(name = "grb_age_groups")

public class AgeGroup {

    @Id
    @Column(name = "AGE_GROUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "AGE_GROUP_DESCRIPTION")
    private String ageGroupDescription;

    /**
     * Instantiates a new Age group.
     */
    public AgeGroup() {
    }

    /**
     * Instantiates a new Age group.
     *
     * @param ageGroupDescription the age group description
     */
    public AgeGroup(String ageGroupDescription) {
        this.ageGroupDescription = ageGroupDescription;
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
     * Gets age group description.
     *
     * @return the age group description
     */
    public String getAgeGroupDescription() {
        return ageGroupDescription;
    }

    /**
     * Sets age group description.
     *
     * @param ageGroupDescription the age group description
     */
    public void setAgeGroupDescription(String ageGroupDescription) {
        this.ageGroupDescription = ageGroupDescription;
    }

    @Override
    public String toString() {
        return "AgeGroup{" +
                "id=" + id +
                ", ageGroupDescription='" + ageGroupDescription + '\'' +
                '}';
    }

}
