package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
            .setName("Minion")
            .setHealth(50)
            .setDamage(10)
            .setDefense(2)
            .setSpeed(20)
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAIBehavior(factory.createAIBehavior())
            .build();
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
            .setName("Elite")
            .setHealth(150)
            .setDamage(25)
            .setDefense(8)
            .setSpeed(30)
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAIBehavior(factory.createAIBehavior())
            .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
            .setName("Mini Boss")
            .setHealth(500)
            .setDamage(75)
            .setDefense(25)
            .setSpeed(35)
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAIBehavior(factory.createAIBehavior())
            .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
            .setName("Raid Boss")
            .setHealth(5000)
            .setDamage(300)
            .setDefense(100)
            .setSpeed(45)
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAIBehavior(factory.createAIBehavior())
            .build();
    }

}
