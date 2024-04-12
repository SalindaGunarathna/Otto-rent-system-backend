package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.ServiceDetailsDto;
import org.springframework.stereotype.Service;



public interface ServiceDetailsService {

    ServiceDetailsDto createServiceDetails(ServiceDetailsDto serviceDetailsDto);
}
