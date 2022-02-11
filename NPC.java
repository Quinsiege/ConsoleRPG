package com.company;

public class NPC extends Person{
    public NPC(String name) {
        setName(name);
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public enum Kingdom { Abberation, Critter, Demon, Dragonkin, Elemental, Giant, Humanoid, Mechanical, Beast } private Kingdom kingdom;
    public enum Classification { Normal, Elite, Rare, RareElite, Boss } private Classification classification;
    public enum Agency { Trainer, Vendor } private Agency agency;
}
