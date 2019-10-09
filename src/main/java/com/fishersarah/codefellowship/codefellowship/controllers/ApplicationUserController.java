package com.fishersarah.codefellowship.codefellowship.controllers;

import com.fishersarah.codefellowship.codefellowship.models.ApplicationUser;
import com.fishersarah.codefellowship.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping
    public String showSignupPage() {
        return "signup";
    }


    @PostMapping("/signup")
    public RedirectView createNewUser(String username, String password) {
        // actually create a user
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password));
        // TODO: salt & hash the password

        // save it to a database
        applicationUserRepository.save(newUser);
        // maybe autologin?
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // send user back to homepage
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
