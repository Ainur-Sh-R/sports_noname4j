package ru.innopolis.stc12.bd.match_inf.pojo;

import java.util.Date;

public class Match {
    private int id;
    private String match_name;
    private String league_football;
    private int team_1_id;
    private int team_2_id;
    private int team_1_goal;
    private int team_2_goal;
    private int team_1_shot;
    private int team_2_shot;
    private int match_time;
    private Date math_date;
    private boolean match_status;

    public Match(String match_name,
                 String league_football,
                 int team_1_id,
                 int team_2_id,
                 int team_1_goal,
                 int team_2_goal,
                 int team_1_shot,
                 int team_2_shot,
                 int match_time,
                 Date math_date,
                 boolean match_status) {
        this.match_name = match_name;
        this.league_football = league_football;
        this.team_1_id = team_1_id;
        this.team_2_id = team_2_id;
        this.team_1_goal = team_1_goal;
        this.team_2_goal = team_2_goal;
        this.team_1_shot = team_1_shot;
        this.team_2_shot = team_2_shot;
        this.match_time = match_time;
        this.math_date = math_date;
        this.match_status = match_status;
    }

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }

    public String getLeague_football() {
        return league_football;
    }

    public void setLeague_football(String league_football) {
        this.league_football = league_football;
    }

    public int getTeam_1_id() {
        return team_1_id;
    }

    public void setTeam_1_id(int team_1_id) {
        this.team_1_id = team_1_id;
    }

    public int getTeam_2_id() {
        return team_2_id;
    }

    public void setTeam_2_id(int team_2_id) {
        this.team_2_id = team_2_id;
    }

    public int getTeam_1_goal() {
        return team_1_goal;
    }

    public void setTeam_1_goal(int team_1_goal) {
        this.team_1_goal = team_1_goal;
    }

    public int getTeam_2_goal() {
        return team_2_goal;
    }

    public void setTeam_2_goal(int team_2_goal) {
        this.team_2_goal = team_2_goal;
    }

    public int getTeam_1_shot() {
        return team_1_shot;
    }

    public void setTeam_1_shot(int team_1_shot) {
        this.team_1_shot = team_1_shot;
    }

    public int getTeam_2_shot() {
        return team_2_shot;
    }

    public void setTeam_2_shot(int team_2_shot) {
        this.team_2_shot = team_2_shot;
    }

    public int getMatch_time() {
        return match_time;
    }

    public void setMatch_time(int match_time) {
        this.match_time = match_time;
    }

    public Date getMath_date() {
        return math_date;
    }

    public void setMath_date(Date math_date) {
        this.math_date = math_date;
    }

    public boolean isMatch_status() {
        return match_status;
    }

    public void setMatch_status(boolean match_status) {
        this.match_status = match_status;
    }


}
