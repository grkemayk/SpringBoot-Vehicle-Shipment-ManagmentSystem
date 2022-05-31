package com.example.SpringDataPostgre.repository;

import com.example.SpringDataPostgre.entity.shipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "shipmentTypeRepository")
public interface shipmentTypeRepository extends JpaRepository<shipmentType, Long> {
}
