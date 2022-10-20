package com.cameron.dungeonrun.shop.shopItems;

import com.cameron.dungeonrun.shop.IItemFunction;
import com.cameron.dungeonrun.shop.ShopItems;

public class HealthPotion extends ShopItems implements IItemFunction {
    @Override
    public int itemAbility() {

        setItemAttribute(15);



        return getItemAttribute();
    }

    @Override
    public int itemCost() {

        setItemCost(8);


        return getItemCost();
    }

    @Override
    public String itemName() {

        setItemName("Health Potion");


        return getItemName();
    }
}
