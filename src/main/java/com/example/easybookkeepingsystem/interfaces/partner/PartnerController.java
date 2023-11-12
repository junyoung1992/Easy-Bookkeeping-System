package com.example.easybookkeepingsystem.interfaces.partner;

import com.example.easybookkeepingsystem.application.PartnerUseCase;
import com.example.easybookkeepingsystem.application.dto.RegisterPartnerCond;
import com.example.easybookkeepingsystem.common.mapper.PartnerMapper;
import com.example.easybookkeepingsystem.config.security.UserSession;
import com.example.easybookkeepingsystem.domain.partner.PartnerForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerUseCase partnerUseCase;

    @GetMapping(path = "/partner/list")
    public String registerPartnerView(@AuthenticationPrincipal UserSession user, Model model) {
        model.addAttribute("companyId", user.getMember().getCompanyId());
        return "/partner/list";
    }

    @GetMapping(path = "/partner/register")
    public String registerPartnerView(@ModelAttribute("partnerForm") PartnerForm form) {
        return "/partner/register";
    }

    @PostMapping(path = "/partner/register")
    public String registerPartner(@AuthenticationPrincipal UserSession user,
                                  @ModelAttribute("partnerForm") PartnerForm form) {
        RegisterPartnerCond registerPartnerCond = PartnerMapper.INSTANCE.fromPartnerForm(form, user);
        partnerUseCase.registerPartner(registerPartnerCond);
        return "redirect:/partner/list";
    }

}
