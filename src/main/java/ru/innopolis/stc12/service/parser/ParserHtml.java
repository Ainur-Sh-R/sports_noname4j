package ru.innopolis.stc12.service.parser;

import ru.innopolis.stc12.bd.dao.entities.Match;

import java.util.List;

public interface ParserHtml {
    List<Match> getOnlineMatches();
}
