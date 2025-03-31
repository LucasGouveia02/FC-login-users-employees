package com.br.foodconnect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_credential")
public class EmployeeCredentialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Boolean isEnabled;
    private String role;

    public EmployeeCredentialModel(String role, Boolean isEnabled, String password, String email, Long id) {
        this.role = role;
        this.isEnabled = isEnabled;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public EmployeeCredentialModel() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
