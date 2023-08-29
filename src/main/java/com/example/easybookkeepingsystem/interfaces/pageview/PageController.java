package com.example.easybookkeepingsystem.interfaces.pageview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping(path = "/bookkeeping/list")
    public String bookkeepingListView(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "/bookkeeping/list";
    }

}
