package com.example.SpringDataPostgre.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "packageShipmentTransaction")
public class packageShipmentTransaction {
    @Id
    @SequenceGenerator(name = "seq_shipmentTransaction", allocationSize = 1)
    @GeneratedValue(generator = "seq_shipmentTransaction", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "packageBarcode", unique = true, nullable = false)
    private String barcode;

    @OneToOne(fetch = FetchType.EAGER)
    private status shipmentStatus;

    @OneToOne(fetch = FetchType.EAGER)
    private deliveryPoint deliveryPointForUnloading;

    @Column(nullable = false)
    private int volumetricWeight;

    @OneToOne
    private bagShipmentTransaction BagShipmentTransaction;



}
