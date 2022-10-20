package com.cameron.dungeonrun.shop.shopItems;

import com.cameron.dungeonrun.shop.IItemFunction;
import com.cameron.dungeonrun.shop.ShopItems;

public class AngelsAscension extends ShopItems implements IItemFunction {
    @Override
    public int itemAbility() {

        setItemAttribute(240);



        return getItemAttribute();
    }


    @Override
    public int itemCost() {
        setItemCost(150);
        return getItemCost();
    }

    @Override
    public String itemName() {
        setItemName("Angels Ascension");
        return getItemName();
    }
}
