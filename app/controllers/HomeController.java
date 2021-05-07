package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Date;
import entities.FootballClub;
import entities.Match;
import play.mvc.*;
import services.PremierLeagueManager;
import utilities.AppUtils;

import java.util.Collections;
import java.util.Random;

public class HomeController extends Controller {
    public Result getPremierLeagueData() {
        PremierLeagueManager manager1  = new PremierLeagueManager();
        try {
            manager1.getFileData();
            Collections.sort(PremierLeagueManager.teamList);
        }catch (NullPointerException e){
            System.out.println("error");
        }
        JsonNode premierLeagueData = AppUtils.convertToJSON(PremierLeagueManager.teamList);
        return ok(premierLeagueData);
    }
    public Result getMatchData() {
        PremierLeagueManager manager1  = new PremierLeagueManager();
        try {
            manager1.getFileData();
        }catch (NullPointerException e){
            System.out.println("error");
        }
        JsonNode matchData = AppUtils.convertToJSON(PremierLeagueManager.matchList);
        return ok(matchData);
    }
    public Result generateMatch() {
        PremierLeagueManager manager1  = new PremierLeagueManager();
        try {
            manager1.getFileData();
        }catch (NullPointerException e){
            System.out.println("error");
        }
        FootballClub team1 = null;
        FootballClub team2 = null;
        Random random = new Random();
        //generating a random date
        Date randomDate = new Date((random.nextInt(30) + 1), (random.nextInt(11) + 1), 2021);

        //random football club object is selected
        do {
            int index = random.nextInt(PremierLeagueManager.teamList.size());
            team1 = PremierLeagueManager.teamList.get(index);
            //another random football club object is selected
            int index1 = random.nextInt(PremierLeagueManager.teamList.size());
            team2 = PremierLeagueManager.teamList.get(index1);
        } while (team1.equals(team2));

        //array with venues to be randomly selected
        String[] venueList = {"Wembley", "Old Trafford", "Anfield", "Stamford Bridge", "Emirates", "Camp Nou"};
        int index2 = random.nextInt(6);
        String venue = venueList[index2];
        int team1Goals = random.nextInt(10);
        int team2Goals = random.nextInt(10);
        Match matchPlayed = new Match(team1.getClubName(), team2.getClubName(), venue, randomDate, team1Goals, team2Goals);
        PremierLeagueManager manager = new PremierLeagueManager();
        manager.addMatch(matchPlayed);
        manager.saveToFile();
        return ok(matchPlayed.toString());
    }



}