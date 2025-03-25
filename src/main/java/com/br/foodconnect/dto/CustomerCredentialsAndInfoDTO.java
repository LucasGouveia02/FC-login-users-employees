package com.br.foodconnect.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerCredentialsAndInfoDTO(
        @NotBlank String email,
        @NotBlank String password,
        @NotBlank String cellphoneNumber,
        @NotBlank String name
) {}