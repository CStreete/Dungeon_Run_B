package com.cameron.dungeonrun.gameTests;



import com.cameron.dungeonrun.GameEngine;
import com.cameron.dungeonrun.Monster;
import org.junit.jupiter.api.*;


public class MonsterTests {
    GameEngine gameEngine;
    Monster monster;



    @BeforeEach
    void setup(){
         gameEngine = new GameEngine();
         monster = new Monster();
    }


    @Test
    @DisplayName("Check if monster list is populated once monster is created")
    public void monsterTest(){
        gameEngine.createMonster("Test Monster",0,0);
        Assertions.assertNotNull(gameEngine.monsterList);
        System.out.println(gameEngine.monsterList);

    }



    @Test
    @DisplayName("Testing method for, if monster hp goes below 0")
    public void monsterHpTest(){
        Assertions.assertNotNull(monster);
        monster.setMonsterHealth(-199);
        monster.checkMonsterHealth();
        Assertions.assertFalse(monster.getMonsterHealth() < 0);

    }

    @Test
    @DisplayName("Testing monster if monster can do double its strength as damage  ")
    public void monsterFightTest(){
        Assertions.assertNotNull(monster);
        monster.setMonsterDamage(50);
        Assertions.assertTrue(monster.fight() <= 100);
        System.out.println(monster.fight());
    }


    // Chance of test failure grows for each test repeat
    @RepeatedTest(4)
    @DisplayName("Testing randomness of monster messages")
    public void monsterMessagesTest() {

        Assertions.assertNotNull(monster);
        monster.createMonsterMessages(monster);
        Assertions.assertNotNull(monster.getMonsterMessages());


        Assertions.assertNotSame(monster.createMonsterMessages(monster), monster.createMonsterMessages(monster), "The monster message was the same");


    }









    }
















