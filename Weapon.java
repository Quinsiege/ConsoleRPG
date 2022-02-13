package com.company;

public class Weapon extends Item {
    public Weapon(String name, Weapon.Type type, Slot slot) {
        setName(name);
        setType(type);
        setSlot(slot);
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public int getMinimalDamage() {
        return minimalDamage;
    }

    public void setMinimalDamage(int minimalDamage) {
        this.minimalDamage = minimalDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Slot { MainHand, OffHand, OneHand, Ranged, TwoHand } private Slot slot;
    public enum Type {  Daggers, FistWeapons, OneHandedAxes, OneHandMaces, OneHandSwords, Polearms, Staves,
                        TwoHandedAxes, TwoHandedMaces, TwoHandedSwords, Warglaives, Bows, Crossbows, Guns,
                        Thrown, Wands, FishingPoles, Miscellaneous } private Type type;
    private int minimalDamage;
    private int maximumDamage;

}
