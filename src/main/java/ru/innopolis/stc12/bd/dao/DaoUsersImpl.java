package ru.innopolis.stc12.bd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.bd.dao.mappers.MapperUser;
import ru.innopolis.stc12.bd.pojo.User;

@Repository
public class DaoUsersImpl implements DaoUsers {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
}
