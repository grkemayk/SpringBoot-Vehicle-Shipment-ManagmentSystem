package com.example.SpringDataPostgre.controller;

import com.example.SpringDataPostgre.dto.statusDto;
import com.example.SpringDataPostgre.entity.shipmentType;
import com.example.SpringDataPostgre.service.statusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/status")
@RequiredArgsConstructor
@Api(value = "Shipment Status Rest Controller")
public class statusController {

    private final statusService StatusService;


    @PostConstruct
    void init()
    {
        try
        {
            statusDto StatusDtoCreated = new statusDto();
            statusDto StatusDtoLoadedIntoBag = new statusDto();
            statusDto StatusDtoLoaded = new statusDto();
            statusDto StatusDtoUnloaded = new statusDto();

            StatusDtoCreated.setStatus("Created");
            StatusDtoLoadedIntoBag.setStatus("Loaded into Bag");
            StatusDtoLoaded.setStatus("Loaded");
            StatusDtoUnloaded.setStatus("Unloaded");


            StatusService.save(StatusDtoCreated);
            StatusService.save(StatusDtoLoadedIntoBag);
            StatusService.save(StatusDtoLoaded);
            StatusService.save(StatusDtoUnloaded);


        }
        catch(Exception e)
        {

        }
    }

    @GetMapping
    @ApiOperation(value = "Get All Shipment Status Method")
    public ResponseEntity<List<statusDto>> getAll()
    {
        return ResponseEntity.ok(StatusService.getAll());
    }

}
