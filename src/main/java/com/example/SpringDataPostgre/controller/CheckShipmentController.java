package com.example.SpringDataPostgre.controller;

import com.example.SpringDataPostgre.model.CheckShipmentResponse;
import com.example.SpringDataPostgre.service.CheckShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/CheckShipment")
public class CheckShipmentController {

    private final CheckShipmentService xCheckShipmentService;

    @PostMapping
    public ResponseEntity<CheckShipmentResponse> check(@RequestBody CheckShipmentResponse xCheckShipmentResponse)
    {
        System.out.println(xCheckShipmentService.checkShipment(xCheckShipmentResponse));
        return ResponseEntity.ok(xCheckShipmentService.checkShipment(xCheckShipmentResponse));


    }


}
