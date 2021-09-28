package com.kgaft.socialnetwork;

import com.kgaft.socialnetwork.Entities.Message;
import com.kgaft.socialnetwork.Entities.Post;
import com.kgaft.socialnetwork.Repositories.UserMessagesDAOImpl;
import com.kgaft.socialnetwork.Repositories.UserPostsDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserMessagesTest {
    @Autowired
    private UserMessagesDAOImpl DAO;
    private Message testMessage = new Message("TestMessage", "TestSender", "TestReceiver");

    @Test
    public void sendingMessageTest(){
        DAO.sendMessage(testMessage);
        Message message = DAO.getMessagesByReceiver("TestReceiver").get(0);
        Assert.hasText(testMessage.getSender(), message.getSender());
        Assert.hasText(testMessage.getReceiver(), message.getReceiver());
        DAO.deleteMessageById(testMessage.getId(), testMessage.getSender());

    }
    @Test
    public void deletePostTest(){
        DAO.sendMessage(testMessage);
        Message message = DAO.getMessagesByReceiver(testMessage.getReceiver()).get(0);
        Assert.isTrue(!message.getReceiver().contains("NotReceiver"));
        DAO.deleteMessageById(testMessage.getId(), testMessage.getSender());

    }
}
