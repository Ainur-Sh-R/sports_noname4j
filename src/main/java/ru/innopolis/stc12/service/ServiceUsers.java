package ru.innopolis.stc12.service;

import ru.innopolis.stc12.bd.pojo.User;

public interface ServiceUsers {
    void registration(User user);

    int getIdByLogin(String login);
}
