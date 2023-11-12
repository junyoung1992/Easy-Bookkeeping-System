package com.example.easybookkeepingsystem.infrastructure.persistence.partner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PartnerJpaRepository extends JpaRepository<PartnerEntity, Long> {

    List<PartnerEntity> findAllByCompanyId(long companyId);

    Optional<PartnerEntity> findOneByCompanyIdAndTaxId(long companyId, long taxId);

}
