package com.br.foodconnect.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEmployeeService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean verificarSenha(String senhaPlana, String senhaCriptografada) {
        return passwordEncoder.matches(senhaPlana, senhaCriptografada);
    }

    public String criptografar(String senha) {
        return passwordEncoder.encode(senha);
    }
}
