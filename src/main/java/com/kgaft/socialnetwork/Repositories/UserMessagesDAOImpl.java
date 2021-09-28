package com.kgaft.socialnetwork.Repositories;

import com.kgaft.socialnetwork.Entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
This service works with messages
 */
@Service
public class UserMessagesDAOImpl {
    @Autowired
    private MessageRepositoryDAO messageRepositoryDAO; //Autowiring the repo

    public void sendMessage(Message message){
        messageRepositoryDAO.save(message); //Saving message
    }
    public List<Message> getMessagesByReceiver(String username){
        ArrayList<Message> userMessages = new ArrayList<>();
        messageRepositoryDAO.findAll().forEach(element -> {  //Getting messages by reciever
            if(element.getReceiver().contains(username)){
                userMessages.add(element);
            }
        });
        return userMessages;
    }
    public List<Message> getMessagesBySender(String username){
        ArrayList<Message> sendedMessages = new ArrayList<>();
        messageRepositoryDAO.findAll().forEach(element->{ //Getting messages by sender
            if(element.getSender().contains(username)){
                sendedMessages.add(element);
            }
        });
        return sendedMessages;
    }
    public void deleteMessageById(int id, String sender){
        if(messageRepositoryDAO.findById(id).get().getSender().contains(sender)){
            messageRepositoryDAO.deleteById(id); //Deleting messages by id, user that wan't to delete
        }
        else{
            throw new AuthorizationServiceException("Error this user is not sender of this message");
        }
    }
}
