package com.fishersarah.codefellowship.codefellowship.controllers;

import com.fishersarah.codefellowship.codefellowship.models.ApplicationUser;
import com.fishersarah.codefellowship.codefellowship.models.ApplicationUserRepository;
import com.fishersarah.codefellowship.codefellowship.models.Post;
import com.fishersarah.codefellowship.codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/addPost")
    public String showPostForm(){
        return "addPost";
    }

    @PostMapping("/addPost")
    public RedirectView addPost(Principal principal, String body){
        ApplicationUser owner = applicationUserRepository.findByUsername(principal.getName());
        String createdAt = LocalDateTime.now().toString();
        Post post = new Post(body, createdAt, owner);

        postRepository.save(post);

        return new RedirectView("/users/" + owner.getId());
    }

    @GetMapping("/follow")
    public String showUsersFollowed (Model model){
        List<ApplicationUser> users = ApplicationUserRepository.findAll();

        model.addAttribute("users", users);

        return "newsfeed";
    }

    @PostMapping("/follow")
    public RedirectView followUser(Principal principal){ //Need to resolve what is needed here
        //get users
        ApplicationUser userClickingFollow = applicationUserRepository.getOne(applicationUser);
        ApplicationUser userAcceptingTheFollow = applicationUserRepository.getOne(follow);

        // update and save one followed user
        userClickingFollow.followed(acceptingTheFollow);
        applicationUserRepository.save(userClickingFollow);

        // send me back to my page
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        return new RedirectView("/users/" + user.getId() );
    }

}
