package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.bd.dao.DaoMatch;
import ru.innopolis.stc12.bd.dao.entities.Match;

import java.util.List;

@Service
public class ServiceMatchImpl implements ServiceMatch {
    private DaoMatch daoMatch;

    @Autowired
    public void setDaoMatch(DaoMatch daoMatch) {
        this.daoMatch = daoMatch;
    }

    @Override
    public List<Match> getMatchList() {
        return daoMatch.getMatchList();
    }
}
