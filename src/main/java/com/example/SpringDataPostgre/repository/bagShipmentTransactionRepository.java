package com.example.SpringDataPostgre.repository;

import com.example.SpringDataPostgre.entity.bagShipmentTransaction;
import com.example.SpringDataPostgre.entity.packageShipmentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "bagShipmentTransactionRepository")
public interface bagShipmentTransactionRepository extends JpaRepository<bagShipmentTransaction, Long> {

    @Query("select b from bagShipmentTransaction b where b.barcode = ?1")
    List<bagShipmentTransaction> getBagShipmentTransaction(@Param("barcode") String barcode);
}
