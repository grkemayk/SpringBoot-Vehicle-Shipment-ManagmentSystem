package com.example.SpringDataPostgre.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Shipment Type Model")

public class shipmentTypeDto {
    @ApiModelProperty(value = "Shipment Type Description")
    public String shipmentType;
}
