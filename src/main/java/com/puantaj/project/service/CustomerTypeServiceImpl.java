package com.puantaj.project.service;

import com.puantaj.project.models.CustomerType;
import com.puantaj.project.repositories.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Autowired
    public CustomerTypeServiceImpl(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public List<CustomerType> getAllCustomerTypes() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType getCustomerTypeByGuid(UUID guid) {
        return customerTypeRepository.findById(guid).orElse(null);
    }

    @Override
    public CustomerType createCustomerType(CustomerType customerType) {
        return customerTypeRepository.save(customerType);
    }

    @Override
    public CustomerType updateCustomerType(UUID guid, CustomerType updatedCustomerType) {
        Optional<CustomerType> existingCustomerType = customerTypeRepository.findById(guid);
        if (existingCustomerType.isPresent()) {
            CustomerType customerType = existingCustomerType.get();
            customerType.setCustomerTypeName(updatedCustomerType.getCustomerTypeName());
            return customerTypeRepository.save(customerType);
        }
        return null;
    }

    @Override
    public void deleteCustomerType(UUID guid) {
        customerTypeRepository.deleteById(guid);
    }
}
