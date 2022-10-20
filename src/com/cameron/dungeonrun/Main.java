package com.cameron.dungeonrun;

import com.cameron.dungeonrun.shop.Shop;
import com.cameron.dungeonrun.shop.ShopItems;

public class Main {
    public static void main(String[] args) {
    GameEngine newGame = new GameEngine();

    Player newPlayer = new Player();

    newGame.startGame(newPlayer);


    }
}
