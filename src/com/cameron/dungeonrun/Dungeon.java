package com.cameron.dungeonrun;


import static com.cameron.dungeonrun.Colors.*;

public class Dungeon {

    private String dungeonName;
    private int dungeonLevel;
    private int dungeonExperience;
    private int dungeonDrop;




    public void createMinions (int minionDamage, int minionHealth){
        Monster monster = new Monster();






    }















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



public int dungeonDropValue(){

        setDungeonDrop((2 * getDungeonLevel()) + 5);

        return getDungeonDrop();
}
public void printDungeonChest(Player player, Monster monster){

    System.out.println("--------------------------------------------------------");
    System.out.println(WHITE_BOLD_BRIGHT + monster.getMonsterName() + " Chest" + RESET );
    System.out.println( GREEN_BOLD_BRIGHT + "+" + dungeonDropValue() + " Health" + RESET);
    player.setHealth(player.getHealth() + dungeonDropValue());
    System.out.println(YELLOW_BOLD_BRIGHT + "+" + dungeonDropValue() + " Gold" + RESET);
    player.setGold(player.getGold() + dungeonDropValue());
    player.setHealth(player.getHealth() + dungeonDropValue());


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
