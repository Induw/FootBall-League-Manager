package services;
import entities.Date;
import entities.FootballClub;
import entities.Match;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        PremierLeagueManager manager1  = new PremierLeagueManager();

            manager1.getFileData();

        //start method contains all the methods of the console
        start();
    }
    public static void start(){
        Scanner sc = new Scanner(System.in);
        //creating a gym manager object
        PremierLeagueManager manager  = new PremierLeagueManager();

        System.out.println("--------------------------------------------------");
        System.out.println("	  WELCOME TO PREMIER LEAGUE MANAGER !!");
        System.out.println("--------------------------------------------------");
        System.out.println("");
        System.out.println("• Press 1 : Add a new football club to the league");
        System.out.println("• Press 2 : Delete a football club from the league");
        System.out.println("• Press 3 : Display  statistics of a team ");
        System.out.println("• Press 4 : Display the Premier League Table");
        System.out.println("• Press 5 : Add a Match Played ");
        System.out.println("• Press 6 : Save Data to File");
        System.out.println("• Press 7 : Open GUI");
        System.out.println("• Press 8 : Exit");
        System.out.print("• Enter your Choice [ 1, 2, 3, 4, 5, 6, 7, 8] : ");

        //switch case to get inputs
        String choice;
        choice = sc.next();
        switch (choice) {
            case "1":
                addFootballClub();
                break;
            case "2":
                deleteFootballClub();
                break;
            case "3":
                displayStatistics();
                break;
            case "4":
                displayTheLeagueTable();
                break;
            case "5":
                addPlayedMatch();
                break;
            case "6":
                manager.saveToFile();
                start();
            case "7":
                System.out.println("Opening GUI....");
                String connectToGUI = "http://localhost:4200/";
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(connectToGUI));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "8":
                break;
            default:
                System.err.println("Invalid input! Please re-enter!");
                start();
        }

    }

    //This method for the adding the football object to the arraylist
    public static void addFootballClub() {
        PremierLeagueManager manager = new PremierLeagueManager();
        Scanner sc1 = new Scanner(System.in);
        //all the variables related to user input
        String name;
        String location;
        int matches;
        int wins;
        int losses;
        int draws;
        int scored;
        int conceded;
        int points;
        System.out.println("	 ____ ____ ____ _________ ____ _________ ____ ____ ____ ____ ");
        System.out.println("	                  A D D   A   C L U B ");
        System.out.println("	 ---- ---- ---- --------- ---- --------- ---- ---- ---- ---- ");
        System.out.print("¤ Enter the name of the football club : ");
        name = (sc1.nextLine());
        System.out.print("¤ Enter the location of the football club :");
        location = (sc1.nextLine());
        System.out.print("• How many matches played in the season? : ");
        matches = sc1.nextInt();
        System.out.print("• How many wins in this season? : ");
        wins = sc1.nextInt();
        System.out.print("• How many draws in this season? : ");
        draws = sc1.nextInt();
        System.out.print("• How many losses in this season? : ");
        losses = sc1.nextInt();
        System.out.print("• How many goals scored in this season? : ");
        scored = sc1.nextInt();
        System.out.print("• How many goals conceded in this season? : ");
        conceded = sc1.nextInt();
        System.out.print("• How many number of points does the team have? : ");
        points = sc1.nextInt();
        //making the FootballClub object using user input
        FootballClub footballClub = new FootballClub(name, location, matches, wins, losses,draws, scored, conceded, points);
        manager.addTheClub(footballClub);
        System.out.println("¤ Do you want to Add again? (Y/N)");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            addFootballClub();
        } else if (choice.equalsIgnoreCase("N")) {
            start();

        }
    }



    //this is for the deleting the football object from the arraylist.
    public static void deleteFootballClub() {
        Scanner sc = new Scanner(System.in);
        System.out.println("	 ____ ____ ____ ____ ____ ____ _________ ____ ____ ____ ____ ");
        System.out.println("	                 D E L E T E        C L U B                   ");
        System.out.println("     ---- ----- ----- ----- ---- --- ------- ------ ----- -------" );
        System.out.println("* Available clubs :");
        PremierLeagueManager manager = new PremierLeagueManager();
        manager.getNames();
        System.out.println("Enter the name of the club to delete : ");
        String name = sc.nextLine();
        boolean result = manager.deleteClub(name);
        if (result) {
            System.out.println("Do you want to delete again? (Y/N)");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                deleteFootballClub();
            } else if (choice.equalsIgnoreCase("N")) {
                start();
            } else {
                System.out.println("Please enter a valid input!");
            }
        } else {
            System.out.println("Club not found! Please input again");
            deleteFootballClub();
        }



    }

    //this is the method to add the various statistics about the club
    public static void displayStatistics() {
        System.out.println("	 ____ ____ ____ ____ ____ ____ ____ ____ ____ ____ ");
        System.out.println("                 S T A T I S T I C S                   ");
        System.out.println("	 ------- ----- --- ----- ---- ---- ---- ----- ----");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("* Available clubs :");
        PremierLeagueManager football = new PremierLeagueManager();
        football.getNames();
        System.out.println("* Type the name of the club to display the statistics : ");
        String name = sc.nextLine();
        football.displayStatistics(football.getFootballClub(name));
        System.out.println("* Do you want to display Statistics again? (Y/N)");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            displayStatistics();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }

    }

    //this method for the display the timetable of the league. All the available clubs details are shown in here.
    public static void displayTheLeagueTable() {
        Scanner sc = new Scanner(System.in);
        System.out.println("	_______ ____ ____ ____ ____ ____ _________ ____ ____ ____ ____ ____ _____ _______ _______ ______ ______ ________ _________ ");
        System.out.println("                                           P R E M I E R   L E A G U E   T A B L E                                        ");
        System.out.println("	_______ ____ ____ ____ ____ ____ _________ ____ ____ ____ ____ ____ ____ _______ ________ ________ ______________ ________");
        PremierLeagueManager football = new PremierLeagueManager();
        football.displayLeagueTable();
        System.out.println("* Do you want to display the table again? (Y/N)");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            displayTheLeagueTable();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }

    }
    //this method will let the user add a played match
    public static void addPlayedMatch(){
        PremierLeagueManager manager = new PremierLeagueManager();
        boolean error = true;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("	 ____ ____ ____ ____ ____ ____ ____ ____ ____ ____ ");
                System.out.println("                  A D D  A  M A T C H                 ");
                System.out.println("	 ------- ----- --- ----- ---- ---- ---- ----- ----");
                System.out.println("--        Fixtures         --");
                //  Date Object Creation
                System.out.print("Enter Day: ");
                int day = sc.nextInt();
                System.out.print("Enter Month (1-12): ");
                int month = sc.nextInt();
                System.out.print("Enter Year: ");
                int year = sc.nextInt();
                Date date = new Date(day, month, year);

                //  Match Object Creation
                System.out.println("--  Enter the Team Details  --");
                System.out.print("Enter the First Team: ");
                String team1 = sc.next();
                System.out.print("Enter the Second Team: ");
                String team2 = sc.next();
                System.out.print("Enter the Team one's goals: ");
                int team1Goals = sc.nextInt();
                System.out.print("Enter the Team Two's goals: ");
                int team2Goals = sc.nextInt();
                System.out.print("Enter the Location: ");
                Scanner input = new Scanner(System.in);
                String location = input.nextLine();

                Match matchPlayed = new Match(team1,team2,location,date,team1Goals,team2Goals);
                manager.addMatch(matchPlayed);
                start();

                error = false;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again.");
                addPlayedMatch();
            }
        }
        while (error);

    }


    }



