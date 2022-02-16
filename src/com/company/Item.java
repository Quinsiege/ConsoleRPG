package com.company;

import java.util.ArrayList;

public class Item {
    public Item() {

    }
    public Item(String name) {
        setName(name);
        setDroppable(true);
        setLimitInStock(9999);
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

    public int getRequireLevel() {
        return requireLevel;
    }

    public void setRequireLevel(int requireLevel) {
        this.requireLevel = requireLevel;
    }

    public boolean isDroppable() {
        return isDroppable;
    }

    public void setDroppable(boolean droppable) {
        isDroppable = droppable;
    }

    public int getLimitInStock() {
        return limitInStock;
    }

    public void setLimitInStock(int limitInStock) {
        this.limitInStock = limitInStock;
    }

    public float getDPS() {
        return DPS;
    }

    public void setDPS(float DPS) {
        this.DPS = DPS;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Binds getBinds() {
        return binds;
    }

    public void setBinds(Binds binds) {
        this.binds = binds;
    }

    private String name;
    private String description;
    private int level;
    private int requireLevel;
    private int limitInStock;
    private float DPS;
    private float speed;
    private boolean isDroppable;
    private boolean isEquipped;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category { Weapon, Armor, Reagent } private Category category;
    public enum Type { Cloth, Leather, Mail, Plate, Cloaks,
        Daggers, FistWeapons, OneHandedAxes, OneHandMaces, OneHandSwords, Polearms, Staves,
        TwoHandedAxes, TwoHandedMaces, TwoHandedSwords, Warglaives, Bows, Crossbows, Guns,
        Thrown, Wands, FishingPoles, Miscellaneous } private Type type;
    public enum Slot { Back, Chest, Feet, Finger, Hands, Head,
        Legs, Neck, Shield, Shoulder, Trinket, Waist, Wrist, Tabard,
        MainHand, OffHand, OneHand, Ranged, TwoHand } private Slot slot;
    public enum Quality { Poor, Common, Uncommon, Rare, Epic, Legendary, Artifact } private Quality quality;
    public enum Binds { BindsWhenPickedUp, BindsWhenEquipped } private Binds binds;
}
