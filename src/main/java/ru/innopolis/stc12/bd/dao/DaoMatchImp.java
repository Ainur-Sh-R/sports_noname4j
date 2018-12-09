package ru.innopolis.stc12.bd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.bd.dao.mappers.MapperMatch;
import ru.innopolis.stc12.bd.pojo.Match;

import java.util.List;

@Repository
public class DaoMatchImp implements DaoMatch {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void updateMatch(List<Match> matchList) {

    }

    @Override
    public List<Match> getMatchList() {
        String getMatchesQuery = "select * from match where team_1_goal = 0 and team_2_goal = 0 and match_status = 'Перерыв' and (team_1_shot + team_2_shot) >10";
        return jdbcTemplate.query(getMatchesQuery, new MapperMatch());
    }
}
