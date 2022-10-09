package com.cameron.dungeonrun;

import java.util.ArrayList;
import java.util.List;

import static com.cameron.dungeonrun.Colors.*;

public class GameEngine {


    List<Monster> monsterList = new ArrayList<>();
    Monster monster = new Monster();
    boolean exit;
    void runMainMenu(){

        System.out.printf("""
              %sDungeon Run\s
              A text based MMO\s
              Creator Cameron Streete%s\s
              ===========================
              Enter Player Name:
              """,RED_BOLD_BRIGHT,RESET);
        Player player = new Player(Scan.scanner.next());

if (Scan.scanner.hasNext()) {

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
        Player player = new Player();


        String choice = Scan.scanner.next();
        switch (choice) {
            case "1" -> {
                System.out.println("Welcome " + player.playerName);
                System.out.println("Inside of new Game...");
                combatSequence();


            }
            case "2" -> {
                player.currentPlayerStatus();
                System.out.println("Inside Player Status...");


            }
            case "0" -> {
                System.out.println("Thank you for Playing!");
                System.exit(0);
            }
            default -> System.out.println("Invalid Selection");
        }

    }
    public void combatSequence (){
        boolean isFighting = true;
        Player player = new Player();
        do {
            player.playerCombatAct();
        }while (isFighting);




    }






    public void addMonsterToList (Monster monster){
        monsterList.add(monster);

    }
    public void createMonster(String monsterName,int monsterHealth, int monsterDamage){
        Monster monster = new Monster(monsterName,monsterHealth,monsterDamage);
        addMonsterToList(monster);
    }
    public List<Monster> getMonstersList() {
        return monsterList;
    }
}
