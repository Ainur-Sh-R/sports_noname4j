package ru.innopolis.stc12.bd.pojo;

import java.util.Date;

public class Match {
    private Long id;
    private String matchName;
    private String leagueFootball;
    private Integer team1Id;
    private Integer team2Id;
    private String team1Name;
    private String team2Name;
    private Integer team1Goal;
    private Integer team2Goal;
    private Integer team1Shot;
    private Integer team2Shot;
    private Integer matchTime;
    private Date matchDate;
    private String matchStatus;

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getLeagueFootball() {
        return leagueFootball;
    }

    public void setLeagueFootball(String leagueFootball) {
        this.leagueFootball = leagueFootball;
    }

    public Integer getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Integer team1Id) {
        this.team1Id = team1Id;
    }

    public Integer getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Integer team2Id) {
        this.team2Id = team2Id;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public Integer getTeam1Goal() {
        return team1Goal;
    }

    public void setTeam1Goal(Integer team1Goal) {
        this.team1Goal = team1Goal;
    }

    public Integer getTeam2Goal() {
        return team2Goal;
    }

    public void setTeam2Goal(Integer team2Goal) {
        this.team2Goal = team2Goal;
    }

    public Integer getTeam1Shot() {
        return team1Shot;
    }

    public void setTeam1Shot(Integer team1Shot) {
        this.team1Shot = team1Shot;
    }

    public Integer getTeam2Shot() {
        return team2Shot;
    }

    public void setTeam2Shot(Integer team2Shot) {
        this.team2Shot = team2Shot;
    }

    public Integer getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Integer matchTime) {
        this.matchTime = matchTime;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Match(Long id, String matchName, String leagueFootball, Integer team1Id, Integer team2Id, String team1Name, String team2Name, Integer team1Goal, Integer team2Goal, Integer team1Shot, Integer team2Shot, Integer matchTime, Date matchDate, String matchStatus) {
        this.id = id;
        this.matchName = matchName;
        this.leagueFootball = leagueFootball;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.team1Goal = team1Goal;
        this.team2Goal = team2Goal;
        this.team1Shot = team1Shot;
        this.team2Shot = team2Shot;
        this.matchTime = matchTime;
        this.matchDate = matchDate;
        this.matchStatus = matchStatus;
    }
}
