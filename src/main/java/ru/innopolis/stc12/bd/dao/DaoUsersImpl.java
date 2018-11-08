package ru.innopolis.stc12.bd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
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
        String addUserQuery = "insert into authorisation VALUES (default, ?, ?, 1, ?)";
        jdbcTemplate.update(addUserQuery, user.getLogin(), user.getPassword(), user.getRole());
    }
}
