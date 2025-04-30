package com.br.foodconnect.repository;

import com.br.foodconnect.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    @Query("SELECT u FROM EmployeeModel u WHERE u.id = ?1")
    EmployeeModel buscarPorId(Long id);
}
