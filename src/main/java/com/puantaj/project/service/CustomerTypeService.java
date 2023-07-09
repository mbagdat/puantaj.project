package com.puantaj.project.service;

import com.puantaj.project.models.CustomerType;

import java.util.List;
import java.util.UUID;

public interface CustomerTypeService {
    List<CustomerType> getAllCustomerTypes();

    CustomerType getCustomerTypeByGuid(UUID guid);

    CustomerType createCustomerType(CustomerType customerType);

    CustomerType updateCustomerType(UUID guid, CustomerType updatedCustomerType);

    void deleteCustomerType(UUID guid);
}
