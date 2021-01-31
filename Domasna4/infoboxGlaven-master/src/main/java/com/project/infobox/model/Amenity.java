package com.project.infobox.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Represents an amenity to be saved in the database.
 */
@Data
@Entity
public class Amenity {

    /**
     * The id that's going to uniquely identify the amenities.
     */
    @Id
    private Long id;

    /**
     * Longitude
     */
    private double lon;

    /**
     * Latitude
     */
    private double lat;

    private String name;

    private String email;

    private String phone;

    /**
     * Type of the amenity
     */
    private String amenity;

    /**
     * Types of food served
     */
    private String cuisine;

    private String smoking;

    private String name_en;

    private String website;

    private String addr_city;

    private String addr_street;

    private String addr_postcode;

    private String opening_hours;

    private String outdoorseating;

    private String addr_housenumber;

    private String wheelchair;

    private String building;

    private String drive_through;

    private String shop;

    private String takeaway;

    private String internet_access;

    private String drive_in;

    private String delivery;

    private String abandoned;

    private String seasonal;

    private String wifi;

    private String operator;

    private String organic;

    private String payment_mastercard;

    private String payment_visa;

    private Integer capacity;


    public Amenity() {

    }
}
