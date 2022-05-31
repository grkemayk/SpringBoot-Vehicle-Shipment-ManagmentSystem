package com.example.SpringDataPostgre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringDataPostgre.entity.vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "vehicleRepository")
public interface vehicleRepository extends JpaRepository<vehicle, Long> {
    @Query("select v from vehicle v where v.plate = ?1")
    List<vehicle> getVehicles(@Param("plate") String plate);
}
