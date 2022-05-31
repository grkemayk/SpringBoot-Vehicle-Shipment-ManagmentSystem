package com.example.SpringDataPostgre.service;


import com.example.SpringDataPostgre.entity.packageShipmentTransaction;
import com.example.SpringDataPostgre.entity.vehicle;
import com.example.SpringDataPostgre.model.CheckShipmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(value = "CheckShipmentService")
@RequiredArgsConstructor
public class CheckShipmentService {

    private final vehicleService VehicleService;
    private final packageShipmentTransactionService PackageShipmentTransactionService;
    private final bagShipmentTransactionService BagShipmentTransactionService;
    public CheckShipmentResponse checkShipment(CheckShipmentResponse xCheckShipmentResponse)
    {
        if(VehicleService.controlVehicle(xCheckShipmentResponse.getPlate()) == true)
        {

            xCheckShipmentResponse.getRoute().forEach(routes ->
            {
                routes.getDeliveries().forEach(DeliveryDataModel ->
                {

                    //Package

                    if(DeliveryDataModel.getBarcode().substring(0,1).equals("P"))
                    {

                        PackageShipmentTransactionService.controlDelivery(routes, DeliveryDataModel);
                    }
                    else if(DeliveryDataModel.getBarcode().substring(0,1).equals("C"))
                    {
                        BagShipmentTransactionService.controlDelivery(routes, DeliveryDataModel);
                    }
                    //Bag

                });
                //PackageShipmentTransactionService.controlPackageShipmentTransaction(deliveryDataModel.);

            });
        }
        else
        {
            return null;
        }

        return xCheckShipmentResponse;
    }
    private void controlPackageShipment()
    {

    }
}
