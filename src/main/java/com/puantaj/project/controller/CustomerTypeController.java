package com.puantaj.project.controller;


import com.puantaj.project.models.CustomerType;
import com.puantaj.project.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer-types")
public class CustomerTypeController {

    @Autowired
     CustomerTypeService customerTypeService;

//    @Autowired
//    public CustomerTypeController(CustomerTypeService customerTypeService) {
//        this.customerTypeService = customerTypeService;
//    }

    @GetMapping
    public List<CustomerType> getAllCustomerTypes() {
        return customerTypeService.getAllCustomerTypes();
    }

    @GetMapping("/{guid}")
    public ResponseEntity<CustomerType> getCustomerTypeById(@PathVariable UUID guid) {
        CustomerType customerType = customerTypeService.getCustomerTypeByGuid(guid);
        if (customerType != null) {
            return new ResponseEntity<>(customerType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CustomerType> createCustomerType(@RequestBody CustomerType customerType) {
        CustomerType createdCustomerType = customerTypeService.createCustomerType(customerType);
        return new ResponseEntity<>(createdCustomerType, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<CustomerType> updateCustomerType(@PathVariable UUID guid, @RequestBody CustomerType updatedCustomerType) {
        CustomerType customerType = customerTypeService.updateCustomerType(guid, updatedCustomerType);
        if (customerType != null) {
            return new ResponseEntity<>(customerType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteCustomerType(@PathVariable UUID guid) {
        customerTypeService.deleteCustomerType(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
