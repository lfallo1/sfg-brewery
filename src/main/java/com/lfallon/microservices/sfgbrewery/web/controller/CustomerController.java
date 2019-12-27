package com.lfallon.microservices.sfgbrewery.web.controller;

import com.lfallon.microservices.sfgbrewery.service.CustomerService;
import com.lfallon.microservices.sfgbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {

        CustomerDto savedCustomer = customerService.saveCustomer(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        //TODO dynamically append hostname to url/location
        httpHeaders.add("location", "api/v1/customer" + savedCustomer.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    public ResponseEntity handlePut(@RequestBody CustomerDto customerDto, @PathVariable("customerId") UUID customerId) {
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
    }
}
