package ru.innopolis.stc12.bd.pojo;

import java.util.Date;

public class Message {
    private int idMessage;
    private int idChat;
    private int idUser;
    private String content;
    private Date dateCreate;

    public Message(int idMessage, int idChat, int idUser, String content, Date dateCreate) {
        this.idMessage = idMessage;
        this.idChat = idChat;
        this.idUser = idUser;
        this.content = content;
        this.dateCreate = dateCreate;
    }

    public Message() {
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }


}
