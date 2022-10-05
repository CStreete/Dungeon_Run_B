package com.cameron.dungeonrun;

import static com.cameron.dungeonrun.Colors.*;
import static com.cameron.dungeonrun.Player.*;

public class GameEngine {

    boolean exit;
    void runMainMenu(){
        System.out.printf("""
              %sDungeon Run\s
              A text based MMO\s
              Creator Cameron Streete%s\s
              ===========================
              Enter Player Name:
              """,RED_BOLD_BRIGHT,RESET);


if (Scan.scanner.hasNext()) {
    Player newPlayer = new Player(Scan.scanner.next());
    System.out.println("Welcome " + newPlayer.playerName);
    System.out.println("Here is a gift: 100xp");
    newPlayer.setExperience(100);
    newPlayer.playerLevelUp();
    mainMenuMessages();
    while (!exit) {
        interactiveMenu();

    }
}


    }


    void mainMenuMessages (){
        System.out.printf("""
                %s1) Start Combat\s
                2) Player Status\s
                0) Exit%s""",WHITE_BOLD_BRIGHT,RESET);

    }

    void interactiveMenu (){

        String choice = Scan.scanner.next();
        switch (choice) {
            case "1" -> {

                System.out.println("Inside of new Game...");

            }
            case "2" -> {
                currentPlayerStatus();

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
