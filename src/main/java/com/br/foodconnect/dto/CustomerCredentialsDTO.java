package com.br.foodconnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerCredentialsDTO(
        @NotBlank @Email String email,
        @NotBlank String password
) {}