package com.cameron.dungeonrun.shop.shopItems;

import com.cameron.dungeonrun.shop.IItemFunction;
import com.cameron.dungeonrun.shop.ShopItems;

public class RangersBow extends ShopItems implements IItemFunction {






    @Override
    public int itemAbility() {

    setItemAttribute(25);



        return getItemAttribute();
    }


    @Override
    public int itemCost() {
        setItemCost(30);
        return getItemCost();
    }

    @Override
    public String itemName() {
        setItemName("Rangers Bow");
        return getItemName();
    }
}
