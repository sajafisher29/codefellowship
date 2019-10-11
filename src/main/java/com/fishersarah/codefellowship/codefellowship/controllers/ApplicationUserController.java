package com.fishersarah.codefellowship.codefellowship.controllers;

import com.fishersarah.codefellowship.codefellowship.models.ApplicationUser;
import com.fishersarah.codefellowship.codefellowship.models.ApplicationUserRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView createNewUser(String username, String password, String nameFirst, String nameLast, String dateOfBirth, String bio) {
        // create a user
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password), nameFirst, nameLast, dateOfBirth, bio);
        // save it to a database
        applicationUserRepository.save(newUser);
        // this auto logs in the user when they sign up
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // send user to homepage now logged in
        return new RedirectView("/myPage");
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/users/{id}")
    public String showSingleUser(@PathVariable long id, Principal principal, Model model) {
        model.addAttribute("viewedUser", applicationUserRepository.findById(id).get() ); // Optional
        model.addAttribute("user", principal);
        return "userProfile";
    }

    @GetMapping("/logout")
    public RedirectView logout() {
        return new RedirectView("/");
    }
}
