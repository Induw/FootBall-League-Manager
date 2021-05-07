package entities;

import entities.FootballClub;

import java.io.Serializable;

public class SchoolClub extends FootballClub implements Serializable {
    private String sclName;


    public SchoolClub() {
    }
    public SchoolClub(String clubName, String address,String sclName, int matchesPlayed, int wins, int losses, int draws, int goalsScored, int goalsConceded, int points) {
        super(clubName,address,matchesPlayed,wins,losses,draws,goalsScored,goalsConceded,points);
        this.sclName = sclName;

    }

    //getter
    public String getSclName() {
        return sclName;
    }
    //setter
    public void setSclName(String sclName) {
        this.sclName = sclName;
    }



  

}