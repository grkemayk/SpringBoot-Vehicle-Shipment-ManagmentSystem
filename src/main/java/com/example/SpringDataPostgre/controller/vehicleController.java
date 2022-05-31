package com.example.SpringDataPostgre.controller;

import com.example.SpringDataPostgre.dto.vehicleDto;
import com.example.SpringDataPostgre.service.vehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
@Api(value = "Vehicle Rest Controller")
public class vehicleController {
    @Resource(name = "vehicleService")
    private vehicleService VehicleService;

    @PostMapping
    @ApiOperation(value = "New Vehicle Add Method")
    private ResponseEntity<vehicleDto> save(@RequestBody vehicleDto VehicleDto)
    {
        //Regex ile plate mask yapilabilir.
        return ResponseEntity.ok(VehicleService.save(VehicleDto));
    }
    @GetMapping
    @ApiOperation(value = "Get All Vehicle Plate Method")
    private ResponseEntity<List<vehicleDto>> getAll()
    {
        return ResponseEntity.ok(VehicleService.getAll());
    }

}
