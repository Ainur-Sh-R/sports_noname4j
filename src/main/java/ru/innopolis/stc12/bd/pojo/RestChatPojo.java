package ru.innopolis.stc12.bd.pojo;


public class RestChatPojo {
    private final long id;
    private String content;


    public RestChatPojo(String content, long id) {
        this.content = content;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
