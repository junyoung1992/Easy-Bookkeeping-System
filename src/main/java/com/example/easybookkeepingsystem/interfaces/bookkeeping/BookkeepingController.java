package com.example.easybookkeepingsystem.interfaces.bookkeeping;

import com.example.easybookkeepingsystem.config.security.UserSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BookkeepingController {

    @GetMapping(path = "/bookkeeping/list")
    public String bookkeepingListView(@AuthenticationPrincipal UserSession user, Model model) {
        model.addAttribute("companyId", user.getMember().getCompanyId());
        return "/bookkeeping/list";
    }

}
