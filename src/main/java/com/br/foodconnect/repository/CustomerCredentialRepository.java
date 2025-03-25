package com.br.foodconnect.repository;

import com.br.foodconnect.dto.CustomerCredentialsAndInfoDTO;
import com.br.foodconnect.model.CustomerCredentialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerCredentialRepository extends JpaRepository<CustomerCredentialModel, Long> {

    @Query("SELECT new com.br.foodconnect.dto.CustomerCredentialsAndInfoDTO(cr.email, cr.password, c.phoneNumber, c.name)" +
            " FROM CustomerModel c INNER JOIN c.credential cr WHERE cr.email = :email")
    CustomerCredentialsAndInfoDTO findByEmail(@Param("email") String email);

}
