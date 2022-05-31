package com.example.SpringDataPostgre.model;

import com.example.SpringDataPostgre.dto.vehicleDto;
import com.example.SpringDataPostgre.entity.vehicle;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CheckShipmentResponse {
    public CheckShipmentResponse()
    {
        route = new ArrayList<>();
    }

    private String plate;
    private List<deliveryDataModel> route;

}
