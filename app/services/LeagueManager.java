package services;

import entities.FootballClub;
import entities.Match;

import java.util.List;

public interface LeagueManager {
    //method to add a club to the array list
    void addTheClub(FootballClub club);

    void addMatch(Match match);

    //method to delete a club from the array list
    boolean deleteClub(String clubName);

    //method to display statistics of selected club
    void displayStatistics(FootballClub index);


    //method to display premier league table
    void displayLeagueTable();

    //method to save data to a file
    void saveToFile();

    void getFileData();

    //method to display names of all the clubs
    void getNames();

    //	method to go through the array List and get the footballClub objects that were involved
    FootballClub getFootballClub(String footballClubName);
}
