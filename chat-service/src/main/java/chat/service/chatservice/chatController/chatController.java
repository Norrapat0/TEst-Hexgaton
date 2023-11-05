package chat.service.chatservice.chatController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import chat.service.chatservice.model.Message;

@Controller
@CrossOrigin
public class chatController {
    
    // @Autowired
    


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private List<Message> publicChatMessages = new ArrayList<>();
    private Map<String, List<Message>> privateChatMessages = new HashMap<>();

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){

        publicChatMessages.add(message); // Store the message
        return message;
    }



    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message){
        privateChatMessages
            .computeIfAbsent(message.getSenderName(), k -> new ArrayList<>())
            .add(message); // Store the message for the sender
        
        privateChatMessages
            .computeIfAbsent(message.getReceiverName(), k -> new ArrayList<>())
            .add(message); // Store the message for the receiver
    
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        return message;
    }
    

    @MessageMapping("/public-chat-history")
public List<Message> getPublicChatHistory() {
    return publicChatMessages;
}

@MessageMapping("/private-chat-history")
public List<Message> getPrivateChatHistory(@Payload String username) {
    return privateChatMessages.get(username);
}
}
