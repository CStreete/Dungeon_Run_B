package com.cameron.dungeonrun.shop.shopItems;

import com.cameron.dungeonrun.shop.IItemFunction;
import com.cameron.dungeonrun.shop.ShopItems;

public class BootsOfAgility extends ShopItems implements IItemFunction {




    @Override
    public int itemAbility() {



        setItemAttribute(5);

        return getItemAttribute();
    }

    @Override
    public int itemCost() {

        setItemCost(20);


        return getItemCost();
    }

    @Override
    public String itemName() {
        setItemName("Boots of Agility");

        return getItemName();
    }
}
