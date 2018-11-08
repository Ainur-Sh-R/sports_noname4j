package ru.innopolis.stc12.bd.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.bd.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapperUser implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setEnabled(rs.getInt("enabled"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
