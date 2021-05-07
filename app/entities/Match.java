package entities;
import entities.Date;

import entities.FootballClub;
import services.PremierLeagueManager;
import java.io.Serializable;


public class Match implements Serializable {

    private String teamOne;
    private String teamTwo;
    private String location;
    private Date date;
    private int teamOneGoals;
    private int teamTwoGoals;

    public Match(){

    }
    public Match( String teamOne, String teamTwo, String location, Date date, int teamOneGoals, int teamTwoGoals){
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.location = location;
        this.date = date;
        this.teamOneGoals = teamOneGoals;
        this.teamTwoGoals = teamTwoGoals;
        updateStatistics();
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTeamOneGoals() {
        return teamOneGoals;
    }

    public void setTeamOneGoals(int teamOneGoals) {
        this.teamOneGoals = teamOneGoals;
    }

    public int getTeamTwoGoals() {
        return teamTwoGoals;
    }

    public void setTeamTwoGoals(int teamTwoGoals) {
        this.teamTwoGoals = teamTwoGoals;
    }

    //	method to update the statistics of the two clubs so that the Premier League table is also updated
    public void updateStatistics(){
        PremierLeagueManager manager = new PremierLeagueManager();
        FootballClub team1 = manager.getFootballClub(teamOne);
        FootballClub team2 = manager.getFootballClub(teamTwo);
        if (teamOneGoals>teamTwoGoals){
            //if the first team has won the match
            team1.setMatchesPlayed(team1.getMatchesPlayed()+1);
            team1.setGoalsScored(team1.getGoalsScored()+teamOneGoals);
            team1.setGoalsConceded(team1.getGoalsConceded()+teamTwoGoals);
            team1.setWins(team1.getWins()+ 1);
            team1.updatePoints("win");
            //losing team
            team2.setMatchesPlayed(team2.getMatchesPlayed()+1);
            team2.setGoalsScored(team2.getGoalsScored()+teamTwoGoals);
            team2.setGoalsConceded(team2.getGoalsConceded()+teamOneGoals);
            team2.setLosses(team2.getLosses()+1);
        }
        else if (teamOneGoals<teamTwoGoals){
            //if the second team has won the match
            //winning team
            team2.setMatchesPlayed(team2.getMatchesPlayed()+1);
            team2.setGoalsScored(team2.getGoalsScored()+teamTwoGoals);
            team2.setGoalsConceded(team2.getGoalsConceded()+teamOneGoals);
            team2.setWins(team2.getWins()+1);
            team2.updatePoints("win");
            //losing team
            team1.setMatchesPlayed(team1.getMatchesPlayed()+1);
            team1.setGoalsScored(team1.getGoalsScored()+teamOneGoals);
            team1.setGoalsConceded(team1.getGoalsConceded()+teamTwoGoals);
            team1.setLosses(team1.getLosses()+1);
        }
        else {
            //	when the match is a draw
            // team One
            team1.setMatchesPlayed(team1.getMatchesPlayed()+1);
            team1.setGoalsScored(team1.getGoalsScored()+teamOneGoals);
            team1.setGoalsConceded(team1.getGoalsConceded()+teamTwoGoals);
            team1.setDraws(team1.getDraws()+1);
            team1.updatePoints("draw");
            //	team Two
            team2.setMatchesPlayed(team2.getMatchesPlayed()+1);
            team2.setGoalsScored(team2.getGoalsScored()+teamTwoGoals);
            team2.setGoalsConceded(team2.getGoalsConceded()+teamOneGoals);
            team2.setDraws(team2.getDraws()+1);
            team2.updatePoints("draw");
        }
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamOne='" + teamOne + '\'' +
                ", teamTwo='" + teamTwo + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", teamOneGoals=" + teamOneGoals +
                ", teamTwoGoals=" + teamTwoGoals +
                '}';
    }
}