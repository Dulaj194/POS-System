package com.springlearn.test.service.impl;

import com.springlearn.test.DTO.CustomerDTO;
import com.springlearn.test.entity.Customer;
import com.springlearn.test.repo.CustomerRepo;
import com.springlearn.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerName(),
                customerDTO.getCustomerID(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );

        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }
}
