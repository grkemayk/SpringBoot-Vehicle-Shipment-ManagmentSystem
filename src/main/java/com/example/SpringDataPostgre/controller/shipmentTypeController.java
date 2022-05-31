package com.example.SpringDataPostgre.controller;

import com.example.SpringDataPostgre.dto.shipmentTypeDto;
import com.example.SpringDataPostgre.entity.shipmentType;
import com.example.SpringDataPostgre.repository.shipmentTypeRepository;
import com.example.SpringDataPostgre.service.shipmentTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/shipmentType")
@Api(value = "Shipment Type Controller")
public class shipmentTypeController {

    @Resource(name = "shipmentTypeService")
    private shipmentTypeService ShipmentTypeService;


    @PostConstruct
    void init()
    {
        try
        {
            shipmentType ShipmentTypePackage = new shipmentType();
            ShipmentTypePackage.setShipmentType("Package");

            shipmentType ShipmentTypeBag = new shipmentType();
            ShipmentTypeBag.setShipmentType("Bag");

            ShipmentTypeService.save(ShipmentTypePackage);
            ShipmentTypeService.save(ShipmentTypeBag);
        }
        catch(Exception e)
        {

        }
    }

    @GetMapping
    @ApiOperation(value = "Get All Shipment Type Method")
    public ResponseEntity<List<shipmentTypeDto>> getAll()
    {
        return ResponseEntity.ok(ShipmentTypeService.getAll());
    }


}
