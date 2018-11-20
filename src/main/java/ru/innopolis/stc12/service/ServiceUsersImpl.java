package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.bd.dao.DaoUsers;
import ru.innopolis.stc12.bd.pojo.OnlineLogin;
import ru.innopolis.stc12.bd.pojo.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceUsersImpl implements ServiceUsers {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private DaoUsers daoUsers;



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

    @Override
    public int getIdByLogin(String login) {
        return daoUsers.getIdByLogin(login);
    }

    @Override
    public List<User> getOnlineLogins() {
        return daoUsers.getOnlineUsers();
    }
}
