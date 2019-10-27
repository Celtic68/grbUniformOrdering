package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a Pants Style.
 */
@Entity(name = "PantsStyle")
@Table(name = "grb_pants_styles")

public class PantsStyle {

    @Id
    @Column(name = "STYLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "STYLE_DESCRIPTION")
    private String styleDescription;

    /**
     * Instantiates a new Pants style.
     */
    public PantsStyle() {
    }

    /**
     * Instantiates a new Pants style.
     *
     * @param styleDescription the style description
     */
    public PantsStyle(String styleDescription) {
        this.styleDescription = styleDescription;
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
     * Gets style description.
     *
     * @return the style description
     */
    public String getStyleDescription() {
        return styleDescription;
    }

    /**
     * Sets style description.
     *
     * @param styleDescription the style description
     */
    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    @Override
    public String toString() {
        return "PantsStyle{" +
                "id=" + id +
                ", styleDescription='" + styleDescription + '\'' +
                '}';
    }

}
