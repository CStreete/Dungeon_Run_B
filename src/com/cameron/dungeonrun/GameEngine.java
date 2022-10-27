package com.cameron.dungeonrun;


import com.cameron.dungeonrun.shop.Shop;

import java.util.ArrayList;
import java.util.List;


import static com.cameron.dungeonrun.Colors.*;

public class GameEngine {


    boolean exit;


    List <Dungeon> dungeonList = new ArrayList<>();
    List<Monster> monsterList = new ArrayList<>();

    Shop shop = new Shop();





 public void userClassSelection (Player player){
     
     boolean isSelecting = false;
do {
    System.out.println( WHITE_BOLD_BRIGHT +
            """
            Please chose a Class\s
            1) Archer\s
            2) Duelist""" + RESET);
    switch (Scan.scanner.next()) {
        case "1" -> {
            System.out.println(WHITE_BOLD_BRIGHT + "You have selected the Archer Class " + RESET);
            System.out.println("--------------------------------------------------------");
            player.createArcher(player);
            isSelecting = true;
        }
        case "2" -> {
            System.out.println(WHITE_BOLD_BRIGHT + "You have selected the Duelist Class" + RESET);
            player.createDuelist(player);
            isSelecting = true;
        }
        default ->System.out.println(WHITE_BOLD_BRIGHT + "Invalid Input! Please try again: " + RESET);
    }
}while (!isSelecting);
 }

    void startGame(Player player){

        System.out.printf("""
              %sDungeon Run\s
              A text based MMO\s
              Creator Cameron Streete%s\s
              --------------------------------------------------------
              """,RED_BOLD_BRIGHT,RESET);
        System.out.println(WHITE_BOLD_BRIGHT + "Enter Player Name: " + RESET );
        player.setCharacterClassName(Scan.scanner.next());

        if (player.getCharacterClassName().equals(player.getCharacterClassName())){
            userClassSelection(player);
        }
 {
        mainMenuMessages();
    while (!exit) {
        interactiveMenu(player);
    }
}
    }

    void mainMenuMessages (){
        System.out.printf( """
                %s1) Start Game\s
                2) Player Status\s
                0) Exit\s
                Enter Option: %s""",WHITE_BOLD_BRIGHT,RESET);
    }

    void interactiveMenu (Player player){
        String choice = Scan.scanner.next();

        switch (choice) {
            case "1" -> {
                System.out.println("--------------------------------------------------------");
                System.out.println( WHITE_BOLD_BRIGHT + "Welcome! This world is an uncertain place were many foes await! Proceed with caution " +  RESET);
                enterWorld(player);
            }
            case "2" -> {
               player.currentStatus();
            }
            case "0" -> {
                System.out.println("Thank you for Playing!");
                System.exit(0);
            }
            default -> System.out.println(WHITE_BOLD_BRIGHT + "Invalid Input! Please try again: " + RESET);
        }

    }


    public void enterWorld(Player player){

        boolean exit = false;


            System.out.println("--------------------------------------------------------");
            System.out.println(WHITE_BOLD_BRIGHT + """
            World Dungeons\s
            1) Killers Den \s
            2) Lovers cove\s
            3) Assassins Hideout\s
            4) The Lost Kingdom\s
            5) Dragons Pit\s
            6) Undead Wonders Realm\s
            --------------------------------------------------------
            Player Options\s
            7) Player Status\s
            8) Shop \s
            0) Quit Game
            Enter Option:""" + RESET);
            do {
            switch (Scan.scanner.next()) {

                case "1" -> {
                    createDungeon("Killers Den", 1, 20);
                    createMonster("Killer Jackals Underlings",20,5);
                    createMonster("Killer Jackal", 70, 15);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);



                    combatSequence(player, monsterList.get(0),dungeonList.get(0));


                }
                case "2" -> {
                    createDungeon("Lovers Den",2,120);
                    createMonster("Oblivious Arianna", 100, 50);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }
                case "3" -> {
                    createDungeon("Assassins Hideout", 3,420);
                    createMonster("Killoua", 300, 90);

                   combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }
                case "4" -> {
                    createMonster("The Fallen Knight",500,100);
                    createDungeon("The Lost Kingdom",4,550);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }


                case "5" -> {
                    createMonster("King Viserys",700,150);
                    createDungeon("Dragons Pit",5,700);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }

                case "6"-> {
                    createMonster("Zurtech II",800,190);
                    createDungeon("Undead Wonders Realm",4,800);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }

                case "7" -> player.currentStatus();

                case "8" -> shop.startShop(player);


                case "0" -> {
                    System.out.println("Thank you for playing");
                    System.exit(0);
                }
                default -> System.out.println(WHITE_BOLD_BRIGHT + "Invalid Input! Please try again: " + RESET);
            }
        }while (!exit);
    }


    public void createDungeon (String dungeonName, int dungeonLevel, int dungeonExperience){
        Dungeon dungeon = new Dungeon(dungeonName,dungeonLevel,dungeonExperience);

        addDungeonToList(dungeon);

    }

    public void addDungeonToList (Dungeon dungeon){
     dungeonList.add(dungeon);
    }




    public void createMonster (String monsterName, int monsterHealth, int monsterDamage){
     Monster monster = new Monster(monsterName,monsterHealth,monsterDamage);

     addMonsterToList(monster);


    }
    public void addMonsterToList (Monster monster){
     monsterList.add(monster);

    }
    public void combatSequence (Player player, Monster monster,Dungeon dungeon){
        boolean isFighting = true;

        do {
            player.playerCombatAct(player,monster,dungeon);
        }while (isFighting);



    }










}
