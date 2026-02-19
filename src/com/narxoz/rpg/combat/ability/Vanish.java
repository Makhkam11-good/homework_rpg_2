package com.narxoz.rpg.combat.ability;

import com.narxoz.rpg.combat.Ability;

public class Vanish implements Ability {

    private String name = "Vanish";
    private int damage = 0;
    private String description = "Meld into the shadows, gaining evasion and stealth to avoid incoming attacks";
    private String type = "DEFENSIVE";

    public Vanish() {
    }

    private Vanish(String name, int damage, String description, String type) {
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
        return new Vanish(this.name, this.damage, this.description, this.type);
    }

}
