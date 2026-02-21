package com.narxoz.rpg.combat.ability;

import com.narxoz.rpg.combat.Ability;

public class FlameBreath implements Ability {

    private String name = "Flame Breath";
    private int damage = 45;
    private String description = "Breathe a burst of flames dealing AoE damage with burn effect";
    private String type = "DAMAGE";

    public FlameBreath() {
    }

    private FlameBreath(String name, int damage, String description, String type) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Ability clone() {
        return new FlameBreath(this.name, this.damage, this.description, this.type);
    }

}
