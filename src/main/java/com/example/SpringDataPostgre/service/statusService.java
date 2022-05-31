package com.example.SpringDataPostgre.service;

import com.example.SpringDataPostgre.dto.statusDto;
import com.example.SpringDataPostgre.entity.status;
import com.example.SpringDataPostgre.repository.statusRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class statusService {

    @Resource(name = "statusRepository")
    private statusRepository StatusRepository;

    @Transactional
    public statusDto save(statusDto StatusDto)
    {
        status Status = new status();
        Status.setStatus(StatusDto.getStatus());

        final status statusFinal = StatusRepository.save(Status);
        return StatusDto;
    }

    @Transactional
    public List<statusDto> getAll()
    {
        List<status> statusList = StatusRepository.findAll();
        List<statusDto> statusDtoList = new ArrayList<>();

        statusList.forEach(statusElement ->
        {
            statusDto statusDtoElement = new statusDto();
            statusDtoElement.setStatus(statusElement.getStatus());
            statusDtoList.add(statusDtoElement);

        });
        return statusDtoList;
    }

}
