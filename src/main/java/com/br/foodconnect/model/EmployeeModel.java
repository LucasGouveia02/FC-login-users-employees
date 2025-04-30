package com.br.foodconnect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")

public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "employee_credential_id")
    private EmployeeCredentialModel credential;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreModel store;

    public EmployeeModel(Long id, String name, String phoneNumber, EmployeeCredentialModel credential, StoreModel store) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.credential = credential;
        this.store = store;
    }

    public EmployeeModel() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EmployeeCredentialModel getCredential() {
        return credential;
    }

    public void setCredential(EmployeeCredentialModel credential) {
        this.credential = credential;
    }

    public StoreModel getStore() {
        return store;
    }

    public void setStore(StoreModel store) {
        this.store = store;
    }
}
