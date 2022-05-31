package com.example.SpringDataPostgre.repository;

import com.example.SpringDataPostgre.entity.packageShipmentTransaction;
import com.example.SpringDataPostgre.entity.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface packageShipmentTransactionRepository extends JpaRepository<packageShipmentTransaction, Long> {

    @Query("select b from packageShipmentTransaction b where b.barcode = ?1")
    List<packageShipmentTransaction> getPackageShipmentTransaction(@Param("barcode") String barcode);
}
