package com.company;

public class Item {
    public Item() {

    }

    private String name;
    private String description;
    private int level;
    private int requireLevel;
    private int stock;

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

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

    public enum Type { Usable, Unusable } private Type type;
    public enum Slot { Head, Chest, Feet, Finger, Hands, Legs, OneHand, TwoHand, MainHand, OffHand, Ranged, Waist, Wrist, Neck, Shoulder, Cloaks, Trinket } private Slot slot;
}
