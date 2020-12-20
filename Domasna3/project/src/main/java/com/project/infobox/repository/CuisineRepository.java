package com.project.infobox.repository;

import java.util.Set;

public interface CuisineRepository {
    Set findBySelectedItems(String items);
    Set findBySelectedItemsAndAmenity(String items, String amenity);
}
