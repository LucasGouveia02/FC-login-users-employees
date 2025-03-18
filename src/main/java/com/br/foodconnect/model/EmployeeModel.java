package com.br.foodconnect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
