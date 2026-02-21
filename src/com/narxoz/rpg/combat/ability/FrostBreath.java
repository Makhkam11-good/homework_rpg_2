package com.narxoz.rpg.combat.ability;

import com.narxoz.rpg.combat.Ability;

public class FrostBreath implements Ability {

    private String name = "Frost Breath";
    private int damage = 40;
    private String description = "Blast enemies with freezing cold, dealing damage and slowing their movement";
    private String type = "DAMAGE";

    public FrostBreath() {
    }

    private FrostBreath(String name, int damage, String description, String type) {
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
        return new FrostBreath(this.name, this.damage, this.description, this.type);
    }

}
