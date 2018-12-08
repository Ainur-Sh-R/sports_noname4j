package ru.innopolis.stc12.bd.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.bd.dao.entities.Match;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMatch implements RowMapper<Match> {
    @Override
    public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
        Match match = new Match();
        match.setId(rs.getLong("id"));
        match.setMatchName(rs.getString("match_name"));
        match.setLeagueFootball(rs.getString("league_football"));
        match.setTeam1Id(rs.getInt("team_1_id"));
        match.setTeam2Id(rs.getInt("team_2_id"));
        match.setTeam1Name(rs.getString("team_1_name"));
        match.setTeam2Name(rs.getString("team_2_name"));
        match.setTeam1Goal(rs.getInt("team_1_goal"));
        match.setTeam2Goal(rs.getInt("team_2_goal"));
        match.setTeam1Shot(rs.getInt("team_1_shot"));
        match.setTeam2Shot(rs.getInt("team_2_shot"));
        match.setMatchTime(rs.getInt("match_time"));
        match.setMatchDate(rs.getDate("match_date"));
        match.setMatchStatus(rs.getString("match_status"));
        return match;
    }
}
