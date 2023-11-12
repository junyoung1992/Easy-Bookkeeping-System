package com.example.easybookkeepingsystem.interfaces.partner;

import com.example.easybookkeepingsystem.application.PartnerUseCase;
import com.example.easybookkeepingsystem.domain.partner.Partner;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/partner")
@RequiredArgsConstructor
public class PartnerApiController {

    private final PartnerUseCase partnerUseCase;

    @GetMapping("/list")
    public PartnerListResponse getPartnerList(@RequestParam Long companyId) {
        List<Partner> partners = partnerUseCase.getPartnerList(companyId);
        return PartnerListResponse.of(partners);
    }

}
