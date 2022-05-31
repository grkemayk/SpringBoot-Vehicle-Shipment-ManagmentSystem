package com.example.SpringDataPostgre.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bagShipmentTransaction")
public class bagShipmentTransaction {

    @Id
    @SequenceGenerator(name = "seq_shipmentTransaction", allocationSize = 1)
    @GeneratedValue(generator = "seq_shipmentTransaction", strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bagBarcode", unique = true, nullable = false)
    private String barcode;

    @OneToOne(fetch = FetchType.EAGER)
    private status shipmentStatus;

    @OneToOne(fetch = FetchType.EAGER)
    private deliveryPoint deliveryPointForUnloading;

    @OneToOne
    @PrimaryKeyJoinColumn
    packageShipmentTransaction packageShipmentTransaction;


}
