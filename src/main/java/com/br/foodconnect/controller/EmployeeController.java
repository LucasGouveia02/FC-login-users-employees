package com.br.foodconnect.controller;

import com.br.foodconnect.dto.AuthenticationEmployeeDTO;
import com.br.foodconnect.dto.EmployeeCredentialsDTO;
import com.br.foodconnect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employeeAccess")
    public ResponseEntity<AuthenticationEmployeeDTO> access (@RequestBody EmployeeCredentialsDTO dto) throws ParseException {
        return employeeService.access(dto);
    }
}
