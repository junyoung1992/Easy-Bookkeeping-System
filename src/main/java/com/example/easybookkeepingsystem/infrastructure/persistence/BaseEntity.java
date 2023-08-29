package com.example.easybookkeepingsystem.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "MODIFIED_DATE", nullable = false)
    private Instant modifiedDate;
}
