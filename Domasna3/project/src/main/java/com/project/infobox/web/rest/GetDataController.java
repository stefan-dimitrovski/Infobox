package com.project.infobox.web.rest;

import com.project.infobox.model.Amenity;
import com.project.infobox.repository.AmenityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GetDataController {

    private final AmenityRepository amenityRepository;

    public GetDataController(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    @GetMapping
    @ResponseBody
    public Optional<Amenity> getLocationData(@RequestParam Long id) {
        return amenityRepository.findById(id);
    }

    @GetMapping("/amenity")
    @ResponseBody
    public List<Amenity> getAmenityData(@RequestParam String type) {
        return amenityRepository.findAmenityByAmenity(type);
    }
}
