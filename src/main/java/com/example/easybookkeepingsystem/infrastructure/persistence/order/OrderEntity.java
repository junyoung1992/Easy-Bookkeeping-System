package com.example.easybookkeepingsystem.infrastructure.persistence.order;

import com.example.easybookkeepingsystem.infrastructure.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    Long id;

    @Version
    @Column(name = "VERSION", nullable = false)
    Long version;

    @NotNull
    @Column(name = "COMPANY_ID", nullable = false)
    Long companyId;

    @NotNull
    @Column(name = "ORDER_DATE", nullable = false)
    Instant orderDate;

    @NotNull
    @Column(name = "PARTNER_ID", nullable = false)
    Long partnerId;

    @NotNull
    @Column(name = "PARTNER_VERSION", nullable = false)
    Long partnerVersion;

    @NotBlank
    @Column(name = "PARTNER_NAME", nullable = false)
    String partnerName;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    BigDecimal price;

    @NotNull
    @Column(name = "NOTE", nullable = false)
    String note;

}
