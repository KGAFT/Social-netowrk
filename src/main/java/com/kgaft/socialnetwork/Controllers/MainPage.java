package com.kgaft.socialnetwork.Controllers;

import com.kgaft.socialnetwork.Repositories.UserPostsDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPage {
    @Autowired
    private UserPostsDAOImpl posts;
    @GetMapping("/")
    public String mainPAge(Model model){
        model.addAttribute("posts", posts.getAllPosts());
        return "mainPage";
    }
}
