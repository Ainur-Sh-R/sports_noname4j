package ru.innopolis.stc12.bd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.bd.dao.mappers.MapperOnlineUsers;
import ru.innopolis.stc12.bd.dao.mappers.MapperUser;
import ru.innopolis.stc12.bd.pojo.OnlineLogin;
import ru.innopolis.stc12.bd.pojo.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoUsersImpl implements DaoUsers {
    private SessionRegistry sessionRegistry;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate, SessionRegistry sessionRegistry) {
        this.jdbcTemplate = jdbcTemplate;
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void addUsers(User user) {
        String addUserQuery = "insert into users VALUES (default, ?, ?, default, ?, ?, ?)";
        jdbcTemplate.update(addUserQuery, user.getLogin(), user.getPassword(), user.getRole(), user.getFullName(), user.getMail());
    }

    @Override
    public int getIdByLogin(String login) {
        String getStudentsQuery = "select * from users where login = ? limit 1";
        User user = jdbcTemplate.query(getStudentsQuery, new Object[]{login}, new MapperUser()).get(0);
        return user.getId();
    }

    @Override
    public List<User> getOnlineUsers() {
        List<OnlineLogin> onlineLogins = getOnlineLogins();
        String getStudentsQuery = "select * from users where login in (''";
        for (OnlineLogin onlineLogin:onlineLogins) {
            getStudentsQuery = getStudentsQuery + ", '" + onlineLogin.getLogin() + "'";
        }
        getStudentsQuery = getStudentsQuery + ")";
        return jdbcTemplate.query(getStudentsQuery, new MapperUser());
    }

    private List<OnlineLogin> getOnlineLogins() {
        List<OnlineLogin> list = new ArrayList();
        List<Object> onlineUsers = sessionRegistry.getAllPrincipals();
        for (Object usr : onlineUsers) {
            list.add(new OnlineLogin(((org.springframework.security.core.userdetails.User) usr).getUsername()));
        }
        return list;
    }
}
