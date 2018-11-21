package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.bd.dao.DaoChat;
import ru.innopolis.stc12.bd.dao.DaoUsers;
import ru.innopolis.stc12.bd.pojo.Message;

import java.util.Date;
import java.util.List;

@Service
public class ServiceChatImpl implements ServiceChat {

    private DaoChat daoChat;
    private DaoUsers daoUsers;
    private ServiceUsers serviceUsers;
    private  final Integer GLOBAL_CHAT_INDEX = 0;

    @Autowired
    public ServiceChatImpl(DaoChat daoChat, DaoUsers daoUsers,ServiceUsers serviceUsers) {
        this.daoChat = daoChat;
        this.daoUsers = daoUsers;
        this.serviceUsers = serviceUsers;
    }

    @Override
    public void addMessage(Message message) {
        daoChat.addMessage(message);
    }

    @Override
    public List<Message> getNewMessages(Integer lastMessagesId, String login) {
        return daoChat.getNewMessages(lastMessagesId, serviceUsers.getIdByLogin(login));
    }

    @Override
    public void addMessage(String msg, String login) {
        Message message = new Message();
        if (msg != "") {
            Integer idChat = getIdChat(msg);
            message.setDateCreate(new Date());
            message.setIdChat(idChat);
            if (idChat > 0) {
                message.setContent("/w " + login + ":" + msg.substring(msg.indexOf(' ')));
            } else {
                message.setContent(login + ": " + msg);
            }
            message.setIdUser(serviceUsers.getIdByLogin(login));
            addMessage(message);
        }
    }

    @Override
    public Integer getIdChat(String msg) {
        Integer res = GLOBAL_CHAT_INDEX;
        if(String.valueOf(msg.charAt(0)).equals("/")){
            int indexEndLogin;
            indexEndLogin = msg.indexOf(' ');
            if (indexEndLogin > 0){
                String login = msg.substring(1,indexEndLogin);
                int idUser = daoUsers.getIdByLogin(login);
                if (idUser>0){
                    res = idUser;
                }
            }
        }
        return res;
    }
}
