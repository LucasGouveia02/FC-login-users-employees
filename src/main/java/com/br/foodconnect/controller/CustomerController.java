package com.br.foodconnect.controller;

import com.br.foodconnect.dto.LoginDTO;
import com.br.foodconnect.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/CustomerLogin")
    public ResponseEntity<?> customerLogin(@RequestBody LoginDTO loginDTO) {
        return customerService.loginCustomer(loginDTO);
    }

}
