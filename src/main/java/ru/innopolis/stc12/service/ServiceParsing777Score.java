package ru.innopolis.stc12.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.stc12.service.parser.ParserHtml;

import java.util.List;
import java.util.TimerTask;

@Component
public class ServiceParsing777Score implements ServiceParsingHtml  {
    private ParserHtml parserHtml;

    @Autowired
    public ServiceParsing777Score(ParserHtml parserHtml) {
        this.parserHtml = parserHtml;
    }

    @Override
    public void updateMatches() {
        System.out.println("START!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        parserHtml.getOnlineMatches();
    }

}
