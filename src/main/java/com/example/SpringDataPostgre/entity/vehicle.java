package com.example.SpringDataPostgre.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Vehicle")
public class vehicle {
    @Id
    @SequenceGenerator(name = "seq_vehicle", allocationSize = 1)
    @GeneratedValue(generator = "seq_vehicle", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "plate", unique = true, nullable = false)
    private String plate;
}
