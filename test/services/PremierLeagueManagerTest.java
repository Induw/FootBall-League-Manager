package services;

import entities.FootballClub;
import org.junit.Test;

public class PremierLeagueManagerTest {
    //creating a premier league manager object to test
    PremierLeagueManager testManager = new PremierLeagueManager();
    FootballClub testClub = new FootballClub("Test","Test",10,10,10,10,10,10,10);
    //testing the add club method
    @Test
    public void addClubTest() {
        testManager.addTheClub(testClub);

    }
    //testing the delete club method
    @Test
    public void deleteClubTest()  {
        boolean testResult = testManager.deleteClub("Test");
        if( testResult){
            System.out.println("Test Passed !");
        }

    }
    // testing the display stats method
    @Test
    public void displayStatisticsTest() {
        testManager.displayStatistics(testClub);
    }
    //testing the display league table method
    @Test
    public void displayLeagueTableTest() {
        testManager.getFileData();
        testManager.displayLeagueTable();
    }
// testing the save to file method
    @Test
    public void saveToFile() {
        testManager.saveToFile();
    }
}