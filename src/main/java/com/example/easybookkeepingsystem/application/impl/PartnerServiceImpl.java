package com.example.easybookkeepingsystem.application.impl;

import com.example.easybookkeepingsystem.application.PartnerUseCase;
import com.example.easybookkeepingsystem.application.dto.RegisterPartnerCond;
import com.example.easybookkeepingsystem.common.mapper.PartnerMapper;
import com.example.easybookkeepingsystem.domain.partner.Partner;
import com.example.easybookkeepingsystem.domain.partner.PartnerRepository;
import com.example.easybookkeepingsystem.infrastructure.persistence.partner.PartnerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerUseCase {

    private final PartnerRepository partnerRepository;

    @Override
    public List<Partner> getPartnerList(Long companyId) {
        return partnerRepository.findAllByCompanyId(companyId);
    }

    @Override
    public Partner registerPartner(RegisterPartnerCond registerPartnerCond) {
        // 이미 등록된 거래처
        partnerRepository.findOneByCompanyIdAndTaxId(registerPartnerCond.getCompanyId(), registerPartnerCond.getTaxId())
                .ifPresent(x -> {
                    throw new IllegalStateException();
                });

        // 파트너 신규 저장
        Partner partner = PartnerMapper.INSTANCE.fromRegisterCond(registerPartnerCond);
        PartnerEntity saved = partnerRepository.save(partner);
        return PartnerMapper.INSTANCE.fromPartnerEntity(saved);
    }

}
