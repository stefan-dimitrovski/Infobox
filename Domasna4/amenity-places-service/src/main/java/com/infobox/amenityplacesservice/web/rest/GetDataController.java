package com.infobox.amenityplacesservice.web.rest;


import com.infobox.amenityplacesservice.model.Amenity;
import com.infobox.amenityplacesservice.repository.AmenityRepository;
import com.infobox.amenityplacesservice.repository.CuisineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

 /**
 * This is a RESTapi that is called from the main microservice to receive data for the amenities.
 */

@RestController
@RequestMapping("/api")
public class GetDataController {

    private final AmenityRepository amenityRepository;
    private final CuisineRepository cuisineRepository;


    public GetDataController(AmenityRepository amenityRepository, CuisineRepository cuisineRepository) {
        this.amenityRepository = amenityRepository;
        this.cuisineRepository = cuisineRepository;
    }

    /**
     * Returns the amenity by its id
     *
     * @param id
     * @return Optional<Amenity>
     */
    @GetMapping
    @ResponseBody
    @CrossOrigin
    public Optional<Amenity> getLocationData(@RequestParam Long id) {
        return amenityRepository.findById(id);
    }

    /**
     * Returns the amenities by the selected type
     *
     * @param type
     * @return List<Amenity>
     */
    @GetMapping("/amenity")
    @ResponseBody
    @CrossOrigin
    public List<Amenity> getAmenityData(@RequestParam String type) {
        return amenityRepository.findAmenityByAmenity(type);
    }

    /**
     * Returns the possible amenities from the selected food types
     *
     * @param items
     * @return List<Amenities>
     */
    @GetMapping("/table")
    @ResponseBody
    @CrossOrigin
    public List<Amenity> getItemsData(@RequestParam String items) {
        return cuisineRepository.findBySelectedItems(items);
    }

    /**
     * Returns the data for the selected amenity
     *
     * @param id
     * @return Optional<Amenity>
     */
    @GetMapping("/place")
    @ResponseBody
    @CrossOrigin
    public Optional<Amenity> getPlaceById(@RequestParam Long id) {
        return amenityRepository.findById(id);
    }

}
