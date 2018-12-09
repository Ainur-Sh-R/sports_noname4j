package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.bd.dao.DaoBanUsers;
import ru.innopolis.stc12.bd.dao.DaoBanUsersImpl;
import ru.innopolis.stc12.bd.dao.DaoMatch;
import ru.innopolis.stc12.bd.dao.entities.Match;
import ru.innopolis.stc12.bd.pojo.User;
import ru.innopolis.stc12.email_sender.EmailSender;

import java.util.List;

@Service
public class ServiceMatchImpl implements ServiceMatch {
    private DaoMatch daoMatch;
    JdbcTemplate jdbcTemplate;
    DaoBanUsers daoBanUsers;

    @Autowired
    public void setDaoBanUsers(DaoBanUsers daoBanUsers) {
        this.daoBanUsers = daoBanUsers;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setDaoMatch(DaoMatch daoMatch) {
        this.daoMatch = daoMatch;
    }



    @Override
    public List<Match> getMatchList() {
        List<Match> matchList = daoMatch.getMatchList();

        List<User> userList = daoBanUsers.getUsers();

        for (Match match: matchList){
            if (match.getSendStatus() == false){
                for(User user: userList){
                    EmailSender.sendEmail(user.getMail(),
                            "Рекомендуемый матч",
                            match.toString()
                            );
                }
               match.setSendStatus(true);
               daoMatch.updateMatchStatus(match);
            }
        }

        return matchList;

    }
}
