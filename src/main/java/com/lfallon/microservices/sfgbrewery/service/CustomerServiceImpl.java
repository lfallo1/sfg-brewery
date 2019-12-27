package com.lfallon.microservices.sfgbrewery.service;

import com.lfallon.microservices.sfgbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getById(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .customerName("Fallon Brewery")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return customerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating customer: " + customerId.toString());
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Updating customer: " + customerId.toString());
    }
}
