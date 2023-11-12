package com.example.easybookkeepingsystem.application;

import com.example.easybookkeepingsystem.application.dto.RegisterPartnerCond;
import com.example.easybookkeepingsystem.domain.partner.Partner;

import java.util.List;

public interface PartnerUseCase {

    List<Partner> getPartnerList(Long companyId);

    Partner registerPartner(RegisterPartnerCond registerPartnerCond);

}
