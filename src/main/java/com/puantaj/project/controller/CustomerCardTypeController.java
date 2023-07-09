package com.puantaj.project.controller;

import com.puantaj.project.models.CustomerCardType;
import com.puantaj.project.service.CustomerCardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer-card-types")

public class CustomerCardTypeController {
    private final CustomerCardTypeService customerCardTypeService;

    @Autowired
    public CustomerCardTypeController(CustomerCardTypeService customerCardTypeService) {
        this.customerCardTypeService = customerCardTypeService;
    }

    @GetMapping
    public List<CustomerCardType> getAllCustomerCardTypes() {
        return customerCardTypeService.getAllCustomerCardTypes();
    }

    @GetMapping("/{guid}")
    public ResponseEntity<CustomerCardType> getCustomerCardTypeById(@PathVariable UUID guid) {
        CustomerCardType customerCardType = customerCardTypeService.getCustomerCardTypeByGuid(guid);
        if (customerCardType != null) {
            return new ResponseEntity<>(customerCardType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CustomerCardType> createCustomerCardType(@RequestBody CustomerCardType customerCardType) {
        CustomerCardType createdCustomerCardType = customerCardTypeService.createCustomerCardType(customerCardType);
        return new ResponseEntity<>(createdCustomerCardType, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<CustomerCardType> updateCustomerCardType(@PathVariable UUID guid, @RequestBody CustomerCardType updatedCustomerCardType) {
        CustomerCardType customerCardType = customerCardTypeService.updateCustomerCardType(guid, updatedCustomerCardType);
        if (customerCardType != null) {
            return new ResponseEntity<>(customerCardType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteCustomerCardType(@PathVariable UUID guid) {
        customerCardTypeService.deleteCustomerCardType(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
