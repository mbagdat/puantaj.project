package com.puantaj.project.service;

import com.puantaj.project.models.CustomerCardType;
import com.puantaj.project.repositories.CustomerCardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerCardTypeServiceImpl implements CustomerCardTypeService{

    @Autowired
    CustomerCardTypeRepository customerCardTypeRepository;


    @Override
    public List<CustomerCardType> getAllCustomerCardTypes() {
        return customerCardTypeRepository.findAll();
    }

    @Override
    public CustomerCardType getCustomerCardTypeByGuid(UUID guid) {
        return customerCardTypeRepository.findById(guid).orElse(null);
    }

    @Override
    public CustomerCardType createCustomerCardType(CustomerCardType customerCardType) {
        return customerCardTypeRepository.save(customerCardType);
    }

    @Override
    public CustomerCardType updateCustomerCardType(UUID guid, CustomerCardType updatedCustomerCardType) {
        Optional<CustomerCardType> existingCustomerCardType = customerCardTypeRepository.findById(guid);
        if (existingCustomerCardType.isPresent()) {
            CustomerCardType customerCardType = existingCustomerCardType.get();
            customerCardType.setCustomerCardTypeName(updatedCustomerCardType.getCustomerCardTypeName());
            return customerCardTypeRepository.save(customerCardType);
        }
        return null;
    }

    @Override
    public void deleteCustomerCardType(UUID guid) {
        customerCardTypeRepository.deleteById(guid);
    }
}
