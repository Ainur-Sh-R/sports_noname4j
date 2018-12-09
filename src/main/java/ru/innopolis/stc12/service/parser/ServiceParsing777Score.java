package ru.innopolis.stc12.service.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.innopolis.stc12.bd.dao.DaoMatch;
import ru.innopolis.stc12.bd.dao.entities.Match;

import java.util.List;

@Component
public class ServiceParsing777Score implements ServiceParsingHtml  {
    private ParserHtml parserHtml;
    private DaoMatch daoMatch;

    @Autowired
    public ServiceParsing777Score(ParserHtml parserHtml, DaoMatch daoMatch) {
        this.parserHtml = parserHtml;
        this.daoMatch = daoMatch;
    }

    @Override
    @Scheduled(fixedDelay = 10000)
    public void updateMatches() {
        List<Match> matches= parserHtml.getOnlineMatches();
        daoMatch.updateMatch(matches);
    }

}
