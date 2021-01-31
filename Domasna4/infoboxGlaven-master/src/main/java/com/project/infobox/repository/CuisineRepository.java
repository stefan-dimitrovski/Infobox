package com.project.infobox.repository;

import com.project.infobox.model.Amenity;

import java.util.List;
import java.util.Set;

public interface CuisineRepository {

    /**
     * Gets a list of all the amenities that serve those food items.
     *
     * @param foodItems
     * @return List<Amenity>
     * @throws
     */
    List<Amenity> findBySelectedItems(String foodItems);
}
