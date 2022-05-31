package com.example.SpringDataPostgre.repository;

import com.example.SpringDataPostgre.entity.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "statusRepository")
public interface statusRepository extends JpaRepository<status, Long> {
}
