package ru.innopolis.stc12.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.bd.dao.DaoBanUsers;
import ru.innopolis.stc12.bd.pojo.User;

import java.util.List;

@Service
public class ServiceBanUsersImpl implements ServiceBanUsers {
    private DaoBanUsers daoBanUsers;

    @Autowired
    public ServiceBanUsersImpl(DaoBanUsers daoBanUsers) {
        this.daoBanUsers = daoBanUsers;
    }

    @Override
    public void banUser(Integer userId) {
        daoBanUsers.banUser(userId);
    }

    @Override
    public void banUserCancel(Integer userId) {
        daoBanUsers.banUserCancel(userId);
    }

    @Override
    public List<User> getUsers() {
        return daoBanUsers.getUsers();
    }
}
