package com.cameron.dungeonrun.gameTests;


import com.cameron.dungeonrun.GameEngine;
import com.cameron.dungeonrun.Monster;
import com.cameron.dungeonrun.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {

    GameEngine gameEngine;
    Player player;
    Player newArcher;
    Player newDuelist;



    @BeforeEach
    void setup(){
        gameEngine = new GameEngine();
        newArcher = new Player();
        newDuelist = new Player();
        player = new Player();
    }

    @Test
    @DisplayName("Testing if archer & duelist start values are correct and not the same when created")
    public void playerTest(){

        Assertions.assertNotNull(newArcher);
        newArcher.setCharacterClassName("Archer");
        newArcher.createArcher();
        newArcher.currentStatus();


        Assertions.assertNotNull(newDuelist);
        newDuelist.setCharacterClassName("Duelist");
        newDuelist.createDuelist();
        newDuelist.currentStatus();

        Assertions.assertNotSame(newArcher,newDuelist);

    }

    @Test
    @DisplayName("Testing method for when player HP goes below 0 and if player can be defeated")
    public void playerHPTest(){

        Assertions.assertNotNull(player);

        for (int i = 15 ; i > -15; i-=1) {
            player.setHealth(i);
            System.out.println(player.getHealth());
            player.playerHealth();
            Assertions.assertFalse(player.getHealth() < 0);
        }
        System.out.println("Health after going below 0");
        System.out.println(player.getHealth());

        System.out.println("Is player defeated?");
        Assertions.assertTrue(player.checkIfPlayerIsDefeated());
        System.out.println(player.checkIfPlayerIsDefeated());




    }

    @RepeatedTest(10)
    @DisplayName("Testing if player flee fight depends on player agility and is random")
    public void playerFleeTest (){

        Assertions.assertNotNull(player);
        player.setAgility(50);

        boolean flee = player.playerFleeFight();


        if (flee){
            Assertions.assertTrue(flee);
            System.out.println("Player can flee");

        }
        else {
            Assertions.assertFalse(flee);
            System.out.println("Player cannot not flee");


        }

    }

    @Test
    @DisplayName("Testing if player can take damage and do damage")
    public void playerVsMonsterCombatTest(){

        Monster monster = new Monster();
        monster.setMonsterDamage(20);
        monster.setMonsterHealth(100);
        player.setHealth(70);
        player.setStrength(20);
        player.setBaseDamage(5);

        Assertions.assertNotNull(player);


        player.setHealth(player.getHealth() - monster.fight());
        System.out.println(player.getHealth());
        Assertions.assertTrue(player.getHealth() < 70);


        monster.setMonsterHealth(monster.getMonsterHealth() - player.fight());
        System.out.println(monster.getMonsterHealth());
        Assertions.assertTrue(monster.getMonsterHealth() < 100);

    }

    @Test
    @DisplayName("Testing if player can loose game")
    public void playerLooseGameTest(){

        player.setHealth(0);
        Assertions.assertTrue(player.checkIfPlayerIsDefeated());


    }
    @RepeatedTest(25)
    @DisplayName("Testing randomness of double damage and if player can deal double damage based on intelligence")
    public void playerDoubleDamageTest(){
        player.setStrength(10);
        player.setBaseDamage(5);
        player.setAgility(10);

        Assertions.assertNotNull(player);

        for (int i = 0; i < 25 ; i++) {
            player.setIntelligence(i);
        }
        boolean doublePlayerDamage = player.doubleDamage();

        if (doublePlayerDamage){
            Assertions.assertTrue(doublePlayerDamage);
            System.out.println("Double Damage!");

        } else {

            Assertions.assertFalse(doublePlayerDamage);
            System.out.println("Did not deal Double Damage");

        }

    }
    @Test
    @DisplayName("Testing if player can level up and if remainder is stored")
    public void playerLevelUpTest(){
        player.createArcher();
        player.calculateExperience(223);
        player.ifPlayerLevelUp();

        Assertions.assertNotNull(player);
        System.out.println(player.getExperience());
        Assertions.assertEquals(3,player.getLevel());
        Assertions.assertTrue(player.getExperience() < 223 && player.getExperience() > 0);

        Assertions.assertEquals(23,player.getExperience());


















    }
















}
