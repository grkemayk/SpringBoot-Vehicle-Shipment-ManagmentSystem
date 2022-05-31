package com.example.SpringDataPostgre.controller;

import com.example.SpringDataPostgre.dto.packageShipmentTransactionDto;
import com.example.SpringDataPostgre.entity.packageShipmentTransaction;
import com.example.SpringDataPostgre.service.packageShipmentTransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/packageShipmentTransaction")
@Api(value = "Package Shipment Transaction Rest Controller")
public class packageShipmentTransactionController {

    private final packageShipmentTransactionService ShipmentTransactionService;

    @PostMapping
    @ApiOperation(value = "New Package Add Method")
    public ResponseEntity<packageShipmentTransactionDto> save(@RequestBody packageShipmentTransactionDto ShipmentTransactionDto)
    {
        System.out.println(ShipmentTransactionDto);
        return ResponseEntity.ok(ShipmentTransactionService.save(ShipmentTransactionDto));
    }

    @GetMapping
    @ApiOperation(value = "Get All Package Method")
    public ResponseEntity<List<packageShipmentTransaction>> getAll()
    {
        return ResponseEntity.ok(ShipmentTransactionService.getAll());
    }
}

