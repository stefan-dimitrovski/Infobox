package com.infobox.amenityplacesservice.service;

import com.infobox.amenityplacesservice.model.Amenity;

import java.util.List;
import java.util.Optional;

public interface AmenityService {

    /**
     * Returns all the amenities
     *
     * @return List<Amenity>
     */
    List<Amenity> findAll();

    /**
     * Returns an optional amenity by his id
     *
     * @param id
     * @return Optional<Amenity>
     * @throws com.infobox.amenityplacesservice.model.exception.AmenityNotFoundException
     */
    Optional<Amenity> findById(Long id);

    /**
     * Return the distinct types of amenities
     *
     * @return List<String>
     */
    List<String> findDistinctAmenityType();

    /**
     * Returns all the amenities of the selected type
     *
     * @param amenity
     * @return List<Amenity>
     */
    List<Amenity> findAmenityByAmenity(String amenity);
}
