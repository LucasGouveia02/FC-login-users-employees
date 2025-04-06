package com.br.foodconnect.service;

import com.br.foodconnect.dto.AuthenticationEmployeeDTO;
import com.br.foodconnect.dto.EmployeeCredentialsDTO;
import com.br.foodconnect.model.EmployeeCredentialModel;
import com.br.foodconnect.model.EmployeeModel;
import com.br.foodconnect.repository.EmployeeCredencialRepository;
import com.br.foodconnect.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeCredencialRepository employeeCredencialRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEmployeeService passwordEmployeeService;

    public ResponseEntity<AuthenticationEmployeeDTO> access (EmployeeCredentialsDTO credencialDTO) {
        EmployeeCredentialModel credencial = employeeCredencialRepository.buscaPorEmail(credencialDTO.getEmail());
        if (credencial != null) {
            boolean senhaCorreta = passwordEmployeeService.verificarSenha(credencialDTO.getPassword(), credencial.getPassword());
            if (senhaCorreta) {
                EmployeeModel employee = employeeRepository.buscarPorId(credencial.getId());
                return new ResponseEntity<>(new AuthenticationEmployeeDTO(credencial.getEnabled(), true, employee.getId(), employee.getName(), credencial.getRole(), employee.getStore().getName(), employee.getStore().getId(), employee.getStore().getFoodCourt()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
