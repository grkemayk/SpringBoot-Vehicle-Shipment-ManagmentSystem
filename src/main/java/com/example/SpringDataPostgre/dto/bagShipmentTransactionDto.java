package com.example.SpringDataPostgre.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Bag Shipment Model")
public class bagShipmentTransactionDto {
    @ApiModelProperty(value = "Bag Barcode")
    private String barcode;
    @ApiModelProperty(value = "Bag Delivery Point")
    private Long deliveryPointForUnloading;
    @ApiModelProperty(value = "Shipment Status")
    private Long status;
}
