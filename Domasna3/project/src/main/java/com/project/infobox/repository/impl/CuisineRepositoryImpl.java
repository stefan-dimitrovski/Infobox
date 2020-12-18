package com.project.infobox.repository.impl;

import com.project.infobox.model.Amenity;
import com.project.infobox.repository.AmenityRepository;
import com.project.infobox.repository.CuisineRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CuisineRepositoryImpl implements CuisineRepository {

    private final AmenityRepository amenityRepository;

    public CuisineRepositoryImpl(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    @Override
    public Set findBySelectedItems(String items) {
        String[] params = items.split(";");
        List<Amenity> temp;
        Set resultArray = new HashSet();
        for (String item: params) {
            temp = amenityRepository.findByCuisine(item);
            resultArray.addAll(temp);
        }
        return resultArray;
    }
}
