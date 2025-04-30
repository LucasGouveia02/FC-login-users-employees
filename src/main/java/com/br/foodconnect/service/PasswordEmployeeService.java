package com.br.foodconnect.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PasswordEmployeeService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean verificarSenha(String senhaPlana, String senhaCriptografada) {
        if (senhaCriptografada == null || senhaCriptografada.isEmpty()) {
            return false;
        }

        if (senhaCriptografada.startsWith("$2a$") || senhaCriptografada.startsWith("$2b$") || senhaCriptografada.startsWith("$2y$")) {
            return passwordEncoder.matches(senhaPlana, senhaCriptografada);
        } else {
            return verificarSHA256(senhaPlana, senhaCriptografada);
        }
    }

    private boolean verificarSHA256(String senhaPlana, String senhaCriptografada) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senhaPlana.getBytes(StandardCharsets.UTF_8));
            String senhaPlanaHash = bytesToHex(hash);
            return senhaPlanaHash.equalsIgnoreCase(senhaCriptografada);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar SHA-256", e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String criptografar(String senha) {
        return passwordEncoder.encode(senha);
    }
}
