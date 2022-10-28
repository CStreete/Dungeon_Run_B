package com.cameron.dungeonrun.shop;



public class ShopItems {

    // Variables
    private String itemName;
    private int itemCost;
    private int itemAttribute;

    // Constructor
    public  ShopItems (){}
    public ShopItems(String itemName, int itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }




    // Getters
    public int getItemAttribute() {
        return itemAttribute;
    }
    public int getItemCost() {
        return itemCost;
    }
    public String getItemName() {
        return itemName;
    }


    // Setters
    public void setItemAttribute(int itemAttributes) {
        this.itemAttribute = itemAttributes;
    }
    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // To String
    @Override
    public String toString() {
        return "ShopItems{" +
                "itemName='" + itemName + '\'' +
                ", itemCost=" + itemCost +
                ", itemAttribute=" + itemAttribute +
                '}';
    }

}
