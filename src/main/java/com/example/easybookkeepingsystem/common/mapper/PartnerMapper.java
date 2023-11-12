package com.example.easybookkeepingsystem.common.mapper;

import com.example.easybookkeepingsystem.application.dto.RegisterPartnerCond;
import com.example.easybookkeepingsystem.config.security.UserSession;
import com.example.easybookkeepingsystem.domain.partner.Partner;
import com.example.easybookkeepingsystem.domain.partner.PartnerForm;
import com.example.easybookkeepingsystem.infrastructure.persistence.partner.PartnerEntity;
import com.example.easybookkeepingsystem.interfaces.partner.PartnerListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartnerMapper {

    PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);

    PartnerListResponse.PartnerResponse toPartnerResponse(Partner partner);

    @Mapping(target = "companyId", source = "userSession.member.companyId")
    RegisterPartnerCond fromPartnerForm(PartnerForm form, UserSession userSession);

    @Mapping(target = "partnerId", ignore = true)
    @Mapping(target = "partnerVersion", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    Partner fromRegisterCond(RegisterPartnerCond registerPartnerCond);

    @Mapping(target = "partnerId", source = "id")
    @Mapping(target = "partnerVersion", source = "version")
    Partner fromPartnerEntity(PartnerEntity partnerEntity);

    PartnerEntity fromPartnerDomain(Partner partner);

}
