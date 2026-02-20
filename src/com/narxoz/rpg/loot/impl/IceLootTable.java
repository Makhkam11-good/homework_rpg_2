package com.narxoz.rpg.loot.impl;

import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IceLootTable implements LootTable {

    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public IceLootTable() {
        this.items = new ArrayList<>(Arrays.asList(
            "Ice Gem",
            "Frost Scale",
            "Ice Rune",
            "Frozen Crystal"
        ));
        this.goldDrop = 450;
        this.experienceDrop = 280;
    }

    private IceLootTable(List<String> items, int goldDrop, int experienceDrop) {
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
        return "Ice Loot: " + items + ", Gold: " + goldDrop + ", XP: " + experienceDrop;
    }

    @Override
    public LootTable clone() {
        return new IceLootTable(new ArrayList<>(this.items), this.goldDrop, this.experienceDrop);
    }

}
