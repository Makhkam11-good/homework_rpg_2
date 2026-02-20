package com.narxoz.rpg.loot.impl;

import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShadowLootTable implements LootTable {

    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public ShadowLootTable() {
        this.items = new ArrayList<>(Arrays.asList(
            "Shadow Gem",
            "Dark Essence",
            "Shadow Rune",
            "Void Shard"
        ));
        this.goldDrop = 550;
        this.experienceDrop = 350;
    }

    private ShadowLootTable(List<String> items, int goldDrop, int experienceDrop) {
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
        return "Shadow Loot: " + items + ", Gold: " + goldDrop + ", XP: " + experienceDrop;
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable(new ArrayList<>(this.items), this.goldDrop, this.experienceDrop);
    }

}
