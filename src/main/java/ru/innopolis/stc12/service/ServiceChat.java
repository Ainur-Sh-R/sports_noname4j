package ru.innopolis.stc12.service;

import ru.innopolis.stc12.bd.pojo.Message;

import java.util.List;


public interface ServiceChat {
    void addMessage(Message message);
    List<Message> getNewMessages(Integer lastMessagesId);
}
