package ru.innopolis.stc12.service;

import ru.innopolis.stc12.bd.pojo.User;

import java.util.List;

public interface ServiceBanUsers {
    void banUser(Integer userId);
    void banUserCancel(Integer userId);
    List<User> getUsers();
}
