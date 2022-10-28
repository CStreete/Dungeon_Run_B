package com.cameron.dungeonrun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.cameron.dungeonrun.Colors.*;

public class Monster implements ICombat{




    //Monster Variables
    String monsterName;
    private int monsterHealth;
    private int monsterDamage;
    private String randomMonsterMessage;
    private String randomMonsterMessage1;
    private String randomMonsterMessage2;
    private String randomMonsterMessage3;

    // Monster messages list
    private  List<String> monsterMessages = new ArrayList<>();


    // Constructor
    public Monster (){}
    public Monster(String monsterName, int monsterHealth, int monsterDamage) {
        setMonsterName(monsterName);
        setMonsterHealth(monsterHealth);
        setMonsterDamage(monsterDamage);
    }


    // Random monster messages methods
    public String createMonsterMessages (Monster monster){
     setRandomMonsterMessage1( RED_BOLD_BRIGHT + "Ahhhhhhhh, you cannot defeat me!" + RESET);
     setRandomMonsterMessage(RED_BOLD_BRIGHT + "I am a born killer" + RESET );
     setRandomMonsterMessage2(RED_BOLD_BRIGHT + "Looks like you will just be another number on my kill list!" + RESET);
     setRandomMonsterMessage3(RED_BOLD_BRIGHT + "This is going to be so much fun hahahhah" + RESET);
     addMessagesToList();
     Random random = new Random();


return monsterMessages.get(random.nextInt(0,3));



 }

    public void addMessagesToList(){
     monsterMessages.add(getRandomMonsterMessage());
     monsterMessages.add(getRandomMonsterMessage1());
     monsterMessages.add(getRandomMonsterMessage2());
     monsterMessages.add(getRandomMonsterMessage3());



 }



    // Method for if monster health < 0
    public void checkMonsterHealth(){
        if (getMonsterHealth() <= 0)
            setMonsterHealth(0);
    }

    // Monster Combat Methods
    @Override
    public int fight() {

      return calculateDamage();
    }

    @Override
    public int calculateDamage() {
     Random random = new Random();
     int x = random.nextInt(0,getMonsterDamage());

        return (getMonsterDamage() + x);
    }


    //To String
    @Override
    public String toString() {
        return "Monster{" +
                "monsterName='" + monsterName + '\'' +
                ", monsterHealth=" + monsterHealth +
                ", monsterDamage=" + monsterDamage +
                '}';
    }

    // Getters
    public String getMonsterName() {
      return monsterName;
  }
    public int getMonsterDamage() {
        return monsterDamage;
    }
    public int getMonsterHealth() {

        return monsterHealth;
    }
    public String getRandomMonsterMessage() {
        return randomMonsterMessage;
    }
    public String getRandomMonsterMessage1() {
        return randomMonsterMessage1;
    }
    public String getRandomMonsterMessage2() {
        return randomMonsterMessage2;
    }
    public String getRandomMonsterMessage3() {
        return randomMonsterMessage3;
    }
    public List<String> getMonsterMessages() {
        return monsterMessages;
    }

    // Setters
    public void setMonsterMessages(List<String> monsterMessages) {
        this.monsterMessages = monsterMessages;
    }
    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }
    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    public void setRandomMonsterMessage(String randomMonsterMessage) {
        this.randomMonsterMessage = randomMonsterMessage;
    }
    public void setRandomMonsterMessage1(String randomMonsterMessage1) {
        this.randomMonsterMessage1 = randomMonsterMessage1;
    }
    public void setRandomMonsterMessage2(String randomMonsterMessage2) {
        this.randomMonsterMessage2 = randomMonsterMessage2;
    }
    public void setRandomMonsterMessage3(String randomMonsterMessage3) {
        this.randomMonsterMessage3 = randomMonsterMessage3;
    }




}
