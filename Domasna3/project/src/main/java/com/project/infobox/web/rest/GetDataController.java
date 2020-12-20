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
    public Optional<Amenity> getAmenityData(@RequestParam Long id) {
        return amenityRepository.findById(id);
    }
}
