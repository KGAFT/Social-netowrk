package com.kgaft.socialnetwork.Controllers;

import com.kgaft.socialnetwork.Repositories.UserPostsDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserPage {
    @Autowired
    private UserPostsDAOImpl userPostsDAOImplManagement;
    @GetMapping("/User")
    public String usersPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("username", user.getUsername());

        model.addAttribute("posts", userPostsDAOImplManagement.findPostByOwner(user.getUsername()));
        return "userPage";
    }
}
