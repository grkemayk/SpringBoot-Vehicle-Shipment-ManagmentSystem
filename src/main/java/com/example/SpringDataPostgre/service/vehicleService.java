package com.example.SpringDataPostgre.service;

import com.example.SpringDataPostgre.dto.vehicleDto;
import com.example.SpringDataPostgre.entity.vehicle;
import com.example.SpringDataPostgre.repository.vehicleRepository;
import io.swagger.annotations.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "vehicleService")
public class vehicleService{

    @Resource(name = "vehicleRepository")
    private vehicleRepository VehicleRepository;


    @Transactional
    public vehicleDto save(vehicleDto VehicleDto)//Vehicle save method
    {
        vehicle newVehicle = new vehicle();
        newVehicle.setPlate(VehicleDto.getPlate());

        final vehicle savedVehicle = VehicleRepository.save(newVehicle);

        return VehicleDto;
    }

    @Transactional
    public boolean controlVehicle(String plate)
    {
        if(VehicleRepository.getVehicles(plate).size() == 0)
            return false;
        else
            return true;
    }

    @Transactional
    public List<vehicleDto> getAll()
    {
        List<vehicle> listVehicle = VehicleRepository.findAll();
        List<vehicleDto> listVehicleDto = new ArrayList<>();

        listVehicle.forEach(vehicleElement ->
        {
            vehicleDto vehicleDtoElement = new vehicleDto();
            vehicleDtoElement.setPlate(vehicleElement.getPlate());
            listVehicleDto.add(vehicleDtoElement);
        });

        return listVehicleDto;
    }

}
