package com.example.SpringDataPostgre.service;

import com.example.SpringDataPostgre.dto.packageShipmentTransactionDto;
import com.example.SpringDataPostgre.entity.bagShipmentTransaction;
import com.example.SpringDataPostgre.entity.deliveryPoint;
import com.example.SpringDataPostgre.entity.packageShipmentTransaction;
import com.example.SpringDataPostgre.model.deliveryDataModel;
import com.example.SpringDataPostgre.model.shipmentDataModel;
import com.example.SpringDataPostgre.repository.packageShipmentTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "shipmentTransactionService")
@RequiredArgsConstructor
public class packageShipmentTransactionService {
    private final packageShipmentTransactionRepository ShipmentTransactionRepository;

    @Transactional
    public packageShipmentTransactionDto save(packageShipmentTransactionDto ShipmentTransactionDto)
    {

        packageShipmentTransaction ShipmentTransaction = new packageShipmentTransaction();
        ShipmentTransaction.setBarcode(ShipmentTransactionDto.getBarcode());
        deliveryPoint DeliveryPoint = new deliveryPoint();
        DeliveryPoint.setId(ShipmentTransactionDto.getDeliveryPointForUnloading());

        ShipmentTransaction.setDeliveryPointForUnloading(DeliveryPoint);
        ShipmentTransaction.setVolumetricWeight(ShipmentTransactionDto.getVolumetricWeight());

        if(ShipmentTransactionDto.getBagBarcode() != null)
        {
            bagShipmentTransaction BagShipmentTransaction = new bagShipmentTransaction();
            BagShipmentTransaction.setId(ShipmentTransactionDto.getBagBarcode());
            ShipmentTransaction.setBagShipmentTransaction(BagShipmentTransaction);
        }

        final packageShipmentTransaction ShipmentTransactionElement = ShipmentTransactionRepository.save(ShipmentTransaction);

        return ShipmentTransactionDto;
    }
    @Transactional
    public packageShipmentTransaction controlPackageShipmentTransaction(String barcode) {

        List<packageShipmentTransaction> ListPackageShipmentTransactions= ShipmentTransactionRepository.getPackageShipmentTransaction(barcode);
        if(ListPackageShipmentTransactions.size() > 0)
            return ListPackageShipmentTransactions.get(0);
        else
            return null;
    }
    @Transactional
    public List<packageShipmentTransaction> getAll()
    {
        List<packageShipmentTransaction> listShipmentTransaction = ShipmentTransactionRepository.findAll();
        List<packageShipmentTransactionDto> listShipmentTransactionDto = new ArrayList<>();
        listShipmentTransaction.forEach(shipmentTransactionElement ->
        {
            packageShipmentTransactionDto ShipmentTransactionDtoElement = new packageShipmentTransactionDto();
            ShipmentTransactionDtoElement.setBarcode(shipmentTransactionElement.getBarcode());
            ShipmentTransactionDtoElement.setDeliveryPointForUnloading(shipmentTransactionElement.getDeliveryPointForUnloading().getId());
            ShipmentTransactionDtoElement.setVolumetricWeight(shipmentTransactionElement.getVolumetricWeight());

            listShipmentTransactionDto.add(ShipmentTransactionDtoElement);
        });
        return listShipmentTransaction;


    }

    public void controlDelivery(deliveryDataModel routes, shipmentDataModel ShipmentDataModel)
    {
        packageShipmentTransaction PackageShipmentTranscation = controlPackageShipmentTransaction(ShipmentDataModel.getBarcode());


        if(PackageShipmentTranscation != null)
        {
            if(PackageShipmentTranscation.getBagShipmentTransaction() == null)//Package
            {
                //Delivery Point Correct
                if(routes.getDeliveryPoint().equals("1")
                || routes.getDeliveryPoint().equals("2"))
                {
                    if(routes.getDeliveryPoint().equals(String.valueOf(PackageShipmentTranscation.getDeliveryPointForUnloading().getId())))
                    {
                        ShipmentDataModel.setState("4");
                    }
                    else
                    {
                        ShipmentDataModel.setState("3");
                    }
                }
                else //Wrong Delivery Point
                {
                    ShipmentDataModel.setState("3");
                }

            }
            else//Package In Bag
            {
                //Delivery Point Correct
                if(routes.getDeliveryPoint().equals("2")
                || routes.getDeliveryPoint().equals("3"))
                {
                    if(routes.getDeliveryPoint().equals(String.valueOf(PackageShipmentTranscation.getBagShipmentTransaction().getDeliveryPointForUnloading().getId())))
                    {
                        ShipmentDataModel.setState("4");
                    }
                    else
                    {
                        ShipmentDataModel.setState("3");
                    }
                }
                else//Wrong Delivery Point
                {
                    ShipmentDataModel.setState("3");
                }
            }
        }
    }



}
