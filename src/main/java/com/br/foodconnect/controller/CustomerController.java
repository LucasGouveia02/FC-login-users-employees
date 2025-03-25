package com.br.foodconnect.controller;

import com.br.foodconnect.dto.CustomerCredentialsDTO;
import com.br.foodconnect.dto.LoginResponseDTO;
import com.br.foodconnect.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/CustomerLogin")
    public ResponseEntity<?> customerLogin(@RequestBody CustomerCredentialsDTO customerCredentialsDTO) {
        return customerService.loginCustomer(customerCredentialsDTO);
    }

}
