package services;

import entities.FootballClub;
import entities.Match;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;



public class PremierLeagueManager implements LeagueManager, Serializable {

    public static ArrayList<FootballClub> teamList = new ArrayList<FootballClub>();
    public static ArrayList<Match> matchList = new ArrayList<Match>();


    //method to add a club to the array list
    @Override
    public void addTheClub(FootballClub club) {
        if(teamList.contains(club)){
            System.err.println("Team already Added to the league!!");
        }else{
            teamList.add(club);
            System.out.println("Club added to the League Successfully!");

        }


    }
    //method to add a match to the match list
    @Override
    public void addMatch(Match match){
        if(matchList.contains(match)){
            System.err.println("Match Already added!");
        }else{
            matchList.add(match);
            System.out.println("Match Added Successfully!");
        }
    }


    //method to delete a club from the array list
    @Override
    public boolean deleteClub(String clubName) {
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getClubName().equals(clubName)) {
                teamList.remove(i);
                System.out.println("Club is deleted successfully!");
                return true;
            }
        }
        return false;
    }

    //method to display statistics of selected club
    @Override
    public void displayStatistics(FootballClub index){
        System.out.println("+------+-------+---------+----------------+--------------+--------+----------------+");
        System.out.println("| MP   | Wins   | Draws | Losses  | GF | GA | GD | Points |");
        System.out.println("+------+-------+---------+----------------+--------------+--------+----------------+");
        System.out.println("| "+index.getMatchesPlayed()+"    | "+index.getWins()+"     | "+index.getLosses()+"  "
                + "  | "+index.getGoalsScored()+"   | "+index.getGoalsConceded()+""
                + "| "+(index.getGoalsScored() - index.getGoalsConceded())+"| "+index.getPoints()+"  |");
        System.out.println("-----------------------------------------------------------------------------------+");
    }


    //method to display premier league table
    @Override
    public void displayLeagueTable(){
        Collections.sort(teamList);
        System.out.printf("%10s %11s %11s %2s %2s %2s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s", "Club Name", "|", "Matches Played", "|", "Wins",
                "|", "Draws ", "|", "Losses", "|", "Goals For    ", "|", "Goals Against", "|", "Goal Difference", "|", "Club Points","|\n");
        System.out.println("------------------------------------------------------------------------------------------" +
                "--------------------------------------");
        for (FootballClub oneclub : teamList) {
            System.out.printf("%10s %10s %8d %7s %3d %2s %4d %4s %3d %3s %8d %7s %7d %6s %8d %8s %7s %5s %n",
                    oneclub.getClubName(),"|", oneclub.getMatchesPlayed(), "|", oneclub.getWins(),
                    "|", oneclub.getDraws(), "|", oneclub.getLosses(), "|",
                    oneclub.getGoalsScored(), "|", oneclub.getGoalsConceded(), "|",
                    oneclub.getGoalDifference(), "|", oneclub.getPoints(), "|");
        }

    }

    //method to save data to a file
    @Override
    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("ClubData.txt");
            FileOutputStream fos2 = new FileOutputStream("MatchData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos.writeObject(teamList);
            oos2.writeObject(matchList);
            oos.close();
            oos2.close();
            fos.close();
            fos2.close();
            System.out.println("Saved to Files Successfully!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
    //method to get data from the file
    @Override
    public void getFileData(){
        FileInputStream fis = null;
        FileInputStream fis2 = null;
        try {
            fis = new FileInputStream("ClubData.txt");
            fis2 = new FileInputStream("MatchData.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        ObjectInputStream ois2 = null;
        try {
            ois = new ObjectInputStream(fis);
            ois2 = new ObjectInputStream(fis2);
            teamList = (ArrayList<FootballClub>) ois.readObject();
            matchList = (ArrayList<Match>)ois2.readObject();
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
            ois2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to display names of all the clubs
    @Override
    public void getNames(){
        for (FootballClub eachClub : teamList) {
            System.out.println(eachClub.getClubName());
        }
    }
    //	method to go through the array List and get the footballClub objects that were involved
    @Override
    public FootballClub getFootballClub(String footballClubName){
        //  traversing through the premierLeagueList to find and output the football club object with the entered name
        for (FootballClub eachFootballClub : PremierLeagueManager.teamList) {
            if (eachFootballClub.getClubName().equals(footballClubName)){
                return eachFootballClub;
            }
        }
        return null;
    }



}
