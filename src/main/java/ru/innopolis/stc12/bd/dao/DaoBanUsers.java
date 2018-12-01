package ru.innopolis.stc12.bd.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.bd.pojo.User;

import java.sql.ResultSet;
import java.util.List;

public interface DaoBanUsers {
    RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setEnabled(resultSet.getBoolean("enabled"));
        user.setRole(resultSet.getString("role"));
        user.setFullName(resultSet.getString("full_name"));
        user.setMail(resultSet.getString("mail"));
        return user;
    };

    void banUser(Integer userId);
    void banUserCancel(Integer userId);
    List<User> getUsers();
}
