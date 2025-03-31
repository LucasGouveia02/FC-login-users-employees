package com.br.foodconnect.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationEmployeeDTO {

    private boolean authenticated;
    private Long id;
    private String name;
    private String role;
    private String storeName;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isEnabled;

    public AuthenticationEmployeeDTO(boolean isEnabled, boolean authenticated, Long id, String name, String role, String storeName) {
        this.isEnabled = isEnabled;
        this.authenticated = authenticated;
        this.id = id;
        this.name = name;
        this.role = role;
        this.storeName = storeName;
    }
}
