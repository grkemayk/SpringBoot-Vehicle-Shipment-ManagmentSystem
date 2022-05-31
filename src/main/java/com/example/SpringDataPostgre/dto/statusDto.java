package com.example.SpringDataPostgre.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Shipment Status Model")
public class statusDto {
    @ApiModelProperty(value = "Shipment Status Description")
    private String status;
}
