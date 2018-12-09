package ru.innopolis.stc12.service.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.innopolis.stc12.bd.dao.entities.Match;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParserHtmlImpl implements ParserHtml {

    static final String MAIN_URL = "https://777score.ru/";
    static final String LIVE_MATCH_CLASS = "status live";

    @Override
    public List<Match> getOnlineMatches() {
        List<Match> matchList = new ArrayList();
        JsonNode jsonNode = null;

        try {
            Element elementBody = Jsoup.connect(MAIN_URL).maxBodySize(0).get().body();
            System.out.println(elementBody.getElementsByClass(LIVE_MATCH_CLASS).size());
            int i = 0;
            for (Element element:elementBody.getElementsByClass(LIVE_MATCH_CLASS)) {
                Element elementBodyStat = Jsoup.connect(MAIN_URL + element.parentNode().attr("href")).get().body();
                matchList.add(convertJsonToMatch(elementBodyStat));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(matchList.size());
        return matchList;
    }

    private Match convertHtmlToMatch(Element elementBodyStat){
        Match match = new Match();
        match.setMatchTime(0);
        List<Element> elementList = elementBodyStat.getElementsByClass("circle");
        if (elementList.size()>0){
            match.setMatchTime(Integer.valueOf(elementList.get(0).nextSibling().nextSibling().toString().replace("\'", "")));
            match.setMatchStatus("Идёт матч");
            /*if (elementBodyStat.hasClass("overtime")) {
                match.setMatchTime(getTime(elementBodyStat.getElementsByClass("circle").get(0).nextSibling().toString()));
            }*/
        }else {
            elementList = elementBodyStat.getElementsByClass("s-label");
            if (elementList.size()>0) {
                match.setMatchStatus(elementList.get(0).text());
            }
        }
        return match;
    }

    private Match convertJsonToMatch(Element elementBodyStat){
        Match match = convertHtmlToMatch(elementBodyStat);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNodeDetails = null;
        try {
            jsonNodeDetails = mapper.readTree(elementBodyStat.getElementsByTag("script").get(0).data().substring(12)).get("footballMatch").get("matchDetails");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNodeLiveData = jsonNodeDetails.get("livedata");
        match.setLeagueFootball(jsonNodeDetails.get("tournament").get("category").get("name").asText());
        match.setId(Long.valueOf(jsonNodeDetails.get("numericId").asText().replace("-","")));
        match.setTeam1Id(jsonNodeLiveData.get("t1").get("id").asInt());
        match.setTeam2Id(jsonNodeLiveData.get("t2").get("id").asInt());
        match.setTeam1Name(jsonNodeLiveData.get("t1").get("n").asText());
        match.setTeam2Name(jsonNodeLiveData.get("t2").get("n").asText());
        if (jsonNodeLiveData.has("stats")){
            match.setTeam1Shot(jsonNodeLiveData.get("stats").get("shoffg").get("t1").asInt());
            match.setTeam2Shot(jsonNodeLiveData.get("stats").get("shoffg").get("t2").asInt());
        } else {
            match.setTeam1Shot(0);
            match.setTeam2Shot(0);
        }
        if (jsonNodeLiveData.has("sc")){
            int sizeGoal = jsonNodeLiveData.get("sc").size();
            match.setTeam1Goal(jsonNodeLiveData.get("sc").get(sizeGoal -1).get("c1").asInt());
            match.setTeam2Goal(jsonNodeLiveData.get("sc").get(sizeGoal -1).get("c2").asInt());
        } else{
            match.setTeam1Goal(0);
            match.setTeam2Goal(0);
        }
        try {
            match.setMatchDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz").parse(jsonNodeDetails.get("dateOfMatch").asText()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        match.setMatchName(match.getLeagueFootball() + ":\n" + jsonNodeLiveData.get("t1").get("n").asText() + ", " + jsonNodeLiveData.get("t2").get("n").asText());
        return match;
    }

    private Integer getTime(String time){
        Integer result = 0;
        int index = time.indexOf("&");
        if (index > 0){
            result = Integer.valueOf(time.substring(0,index-1));
        }
        return result;
    }
}

