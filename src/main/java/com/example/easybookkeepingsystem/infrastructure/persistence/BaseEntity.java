package com.example.easybookkeepingsystem.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@SuperBuilder
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseEntity {
    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "MODIFIED_DATE", nullable = false)
    private Instant modifiedDate;
}
