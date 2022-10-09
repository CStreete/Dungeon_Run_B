package com.cameron.dungeonrun;

public class Player implements ICombat {
// Random number for attacks
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
    public void currentPlayerStatus(){
        System.out.println("Current player status");
        System.out.println("---------------------");
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Strength: " + getStrength());
        System.out.println("Intelligence: " + getIntelligence());
        System.out.println("Experience: " + getExperience());



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
                System.out.println("You did " + fight() + " Damage to " + killerJakhal.getMonsterName() );
                System.out.println(killerJakhal.getMonsterName() + " Did " + killerJakhal.fight() + " Damage " + " to" + playerName);
                health -= killerJakhal.fight();
                int mHealth = killerJakhal.getMonsterHealth();
                mHealth -= fight();
                System.out.println("Current Monster Health:" + mHealth);
            }

            case "2" -> System.out.println("Fleeing......");
            case "3" -> {
                System.out.println("showing status.....");
                currentPlayerStatus();

                {




                }
            }

        }
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

        return baseDamage + calculateDamage();
    }



    @Override
    public int calculateDamage() {

        return (((strength + level) /4) + 1);
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
