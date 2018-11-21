package ru.innopolis.stc12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc12.bd.pojo.Message;
import ru.innopolis.stc12.bd.pojo.User;
import ru.innopolis.stc12.service.ServiceChat;
import ru.innopolis.stc12.service.ServiceUsers;
import java.security.Principal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestChatController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();
    private ServiceChat serviceChat;
    private ServiceUsers serviceUsers;

    @Autowired
    public RestChatController(ServiceChat serviceChat, ServiceUsers serviceUsers) {
        this.serviceChat = serviceChat;
        this.serviceUsers = serviceUsers;
    }

    @RequestMapping("/newMessage")
    public void newMessage(
            @RequestParam(value = "message", required = false, defaultValue = "") String newMessage,
            Principal principal) {
        serviceChat.addMessage(newMessage, principal.getName());
    }

    @RequestMapping("/updateMessages")
    public List<Message> getNewMessages(
            @RequestParam(value = "lastMessageId") Integer lastMessageId,
            Principal principal) {
        return serviceChat.getNewMessages(lastMessageId, principal.getName());
    }

    @RequestMapping("/updateOnlineUsers")
    public List<User> getOnlineUsers(){
        return serviceUsers.getOnlineLogins();
    }

}


