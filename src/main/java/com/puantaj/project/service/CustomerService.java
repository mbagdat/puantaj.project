package com.puantaj.project.service;

import com.puantaj.project.models.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerByGuid(UUID guid);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(UUID guid, Customer customer);

    void deleteCustomer(UUID guid);
}
