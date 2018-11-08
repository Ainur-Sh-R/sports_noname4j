package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.bd.dao.DaoUsers;
import ru.innopolis.stc12.bd.pojo.User;

@Service
public class ServiceUsersImpl implements ServiceUsers {

    BCryptPasswordEncoder bCryptPasswordEncoder;
    DaoUsers daoUsers;

    @Autowired
    public void setBCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    public void setDaoUsers(DaoUsers daoUsers) {
        this.daoUsers = daoUsers;
    }

    @Override
    public void registration(User user) {
        String passwordHash = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        daoUsers.addUsers(user);
    }
}
