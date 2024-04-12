package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.ServiceDetailsDto;
import com.cttorentsystem.ottorentbackend.entity.ServiceDetails;
import com.cttorentsystem.ottorentbackend.mapper.ServiceDetailsMapper;
import com.cttorentsystem.ottorentbackend.repositorys.ServiceDetailsReporsitory;
import com.cttorentsystem.ottorentbackend.service.ServiceDetailsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ServiceDetailsServiceImpl implements ServiceDetailsService {

    private ServiceDetailsReporsitory serviceDetailsReporsitory;

    @Override
    public ServiceDetailsDto createServiceDetails(ServiceDetailsDto serviceDetailsDto) {

        ServiceDetails newServiceDetails = ServiceDetailsMapper.mapToServiceDetails(serviceDetailsDto);
        ServiceDetails saveServiceDetails = serviceDetailsReporsitory.save(newServiceDetails);
        return  ServiceDetailsMapper.mapToServiceDetailsDto(saveServiceDetails);


    }
}
