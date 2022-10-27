package com.cameron.dungeonrun;

import java.io.File;
import java.io.IOException;

public class FileWriter {


    public void createFile(Player player){
        File myFile = new File( "playerStats.txt");

        try {
            if (myFile.createNewFile()){
                System.out.println("Score File Created");
            }
            else {
                System.out.println("Score File Updated");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeToFile(Player player){

        String b = player.getCharacterClassName();
        String c = Integer.toString(player.getLevel());
        String f = Integer.toString(player.getTotalMonstersKilled());







        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("playerStats.txt");

            fileWriter.write("Owned Items");
            fileWriter.write("\n--------------------------------------------------" +
                    "\n");

            for (int i = 0; i < player.getPlayerPurchasedItems().size() ; i++) {

                String a = player.getPlayerPurchasedItems().get(i).getItemName();
                fileWriter.write(a);
                fileWriter.write("\n");
            }
            fileWriter.write("\n"+ b + " Score");
            fileWriter.write("\n--------------------------------------------------" +
                    "\n" + "Level: " + c +
                    "\n" + "Monsters Killed: " + f);


            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
