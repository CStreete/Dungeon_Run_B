package com.cameron.dungeonrun.shop.shopItems;

import com.cameron.dungeonrun.shop.IItemFunction;
import com.cameron.dungeonrun.shop.ShopItems;

public class DragonmancerChains extends ShopItems implements IItemFunction {






    @Override
    public int itemAbility() {

        setItemAttribute(45);



        return getItemAttribute();
    }

    @Override
    public int itemCost() {
        setItemCost(50);



        return getItemCost();
    }

    @Override
    public String itemName() {

        setItemName("Dragonmancer Chains");

        return getItemName();
    }
}
