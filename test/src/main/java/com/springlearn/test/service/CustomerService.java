package com.springlearn.test.service;

import com.springlearn.test.DTO.CustomerDTO;
import com.springlearn.test.DTO.request.CustomerUpdateDTO;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerID);
}
