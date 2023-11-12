package com.example.easybookkeepingsystem.domain.partner;

import com.example.easybookkeepingsystem.common.mapper.PartnerMapper;
import com.example.easybookkeepingsystem.infrastructure.persistence.partner.PartnerEntity;
import com.example.easybookkeepingsystem.infrastructure.persistence.partner.PartnerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PartnerRepository {

    private final PartnerJpaRepository partnerJpaRepository;

    public List<Partner> findAllByCompanyId(Long companyId) {
        return partnerJpaRepository.findAllByCompanyId(companyId).stream()
                .map(PartnerMapper.INSTANCE::fromPartnerEntity)
                .sorted(Comparator.comparing(Partner::getPartnerId))
                .toList();
    }

    public Optional<Partner> findOneByCompanyIdAndTaxId(Long companyId, Long taxId) {
        return partnerJpaRepository.findOneByCompanyIdAndTaxId(companyId, taxId)
                .map(PartnerMapper.INSTANCE::fromPartnerEntity);
    }

    public PartnerEntity save(Partner partner) {
        return partnerJpaRepository.save(PartnerMapper.INSTANCE.fromPartnerDomain(partner));
    }

}
