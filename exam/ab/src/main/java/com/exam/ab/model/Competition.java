package com.exam.ab.model;

public class Competition {
    private String competitionDate;
    private String teams;
    private String ground;

    public Competition(String competitionDate, String teams, String ground) {
        this.competitionDate = competitionDate;
        this.teams = teams;
        this.ground = ground;
    }

    public String getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(String competitionDate) {
        this.competitionDate = competitionDate;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }
}
