package com.narxoz.rpg.combat.ability;

import com.narxoz.rpg.combat.Ability;

public class ShadowStrike implements Ability {

    private String name = "Shadow Strike";
    private int damage = 50;
    private String description = "Strike from the shadows with deadly precision, dealing high single-target damage and blinding the target";
    private String type = "DAMAGE";

    public ShadowStrike() {
    }

    private ShadowStrike(String name, int damage, String description, String type) {
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
        return new ShadowStrike(this.name, this.damage, this.description, this.type);
    }

}
