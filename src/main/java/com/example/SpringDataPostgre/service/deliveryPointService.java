package com.example.SpringDataPostgre.service;

import com.example.SpringDataPostgre.dto.deliveryPointDto;
import com.example.SpringDataPostgre.entity.deliveryPoint;
import com.example.SpringDataPostgre.repository.deliveryPointRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class deliveryPointService {

    private final deliveryPointRepository DeliveryPointRepository;

    @Transactional
    public deliveryPointDto save(deliveryPointDto DeliveryPointDto)
    {
        deliveryPoint DeliveryPoint = new deliveryPoint();
        DeliveryPoint.setDeliveryPoint(DeliveryPointDto.getDeliveryPoint());

        final deliveryPoint DeliveryPointFinal = DeliveryPointRepository.save(DeliveryPoint);

        return DeliveryPointDto;
    }

    @Transactional
    public List<deliveryPointDto> getAll()
    {
        List<deliveryPoint> listDeliveryPoint = DeliveryPointRepository.findAll();
        List<deliveryPointDto> listDeliveryPointDto = new ArrayList<>();
        listDeliveryPoint.forEach(deliveryPointElement ->
        {
            deliveryPointDto DeliveryPointDtoElement = new deliveryPointDto();
            DeliveryPointDtoElement.setDeliveryPoint(deliveryPointElement.getDeliveryPoint());
            listDeliveryPointDto.add(DeliveryPointDtoElement);
        });
        return listDeliveryPointDto;
    }
}
