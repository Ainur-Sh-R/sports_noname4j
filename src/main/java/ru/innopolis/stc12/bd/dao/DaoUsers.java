package ru.innopolis.stc12.bd.dao;

import ru.innopolis.stc12.bd.pojo.User;

public interface DaoUsers {
    void addUsers(User user);

    int getIdByLogin(String login);
}
