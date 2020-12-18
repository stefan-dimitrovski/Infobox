package com.project.infobox.resource;

import com.project.infobox.model.Amenity;
import com.project.infobox.repository.AmenityRepository;
import com.project.infobox.repository.CuisineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class ShowItemsResource {

    private final AmenityRepository amenityRepository;
    private final CuisineRepository cuisineRepository;

    public ShowItemsResource(AmenityRepository amenityRepository, CuisineRepository cuisineRepository) {
        this.amenityRepository = amenityRepository;
        this.cuisineRepository = cuisineRepository;
    }


    @GetMapping
    @ResponseBody
    public List<Amenity> getItems() {
        return amenityRepository.findAll();
    }

    @GetMapping("/b")
    @ResponseBody
    public Set getCuisine(@RequestParam String items) {
        //return cuisineRepository.findBySelectedItems(items);
        return cuisineRepository.findBySelectedItems(items);
    }



}
