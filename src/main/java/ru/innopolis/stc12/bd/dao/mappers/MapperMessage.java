package ru.innopolis.stc12.bd.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.bd.pojo.Message;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMessage implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();
        message.setIdMessage(rs.getInt("id_message"));
        message.setIdChat(rs.getInt("id_chat"));
        message.setIdUser(rs.getInt("id_user"));
        message.setContent(rs.getString("content"));
        message.setDateCreate(rs.getDate("date_create"));
        return message;
    }
}
