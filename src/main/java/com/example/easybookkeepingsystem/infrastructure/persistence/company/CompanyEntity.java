package com.example.easybookkeepingsystem.infrastructure.persistence.company;

import com.example.easybookkeepingsystem.infrastructure.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Entity
@Table(name = "COMPANY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    Long id;

    @Version
    @Column(name = "VERSION", nullable = false)
    Long version;

    @NotBlank
    @Column(name = "COMPANYNAME", nullable = false)
    String companyName;

}
