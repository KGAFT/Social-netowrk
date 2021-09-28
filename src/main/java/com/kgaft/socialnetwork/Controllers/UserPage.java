package com.kgaft.socialnetwork.Controllers;

import com.kgaft.socialnetwork.Repositories.UserMessagesDAOImpl;
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
    @Autowired
    private UserMessagesDAOImpl userMessagesDAO;
    @GetMapping("/User")
    public String usersPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("username", user.getUsername()); //Adding username to user page
        model.addAttribute("posts", userPostsDAOImplManagement.findPostByOwner(user.getUsername()));  //Adding posts to user page
        model.addAttribute("Messages", userMessagesDAO.getMessagesByReceiver(user.getUsername())); //Adding new messages to user page
        model.addAttribute("sended_messages", userMessagesDAO.getMessagesBySender(user.getUsername())); //Adding messages that user sent
        return "userPage";
    }
}
