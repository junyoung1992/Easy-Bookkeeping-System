package com.example.easybookkeepingsystem.infrastructure.persistence.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findOneByUserId(String userId);

}
