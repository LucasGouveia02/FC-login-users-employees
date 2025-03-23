package com.br.foodconnect.service;

import com.br.foodconnect.dto.LoginDTO;
import com.br.foodconnect.repository.CustomerCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CustomerService {

    @Autowired
    private CustomerCredentialRepository customerCredentialRepository;

    private final BCryptPasswordEncoder encryptPassword = new BCryptPasswordEncoder();

    public ResponseEntity<?> loginCustomer(LoginDTO loginDTO) {
        var credentials = customerCredentialRepository.findByEmail(loginDTO.email());

        if(credentials == null){
            return ResponseEntity.status(404).body("Credentials Not Found.");
        }

        if(encryptPassword.matches(loginDTO.password(), credentials.password())){
        return ResponseEntity.status(200).body(new HashMap<String, String>() {{
            put("message", "Access Granted.");
            put("status", "success");
        }});
        } else {
        return ResponseEntity.status(401).body(new HashMap<String, String>() {{
            put("message", "E-mail or password invalid.");
            put("status", "error");
        }});
        }

    }
}
