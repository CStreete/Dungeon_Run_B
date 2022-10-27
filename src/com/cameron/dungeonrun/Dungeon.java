package com.cameron.dungeonrun;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.cameron.dungeonrun.Colors.*;

public class Dungeon {

    private String dungeonName;
    private int dungeonLevel;
    private int dungeonExperience;
    private int dungeonDrop;




/*public void enterDungeon(Player player, Monster monster) {
boolean isFighting = false;

    String dungeonRoom;

    do {


        System.out.println(monster.monsterList);
    System.out.println("You have entered " + getDungeonName());
    System.out.println("1) Room 1, 2) Room 2");


    dungeonRoom = Scan.scanner.next();
    switch (dungeonRoom) {

        case "1": {
            System.out.println(monster.monsterList);

            combatSequence(player,monster.monsterList.get(0));


            break;
        }




        case "2": {
            System.out.println(monster.monsterList);
            if (monster.monsterList.get(0).getMonsterHealth() <= 0) {
                combatSequence(player,monster.monsterList.get(1));
            }else {
                System.out.println("You must complete room 1 first ");
            }
            break;

        }


    }
}while (!isFighting);
}*/






























    @Override
    public String toString() {
        return "Dungeon{" +
                "dungeonName='" + dungeonName + '\'' +
                ", dungeonLevel=" + dungeonLevel +
                ", dungeonExperience=" + dungeonExperience +
                '}';
    }




    public  Dungeon (){}

    public Dungeon(String dungeonName, int dungeonLevel, int dungeonExperience) {
        setDungeonName(dungeonName);
        setDungeonLevel(dungeonLevel);
        setDungeonExperience(dungeonExperience);
    }



public int dungeonDropValue(Player player){
    Random random = new Random();
    int x = random.nextInt(0,player.getLevel() + getDungeonLevel());

        setDungeonDrop(((2 * getDungeonLevel()) + 5) + x);

        return getDungeonDrop();
}


public void printDungeonChest(Player player, Monster monster){

    System.out.println("--------------------------------------------------------");
    System.out.println(WHITE_BOLD_BRIGHT + monster.getMonsterName() + " Chest" + RESET );
    System.out.println( GREEN_BOLD_BRIGHT + "+" + dungeonDropValue(player) + " Health" + RESET);
    player.setHealth(player.getHealth() + dungeonDropValue(player));
    System.out.println(YELLOW_BOLD_BRIGHT + "+" + dungeonDropValue(player) + " Gold" + RESET);
    player.setGold(player.getGold() + dungeonDropValue(player));



}





    public int getDungeonDrop() {
        return dungeonDrop;
    }
    public int getDungeonExperience() {
        return dungeonExperience;
    }
    public int getDungeonLevel() {
        return dungeonLevel;
    }
    public String getDungeonName() {
        return dungeonName;
    }


    public void setDungeonExperience(int dungeonExperience) {
        this.dungeonExperience = dungeonExperience;
    }
    public void setDungeonLevel(int dungeonLevel) {
        this.dungeonLevel = dungeonLevel;
    }
    public void setDungeonName(String dungeonName) {
        this.dungeonName = dungeonName;
    }
    public void setDungeonDrop(int dungeonDrop) {
        this.dungeonDrop = dungeonDrop;
    }
}
