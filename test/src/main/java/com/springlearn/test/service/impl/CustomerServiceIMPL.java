package com.springlearn.test.service.impl;

import com.springlearn.test.DTO.CustomerDTO;
import com.springlearn.test.DTO.request.CustomerUpdateDTO;
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

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerID())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerID());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " updated succesful";

        }else {
            throw new RuntimeException("no data found for that id");
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerID) {
        if (customerRepo.existsById(customerID)) {
            Customer customer = customerRepo.getReferenceById((customerID));
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        }else {
            throw new RuntimeException("no customer");
        }
    }
}
