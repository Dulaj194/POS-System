package com.springlearn.test.controller;

import com.springlearn.test.DTO.CustomerDTO;
import com.springlearn.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springlearn.test.DTO.request.CustomerUpdateDTO;


@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "Done";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
    String msg = customerService.updateCustomer(customerUpdateDTO);
        return "msg";
    }
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerID){
        CustomerDTO customerDTO = customerService.getCustomerById(customerID);
        return customerDTO;
    }


}
