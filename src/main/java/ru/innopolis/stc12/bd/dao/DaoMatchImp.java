package ru.innopolis.stc12.bd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.bd.dao.entities.Match;

import java.util.List;

@Repository
public class DaoMatchImp implements DaoMatch {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void updateMatch(List<Match> matchList) {
        for (Match match: matchList) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(match);
            session.getTransaction().commit();
            session.close();
        }
    }


}
