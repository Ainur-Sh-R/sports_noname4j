package ru.innopolis.stc12.bd.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.bd.pojo.OnlineLogin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperOnlineUsers implements RowMapper<OnlineLogin> {

    @Override
    public OnlineLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
        OnlineLogin onlineLogin = new OnlineLogin();
        onlineLogin.setLogin(rs.getString("login"));
        return onlineLogin;
    }
}
