package com.kgaft.socialnetwork.Repositories;

import com.kgaft.socialnetwork.Entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPostsDAOImpl {
    @Autowired
    private PostRepositoryDAO userRepositoryDAO;

    public List<Post> findPostByOwner(String owner){
        ArrayList<Post> postToReturn = new ArrayList<>();
        try {
            userRepositoryDAO.findAll().forEach(element -> {
                if (element.getOwner().contains(owner)) {
                    postToReturn.add(element);
                }
            });
        }catch(Exception e){
            postToReturn.add(new Post("You ain't added any posts", "Please add new post", "Service"));
        }
        return postToReturn;
    }
    public  void addNewPost(Post post){
        userRepositoryDAO.save(post);
    }
    public Iterable<Post> getAllPosts(){

        return userRepositoryDAO.findAll();
    }
    public void deletePost(int id, String author){
        if(userRepositoryDAO.findById(id).get().getOwner().contains(author)){
            userRepositoryDAO.deleteById(id);
        }
        else{
            throw new AuthorizationServiceException("Owner in post isn't equals to current user.");
        }
    }
    public void editPost(Post post, int id){
        if(userRepositoryDAO.findById(id).get().getOwner().contains(post.getOwner())){
            post.setId(id);
            userRepositoryDAO.save(post);
        }
        else{
            throw new AuthorizationServiceException("Owner in post isn't equals to current user.");
        }
    }
}
