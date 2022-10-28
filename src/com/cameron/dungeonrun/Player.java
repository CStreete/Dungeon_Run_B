package com.cameron.dungeonrun;

import com.cameron.dungeonrun.shop.ShopItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.cameron.dungeonrun.Colors.*;
import static com.cameron.dungeonrun.Scan.*;

public class Player implements ICombat {


    //Player Variables
    private String characterClassName;
    private  int strength;
    private  int intelligence;
    private  int health;
    private  int experience;
    private  int level;
    private  int baseDamage;
    private int maxHp;
    private  int agility;
    private int gold;
    private int totalMonstersKilled;


    // List for owned items
    private List<ShopItems> playerPurchasedItems = new ArrayList<>();


    //Constructor
    public Player (){}
    public Player(String characterClassName, int strength, int intelligence, int health, int experience, int level, int baseDamage, int maxHp, int agility, int gold) {
        this.characterClassName = characterClassName;
        this.strength = strength;
        this.intelligence = intelligence;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.baseDamage = baseDamage;
        this.maxHp = maxHp;
        this.agility = agility;
        this.gold = gold;
    }

    // Calculate Experience method from krille :)
    public void calculateExperience(int cheatInputExp)  {


        int difference = 100 - getExperience();         // Every 100:th EXP = level up!
        cheatInputExp -= difference;

        int remainder = cheatInputExp % 100;            // For example 526 cheatInputExp = 26
        cheatInputExp -= remainder;




        // Loop for each 100:th experience IF it's above 100!
        if ( cheatInputExp >= 100) {
            for (int i = cheatInputExp; i >= 100; i -= 100) {                           // Loop for each
                setLevel(getLevel() + 1);
                setGold(getGold() + 10);// never prints "LEVEL UP"
            }
        }

        if (getExperience() + (remainder + difference) >= 100) {
            setExperience(getExperience() + difference);
            setExperience(getExperience() + remainder);

        } else {

            setExperience(getExperience() + (remainder + difference));
        }
    }

    //Player Level up method
    public void ifPlayerLevelUp(){


           if (getExperience() >= 100 ){
               setLevel(getLevel() + 1);
               setStrength(getStrength() + 10);
               setIntelligence(getIntelligence() + 10);
               setAgility(getAgility() + 10);
               setExperience(getExperience() - 100);
               setBaseDamage(getBaseDamage() + 10);
               setGold(getGold() + 10);
               System.out.println(WHITE_BOLD_BRIGHT + "Level Up! " + "Level: " + getLevel() + RESET);
           }



    }

    // Current player status method
    public void currentStatus(){
        System.out.println("--------------------------------------------------------");
        System.out.println( WHITE_BOLD_BRIGHT + "Player " + getCharacterClassName() +" Stats:" + RESET);
        System.out.println(YELLOW_BOLD_BRIGHT + "Level: "  + getLevel() + RESET);
        System.out.println( GREEN_BOLD_BRIGHT + "Health: " + getHealth() + RESET);
        System.out.println(RED_BOLD_BRIGHT + "Strength: " + getStrength() + RESET);
        System.out.println(BLUE_BOLD_BRIGHT + "Intelligence: " + getIntelligence() + RESET);
        System.out.println(CYAN_BOLD_BRIGHT +"Experience: " + getExperience() + RESET);
        System.out.println(PURPLE_BOLD_BRIGHT + "Agility: " + getAgility() + RESET);
        System.out.println(WHITE_BOLD_BRIGHT + "Gold: " + getGold() + RESET);
        System.out.println("--------------------------------------------------------");
        System.out.println(WHITE_BOLD_BRIGHT + "Owned Items " + RESET);
        for (int i = 0; i < getPlayerPurchasedItems().size() ; i++) {
            System.out.println(YELLOW_BOLD_BRIGHT + playerPurchasedItems.get(i).getItemName() + RESET);

        }
        System.out.println("--------------------------------------------------------");
        System.out.println(WHITE_BOLD_BRIGHT + "Total Monsters Defeated" + RESET);
        System.out.println(RED_BOLD_BRIGHT + getTotalMonstersKilled() + RESET);

    }

