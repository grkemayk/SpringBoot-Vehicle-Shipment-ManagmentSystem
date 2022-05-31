package com.example.SpringDataPostgre.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Package Shipment Model")
public class packageShipmentTransactionDto {
    @ApiModelProperty(value = "Package Barcode")
    private String barcode;
    @ApiModelProperty(value = "Package Delivery Point")
    private Long deliveryPointForUnloading;
    @ApiModelProperty(value = "Package Volumetric Weight")
    private int volumetricWeight;
    @ApiModelProperty(value = "Package In Bag")
    private Long bagBarcode;
    @ApiModelProperty(value = "Shipment Status")
    private Long status;

}
