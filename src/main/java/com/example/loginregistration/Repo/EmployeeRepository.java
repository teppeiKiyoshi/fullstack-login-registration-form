package com.example.loginregistration.Repo;

import com.example.loginregistration.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByEmail(String email);

    Optional<EmployeeEntity> findOneByEmailAndPassword(String email, String password);

}
