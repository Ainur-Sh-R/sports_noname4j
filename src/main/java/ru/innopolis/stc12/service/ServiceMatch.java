package ru.innopolis.stc12.service;


import ru.innopolis.stc12.bd.dao.entities.Match;

import java.util.List;

public interface ServiceMatch {
    List<Match> getMatchList();
}
