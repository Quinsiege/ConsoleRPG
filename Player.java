package com.company;
import java.util.ArrayList;

public class Player extends Person {
    public Player(String name) {
        setName(name);
    }

    private int strength;
    private int agillity;
    private int intellegence;
    private int stamina;
    private int CP;
    public enum Race {  Human, Dwarf, NightElf, Gnome, Draenei, Worgen, Pandaren,
        Orc, Undead, Tauren, Troll, BloodElf, Goblin,
        VoidElf, LightforgedDraenei, DarkIronDwarf, KulTiran, Mechagnome,
        Nightborne, HighmountainTauren, MagharOrc, ZandalariTroll, Vulpera
    } private Race race;
    private ArrayList<Proffesion> proffesions = new ArrayList<Proffesion>();
    private ArrayList<Achievement> achievements = new ArrayList<Achievement>();
    private ArrayList<Currency> currencies = new ArrayList<Currency>();


    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public ArrayList<Proffesion> getProffesions() {
        return proffesions;
    }

    public void setProffesions(ArrayList<Proffesion> proffesions) {
        this.proffesions = proffesions;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<Achievement> achievements) {
        this.achievements = achievements;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgillity() {
        return agillity;
    }

    public void setAgillity(int agillity) {
        this.agillity = agillity;
    }

    public int getIntellegence() {
        return intellegence;
    }

    public void setIntellegence(int intellegence) {
        this.intellegence = intellegence;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }
}
