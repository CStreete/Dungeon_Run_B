package com.cameron.dungeonrun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.cameron.dungeonrun.Colors.*;

public class Monster implements ICombat{


    // TODO: 2022-10-05 Create new monsters, Killer Jackal

    //Monster Variables
    String monsterName;
    private int monsterHealth;
    private int monsterDamage;
    private int minionHealth;
    private int minionDamage;
    private String randomMonsterMessage;
    private String randomMonsterMessage1;
    private String randomMonsterMessage2;
    private String randomMonsterMessage3;



     private  List<String> monsterMessages = new ArrayList<>();








 public void createMonsterMessages (Monster monster){
     setRandomMonsterMessage1( RED_BOLD_BRIGHT + "Ahhhhhhhh, you cannot defeat me!" + RESET);
     setRandomMonsterMessage(RED_BOLD_BRIGHT + "I am a born killer" + RESET );
     setRandomMonsterMessage2(RED_BOLD_BRIGHT + "Looks like you will just be another number on my kill list!" + RESET);
     setRandomMonsterMessage3(RED_BOLD_BRIGHT + "This is going to be so much fun hahahhah" + RESET);
     addMessagesToList();
     Random random = new Random();

     System.out.println(monsterMessages.get(random.nextInt(0,3)));




 }
 public void addMessagesToList(){
     monsterMessages.add(getRandomMonsterMessage());
     monsterMessages.add(getRandomMonsterMessage1());
     monsterMessages.add(getRandomMonsterMessage2());
     monsterMessages.add(getRandomMonsterMessage3());



 }







public Monster (){}

    public Monster(String monsterName, int monsterHealth, int monsterDamage) {
        setMonsterName(monsterName);
        setMonsterHealth(monsterHealth);
        setMonsterDamage(monsterDamage);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterName='" + monsterName + '\'' +
                ", monsterHealth=" + monsterHealth +
                ", monsterDamage=" + monsterDamage +
                '}';
    }

    @Override
    public int fight() {




      return calculateDamage();
    }

    @Override
    public int calculateDamage() {

        return monsterDamage;
    }





    public int getMinionHealth() {
        return minionHealth;
    }

    public int getMinionDamage() {
        return minionDamage;
    }


    public String getMonsterName() {
        return monsterName;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }
    public int getMonsterHealth() {

        return monsterHealth;
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
    public String getRandomMonsterMessage() {
        return randomMonsterMessage;
    }

    public void setRandomMonsterMessage(String randomMonsterMessage) {
        this.randomMonsterMessage = randomMonsterMessage;
    }

    public String getRandomMonsterMessage1() {
        return randomMonsterMessage1;
    }

    public void setRandomMonsterMessage1(String randomMonsterMessage1) {
        this.randomMonsterMessage1 = randomMonsterMessage1;
    }

    public String getRandomMonsterMessage2() {
        return randomMonsterMessage2;
    }

    public void setRandomMonsterMessage2(String randomMonsterMessage2) {
        this.randomMonsterMessage2 = randomMonsterMessage2;
    }

    public String getRandomMonsterMessage3() {
        return randomMonsterMessage3;
    }

    public void setRandomMonsterMessage3(String randomMonsterMessage3) {
        this.randomMonsterMessage3 = randomMonsterMessage3;
    }
    public void setMinionDamage(int minionDamage) {
        this.minionDamage = minionDamage;
    }
    public void setMinionHealth(int minionHealth) {
        this.minionHealth = minionHealth;
    }



}
