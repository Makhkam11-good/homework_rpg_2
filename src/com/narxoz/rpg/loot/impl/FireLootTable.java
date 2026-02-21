package com.narxoz.rpg.loot.impl;

import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FireLootTable implements LootTable {

    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public FireLootTable() {
        this.items = new ArrayList<>(Arrays.asList(
            "Fire Gem",
            "Dragon Scale",
            "Flame Rune",
            "Ember Crystal"
        ));
        this.goldDrop = 500;
        this.experienceDrop = 300;
    }

    private FireLootTable(List<String> items, int goldDrop, int experienceDrop) {
        this.items = new ArrayList<>(items);
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public String getLootInfo() {
        return "Fire Loot: " + items + ", Gold: " + goldDrop + ", XP: " + experienceDrop;
    }

    @Override
    public LootTable clone() {
        return new FireLootTable(new ArrayList<>(this.items), this.goldDrop, this.experienceDrop);
    }

}
