package com.example.easybookkeepingsystem.infrastructure.persistence.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {
}
