package com.kgaft.socialnetwork.Controllers;

import com.kgaft.socialnetwork.Entities.Post;
import com.kgaft.socialnetwork.Repositories.UserPostsDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
This controller recieves requests to dit posts
 */

@Controller
public class PostsController {
    @Autowired
    private UserPostsDAOImpl posts;  //Autowiring the repo
    @PostMapping("/Posts")
    public String addPost(@RequestParam(value = "PostName", required = true) String postName, @RequestParam(value="PostInfo", required = true) String postInfo, @AuthenticationPrincipal User user, Model model){
        posts.addNewPost(new Post(postName, postInfo, user.getUsername())); //Adding new post
        model.addAttribute("result", "Successfully added: " + postName); //Adding text to successpage
        return "successPage";
    }
    @PostMapping("/deletePost")
    public String deletePost(@RequestParam(required = true) String id, Model model, @AuthenticationPrincipal User user){ //@AuthenticaionPrincipal authorizing the user, who wants to delete the post
        posts.deletePost(Integer.parseInt(id), user.getUsername()); //Deleting post
        model.addAttribute("result", "Successfully deleted");
        return "successPage";
    }

    @GetMapping("/editPost")
    public String editPostPage(@RequestParam String id, Model model){
        model.addAttribute("id", id); //Returning page for editting post
        return "editPage";
    }
    @PostMapping("/editPost")
    public String editOldPost(@RequestParam(value="postName", required = true) String postName, @RequestParam(value = "postInfo", required = true) String postInfo, @RequestParam(value = "id", required = true) String id,
                              @AuthenticationPrincipal User user, Model model){
        posts.editPost(new Post(postName, postInfo, user.getUsername()), Integer.parseInt(id)); //Editting old post
        model.addAttribute("result", "Successfully editted: " + postName);
        return "successPage";
    }
}
