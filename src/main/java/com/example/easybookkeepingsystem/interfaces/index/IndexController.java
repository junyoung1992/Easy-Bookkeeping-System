package com.example.easybookkeepingsystem.interfaces.index;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping(path = "/")
    public String indexView(@AuthenticationPrincipal User user, Model model) {
        if (Objects.nonNull(user)) {
            model.addAttribute("userId", user.getUsername());
        }

        return "/home";
    }

}
