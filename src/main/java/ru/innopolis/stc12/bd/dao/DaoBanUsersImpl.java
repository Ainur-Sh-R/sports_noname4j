package ru.innopolis.stc12.bd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.bd.dao.mappers.MapperUser;
import ru.innopolis.stc12.bd.pojo.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoBanUsersImpl implements DaoBanUsers {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoBanUsersImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void banUser(Integer userId) {
        String command = "UPDATE  users SET enabled='false' where id=?";
        jdbcTemplate.update(command, userId);
    }

    @Override
    public void banUserCancel(Integer userId) {
        String command = "UPDATE  users SET enabled='true' where id=?";
        jdbcTemplate.update(command, userId);
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users order by id", ROW_MAPPER);
    }
}
