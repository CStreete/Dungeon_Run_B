package com.cameron.dungeonrun;


import com.cameron.dungeonrun.shop.Shop;
import java.util.ArrayList;
import java.util.List;
import static com.cameron.dungeonrun.Colors.*;
import static com.cameron.dungeonrun.Scan.*;

public class GameEngine {

    // Variable
    boolean exit;

    // Lists
    public List <Dungeon> dungeonList = new ArrayList<>();
    public List<Monster> monsterList = new ArrayList<>();

    // Instantiation
    Shop shop = new Shop();

    // Start game
    public void startGame(Player player){

        System.out.printf("""
              %sDungeon Run\s
              A text based MMO\s
              Creator Cameron Streete%s\s
              --------------------------------------------------------
              """,RED_BOLD_BRIGHT,RESET);
        System.out.println(WHITE_BOLD_BRIGHT + "Enter Player Name: " + RESET );

        player.setCharacterClassName(scanner.next());

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

    // Chose starting class method
    public void userClassSelection (Player player){
     
     boolean isSelecting = false;
do {
    System.out.println( WHITE_BOLD_BRIGHT +
            """
            Please chose a Class\s
            1) Archer\s
            2) Duelist""" + RESET);
    switch (scanner.next()) {
        case "1":
            System.out.println(WHITE_BOLD_BRIGHT + "You have selected the Archer Class " + RESET);
            System.out.println("--------------------------------------------------------");
            player.createArcher();
            isSelecting = true;
            break;

        case "2":
            System.out.println(WHITE_BOLD_BRIGHT + "You have selected the Duelist Class" + RESET);
            player.createDuelist();
            isSelecting = true;
            break;

        default:
            System.out.println(WHITE_BOLD_BRIGHT + "Invalid Input! Please try again: " + RESET);
            break;
    }
     }while (!isSelecting);
 }

    // Main menu
    public void interactiveMenu (Player player){
        String choice = scanner.next();

        switch (choice) {
            case "1": {
                System.out.println("--------------------------------------------------------");
                System.out.println( WHITE_BOLD_BRIGHT + "Welcome! This world is an uncertain place were many foes await! Proceed with caution " +  RESET);
                enterWorld(player);
                break;
            }
            case "2": {
               player.currentStatus();
               break;
            }
            case "0": {
                System.out.println("Thank you for Playing!");
                System.exit(0);
                break;
            }
            default:
                System.out.println(WHITE_BOLD_BRIGHT + "Invalid Input! Please try again: " + RESET);
                break;
        }

    }

    // Enter world & dungeons
    public void enterWorld(Player player){

        boolean exit = false;

        do {
            System.out.println("--------------------------------------------------------");
            System.out.println(WHITE_BOLD_BRIGHT + """
            World Dungeons\s
            1) Killers Den (Recommended Level 1 -2)\s
            2) Lovers cove (Recommended Level 2 - 4)\s
            3) Assassins Hideout (Recommended Level 4 - 6)\s
            4) The Lost Kingdom (Recommended Level 6 - 10)\s
            5) Dragons Pit (Recommended Level 10 - 15)\s
            6) Undead Wonders Realm (Recommended Level 15)\s
            --------------------------------------------------------
            Player Options\s
            7) Player Status\s
            8) Shop \s
            0) Quit Game
            Enter Option:""" + RESET);

            switch (scanner.next()) {

                case "1":
                    createDungeon("Killers Den", 1, 30);
                    createMonster("Killer Jackals Sergent", 20, 5);
                    createMonster("Boss Killer Jackal", 50, 10);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                    System.out.println(GREEN_BOLD_BRIGHT + "BOSS FIGHT" + RESET);
                    combatSequence(player,monsterList.get(1),dungeonList.get(0));

                    break;


                case "2":
                    createDungeon("Lovers Den",2,70);
                    createMonster("Arianna's Secret Admirer", 50, 10);
                    createMonster("Boss Oblivious Arianna",120,20);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                    System.out.println(GREEN_BOLD_BRIGHT + "BOSS FIGHT" + RESET);
                    combatSequence(player, monsterList.get(1),dungeonList.get(0));

                    break;

                case "3":
                    createDungeon("Assassins Hideout", 3,420);
                    createMonster("Elektra",80,20);
                    createMonster("Boss Killoua", 220, 30);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                    System.out.println(GREEN_BOLD_BRIGHT + "BOSS FIGHT" + RESET);
                    combatSequence(player, monsterList.get(1),dungeonList.get(0));
                   break;

                case "4":
                    createDungeon("The Lost Kingdom",4,550);
                    createMonster("Wondering Peasant",100,40);
                    createMonster("Boss Fallen Knight",320,50);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                    System.out.println(GREEN_BOLD_BRIGHT + "BOSS FIGHT" + RESET);
                    combatSequence(player, monsterList.get(1),dungeonList.get(0));
                    break;



                case "5":
                    createDungeon("Dragons Pit",5,700);
                    createMonster("Wild Dragon",150,80);
                    createMonster("Boss Viserys",450,95);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                    System.out.println(GREEN_BOLD_BRIGHT + "BOSS FIGHT" + RESET);
                    combatSequence(player, monsterList.get(1),dungeonList.get(0));
                    break;


                case "6":
                    createDungeon("Undead Wonders Realm",4,800);
                    createMonster("Zavery The Lost Soul",250,100);
                    createMonster("Boss Zurtech II",650,120);
                    System.out.println(WHITE_BOLD_BRIGHT + "You have entered: " + dungeonList.get(0).getDungeonName() + RESET);
                    combatSequence(player, monsterList.get(0),dungeonList.get(0));
                    System.out.println(GREEN_BOLD_BRIGHT + "BOSS FIGHT" + RESET);
                    combatSequence(player, monsterList.get(1),dungeonList.get(0));
                    break;


                case "7":
                    player.currentStatus();
                    break;
                case "8":
                    shop.startShop(player);
                    break;


                case "0":
                    System.out.println("Thank you for playing");
                    System.exit(0);
                    break;

                default:
                    System.out.println(WHITE_BOLD_BRIGHT + "Invalid Input! Please try again: " + RESET);
            }
        }while (!exit);
    }

    // Main menu messages
    public void mainMenuMessages (){
        System.out.printf( """
                %s1) Start Game\s
                2) Player Status\s
                0) Exit\s
                Enter Option: %s""",WHITE_BOLD_BRIGHT,RESET);
    }


    // Create and add dungeons and monsters to list
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

    // Combat sequence
    public void combatSequence (Player player, Monster monster,Dungeon dungeon){



            player.playerCombatAct(player,monster,dungeon);




    }













}
