package com.example.SpringDataPostgre.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deliveryPoint")
public class deliveryPoint {

    @Id
    @SequenceGenerator(name = "seq_shipmentTransaction", allocationSize = 1)
    @GeneratedValue(generator = "seq_shipmentTransaction", strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String deliveryPoint;
    @OneToOne
    @PrimaryKeyJoinColumn
    packageShipmentTransaction packageShipmentTransaction;

    @OneToOne
    @PrimaryKeyJoinColumn
    bagShipmentTransaction bagShipmentTransaction;

}
