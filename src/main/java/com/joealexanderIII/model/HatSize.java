package com.joealexanderIII.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a Hat Size.
 */
@Entity(name = "HatSize")
@Table(name = "grb_hat_sizes")

public class HatSize {

    @Id
    @Column(name = "SIZE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "SIZE_DESCRIPTION")
    private String sizeDescription;

    /**
     * Instantiates a new Hat sizes.
     */
    public HatSize() {
    }

    /**
     * Instantiates a new Hat sizes.
     *
     * @param sizeDescription the size description
     */
    public HatSize(String sizeDescription) {
        this.sizeDescription = sizeDescription;
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
     * Gets size description.
     *
     * @return the size description
     */
    public String getSizeDescription() {
        return sizeDescription;
    }

    /**
     * Sets size description.
     *
     * @param sizeDescription the size description
     */
    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }

    @Override
    public String toString() {
        return "HatSizes{" +
                "id=" + id +
                ", sizeDescription='" + sizeDescription + '\'' +
                '}';
    }

}
