package ru.innopolis.stc12.bd.dao;

import ru.innopolis.stc12.bd.dao.entities.Match;

import java.util.List;

public interface DaoMatch {
    void updateMatch(List<Match> matchList);

    List<Match> getMatchList();
    void updateMatchStatus(Match match);
}
