package com.puantaj.project.controller;


import com.puantaj.project.models.Customer;
import com.puantaj.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{guid}")
    public ResponseEntity<Customer> getCustomerByGuid(@PathVariable("guid") UUID guid) {
        Customer customer = customerService.getCustomerByGuid(guid);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable("guid") UUID guid,
            @RequestBody Customer customer
    ) {
        Customer updatedCustomer = customerService.updateCustomer(guid, customer);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("guid") UUID guid) {
        customerService.deleteCustomer(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
