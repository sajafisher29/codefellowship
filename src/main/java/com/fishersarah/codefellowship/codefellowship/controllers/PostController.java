package com.fishersarah.codefellowship.codefellowship.controllers;

import com.fishersarah.codefellowship.codefellowship.models.ApplicationUser;
import com.fishersarah.codefellowship.codefellowship.models.ApplicationUserRepository;
import com.fishersarah.codefellowship.codefellowship.models.Post;
import com.fishersarah.codefellowship.codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;

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

}
