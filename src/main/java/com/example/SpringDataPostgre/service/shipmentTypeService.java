package com.example.SpringDataPostgre.service;

import com.example.SpringDataPostgre.dto.shipmentTypeDto;
import com.example.SpringDataPostgre.entity.shipmentType;
import com.example.SpringDataPostgre.repository.shipmentTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class shipmentTypeService {

    @Resource(name = "shipmentTypeRepository")
    private shipmentTypeRepository ShipmentTypeRepository;

    @Transactional
    public void save(shipmentType ShipmentType)
    {
        ShipmentTypeRepository.save(ShipmentType);
    }

    @Transactional
    public List<shipmentTypeDto> getAll()
    {
        List<shipmentType> shipmentTypeList = ShipmentTypeRepository.findAll();
        List<shipmentTypeDto> shipmentTypeDto = new ArrayList<>();

        shipmentTypeList.forEach(shipmentTypeElement -> {

            shipmentTypeDto ShipmentTypeDto = new shipmentTypeDto();
            ShipmentTypeDto.setShipmentType(shipmentTypeElement.getShipmentType());
            shipmentTypeDto.add(ShipmentTypeDto);
        });


        return shipmentTypeDto;
    }
}
