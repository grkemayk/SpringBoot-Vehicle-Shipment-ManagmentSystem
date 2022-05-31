package com.example.SpringDataPostgre.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipmentType")
public class shipmentType {

    @Id
    @SequenceGenerator(name = "seq_shipment", allocationSize = 1)
    @GeneratedValue(generator = "seq_shipment", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "shipmentType", unique = true, nullable = false)
    private String shipmentType;
}
