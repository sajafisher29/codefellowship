package com.fishersarah.codefellowship.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public class HomeController {

    @Controller
    public class HomeController {
        // The principal is the currently logged-in user
        // It could be null or have useful information

        @GetMapping("/")
        public String getHome(Principal principal, Model model) {
            if (principal != null) {

                model.addAttribute("username", principal.getName());
            }
            return "home";
        }
}
