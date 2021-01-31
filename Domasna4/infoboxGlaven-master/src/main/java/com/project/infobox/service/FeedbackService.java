package com.project.infobox.service;

import com.project.infobox.model.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {

    /**
     * Gets a list of all the feedbacks in the database.
     *
     * @return List<Feedback>
     * @throws
     */
    List<Feedback> findAll();

    /**
     * Saves a Feedback to the database.
     *
     * @param userName
     * @param userEmail
     * @param userRating
     * @param userText
     * @return Optional<Feedback>
     * @throws
     */
    Optional<Feedback> save(String userName,
                            String userEmail,
                            String userRating,
                            String userText);


}
