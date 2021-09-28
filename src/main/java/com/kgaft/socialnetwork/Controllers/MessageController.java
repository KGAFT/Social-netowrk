package com.kgaft.socialnetwork.Controllers;

import com.kgaft.socialnetwork.Entities.Message;
import com.kgaft.socialnetwork.Repositories.UserMessagesDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
THis controller recieves a post request with messages and handles it's
 */

@Controller
public class MessageController {
    @Autowired
    private UserMessagesDAOImpl dao;
    @PostMapping("/message")
    public String messagePage(Model model, @RequestParam(value = "messageText", required = true) String text, @RequestParam(value = "messageReceiver", required = true) String receiver, @AuthenticationPrincipal User user){
        dao.sendMessage(new Message(text, user.getUsername(), receiver)); //Sending message
        model.addAttribute("result", "Successfully sent to: " + receiver); //Adding result to html view
        return "successPage";
    }
    @PostMapping("/deleteMessage")
    public String deleteMessagePage(@RequestParam(value="id") String id, @AuthenticationPrincipal User user, Model model){
        dao.deleteMessageById(Integer.parseInt(id), user.getUsername()); //Deleting message
        model.addAttribute("result", "Successfully deleted..."); //Adding result to html view
        return "successPage";
    }
}
