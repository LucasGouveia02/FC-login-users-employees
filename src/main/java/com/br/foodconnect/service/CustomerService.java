package com.br.foodconnect.service;

import com.br.foodconnect.dto.CustomerCredentialsAndInfoDTO;
import com.br.foodconnect.dto.CustomerCredentialsDTO;
import com.br.foodconnect.dto.CustomerInfoDTO;
import com.br.foodconnect.dto.LoginResponseDTO;
import com.br.foodconnect.repository.CustomerCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CustomerService {

    @Autowired
    private CustomerCredentialRepository customerCredentialRepository;

    private final BCryptPasswordEncoder encryptPassword = new BCryptPasswordEncoder();

    public ResponseEntity<LoginResponseDTO> loginCustomer(CustomerCredentialsDTO customerCredentialsDTO) {
        CustomerCredentialsAndInfoDTO customerCredentialsAndInfoDTO = customerCredentialRepository.findByEmail(customerCredentialsDTO.email());

        if(customerCredentialsAndInfoDTO == null){
            return ResponseEntity.status(404).body(new LoginResponseDTO(
                    "Credentials not register in system.",
                    "error",
                    null
            ));
        }

        if(encryptPassword.matches(customerCredentialsDTO.password(), customerCredentialsAndInfoDTO.password())){
            CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO(
                    customerCredentialsAndInfoDTO.email(),
                    customerCredentialsAndInfoDTO.cellphoneNumber(),
                    customerCredentialsAndInfoDTO.name()
            );
            return ResponseEntity.status(200).body(new LoginResponseDTO(
                    "Access Granted.",
                    "success",
                    customerInfoDTO
            ));
        } else {
            return ResponseEntity.status(401).body(new LoginResponseDTO(
                    "E-mail or password invalid.",
                    "error",
                    null
            ));
        }

    }
}
