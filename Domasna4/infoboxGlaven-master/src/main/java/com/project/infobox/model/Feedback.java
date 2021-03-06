package com.project.infobox.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Wrapper class for the user feedback.
 */
@Data
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userEmail;

    private String userRating;

    private String userText;

    /**
     * Creates a new Feedback with the given attributes
     * Then saves it in the database for review
     */
    public Feedback( String userName, String userEmail, String userRating, String userText) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRating = userRating;
        this.userText = userText;
    }

    public Feedback() {

    }
}
