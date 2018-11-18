package ru.innopolis.stc12.service;

import ru.innopolis.stc12.bd.pojo.OnlineLogin;
import ru.innopolis.stc12.bd.pojo.User;

import java.util.List;

public interface ServiceUsers {
    void registration(User user);
    int getIdByLogin(String login);
    List<User> getOnlineLogins();
}
