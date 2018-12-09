package ru.innopolis.stc12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc12.service.ServiceMatch;
import ru.innopolis.stc12.bd.dao.entities.Match;

import java.util.List;

@RestController
public class MatchController {
    private ServiceMatch serviceMatch;

    @Autowired
    public void setServiceMatch(ServiceMatch serviceMatch) {
        this.serviceMatch = serviceMatch;
    }

    @RequestMapping(value = "/showMatch", method = RequestMethod.GET)
    public List<Match> matchList(Model model) {
        return serviceMatch.getMatchList();
    }

}
