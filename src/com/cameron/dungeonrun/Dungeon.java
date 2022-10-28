package com.cameron.dungeonrun;



import java.util.Random;


import static com.cameron.dungeonrun.Colors.*;

public class Dungeon {

    // Variables
    private String dungeonName;
    private int dungeonLevel;
    private int dungeonExperience;
    private int dungeonDrop;


    // Constructor
    public  Dungeon (){}
    public Dungeon(String dungeonName, int dungeonLevel, int dungeonExperience) {
        setDungeonName(dungeonName);
        setDungeonLevel(dungeonLevel);
        setDungeonExperience(dungeonExperience);
    }


    // Dungeon methods for drop value & chest
    public int dungeonDropValue(Player player){
    Random random = new Random();
    int x = random.nextInt(0,player.getLevel() + getDungeonLevel());

        setDungeonDrop(((2 * getDungeonLevel()) + 5) + x);

        return getDungeonDrop();
}
    public void printDungeonChest(Player player, Monster monster){
    int healthDropValue = dungeonDropValue(player);
    int goldDropValue = dungeonDropValue(player);

    System.out.println("--------------------------------------------------------");
    System.out.println(WHITE_BOLD_BRIGHT + monster.getMonsterName() + " Chest" + RESET );
    System.out.println( GREEN_BOLD_BRIGHT + "+" + healthDropValue + " Health" + RESET);
    player.setHealth(player.getHealth() + healthDropValue);
    System.out.println(YELLOW_BOLD_BRIGHT + "+" + goldDropValue + " Gold" + RESET);
    player.setGold(player.getGold() + goldDropValue);



}



    //Getters
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

    // Setters
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

    // To String
    @Override
    public String toString() {
        return "Dungeon{" +
                "dungeonName='" + dungeonName + '\'' +
                ", dungeonLevel=" + dungeonLevel +
                ", dungeonExperience=" + dungeonExperience +
                '}';
    }
}
