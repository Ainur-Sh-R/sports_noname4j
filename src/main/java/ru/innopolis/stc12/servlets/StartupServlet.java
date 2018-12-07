package ru.innopolis.stc12.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.stc12.service.ServiceParsingHtml;
import ru.innopolis.stc12.service.parser.ParserHtml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Timer;
import java.util.TimerTask;


public class StartupServlet  extends HttpServlet {
    ServiceParsingHtml serviceParsingHtml;

    public StartupServlet() {
        System.out.println("Start const");
    }

    @Autowired
    public void setServiceParsingHtml(ServiceParsingHtml serviceParsingHtml) {
        this.serviceParsingHtml = serviceParsingHtml;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }


}
