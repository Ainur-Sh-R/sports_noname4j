package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.bd.dao.DaoChat;
import ru.innopolis.stc12.bd.pojo.Message;

import java.util.List;

@Service
public class ServiceChatImpl implements ServiceChat {

    DaoChat daoChat;

    @Autowired
    public ServiceChatImpl(DaoChat daoChat) {
        this.daoChat = daoChat;
    }

    @Override
    public void addMessage(Message message) {
        daoChat.addMessage(message);

    }

    @Override
    public List<Message> getNewMessages(Integer lastMessagesId) {
        return daoChat.getNewMessages(lastMessagesId);
    }
}
