package com.cameron.dungeonrun;

public class Player {

    //Player Variables
    String playerName;
    private int strength = 0;
    private int intelligence = 0;
    private int health = 0;
    private int experience = 0;
    private int level = 0;
    private int baseDamage = 5;


    //Constructor
    public Player(String playerName) {
        this.playerName = playerName;
    }


    void playerLevelUp (){
        if (experience == 100){
            System.out.println("Level" + level +1);
        }

    }


void currentPlayerStatus(){
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

    // Setters
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setStrength (int newStrength){
        this.strength = newStrength;
    }

    public void setIntelligence (int newIntelligence){
        this.intelligence = newIntelligence;
    }
     public void setExperience(int newExperience){
        this.experience = newExperience;
     }
     public void setLevel(int newLevel){
        this.level = newLevel;
     }
     public void setBaseDamage (int newBaseDamage){
        this.baseDamage = newBaseDamage;

     }




}
