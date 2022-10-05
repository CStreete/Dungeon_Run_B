package com.cameron.dungeonrun;

public class Player implements ICombat {

    //Player Variables
    String playerName;
    private static int strength = 0;
    private static int intelligence = 0;
    private static int health = 75;
    private static int experience = 0;
    private static int level = 1;
    private static int baseDamage = 5;
    private static int agility = 0;


    //Constructor
    public Player(String playerName) {
        this.playerName = playerName;
    }


    void playerLevelUp (){
        if (experience == 100){
            level += 1;
            System.out.println("Level " + level);
            strength += 2;
            intelligence +=2;
            agility+=2;
            experience = 0;
        }

    }


public static void currentPlayerStatus(){
    System.out.println("Current player status");
    System.out.println("---------------------");
    System.out.println("Level: " + level);
    System.out.println("Health: " + health);
    System.out.println("Strength: " + strength);
    System.out.println("Intelligence: " + intelligence);
    System.out.println("Experience: " + experience);



    }








    //Getters
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

    // Setters
    public void setHealth(int newHealth){
        health = newHealth;
    }
    public void setStrength (int newStrength){
        strength = newStrength;
    }

    public void setIntelligence (int newIntelligence){
        intelligence = newIntelligence;
    }
     public void setExperience(int newExperience){
        experience = newExperience;
     }
     public void setLevel(int newLevel){
        level = newLevel;
     }
     public void setBaseDamage (int newBaseDamage){
        baseDamage = newBaseDamage;

     }
     public void setAgility(int newAgility){
        agility = newAgility;
     }


    @Override
    public void fight() {



    }
}
