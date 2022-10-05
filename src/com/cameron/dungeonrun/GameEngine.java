package com.cameron.dungeonrun;

import static com.cameron.dungeonrun.Colors.*;

public class GameEngine {

    boolean exit;
    void runMainMenu(){

mainMenuMessages();
        while (!exit){
            interactiveMenu();

        }



    }


    void mainMenuMessages (){
        System.out.printf("""
                %sDungeon Run\s
                A text based MMO\s
                Creator Cameron Streete%s\s
                ____________________________\s
                %s1) Start Combat\s
                2) Player Status\s
                0) Exit%s""",RED_BOLD_BRIGHT,RESET,WHITE_BOLD_BRIGHT,RESET);

    }

    void interactiveMenu (){
        String choice = Scan.scanner.next();
        switch (choice) {
            case "1" -> {
                System.out.println("Enter Player Name");
                Player newPlayer = new Player(Scan.scanner.next());
                System.out.println("Welcome " + newPlayer.playerName);
                System.out.println("Inside of new Game...");

            }
            case "2" -> {
                System.out.println("Inside Player Status...");
            }
            case "0" -> {
                System.out.println("Thank you for Playing!");
                System.exit(0);
            }
            default -> System.out.println("Invalid Selection");
        }


    }
















}
