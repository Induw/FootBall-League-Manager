package entities;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable,Comparable<FootballClub> {
    private static final long serialVersionUID = -6277391780397991006L;
    private int matchesPlayed;
    private int wins;
    private int losses;
    private int draws;
    private int goalsScored;
    private int goalsConceded;
    private int points;
    
    public FootballClub()
    {
    }

    public FootballClub(String clubName,String address,int matchesPlayed, int wins, int losses, int draws, int goalsScored, int goalsConceded,int points)
    {
        super(clubName,address);
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.points = points;
    }


    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalDifference(){
        return this.getGoalsScored() - this.getGoalsConceded();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FootballClub)) return false;
        FootballClub that = (FootballClub) obj;
        return getMatchesPlayed() == that.getMatchesPlayed() &&
                getWins() == that.getWins() &&
                getLosses() == that.getLosses() &&
                getDraws() == that.getDraws() &&
                getGoalsScored() == that.getGoalsScored() &&
                getGoalsConceded() == that.getGoalsConceded() &&
                getPoints() == that.getPoints();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchesPlayed(), getWins(), getLosses(), getDraws(), getGoalsScored(), getGoalsConceded(), getPoints());
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "matchesPlayed=" + matchesPlayed +
                ", wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                ", points=" + points +
                ", clubName='" + clubName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(FootballClub obj) {
        if (this.getPoints()!=obj.getPoints()){
            if (this.getPoints()<obj.getPoints()){
                return 1;
            }
            else{
                return -1;
            }
        }
        else {
            if (this.getGoalDifference()<obj.getGoalDifference()){
                return 1;
            }
            else{
                return -1;
            }
        }

    }
    public void updatePoints(String result) {
        if (result.equalsIgnoreCase("win")) {
            setPoints((getPoints() + 3));
        } else if (result.equalsIgnoreCase("draw")) {
            setPoints((getPoints() + 1));
        } else {
            System.out.println("Please enter a valid input!");
        }
    }

}