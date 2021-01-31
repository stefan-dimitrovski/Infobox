package com.project.infobox.repository.impl;

import com.project.infobox.model.Amenity;
import com.project.infobox.repository.CuisineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class CuisineRepositoryImpl implements CuisineRepository {

    private final RestTemplate restTemplate;

    public CuisineRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Calls the amenity service.
     */
    @Override
    public List<Amenity> findBySelectedItems(String items) {
        ResponseEntity<Amenity[]> am = restTemplate.getForEntity(
                "http://AMENITY-PLACES-SERVICE/api/table/?items=" + items,
                Amenity[].class
        );
        return Arrays.asList(am.getBody());
    }
}
