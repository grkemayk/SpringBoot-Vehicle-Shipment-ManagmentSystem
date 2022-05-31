package com.example.SpringDataPostgre.controller;

import com.example.SpringDataPostgre.dto.bagShipmentTransactionDto;
import com.example.SpringDataPostgre.dto.packageShipmentTransactionDto;
import com.example.SpringDataPostgre.entity.bagShipmentTransaction;
import com.example.SpringDataPostgre.service.bagShipmentTransactionService;
import com.example.SpringDataPostgre.service.packageShipmentTransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/bagShipmentTransaction")
@Api(value = "Bag Shipment Rest Controller")
public class bagShipmentTransactionController {

    private final bagShipmentTransactionService ShipmentTransactionService;

    @PostMapping
    @ApiOperation(value = "New Bag Add Method")
    public ResponseEntity<bagShipmentTransactionDto> save(@RequestBody bagShipmentTransactionDto ShipmentTransactionDto)
    {
        return ResponseEntity.ok(ShipmentTransactionService.save(ShipmentTransactionDto));
    }

    @GetMapping
    @ApiOperation(value = "Get All Bag Method")
    public ResponseEntity<List<bagShipmentTransaction>>getAll()
    {
        return ResponseEntity.ok(ShipmentTransactionService.getAll());
    }
}
