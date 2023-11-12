package com.example.easybookkeepingsystem.interfaces.partner;

import com.example.easybookkeepingsystem.common.mapper.PartnerMapper;
import com.example.easybookkeepingsystem.common.utils.DateTimeUtils;
import com.example.easybookkeepingsystem.domain.partner.Partner;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PartnerListResponse {

    List<PartnerResponse> list;

    public static PartnerListResponse of(List<Partner> partners) {
        List<PartnerResponse> list = partners.stream()
                .map(PartnerMapper.INSTANCE::toPartnerResponse)
                .toList();

        return PartnerListResponse.builder()
                .list(list)
                .build();
    }

    @Builder
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static class PartnerResponse {
        Long partnerId;
        Long partnerVersion;
        String partnerName;
        Long taxId;
        Long companyId;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.PATTERN_DISPLAY_DATETIME, timezone = DateTimeUtils.KST)
        Instant createdDate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.PATTERN_DISPLAY_DATETIME, timezone = DateTimeUtils.KST)
        Instant modifiedDate;
    }

}
