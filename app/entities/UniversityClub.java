package entities;

import java.io.Serializable;

public class UniversityClub extends FootballClub implements Serializable {
    private String uniName;


    public UniversityClub() {
    }

    public UniversityClub(String clubName, String address, String uniName, int matchesPlayed, int wins, int losses, int draws, int goalsScored, int goalsConceded, int points) {
        super(clubName,address,matchesPlayed,wins,losses,draws,goalsScored,goalsConceded,points);
        this.uniName = uniName;

    }

    //getter
    public String getUniName() {
        return uniName;
    }
    //setter
    public void setUniName(String uniName) {
        this.uniName = uniName;
    }



}

