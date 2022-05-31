package com.example.SpringDataPostgre.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "status")
public class status {
    @Id
    @SequenceGenerator(name = "seq_status", allocationSize = 1)
    @GeneratedValue(generator = "seq_status", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String status;

    @OneToOne
    @PrimaryKeyJoinColumn
    packageShipmentTransaction packageShipmentTransaction;

    @OneToOne
    @PrimaryKeyJoinColumn
    bagShipmentTransaction bagShipmentTransaction;
}
