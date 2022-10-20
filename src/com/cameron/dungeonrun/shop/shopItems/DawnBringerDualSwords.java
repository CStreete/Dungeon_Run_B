package com.cameron.dungeonrun.shop.shopItems;

import com.cameron.dungeonrun.shop.IItemFunction;
import com.cameron.dungeonrun.shop.ShopItems;

public class DawnBringerDualSwords extends ShopItems implements IItemFunction {

    @Override
    public int itemAbility() {

        setItemAttribute(80);



        return getItemAttribute();
    }


    @Override
    public int itemCost() {
        setItemCost(90);
        return getItemCost();
    }

    @Override
    public String itemName() {
        setItemName("Dawnbringer Dual Swords");
        return getItemName();
    }


}
