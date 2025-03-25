package com.br.foodconnect.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginResponseDTO(
        @NotBlank String message,
        @NotBlank String status,
        CustomerInfoDTO customerInfo
) {}
