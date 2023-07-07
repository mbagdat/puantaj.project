package com.puantaj.project.service;

import com.puantaj.project.models.CustomerCardType;

import java.util.List;
import java.util.UUID;

public interface CustomerCardTypeService {
    List<CustomerCardType> getAllCustomerCardTypes();

    CustomerCardType getCustomerCardTypeByGuid(UUID guid);

    CustomerCardType createCustomerCardType(CustomerCardType customerCardType);

    CustomerCardType updateCustomerCardType(UUID guid, CustomerCardType updatedCustomerCardType);

    void deleteCustomerCardType(UUID guid);
}
