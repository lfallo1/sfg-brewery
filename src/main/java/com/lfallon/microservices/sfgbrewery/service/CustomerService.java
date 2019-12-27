package com.lfallon.microservices.sfgbrewery.service;

import com.lfallon.microservices.sfgbrewery.web.model.BeerDto;
import com.lfallon.microservices.sfgbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}
