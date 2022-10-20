package com.cameron.dungeonrun;

import java.util.Random;

import static com.cameron.dungeonrun.Colors.*;

public class Player implements ICombat {


    //Player Variables
    String characterClassName;
    private  int strength;
    private  int intelligence;
    private  int health;
    private  int experience;
    private  int level;
    private  int baseDamage;
    private  int agility;
    private int gold;



    //Constructor
    public Player(String characterClassName, int strength, int intelligence, int health, int experience, int level, int baseDamage, int agility) {
        this.characterClassName = characterClassName;
        this.strength = strength;
        this.intelligence = intelligence;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.baseDamage = baseDamage;
        this.agility = agility;
    }
    public Player (){}



   public void playerLevelUp (){
        if (experience == 100){
            setLevel(getLevel() + 1);
            setStrength(getStrength() + 2);
            setIntelligence(getIntelligence() + 2);
            setAgility(getAgility() + 2);
            setExperience(0);
            setBaseDamage(getBaseDamage() + 2);
            setGold(getGold() + 5);
            System.out.println("Level Up! " + "Level: " + getLevel());
        }


    }
    public void currentStatus(){
        System.out.println("===============================================");
        System.out.println( WHITE_BOLD_BRIGHT + "Player " + getCharacterClassName() +" Stats:" + RESET);
        System.out.println(YELLOW_BOLD_BRIGHT + "Level: "  + getLevel() + RESET);
        System.out.println( GREEN_BOLD_BRIGHT + "Health: " + getHealth() + RESET);
        System.out.println(RED_BOLD_BRIGHT + "Strength: " + getStrength() + RESET);
        System.out.println(BLUE_BOLD_BRIGHT + "Intelligence: " + getIntelligence() + RESET);
        System.out.println(CYAN_BOLD_BRIGHT +"Experience: " + getExperience() + RESET);
        System.out.println(PURPLE_BOLD_BRIGHT + "Agility: " + getAgility() + RESET);
        System.out.println(WHITE_BOLD_BRIGHT + "Gold: " + getGold() + RESET);
        System.out.println("===============================================");

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


    @Override
    public int fight() {
        Random random = new Random();
        if (!doubleDamage()) {
            return baseDamage + calculateDamage() + random.nextInt(1, baseDamage);
        }else
            System.out.println("Double Damage!");
        return (baseDamage + calculateDamage() + random.nextInt(1, baseDamage)) *2;
    }


    @Override
    public int calculateDamage() {
        return (((getStrength() + getAgility()) / 4) + 1);
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


    public void returnToDungeonMenu(Player player){
        GameEngine gameEngine = new GameEngine();
        if (!playerFleeFight()){

            System.out.println("You must fight to the death!");
        }
        else {
            System.out.println("You successfully ran way!");
            gameEngine.dungeon(player);
        }
    }


    public boolean playerFleeFight(){

        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(1,100);
        return randomNumber <= getAgility();


    }



    public void playerCombatAct (Player player, Monster monster,Dungeon dungeon){

        System.out.println("""
                 1) Fight\s
                 2) Flee\s
                 3) Status\s
                 4) Leave dungeon
                 --------------------------------------------------------""");

        String userChoice = Scan.scanner.next();




        switch (userChoice) {

            case "1" -> {
                int fightDamage = fight();
                System.out.println( WHITE_BOLD_BRIGHT + getCharacterClassName() +  " did " + RED_BOLD_BRIGHT + fightDamage + RESET + " Damage to " + monster.getMonsterName() + RESET);
                monster.setMonsterHealth((monster.getMonsterHealth()) - fightDamage);
                if (monster.getMonsterHealth() > 0) {

                    if (!playerDodge()) {
                        System.out.println("--------------------------------------------------------" );
                        monster.createMonsterMessages(monster);
                        System.out.println(RED_BOLD_BRIGHT + monster.getMonsterName() + " Did " + monster.fight() + " Damage " + "to " + RESET + WHITE_BOLD_BRIGHT + getCharacterClassName() + RESET );
                        setHealth(getHealth()- monster.fight());

                        if (getHealth() == 0|| getHealth() < 0 ) {
                            player.setHealth(0);
                            System.out.println("You have died");
                            // Print Score
                        }
                    }
                    System.out.println(GREEN_BOLD_BRIGHT + "Current Monster Health:" + monster.getMonsterHealth() + RESET);
                }else {
                    monster.setMonsterHealth(0);
                    System.out.println("You have defeated me....");
                    dungeon.printDungeonChest(player,monster);
                    System.out.println("--------------------------------------------------------" );
                    System.out.println("Well done " + getCharacterClassName());
                    System.out.println("You received " + dungeon.getDungeonExperience() + " XP");
                    setExperience(getExperience() + dungeon.getDungeonExperience());
                    playerLevelUp();
                }
            }

            case "2" -> {
                returnToDungeonMenu(player);
            }

            case "3" -> {
                currentStatus();

            }
            case "4"-> {
                if (monster.getMonsterHealth() <= 0){
                    GameEngine gameEngine = new GameEngine();
                    gameEngine.dungeon(player);

                } else {
                    System.out.println("You cannot leave the dungeon");
                }



            }

        }
    }












public void createArcher (Player player){
        setHealth(75);
        setStrength(5);
        setExperience(0);
        setLevel(1);
        setAgility(15);
        setBaseDamage(5);
        setIntelligence(10);

}
public void createDuelist(Player player){
    setHealth(100);
    setStrength(10);
    setExperience(0);
    setLevel(1);
    setAgility(5);
    setBaseDamage(5);
    setIntelligence(5);


}

    //Getters
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

    // Setters
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
}
