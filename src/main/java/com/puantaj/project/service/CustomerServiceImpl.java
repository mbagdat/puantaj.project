package com.puantaj.project.service;


import com.puantaj.project.models.Customer;
import com.puantaj.project.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByGuid(UUID guid) {
        return customerRepository.findById(guid).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setGuid(UUID.randomUUID());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(UUID guid, Customer customer) {
        Customer existingCustomer = customerRepository.findById(guid).orElse(null);
        if (existingCustomer != null) {
            BeanUtils.copyProperties(customer, existingCustomer);
            existingCustomer.setGuid(guid);
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(UUID guid) {
        customerRepository.deleteById(guid);
    }
}
