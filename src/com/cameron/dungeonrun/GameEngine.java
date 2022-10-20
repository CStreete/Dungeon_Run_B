package com.cameron.dungeonrun;


import com.cameron.dungeonrun.shop.Shop;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.List;

import static com.cameron.dungeonrun.Colors.*;

public class GameEngine {


    boolean exit;

    List<Monster> monsterList = new ArrayList<>();
    List <Dungeon> dungeonList = new ArrayList<>();
    Dungeon dungeon = new Dungeon();
    Monster monster = new Monster();
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
            System.out.println("You have selected the Archer Class");
            player.createArcher(player);
            player.currentStatus();
            isSelecting = true;
        }
        case "2" -> {
            System.out.println("You have selected the Duelist Class");
            player.createDuelist(player);
            player.currentStatus();
            isSelecting = true;
        }
        default -> System.out.println("Invalid Input");
    }
}while (!isSelecting);
 }

    void startGame(Player player){

        System.out.printf("""
              %sDungeon Run\s
              A text based MMO\s
              Creator Cameron Streete%s\s
              ===============================================
              Enter Player Name:
              """,RED_BOLD_BRIGHT,RESET);
        player.setCharacterClassName(Scan.scanner.next());

        if (player.characterClassName.equals(player.characterClassName)){
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
        System.out.printf("""
                %s1) Start Game\s
                2) Player Status\s
                0) Exit\s
                Enter Option: %s""",WHITE_BOLD_BRIGHT,RESET);
    }

    void interactiveMenu (Player player){
        String choice = Scan.scanner.next();

        switch (choice) {
            case "1" -> {
                System.out.println("Welcome " + player.characterClassName);
                dungeon(player);
            }
            case "2" -> {
               player.currentStatus();
            }
            case "0" -> {
                System.out.println("Thank you for Playing!");
                System.exit(0);
            }
            default -> System.out.println("Invalid Selection");
        }

    }


    public void dungeon (Player player){

        boolean exit = false;
        do {
            System.out.println(WHITE_BOLD_BRIGHT + "Chose a dungeon you would like to enter" + RESET);
            System.out.println(WHITE_BOLD_BRIGHT + """
            1) Killers Den \s
            2) Lovers cove\s
            3) Assassins Hideout\s
            4) Player Status\s
            5) Shop
            0) Quit Game""" + RESET);

            switch (Scan.scanner.next()) {
                case "1" -> {

                    createDungeon("Killers Den", 1, 20);
                    createMonster("Killer Jackal", 100, 20);
                    System.out.println("You have entered: " + dungeonList.get(0).getDungeonName() + " Dungeon Level: " + dungeonList.get(0).getDungeonLevel());
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }
                case "2" -> {
                    createMonster("Oblivious Arianna", 200, 50);

                    System.out.println("You have entered: " + dungeon.getDungeonName());
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }
                case "3" -> {
                    createMonster("Killoua", 300, 90);
                    createDungeon("Assassins Hideout", 3,200);
                    System.out.println("You have entered: " + dungeon.getDungeonName());
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                }
                case "4" -> player.currentStatus();
                case "5" -> shop.startShop(player);
                case "0" -> {
                    System.out.println("Thank you for playing");
                    System.exit(0);
                }
                default -> System.out.println("Invalid ");
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
