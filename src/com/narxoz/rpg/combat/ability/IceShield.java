package com.narxoz.rpg.combat.ability;

import com.narxoz.rpg.combat.Ability;

public class IceShield implements Ability {

    private String name = "Ice Shield";
    private int damage = 10;
    private String description = "Summon a protective barrier of ice, reducing incoming damage and creating a protective aura";
    private String type = "DEFENSIVE";

    public IceShield() {
    }

    private IceShield(String name, int damage, String description, String type) {
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
        return new IceShield(this.name, this.damage, this.description, this.type);
    }

}
