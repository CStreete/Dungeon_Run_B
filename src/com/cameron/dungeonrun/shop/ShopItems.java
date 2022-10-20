package com.cameron.dungeonrun.shop;



public class ShopItems {


    private String itemName;
    private int itemCost;
    private int itemAttribute;





public  ShopItems (){}
    public ShopItems(String itemName, int itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return "ShopItems{" +
                "itemName='" + itemName + '\'' +
                ", itemCost=" + itemCost +
                ", itemAttribute=" + itemAttribute +
                '}';
    }

    public int getItemAttribute() {
        return itemAttribute;
    }

    public int getItemCost() {
        return itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemAttribute(int itemAttributes) {
        this.itemAttribute = itemAttributes;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
