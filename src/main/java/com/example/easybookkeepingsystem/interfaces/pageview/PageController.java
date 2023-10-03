package com.example.easybookkeepingsystem.interfaces.pageview;

import com.example.easybookkeepingsystem.domain.member.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping(path = "/")
    public String indexView(@AuthenticationPrincipal User user, Model model) {
        if (Objects.nonNull(user)) {
            model.addAttribute("userId", user.getUsername());
        }

        return "/home";
    }

    @GetMapping(path = "/bookkeeping/list")
    public String bookkeepingListView(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "/bookkeeping/list";
    }

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
