package com.example.SpringDataPostgre.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class deliveryDataModel {
    public deliveryDataModel()
    {
        deliveries = new ArrayList<>();
    }
    private String deliveryPoint;
    private List<shipmentDataModel> deliveries;



}
