package com.br.foodconnect.repository;

import com.br.foodconnect.model.EmployeeCredentialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCredencialRepository extends JpaRepository<EmployeeCredentialModel, Long> {

    @Query("SELECT u FROM EmployeeCredentialModel u WHERE u.email = ?1")
    EmployeeCredentialModel buscaPorEmail(String email);
}