    // Write Score when player dies
    public void WriteScore (Player player){
        FileWriter fileWriter = new FileWriter();
        fileWriter.createFile(player);
        fileWriter.writeToFile(player);
    }


    // Combat Methods
    @Override
    public int fight() {
        Random random = new Random();
        if (!doubleDamage()) {
            return baseDamage + calculateDamage() + random.nextInt(1, baseDamage);
        }else
            System.out.println(WHITE_BOLD_BRIGHT + "Double Damage!" + RESET);
        return (baseDamage + calculateDamage() + random.nextInt(1, baseDamage)) *2;
    }
    @Override
    public int calculateDamage() {
        return (((getStrength() + getAgility()) / 4) + 1);
    }
    public boolean playerDodge (){
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(1,100);

        if (randomNumber > getAgility()) {
            return false;
        } else {
            System.out.println("You dodged the attack! ");
        } return true;

    }
    public boolean doubleDamage(){
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(1,100);
        if (randomNumber >= getIntelligence()) {
            return false;
        }
        else
            return true;
    }
    public void fleeToDungeonMenu(Player player, Monster monster){
        GameEngine gameEngine = new GameEngine();
        if (playerFleeFight() || monster.getMonsterHealth() == 0){
            System.out.println(WHITE_BOLD_BRIGHT + "You successfully left the dungeon!" + RESET);
            gameEngine.enterWorld(player);

        }
        else {
            System.out.println(WHITE_BOLD_BRIGHT + "You must fight to the death!" + RESET);

        }
    }
    public boolean playerFleeFight(){

        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(1,100);
        return randomNumber <= getAgility();

    }
    public void playerHealth (){
        if (getHealth() <= 0)
            setHealth(0);
    }

    // Method for max health
    public void playerHealthLimit(){

        if (getHealth() > getMaxHp()){
            setHealth(getMaxHp());
        }


    }

    // Method for if player is defeated
    public boolean checkIfPlayerIsDefeated(){
        if (getHealth() == 0) {
            return true;
        }
        else
            return false;

    }

    // Create Archer and Duelist
    public void createArcher (){
        setHealth(75);
        setStrength(5);
        setExperience(0);
        setLevel(1);
        setAgility(15);
        setBaseDamage(5);
        setIntelligence(10);
        setMaxHp(250);
        playerHealthLimit();

    }
    public void createDuelist(){
        setHealth(100);
        setStrength(10);
        setExperience(0);
        setLevel(1);
        setAgility(5);
        setBaseDamage(5);
        setIntelligence(5);
        setMaxHp(400);
        playerHealthLimit();


    }





