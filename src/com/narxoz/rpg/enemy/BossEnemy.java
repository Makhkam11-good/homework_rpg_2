package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemy implements Enemy {

    private final String name;
    private final int health;
    private final int damage;
    private final int defense;
    private final int speed;
    private final String element;
    private final List<Ability> abilities;
    private final LootTable lootTable;
    private final String aiBehavior;
    private final Map<Integer, Integer> phases;

    public BossEnemy(String name, int health, int damage, int defense, int speed,
                     String element, List<Ability> abilities, LootTable lootTable,
                     String aiBehavior, Map<Integer, Integer> phases) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = new ArrayList<>(abilities);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.phases = new HashMap<>(phases);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getElement() {
        return element;
    }

    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public String getAIBehavior() {
        return aiBehavior;
    }

    public Map<Integer, Integer> getPhases() {
        return new HashMap<>(phases);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (BOSS) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + 
                           " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element + " | AI: " + aiBehavior);
        System.out.println("Abilities: " + abilities.size());
        for (Ability ability : abilities) {
            System.out.println("  - " + ability.getName() + " (" + ability.getType() + 
                             ", DMG: " + ability.getDamage() + ")");
        }
        System.out.println("Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> entry : phases.entrySet()) {
            System.out.println("  - Phase " + entry.getKey() + " at " + entry.getValue() + " HP");
        }
        System.out.println("Loot: " + lootTable.getLootInfo());
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            clonedAbilities.add(ability.clone());
        }
        return new BossEnemy(
            this.name,
            this.health,
            this.damage,
            this.defense,
            this.speed,
            this.element,
            clonedAbilities,
            this.lootTable.clone(),
            this.aiBehavior,
            new HashMap<>(this.phases)
        );
    }

}
