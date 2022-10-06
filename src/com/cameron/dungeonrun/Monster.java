package com.cameron.dungeonrun;

public class Monster implements ICombat{


    // TODO: 2022-10-05 Create new monsters, Killer Jackal

    //Monster Variables
    String monsterName;
    private int monsterHealth;
    private int monsterDamage;





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

        return calculateDamage(monsterDamage);
    }

    @Override
    public int calculateDamage(int strength) {

        monsterDamage = strength;
        return strength;
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
}
