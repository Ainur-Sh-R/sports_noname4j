package ru.innopolis.stc12.bd.dao;

import ru.innopolis.stc12.bd.pojo.OnlineLogin;
import ru.innopolis.stc12.bd.pojo.User;

import java.util.List;

public interface DaoUsers {
    void addUsers(User user);
    int getIdByLogin(String login);
    List<User> getOnlineUsers();
}
