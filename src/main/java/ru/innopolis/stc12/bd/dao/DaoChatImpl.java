package ru.innopolis.stc12.bd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.bd.dao.mappers.MapperMessage;
import ru.innopolis.stc12.bd.pojo.Message;

import java.util.List;

@Repository
public class DaoChatImpl implements DaoChat {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addMessage(Message message) {
        String addUserQuery = "insert into messages_list VALUES (default, ?, ?, ?, ?)";
        jdbcTemplate.update(addUserQuery, message.getIdChat(), message.getIdUser(), message.getContent(), message.getDateCreate());
    }

    @Override
    public List<Message> getNewMessages(Integer lastMessagesId) {
        String getStudentsQuery = "select * from messages_list where id_message > ?";
        return jdbcTemplate.query(getStudentsQuery, new Object[]{lastMessagesId}, new MapperMessage());
    }


}