    // Player Combat Act aka the big boy
    public void playerCombatAct (Player player, Monster monster,Dungeon dungeon){
        boolean isFighting = true;

        do {

                System.out.println(WHITE_BOLD_BRIGHT + """
                        0) Flee / Leave Dungeon\s
                        1) Fight\s
                        2) Status\s
                        --------------------------------------------------------""" + RESET);

            String userChoice = scanner.next();
    switch (userChoice) {


        case "0":
           fleeToDungeonMenu(player,monster);
        case "1":
            if (monster.getMonsterHealth() > 0) {
                int fightDamage = fight();
                System.out.println(WHITE_BOLD_BRIGHT + getCharacterClassName() + " did " + RED_BOLD_BRIGHT + fightDamage + RESET + " Damage to " + monster.getMonsterName() + RESET);
                monster.setMonsterHealth((monster.getMonsterHealth()) - fightDamage);
                monster.checkMonsterHealth();
                System.out.println(RED_BOLD_BRIGHT + "Current Monster Health:" + monster.getMonsterHealth() + RESET);
                if (monster.getMonsterHealth() > 0) {

                    if (!playerDodge()) {
                        System.out.println("--------------------------------------------------------");
                        monster.createMonsterMessages(monster);
                        System.out.println(RED_BOLD_BRIGHT + monster.getMonsterName() + " Did " + monster.fight() + " Damage " + "to " + RESET + WHITE_BOLD_BRIGHT + getCharacterClassName() + RESET);
                        setHealth(getHealth() - monster.fight());
                        playerHealth();
                        System.out.println(GREEN_BOLD_BRIGHT + "Your Health: " + getHealth() + RESET);
                        if (getHealth() == 0 || getHealth() < 0 && checkIfPlayerIsDefeated()) {
                            player.setHealth(0);
                            System.out.println(WHITE_BOLD_BRIGHT + "You have died" + RESET);
                            System.out.println(WHITE_BOLD_BRIGHT + "Thank you for playing!" + RESET);
                            WriteScore(player);
                            System.exit(0);
                        }
                    }

                    System.out.println("--------------------------------------------------------");
                } else {

                    if (monster.monsterName.contains("Boss")) {
                        monster.setMonsterHealth(0);
                        System.out.println(RED_BOLD_BRIGHT + "You have defeated me...." + RESET);
                        dungeon.printDungeonChest(player, monster);
                        System.out.println("--------------------------------------------------------");
                        System.out.println(WHITE_BOLD_BRIGHT + "Well done " + getCharacterClassName() + RESET);
                        calculateExperience(dungeon.getDungeonExperience());
                        System.out.println(WHITE_BOLD_BRIGHT + "You received " + dungeon.getDungeonExperience() + " XP" + RESET);
                        System.out.println(WHITE_BOLD_BRIGHT + "You can leave the dungeon" + RESET);
                        ifPlayerLevelUp();
                        setTotalMonstersKilled(getTotalMonstersKilled() + 1);
                    }
                    else {
                        System.out.println(RED_BOLD_BRIGHT + "You have defeated me...." + RESET);
                        dungeon.printDungeonChest(player, monster);
                        System.out.println("--------------------------------------------------------");
                        isFighting = false;
                    }
                }
            }else {
                System.out.println("The Monster is dead");

        }
        break;


        case "2":
            currentStatus();
            break;
        default:
            System.out.println(WHITE_BOLD_BRIGHT + "Invalid Input! Please try again: " + RESET);
    }
    }while (isFighting);
    }








    //Getters
    public int getMaxHp() {
          return maxHp;
      }
    public List<ShopItems> getPlayerPurchasedItems() {
        return playerPurchasedItems;
    }
    public String getCharacterClassName() {
           return characterClassName;
       }
    public int getStrength(){
        return strength;
    }
    public int getHealth(){
        return health;
    }
    public int getExperience (){


        return experience;
    }
    public int getLevel (){

        return level;
    } public int getIntelligence (){

        return intelligence;
    }
    public int getBaseDamage (){

        return baseDamage;
    }
    public int getAgility (){
        return agility;
    }
    public int getGold() {
        return gold;
    }
    public int getTotalMonstersKilled() {
        return totalMonstersKilled;
    }


    // Setters

    public void setMaxHp(int maxHp) {
          this.maxHp = maxHp;
        }
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setStrength (int strength){
        this.strength = strength;
    }
    public void setIntelligence (int intelligence){
        this.intelligence = intelligence;
    }
    public void setExperience(int experience){
        this.experience = experience;
     }
     public void setLevel(int level){
        this.level = level;
     }
     public void setBaseDamage (int baseDamage){
        this.baseDamage = baseDamage;
     }
     public void setAgility(int agility){
        this.agility = agility;
     }
     public void setCharacterClassName(String characterClassName) {
        this.characterClassName = characterClassName;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setTotalMonstersKilled(int totalMonstersKilled) {
        this.totalMonstersKilled = totalMonstersKilled;
    }
    public void setPlayerPurchasedItems(List<ShopItems> playerPurchasedItems) {
        this.playerPurchasedItems = playerPurchasedItems;
    }

    // To String
    @Override
    public String toString() {
        return "Player{" +
                "playerPurchasedItems=" + playerPurchasedItems +
                '}';
    }

}
