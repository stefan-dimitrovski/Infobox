package com.project.infobox.repository;

import com.project.infobox.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    List<Amenity> findAmenityByAmenity(String amenity);

    @Query("select distinct u.amenity from Amenity u")
    List<String> findDistinctAmenityType();

}
