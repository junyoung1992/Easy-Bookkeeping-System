package com.example.easybookkeepingsystem.domain.partner;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode
public class Partner {
    Long partnerId;
    Long partnerVersion;
    String partnerName;
    Long taxId;
    Long companyId;
    Instant createdDate;
    Instant modifiedDate;
}
