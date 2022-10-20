package com.cameron.dungeonrun.shop;

import com.cameron.dungeonrun.GameEngine;
import com.cameron.dungeonrun.Player;
import com.cameron.dungeonrun.Scan;
import com.cameron.dungeonrun.shop.shopItems.*;

import java.util.ArrayList;
import java.util.List;

import static com.cameron.dungeonrun.Colors.*;

public class Shop {


    List<ShopItems> shopItemsList = new ArrayList<>();
    ShopItems shopItems;
    BootsOfAgility bootsOfAgility = new BootsOfAgility();
    RangersBow rangersBow = new RangersBow();
    DragonmancerChains dragonmancerChains = new DragonmancerChains();
    HealthPotion healthPotion = new HealthPotion();
    DawnBringerDualSwords dawnBringerDualSwords = new DawnBringerDualSwords();
    AngelsAscension angelsAscension = new AngelsAscension();




public void startShop(Player player){

    GameEngine gameEngine = new GameEngine();
    boolean exit = false;
    createShopItem(bootsOfAgility,rangersBow,dragonmancerChains,healthPotion,dawnBringerDualSwords,angelsAscension);
    shopMessages(player);




do {


    System.out.println( WHITE_BOLD_BRIGHT + "0) Leave Shop" + "\nEnter your choice: " );


    switch (Scan.scanner.next()) {

        case "0":
            gameEngine.dungeon(player);
            break;
        case "1":

            if (player.getGold() >= shopItemsList.get(0).getItemCost()) {
                player.setGold(player.getGold() - shopItemsList.get(0).getItemCost());
                player.setAgility(player.getAgility() + shopItemsList.get(0).getItemAttribute());
                System.out.println("You have purchased: " +  PURPLE_BOLD_BRIGHT + shopItemsList.get(0).getItemName()+ RESET);
                System.out.println("Gold: " + player.getGold());


            } else {
                System.out.println("Shop Merchant: Sorry Traveler, you do not have enough gold");
            }
            break;
        case "2":
            if (player.getGold() >= shopItemsList.get(1).getItemCost()) {
                player.setGold(player.getGold() - shopItemsList.get(1).getItemCost());
                player.setAgility(player.getAgility() + (shopItemsList.get(1).getItemAttribute()- 10));
                player.setStrength(player.getStrength() + shopItemsList.get(1).getItemAttribute() - 15);
                System.out.println("You have purchased: " + BLUE_BOLD_BRIGHT + shopItemsList.get(1).getItemName()+ RESET);
                System.out.println("Gold: " + player.getGold());


            } else {
                System.out.println("Shop Merchant: Sorry Traveler, you do not have enough gold");
            }
            break;


        case "3":
            if (player.getGold() >= shopItemsList.get(2).getItemCost()) {
                player.setGold(player.getGold() - shopItemsList.get(2).getItemCost());
                player.setAgility(player.getAgility() + (shopItemsList.get(2).getItemAttribute()- 40));
                player.setStrength(player.getStrength() + (shopItemsList.get(2).getItemAttribute() - 25));
                player.setHealth(player.getHealth() + (shopItemsList.get(2).getItemAttribute() - 25) );
                System.out.println("You have purchased: " + RED_BOLD_BRIGHT +  shopItemsList.get(2).getItemName()+ RESET);
                System.out.println("Gold: " + player.getGold());

            } else {
                System.out.println("Shop Merchant: Sorry Traveler, you do not have enough gold");
            }

            break;

        case "4":
            if (player.getGold() >= shopItemsList.get(3).getItemCost()) {
                player.setGold(player.getGold() - shopItemsList.get(3).getItemCost());
                player.setHealth(player.getHealth() + shopItemsList.get(3).getItemAttribute());
                System.out.println("You have purchased: "  + GREEN_BOLD_BRIGHT + shopItemsList.get(3).getItemName()+ RESET);
                System.out.println("Gold: " + player.getGold());


            } else {
                System.out.println("Shop Merchant: Sorry Traveler, you do not have enough gold");
            }
            break;


        case "5":

            if (player.getGold() >= shopItemsList.get(4).getItemCost()) {
                player.setGold(player.getGold() - shopItemsList.get(4).getItemCost());
                player.setAgility(player.getAgility() + (shopItemsList.get(4).getItemAttribute()- 65));
                player.setStrength(player.getStrength() + (shopItemsList.get(4).getItemAttribute() - 55));
                player.setHealth(player.getHealth() + (shopItemsList.get(4).getItemAttribute() - 55));
                player.setBaseDamage(player.getBaseDamage() + (shopItemsList.get(4).getItemAttribute() - 65));
                System.out.println("You have purchased: " + CYAN_BOLD_BRIGHT + shopItemsList.get(4).getItemName()+ RESET );
                System.out.println("Gold: " + player.getGold());

            } else {
                System.out.println("Shop Merchant: Sorry Traveler, you do not have enough gold");
            }

            break;


        case "6":
            if (player.getGold() >= shopItemsList.get(5).getItemCost()) {
                player.setGold(player.getGold() - shopItemsList.get(5).getItemCost());
                player.setAgility(player.getAgility() + (shopItemsList.get(5).getItemAttribute()- 190));
                player.setStrength(player.getStrength() + (shopItemsList.get(5).getItemAttribute() - 190));
                player.setHealth(player.getHealth() + (shopItemsList.get(5).getItemAttribute() - 140));
                player.setBaseDamage(player.getBaseDamage() + (shopItemsList.get(5).getItemAttribute() - 220));
                player.setIntelligence(player.getIntelligence() + (shopItemsList.get(5).getItemAttribute() - 220));
                System.out.println("You have purchased: " +  YELLOW_BOLD_BRIGHT + shopItemsList.get(5).getItemName() + RESET);
                System.out.println("Gold: " + player.getGold());

            } else {
                System.out.println("Shop Merchant: Sorry Traveler, you do not have enough gold");
            }

            break;


    }
}while (!exit);
}








public void shopMessages (Player player){
    System.out.println(WHITE_BOLD_BRIGHT + "Shop Merchant: Welcome Traveler!");
    System.out.println(WHITE_BOLD_BRIGHT + "What would you like to purchase?");
    System.out.println("Your current Gold: " + player.getGold());
    System.out.println(PURPLE_BOLD_BRIGHT + "1) Boots of Agility " + RESET + WHITE_BOLD_BRIGHT +
            "\n20 Gold \nStats: +5 Agility" + RESET +
            "\n----------------------------------------------" +
            BLUE_BOLD_BRIGHT + "\n2) Rangers Bow " + RESET +
            WHITE_BOLD_BRIGHT + "\n30 Gold\nStats: +10 Agility +15 Strength " +
            "\n----------------------------------------------" +
            RED_BOLD_BRIGHT + "\n3) Dragonmancer Chains" + RESET +
            WHITE_BOLD_BRIGHT + "\n50 Gold\nStats: +5 Agility +20 Strength +20 Health" + RESET +
            "\n----------------------------------------------" +
            GREEN_BOLD_BRIGHT + "\n4) Health Potion " + RESET +
            WHITE_BOLD_BRIGHT + "\n8 Gold \nStats: +15 Health" + RESET +
            "\n----------------------------------------------" +
            CYAN_BOLD_BRIGHT + "\n5) Dawnbringer Dual Swords " + RESET +
            WHITE_BOLD_BRIGHT + "\n90 Gold \nStats: +15 Agility +25 Strength +25 Health +15 Base Damage" + RESET +
            "\n----------------------------------------------" +
            YELLOW_BOLD_BRIGHT + "\n6) Angels Ascension " + RESET +
            WHITE_BOLD_BRIGHT + "\n150 Gold \nStats: +50 Agility + 50 Strength + 100 Health + 20 Base Damage + 20 Intelligence" +
            "\n----------------------------------------------");
}




