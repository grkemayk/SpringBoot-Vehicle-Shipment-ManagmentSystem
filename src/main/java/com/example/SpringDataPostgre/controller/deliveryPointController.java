package com.example.SpringDataPostgre.controller;

import com.example.SpringDataPostgre.dto.deliveryPointDto;
import com.example.SpringDataPostgre.entity.deliveryPoint;
import com.example.SpringDataPostgre.service.deliveryPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/deliveryPoint")
@RequiredArgsConstructor
@Api(value = "Delivery Point Rest Controller")
public class deliveryPointController {

    private final deliveryPointService DeliveryPointService;

    @PostConstruct
    void init()
    {
        try
        {
            deliveryPointDto DeliveryPointBranch = new deliveryPointDto();
            deliveryPointDto DeliveryPointDistributionCenter = new deliveryPointDto();
            deliveryPointDto DeliveryPointTransferCenter = new deliveryPointDto();

            DeliveryPointBranch.setDeliveryPoint("Branch");
            DeliveryPointDistributionCenter.setDeliveryPoint("Distribution Center");
            DeliveryPointTransferCenter.setDeliveryPoint("Transfer Center");

            DeliveryPointService.save(DeliveryPointBranch);
            DeliveryPointService.save(DeliveryPointDistributionCenter);
            DeliveryPointService.save(DeliveryPointTransferCenter);
        }
        catch(Exception e)
        {

        }
    }

    @GetMapping
    @ApiOperation(value = "Get All Delivery Points Method")
    public ResponseEntity<List<deliveryPointDto>> getAll()
    {
        return ResponseEntity.ok(DeliveryPointService.getAll());
    }
}
