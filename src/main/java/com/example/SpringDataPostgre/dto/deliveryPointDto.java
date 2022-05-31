package com.example.SpringDataPostgre.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Delivery Points Model")
public class deliveryPointDto {

    @ApiModelProperty(value = "Delivery Point")
    private String deliveryPoint;
}
