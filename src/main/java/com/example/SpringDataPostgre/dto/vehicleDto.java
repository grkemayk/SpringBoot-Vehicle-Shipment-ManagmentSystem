package com.example.SpringDataPostgre.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Vehicle Model")
public class vehicleDto {

    @ApiModelProperty(value = "Vehicle Plate")
    private String plate;

}
