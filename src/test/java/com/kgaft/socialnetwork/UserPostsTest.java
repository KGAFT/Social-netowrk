package com.kgaft.socialnetwork;

import com.kgaft.socialnetwork.Entities.Post;
import com.kgaft.socialnetwork.Repositories.UserPostsDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class UserPostsTest {
    @Autowired
    private UserPostsDAOImpl DAO;
    Post testPost = new Post("TestPost", "TestInfo", "TestOwner");
    @Test
    public void addingPostTest(){
        DAO.addNewPost(testPost);
        Post receivedPost = DAO.findPostByOwner(testPost.getOwner()).get(0);
        Assert.hasText(testPost.getPostname(), testPost.getPostname());
        Assert.hasText(receivedPost.getPostname(), testPost.getPostinfo());
        DAO.deletePost(testPost.getId(), testPost.getOwner());
    }
    @Test
    public void deletePostTest(){
        DAO.addNewPost(testPost);
        Post recievedPost = DAO.findPostByOwner(testPost.getOwner()).get(0);
        Assert.isTrue(!recievedPost.getOwner().contains("notUser"));
        DAO.deletePost(recievedPost.getId(), recievedPost.getOwner());

    }

}
