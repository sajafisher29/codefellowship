package com.fishersarah.codefellowship.codefellowship.controllers;

import com.fishersarah.codefellowship.codefellowship.models.ApplicationUser;
import com.fishersarah.codefellowship.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class ApplicationUserListController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/user/{id}")
    public String getUserInfo(Model model, @PathVariable long id){
        ApplicationUser gottenUser =  applicationUserRepository.getOne(id);
        model.addAttribute("user", gottenUser);
        return "userProfile";
    }

    @GetMapping("/userList")
    public String getUserList(Model model, Principal principal){
        List<ApplicationUser> userList = applicationUserRepository.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("currentUser", applicationUserRepository.findByUsername(principal.getName()));
        return "allUsers";
    }

    @PostMapping("/follow")
    public RedirectView followUser(String id, Principal principal){
        Long idL = Long.parseLong(id);

        ApplicationUser userFollowing = applicationUserRepository.findByUsername(principal.getName());
        ApplicationUser userToBeFollowed = applicationUserRepository.getOne(idL);

        userFollowing.followUser(userToBeFollowed);
        applicationUserRepository.save(userFollowing);

        return new RedirectView("/profile");
    }

    @GetMapping("/feed")
    public String getFeed(Model model, Principal principal){
        ApplicationUser currentUser = applicationUserRepository.findByUsername(principal.getName());
        Set<ApplicationUser> usersIFollowList = currentUser.getUsersIFollow();

        model.addAttribute("listOfUsersIFollow", usersIFollowList);
        return "feed";
    }
}
