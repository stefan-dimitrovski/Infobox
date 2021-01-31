package com.infobox.amenityplacesservice.repository;

import com.infobox.amenityplacesservice.model.Amenity;

import java.util.List;
import java.util.Set;

public interface CuisineRepository {

    /**
     * Returns a list of amenities containing the items
     *
     * @param items
     * @return List<Amenities>
     */
    List<Amenity> findBySelectedItems(String items);
    Set findBySelectedItemsAndAmenity(String items, String amenity);
}
