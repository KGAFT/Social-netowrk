package com.kgaft.socialnetwork.Controllers;

import com.kgaft.socialnetwork.Repositories.UserPostsDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 This controller returns mainpage
 */



@Controller
public class MainPage {
    @Autowired
    private UserPostsDAOImpl posts;
    @GetMapping("/")
    public String mainPAge(Model model){
        model.addAttribute("posts", posts.getAllPosts());  //Adding posts to html view
        return "mainPage";
    }
}
