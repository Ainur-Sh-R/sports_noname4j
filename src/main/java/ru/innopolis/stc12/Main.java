package ru.innopolis.stc12;

import ru.innopolis.stc12.service.parser.ParserHtml;
import ru.innopolis.stc12.service.parser.ParserHtmlImpl;

public class Main {
    public static void main(String[] args) {
        /*ParserHtml parserHtml = new ParserHtmlImpl();
        parserHtml.getOnlineMatches();*/

        Integer i = 3;
        i = i ^ 2;
        System.out.println(Integer.toBinaryString(i));
    }
}
