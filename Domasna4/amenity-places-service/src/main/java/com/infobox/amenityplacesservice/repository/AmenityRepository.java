package com.infobox.amenityplacesservice.repository;


import com.infobox.amenityplacesservice.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    /**
     * Returns a list of amenities that are of the type selected
     *
     * @param amenity
     * @return List<Amenity>
     */
    List<Amenity> findAmenityByAmenity(String amenity);

    /**
     * Returns all the distinct types an amenity can have
     *
     * @return List<String>
     */
    @Query("select distinct u.amenity from Amenity u")
    List<String> findDistinctAmenityType();

    /**
     * Returns the amenities that contain the items selected
     *
     * @param item
     * @return List<Amenity>
     */
    @Query(value = "SELECT * FROM amenity WHERE cuisine ILIKE %:items%", nativeQuery = true)
    List<Amenity> findByCuisine(@Param("items") String item);

    /**
     * Returns the amenities that are of the selected type and contain the items selected
     *
     * @param item
     * @param amenity
     * @return List<Amenity>
     */
    @Query(value = "SELECT * FROM amenity WHERE amenity = :amen AND cuisine ILIKE %:items%", nativeQuery = true)
    List<Amenity> findByCuisineAndAmenity(@Param("items") String item, @Param("amen") String amenity);

}
