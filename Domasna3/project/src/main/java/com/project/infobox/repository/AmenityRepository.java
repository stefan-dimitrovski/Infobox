package com.project.infobox.repository;

import com.project.infobox.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    @Query(value = "SELECT * FROM amenity WHERE cuisine ILIKE %:items%", nativeQuery = true)
    List<Amenity> findByCuisine(@Param("items") String item);
}
