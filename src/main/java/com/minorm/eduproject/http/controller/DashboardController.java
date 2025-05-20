package com.minorm.eduproject.http.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OAuth2User user, Model model) {
        String email = user.getAttribute("email");
        String name = user.getAttribute("name");

        model.addAttribute("email", email);
        model.addAttribute("name", name);

        return "dashboard";
    }
}
