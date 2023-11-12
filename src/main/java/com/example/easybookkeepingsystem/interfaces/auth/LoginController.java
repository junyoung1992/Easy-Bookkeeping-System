package com.example.easybookkeepingsystem.interfaces.auth;

import com.example.easybookkeepingsystem.domain.member.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping(path = "/login")
    public String loginFormView(@ModelAttribute("loginForm") LoginForm form) {
        return "/login/form";
    }

    @PostMapping("/login/process")
    public String login(@ModelAttribute("loginForm") LoginForm form) {
        return "/login/form";
    }

    @PostMapping("/logout")
    public String logout() {
        return "/home";
    }

}
