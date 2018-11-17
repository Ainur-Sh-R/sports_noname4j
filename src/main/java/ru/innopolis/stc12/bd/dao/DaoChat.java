package ru.innopolis.stc12.bd.dao;

import ru.innopolis.stc12.bd.pojo.Message;

import java.util.List;

public interface DaoChat {
    void addMessage(Message message);

    List<Message> getNewMessages(Integer lastMessagesId);
}
