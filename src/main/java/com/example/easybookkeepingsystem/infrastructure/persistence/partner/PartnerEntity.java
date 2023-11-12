package com.example.easybookkeepingsystem.infrastructure.persistence.partner;

import com.example.easybookkeepingsystem.infrastructure.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Entity
@Table(name = "PARTNER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PartnerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    Long id;

    @Version
    @Column(name = "VERSION", nullable = false)
    Long version;

    @NotBlank
    @Column(name = "PARTNERNAME", nullable = false)
    String partnerName;

    @NotNull
    @Column(name = "TAXID", nullable = false)
    Long taxId;

    @NotNull
    @Column(name = "COMPANYID", nullable = false)
    Long companyId;

}
