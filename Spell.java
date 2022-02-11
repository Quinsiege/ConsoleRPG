package com.company;
import java.util.ArrayList;

public class Spell {
    public Spell(String name) {
        setName(name);
        setDamage(30);
        setManaCost(15);
        setRange(40);
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public void setEffects(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public float getGCD() {
        return GCD;
    }

    public void setGCD(float GCD) {
        this.GCD = GCD;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private String name;
    private String description;
    private int level;
    private ArrayList<Effect> effects = new ArrayList<Effect>();
    private int range;
    private float manaCost;
    private float damage;
    private float GCD;

    public float getManaCost() {
        return manaCost;
    }

    public void setManaCost(float manaCost) {
        this.manaCost = manaCost;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public enum Type { Passive, Active } private Type type;
    public enum School { Physical, Arcane, Fire, Frost, Nature, Shadow, Holy } private School school;

    private class Effect {
        Effect() {
            setActive(false);
        }

        public void Summon(Object object) {

        }

        private boolean isActive;

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }
    }

}
