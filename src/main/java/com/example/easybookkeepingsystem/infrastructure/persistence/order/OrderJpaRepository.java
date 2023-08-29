package com.example.easybookkeepingsystem.infrastructure.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByCompanyIdAndOrderDateBetween(long companyId, Instant startDateTime, Instant endDateTime);
}
