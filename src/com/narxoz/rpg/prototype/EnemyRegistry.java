package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EnemyRegistry {

    private Map<String, Enemy> templates;

    public EnemyRegistry() {
        this.templates = new HashMap<>();
    }

    public void registerTemplate(String key, Enemy template) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Template key cannot be null or empty");
        }
        if (template == null) {
            throw new IllegalArgumentException("Template enemy cannot be null");
        }
        templates.put(key, template);
    }

    public Enemy createFromTemplate(String key) {
        if (!templates.containsKey(key)) {
            throw new IllegalArgumentException("Template '" + key + "' not found in registry");
        }
        Enemy template = templates.get(key);
        return template.clone();
    }

    public Set<String> listTemplates() {
        return templates.keySet();
    }

    public boolean hasTemplate(String key) {
        return templates.containsKey(key);
    }

    public void removeTemplate(String key) {
        templates.remove(key);
    }

    public void clear() {
        templates.clear();
    }

}
