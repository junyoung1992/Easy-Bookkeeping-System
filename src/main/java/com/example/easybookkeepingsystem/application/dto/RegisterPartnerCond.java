package com.example.easybookkeepingsystem.application.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegisterPartnerCond {
    Long companyId;
    String partnerName;
    Long taxId;
}
