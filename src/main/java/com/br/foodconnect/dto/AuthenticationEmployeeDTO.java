package com.br.foodconnect.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

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

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
