package com.gsfranzoni.geolocation.repositories;

import com.gsfranzoni.geolocation.entities.Partner;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, String> {
    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM partner " +
            "WHERE ST_Intersects(coverage_area, :location) " +
            "ORDER BY ST_Distance(address, :location) " +
            "LIMIT 1" +
    "")
    Optional<Partner> findByNearestAddress(@Param("location") Point location);
}