    public void createShopItem(BootsOfAgility bootsOfAgility, RangersBow rangersBow,
                               DragonmancerChains dragonmancerChains,HealthPotion healthPotion,
                               DawnBringerDualSwords dawnBringerDualSwords,AngelsAscension angelsAscension){


    bootsOfAgility.setItemName(bootsOfAgility.itemName());
    bootsOfAgility.setItemCost(bootsOfAgility.itemCost());
    bootsOfAgility.setItemAttribute(bootsOfAgility.itemAbility());

    rangersBow.setItemName(rangersBow.itemName());
    rangersBow.setItemCost(rangersBow.itemCost());
    rangersBow.setItemAttribute(rangersBow.itemAbility());


    dragonmancerChains.setItemName(dragonmancerChains.itemName());
    dragonmancerChains.setItemCost(dragonmancerChains.itemCost());
    dragonmancerChains.setItemAttribute(dragonmancerChains.itemAbility());

    healthPotion.setItemName(healthPotion.itemName());
    healthPotion.setItemCost(healthPotion.itemCost());
    healthPotion.setItemAttribute(healthPotion.itemAbility());

    dawnBringerDualSwords.setItemName(dawnBringerDualSwords.itemName());
    dawnBringerDualSwords.setItemCost(dawnBringerDualSwords.itemCost());
    dawnBringerDualSwords.setItemAttribute(dawnBringerDualSwords.itemAbility());

    angelsAscension.setItemName(angelsAscension.itemName());
    angelsAscension.setItemCost(angelsAscension.itemCost());
    angelsAscension.setItemAttribute(angelsAscension.itemAbility());




    addItemToList(bootsOfAgility);
    addItemToList(rangersBow);
    addItemToList(dragonmancerChains);
    addItemToList(healthPotion);
    addItemToList(dawnBringerDualSwords);
    addItemToList(angelsAscension);
    }
    





    public void addItemToList(ShopItems shopItems){
     shopItemsList.add(shopItems);


    }




}
