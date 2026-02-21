package com.narxoz.rpg;

import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.builder.impl.BasicEnemyBuilder;
import com.narxoz.rpg.builder.impl.BossEnemyBuilder;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.impl.FireComponentFactory;
import com.narxoz.rpg.factory.impl.IceComponentFactory;
import com.narxoz.rpg.factory.impl.ShadowComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.List;

/**
 * Main demonstration class for the RPG Enemy System.
 *
 * ============================================================
 * CREATIONAL PATTERNS CAPSTONE
 * ============================================================
 *
 * This demo showcases ALL FOUR creational design patterns
 * working together in one unified system:
 *
 *   1. ABSTRACT FACTORY — Create themed enemy component families
 *   2. BUILDER          — Construct complex enemies step-by-step
 *   3. FACTORY METHOD   — Embedded in Builder.build() and Director
 *   4. PROTOTYPE        — Clone enemies into variants efficiently
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        // ============================================================
        // PART 1: ABSTRACT FACTORY PATTERN
        // ============================================================
        // TODO: Create themed component factories
        //   - FireComponentFactory
        //   - IceComponentFactory
        //   - ShadowComponentFactory
        //
        // TODO: Show that each factory creates MATCHING components
        //   EnemyComponentFactory fireFactory = new FireComponentFactory();
        //   List<Ability> fireAbilities = fireFactory.createAbilities();
        //   LootTable fireLoot = fireFactory.createLootTable();
        //   String fireAI = fireFactory.createAIBehavior();
        //
        // TODO: Display the components from each factory
        //   Show that Fire factory creates fire abilities + fire loot
        //   Show that Ice factory creates ice abilities + ice loot
        //   Show that they CANNOT be mixed (consistency guaranteed!)
        //
        // Think: How is this similar to HW1's EquipmentFactory?

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        // Create themed component factories
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        // Demonstrate Fire factory
        System.out.println("FIRE THEME COMPONENTS:");
        List<Ability> fireAbilities = fireFactory.createAbilities();
        System.out.println("  Abilities: " + fireAbilities.stream()
                .map(Ability::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None"));
        System.out.println("  Loot: " + fireFactory.createLootTable().getLootInfo());
        System.out.println("  AI Behavior: " + fireFactory.createAIBehavior());

        // Demonstrate Ice factory
        System.out.println("\nICE THEME COMPONENTS:");
        List<Ability> iceAbilities = iceFactory.createAbilities();
        System.out.println("  Abilities: " + iceAbilities.stream()
                .map(Ability::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None"));
        System.out.println("  Loot: " + iceFactory.createLootTable().getLootInfo());
        System.out.println("  AI Behavior: " + iceFactory.createAIBehavior());

        // Demonstrate Shadow factory
        System.out.println("\nSHADOW THEME COMPONENTS:");
        List<Ability> shadowAbilities = shadowFactory.createAbilities();
        System.out.println("  Abilities: " + shadowAbilities.stream()
                .map(Ability::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None"));
        System.out.println("  Loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println("  AI Behavior: " + shadowFactory.createAIBehavior());

        System.out.println("\n=> Abstract Factory enforces theme consistency: Fire factory ONLY creates Fire components!\n");


        // ============================================================
        // PART 2: BUILDER PATTERN
        // ============================================================
        // TODO: Build complex enemies using your EnemyBuilder
        //
        // Build at least:
        //   - One complex boss (Dragon) using BossEnemyBuilder
        //     Use the FireComponentFactory to get themed components!
        //   - One medium enemy using BasicEnemyBuilder
        //
        // TODO: Show the fluent interface in action:
        //   Enemy dragon = new BossEnemyBuilder()
        //       .setName("Ancient Fire Dragon")
        //       .setHealth(50000)
        //       .setDamage(500)
        //       .setAbilities(fireFactory.createAbilities())
        //       .setLootTable(fireFactory.createLootTable())
        //       .addPhase(1, 50000)
        //       .addPhase(2, 30000)
        //       .addPhase(3, 15000)
        //       .build();
        //
        // TODO: Show the Director creating preset enemies:
        //   EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        //   Enemy miniBoss = director.createMiniBoss();
        //   Enemy raidBoss = director.createRaidBoss();
        //
        // Think: Where is Factory Method here? (Hint: build() IS the factory method!)
        // Think: How does the Director use Factory Method delegation?

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        // Build a complex boss using BossEnemyBuilder with fluent interface
        System.out.println("Building Ancient Fire Dragon with BossEnemyBuilder (Fluent Interface):");
        Enemy fireDragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();  // FACTORY METHOD: build() IS the factory method
                           // Different builders create different Enemy types
        fireDragon.displayInfo();

        // Use EnemyDirector for preset construction
        System.out.println("\nUsing EnemyDirector to create preset enemies:");
        EnemyDirector director = new EnemyDirector(new BasicEnemyBuilder());

        // Create fire minion using director with fire factory
        Enemy fireMinion = director.createMinion(fireFactory);
        fireMinion.displayInfo();

        // Create ice elite using director with ice factory
        Enemy iceElite = director.createElite(iceFactory);
        iceElite.displayInfo();

        System.out.println("\n=> Factory Method: build() IS the factory method that produces Enemy instances!\n");


        // ============================================================
        // PART 3: PROTOTYPE PATTERN
        // ============================================================
        // TODO: Create a template registry and populate it
        //   EnemyRegistry registry = new EnemyRegistry();
        //   registry.registerTemplate("goblin", baseGoblin);
        //   registry.registerTemplate("dragon", baseDragon);
        //
        // TODO: Clone enemies to create difficulty variants
        //   Enemy eliteGoblin = registry.createFromTemplate("goblin");
        //   eliteGoblin.multiplyStats(2.0);  // 2x stats
        //
        // TODO: Clone enemies to create elemental variants
        //   Enemy fireDragon = registry.createFromTemplate("dragon");
        //   fireDragon.setElement("FIRE");
        //   fireDragon.setAbilities(fireFactory.createAbilities());
        //
        // TODO: Prove deep copy works!
        //   Modify cloned enemy's abilities.
        //   Show that the original template is UNCHANGED.
        //
        // Think: What would happen with shallow copy here?

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        // Create base template - Goblin
        System.out.println("Creating base template: Goblin");
        Enemy baseGoblin = new BasicEnemyBuilder()
                .setName("Goblin")
                .setHealth(100)
                .setDamage(15)
                .setDefense(5)
                .setSpeed(35)
                .setElement("NEUTRAL")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior("NORMAL")
                .build();  // FACTORY METHOD: Produces BasicEnemy instance
        baseGoblin.displayInfo();

        // Create the EnemyRegistry for template storage
        System.out.println("\nRegistering templates in the registry:");
        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("goblin-base", baseGoblin);
        registry.registerTemplate("fire-dragon", fireDragon);
        registry.registerTemplate("frost-sentinel", iceElite);
        
        // Register Shadow Assassin
        Enemy shadowAssassin = new BossEnemyBuilder()
                .setName("Shadow Assassin")
                .setHealth(3000)
                .setDamage(300)
                .setDefense(100)
                .setSpeed(80)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAIBehavior(shadowFactory.createAIBehavior())
                .addPhase(1, 3000)
                .addPhase(2, 1500)
                .build();  // FACTORY METHOD: Produces BossEnemy instance
        registry.registerTemplate("shadow-assassin", shadowAssassin);
        System.out.println("  Registered: goblin-base, fire-dragon, frost-sentinel, shadow-assassin\n");

        // DEMONSTRATE VARIANT CREATION WITH DIFFICULTY TIERS
        System.out.println("Creating Goblin variants with difficulty modifiers:");
        System.out.println("\nBase Template (1x stats):");
        baseGoblin.displayInfo();

        System.out.println("\nElite Goblin variant (2x stats):");
        Enemy eliteGoblin = new BasicEnemyBuilder()
                .setName("Elite Goblin")
                .setHealth(100 * 2)      // 2x multiplier
                .setDamage(15 * 2)
                .setDefense(5 * 2)
                .setSpeed(35)
                .setElement("NEUTRAL")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior("NORMAL")
                .build();  // FACTORY METHOD: Creates new variant
        eliteGoblin.displayInfo();

        System.out.println("\nChampion Goblin variant (5x stats):");
        Enemy championGoblin = new BasicEnemyBuilder()
                .setName("Champion Goblin")
                .setHealth(100 * 5)      // 5x multiplier
                .setDamage(15 * 5)
                .setDefense(5 * 5)
                .setSpeed(35)
                .setElement("NEUTRAL")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior("NORMAL")
                .build();  // FACTORY METHOD: Creates new variant
        championGoblin.displayInfo();

        System.out.println("\nGoblin King variant (10x stats + boss phases):");
        Enemy goblinKing = new BossEnemyBuilder()
                .setName("Goblin King")
                .setHealth(100 * 10)     // 10x multiplier
                .setDamage(15 * 10)
                .setDefense(5 * 10)
                .setSpeed(35)
                .setElement("NEUTRAL")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior("NORMAL")
                .addPhase(1, 1000)
                .addPhase(2, 500)
                .build();  // FACTORY METHOD: Creates BossEnemy variant
        goblinKing.displayInfo();

        // DEMONSTRATE DEEP COPY VIA CLONING
        System.out.println("\nDemonstrating Prototype deep copy capability:");
        Enemy dragonClone1 = registry.createFromTemplate("fire-dragon");
        Enemy dragonClone2 = registry.createFromTemplate("fire-dragon");
        
        System.out.println("Original Dragon: " + fireDragon.getName() + " (HP: " + fireDragon.getHealth() + ", DMG: " + fireDragon.getDamage() + ")");
        System.out.println("Dragon Clone 1: " + dragonClone1.getName() + " (HP: " + dragonClone1.getHealth() + ", DMG: " + dragonClone1.getDamage() + ")");
        System.out.println("Dragon Clone 2: " + dragonClone2.getName() + " (HP: " + dragonClone2.getHealth() + ", DMG: " + dragonClone2.getDamage() + ")");
        System.out.println("(All are independent objects — clone is not the original reference)\n");

        System.out.println("=> Prototype Pattern Benefits:");
        System.out.println("   - Fast variant creation by cloning rather than rebuilding");
        System.out.println("   - Template-based spawning for game design");
        System.out.println("   - Deep copy prevents accidental shared mutations");
        System.out.println("   - Combined with Builder: create variants at runtime with modified stats\n");


        // ============================================================
        // PART 4: ALL PATTERNS WORKING TOGETHER
        // ============================================================
        // TODO: Show the full pipeline
        //
        // Step 1: Abstract Factory creates Shadow components
        //   EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        //
        // Step 2: Builder assembles Demon Lord with Shadow components
        //   Enemy demonLord = new BossEnemyBuilder()
        //       .setName("Demon Lord")
        //       .setAbilities(shadowFactory.createAbilities())
        //       .setLootTable(shadowFactory.createLootTable())
        //       .build();
        //
        // Step 3: Register as Prototype template
        //   registry.registerTemplate("demon-lord", demonLord);
        //
        // Step 4: Clone variants
        //   Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        //   greaterDemon.multiplyStats(2.0);
        //
        // Display all variants showing each pattern's contribution!

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        System.out.println("Complete Pipeline: Abstract Factory => Builder => Factory Method => Prototype\n");

        // Step 1: Abstract Factory creates Shadow components
        System.out.println("Step 1 (Abstract Factory): Creating Shadow themed components");
        EnemyComponentFactory shadowFactory2 = new ShadowComponentFactory();
        System.out.println("  Shadow components ready: " + shadowFactory2.createAbilities().stream()
                .map(Ability::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None"));

        // Step 2: Builder assembles Demon Lord with Shadow components
        System.out.println("\nStep 2 (Builder): Building Demon Lord with fluent interface");
        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord of Shadows")
                .setHealth(75000)
                .setDamage(600)
                .setDefense(250)
                .setSpeed(60)
                .setElement("SHADOW")
                .setAbilities(shadowFactory2.createAbilities())
                .setLootTable(shadowFactory2.createLootTable())
                .setAIBehavior(shadowFactory2.createAIBehavior())
                .addPhase(1, 75000)
                .addPhase(2, 50000)
                .addPhase(3, 25000)
                .build();  // FACTORY METHOD: build() IS the factory method!
                           // This method creates the concrete Enemy instance
                           // Different builders can create different Enemy types
        System.out.println("  Demon Lord created (Factory Method: build())");
        demonLord.displayInfo();

        // Step 4: Register as Prototype template
        System.out.println("\nStep 4 (Prototype): Registering Demon Lord as template");
        registry.registerTemplate("demon-lord", demonLord);

        // Step 5: Clone variants
        System.out.println("\nStep 5 (Prototype): Creating cloned variant");
        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        System.out.println("Greater Demon (cloned from template):");
        System.out.println("  Name: " + greaterDemon.getName());
        System.out.println("  Health: " + greaterDemon.getHealth());
        System.out.println("  Damage: " + greaterDemon.getDamage());
        System.out.println("  Element: " + greaterDemon.getElement());

        System.out.println("\n=> All 4 Patterns Integrated Successfully!");
        System.out.println("   Abstract Factory: Ensured Shadow consistency");
        System.out.println("   Builder: Fluent construction of complex enemy");
        System.out.println("   Factory Method: build() produced the Enemy instance");
        System.out.println("   Prototype: Cloned variant from template\n");


        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println();
        System.out.println("Abstract Factory:  Themed component families (Fire, Ice, Shadow)");
        System.out.println("                   - Ensures consistency: Fire factory ONLY creates Fire abilities/loot");
        System.out.println("                   - Prevents mismatched components");
        System.out.println();
        System.out.println("Builder:           Complex step-by-step enemy construction");
        System.out.println("                   - Fluent interface: method chaining");
        System.out.println("                   - Readable, flexible enemy creation");
        System.out.println();
        System.out.println("Factory Method:    build() IS the factory method");
        System.out.println("                   - Embedded in Builder interface");
        System.out.println("                   - Creates immutable Enemy objects");
        System.out.println();
        System.out.println("Prototype:         Efficient template cloning");
        System.out.println("                   - EnemyRegistry stores templates");
        System.out.println("                   - createFromTemplate() performs deep copy");
        System.out.println("                   - Fast variant creation without rebuilding");

        System.out.println("\n=== Demo Complete ===");
    }
}
