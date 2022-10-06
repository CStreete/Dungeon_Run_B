package com.cameron.dungeonrun;

import java.util.Random;

public class Player implements ICombat {

    //Player Variables
    String playerName;
    private  int strength = 0;
    private  int intelligence = 0;
    private  int health = 75;
    private  int experience = 0;
    private  int level = 1;
    private  int baseDamage = 5;
    private  int agility = 0;


    //Constructor
    public Player(String playerName) {
        this.playerName = playerName;
    }
    public Player(){}


   public void playerLevelUp (){
        if (experience == 100){
            level += 1;
            strength += 2;
            intelligence +=2;
            agility+=2;
            experience = 0;
            System.out.println("Level " + level);
        }

    }


    public void playerCombatAct (){
        Monster killerJakhal = new Monster("Killer Jakhal", 20,2);
        System.out.println("""
                 1) Fight\s
                 2) Flee\s
                 3- Status""");
        String userChoice = Scan.scanner.next();
        switch (userChoice) {
            case "1" -> {
                System.out.println("You did " + calculateDamage(baseDamage) + "Damage to " + killerJakhal.getMonsterName() );
                System.out.println(killerJakhal.getMonsterName() + " Did");

            }

            case "2" -> System.out.println("Fleeing......");
            case "3" -> System.out.println("showing status.....");
        }
    }
    public void combatSequence (Monster monster, Player player){
        boolean isFighting = true;
        do {
            player.playerCombatAct();
        }while (isFighting);




    }

    /*public void playerDodge (){
        int randomNumber;
            Random random = new Random();
            randomNumber = random.nextInt(1,100);

    if (randomNumber > agility) {
        System.out.println("You didnt dodge");
        System.out.println(randomNumber);
    } else
        System.out.println("Dodged ");
    System.out.println(randomNumber);


    }*/

    @Override
    public int fight() {

        return calculateDamage(strength);
    }



    @Override
    public int calculateDamage(int strength) {

        baseDamage += (strength * 2 / 4+1);
        return strength;
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



}
