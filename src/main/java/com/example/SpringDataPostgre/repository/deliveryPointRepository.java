package com.example.SpringDataPostgre.repository;

import com.example.SpringDataPostgre.entity.deliveryPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "deliveryPointRepository")
public interface deliveryPointRepository extends JpaRepository<deliveryPoint, Long> {
}
