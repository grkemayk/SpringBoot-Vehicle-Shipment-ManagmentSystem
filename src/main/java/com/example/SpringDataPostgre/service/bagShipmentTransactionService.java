package com.example.SpringDataPostgre.service;

import com.example.SpringDataPostgre.dto.bagShipmentTransactionDto;
import com.example.SpringDataPostgre.dto.packageShipmentTransactionDto;
import com.example.SpringDataPostgre.entity.bagShipmentTransaction;
import com.example.SpringDataPostgre.entity.deliveryPoint;
import com.example.SpringDataPostgre.entity.packageShipmentTransaction;
import com.example.SpringDataPostgre.model.deliveryDataModel;
import com.example.SpringDataPostgre.model.shipmentDataModel;
import com.example.SpringDataPostgre.repository.bagShipmentTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bagShipmentTransactionService")
@RequiredArgsConstructor
public class bagShipmentTransactionService {
    private final bagShipmentTransactionRepository BagShipmentTransactionRepository;

    @Transactional
    public bagShipmentTransactionDto save(bagShipmentTransactionDto BagShipmentTransactionDto)
    {
        bagShipmentTransaction BagShipmentTransaction = new bagShipmentTransaction();
        BagShipmentTransaction.setBarcode(BagShipmentTransactionDto.getBarcode());
        deliveryPoint DeliveryPoint = new deliveryPoint();
        DeliveryPoint.setId(BagShipmentTransactionDto.getDeliveryPointForUnloading());
        BagShipmentTransaction.setDeliveryPointForUnloading(DeliveryPoint);

        final bagShipmentTransaction bagShipmentTransactionSaved = BagShipmentTransactionRepository.save(BagShipmentTransaction);

        return BagShipmentTransactionDto;
    }

    @Transactional
    public bagShipmentTransaction controlBagShipmentTransaction(String barcode) {

        List<bagShipmentTransaction> ListBagShipmentTransactions= BagShipmentTransactionRepository.getBagShipmentTransaction(barcode);
        if(ListBagShipmentTransactions.size() > 0)
            return ListBagShipmentTransactions.get(0);
        else
            return null;
    }

    @Transactional
    public List<bagShipmentTransaction> getAll()
    {
        List<bagShipmentTransaction> listShipmentTransaction = BagShipmentTransactionRepository.findAll();
        List<bagShipmentTransactionDto> listShipmentTransactionDto = new ArrayList<>();
        listShipmentTransaction.forEach(shipmentTransactionElement ->
        {
            bagShipmentTransactionDto ShipmentTransactionDtoElement = new bagShipmentTransactionDto();
            ShipmentTransactionDtoElement.setBarcode(shipmentTransactionElement.getBarcode());
            ShipmentTransactionDtoElement.setDeliveryPointForUnloading(shipmentTransactionElement.getDeliveryPointForUnloading().getId());


            listShipmentTransactionDto.add(ShipmentTransactionDtoElement);
        });
        return listShipmentTransaction;
    }

    public void controlDelivery(deliveryDataModel routes, shipmentDataModel ShipmentDataModel) {
        bagShipmentTransaction BagShipmentTranscation = controlBagShipmentTransaction(ShipmentDataModel.getBarcode());


        if (BagShipmentTranscation != null) {
            //Delivery Point Correct
            if (routes.getDeliveryPoint().equals("2")
                    || routes.getDeliveryPoint().equals("3")) {
                if (routes.getDeliveryPoint().equals(String.valueOf(BagShipmentTranscation.getDeliveryPointForUnloading().getId()))) {
                    ShipmentDataModel.setState("4");
                } else {
                    ShipmentDataModel.setState("3");
                }
            } else //Wrong Delivery Point
            {
                ShipmentDataModel.setState("3");
            }


        }

    }
}
