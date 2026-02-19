package com.narxoz.rpg.combat.ability;

import com.narxoz.rpg.combat.Ability;

public class FireShield implements Ability {

    private String name = "Fire Shield";
    private int damage = 15;
    private String description = "Envelop yourself in flames, damaging attackers while reducing incoming damage";
    private String type = "DEFENSIVE";

    public FireShield() {
    }

    private FireShield(String name, int damage, String description, String type) {
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
        return new FireShield(this.name, this.damage, this.description, this.type);
    }

}
