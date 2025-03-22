package com.br.foodconnect.repository;

import com.br.foodconnect.dto.LoginDTO;
import com.br.foodconnect.model.CustomerCredentialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerCredentialRepository extends JpaRepository<CustomerCredentialModel, Long> {

    @Query("SELECT new com.br.foodconnect.dto.LoginDTO(c.email, c.password) FROM CustomerCredentialModel c WHERE c.email = ?1")
    LoginDTO findByEmail(String email);

}
