package com.br.foodconnect.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerInfoDTO(
        @NotBlank String email,
        @NotBlank String cellphoneNumber,
        @NotBlank String name
) {}
