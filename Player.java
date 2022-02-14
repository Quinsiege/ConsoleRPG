package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {
    public Player(String name, Gender gender, Fraction fraction, Race race, Class aClass) {
        setName(name);
        setRace(race);
        setaClass(aClass);
        setFraction(fraction);
        setRace(race);
        setaClass(aClass);
        setLevel(1);
        setClassification(Classification.Normal);
        setStrength(0);
        setAgillity(0);
        setIntellegence(0);
        setStamina(0);
        setCP(0);
        setAchievements(new ArrayList<Achievement> ());
        setCurrencies(new ArrayList<Currency>());
        setProffesions(new ArrayList<Proffesion>());
        setGender(gender);
        setArmor(new ArrayList<Armor>());
        setWeapons(new ArrayList<Weapon>());
        setPositionX(0);
        setPositionY(0);
        setBags(new ArrayList<Bag>());
        setScanner(new Scanner(System.in));
        Location location;
        setRole(Role.Damage);
        switch (getFraction ()) {
            case Alliance:
                switch (getRace()) {
                    case Human:
                        setKingdom(Kingdom.Humanoid);
                        switch (getaClass ()) {
                            case Warrior:
                                location = new Location ("Элвинский лес");
                                setHealth(50);
                                setMana(50);
                                setDead(false);
                                setLocation(location);
                                break;
                            case Monk:
                                break;
                            case Rogue:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case Paladin:
                                break;
                            case Warlock:
                                break;
                            case DeathKnight:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Dwarf:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Rogue:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case Paladin:
                                break;
                            case Warlock:
                                break;
                            case DeathKnight:
                                break;
                            case Shaman:
                                break;
                            default:
                                break;
                        }
                    case NightElf:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Rogue:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case DeathKnight:
                                break;
                            case Druid:
                                break;
                            case DemonHunter:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Gnome:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Rogue:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case Warlock:
                                break;
                            case DeathKnight:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Draenei:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case DeathKnight:
                                break;
                            case Paladin:
                                break;
                            case Shaman:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Worgen:
                        ArrayList<Spell> spells = new ArrayList<Spell>();
                        spells.add(new Spell(1));
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case DeathKnight:
                                break;
                            case Warlock:
                                break;
                            case Druid:
                                break;
                            case Rogue:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Pandaren:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case DeathKnight:
                                break;
                            case Rogue:
                                break;
                            case Shaman:
                                break;
                            case Monk:
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case Horde:
                switch (race) {
                    case Orc:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Rogue:
                                break;
                            case Hunter:
                                break;
                            case Mage:
                                break;
                            case Warlock:
                                break;
                            case DeathKnight:
                                break;
                            case Shaman:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Undead:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Rogue:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case Warlock:
                                break;
                            case DeathKnight:
                                break;
                            default:
                                break;
                        }
                    case Tauren:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case DeathKnight:
                                break;
                            case Druid:
                                break;
                            case Paladin:
                                break;
                            case Shaman:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Troll:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Rogue:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case Warlock:
                                break;
                            case DeathKnight:
                                break;
                            case Shaman:
                                break;
                            case Druid:
                                break;
                            default:
                                break;
                        }
                        break;
                    case BloodElf:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Monk:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case DeathKnight:
                                break;
                            case Paladin:
                                break;
                            case Rogue:
                                break;
                            case Warlock:
                                break;
                            case DemonHunter:
                                break;
                            default:
                                break;
                        }
                        break;
                    case Goblin:
                        switch (aClass) {
                            case Warrior:
                                break;
                            case Hunter:
                                break;
                            case Priest:
                                break;
                            case Mage:
                                break;
                            case DeathKnight:
                                break;
                            case Warlock:
                                break;
                            case Rogue:
                                break;
                            case Shaman:
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    private int strength;
    private int agillity;
    private int intellegence;
    private int stamina;
    private int CP;

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ArrayList<Armor> getArmor() {
        return armor;
    }

    public void setArmor(ArrayList<Armor> armor) {
        this.armor = armor;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Race {  Human, Dwarf, NightElf, Gnome, Draenei, Worgen, Pandaren,
        Orc, Undead, Tauren, Troll, BloodElf, Goblin,
        VoidElf, LightforgedDraenei, DarkIronDwarf, KulTiran, Mechagnome,
        Nightborne, HighmountainTauren, MagharOrc, ZandalariTroll, Vulpera
    } private Race race;
    public enum Gender { Male, Female } private Gender gender;
    public enum Class { Warrior, Mage, Priest, Paladin, Shaman, Rogue, Warlock, Druid, Hunter, Monk, DeathKnight, DemonHunter } private Class aClass;
    public enum Role { Damage, Heal, Tank } private Role role;
    private ArrayList<Proffesion> proffesions = new ArrayList<Proffesion>();
    private ArrayList<Achievement> achievements = new ArrayList<Achievement>();
    private ArrayList<Currency> currencies = new ArrayList<Currency>();
    private ArrayList<Armor> armor = new ArrayList<Armor>();
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();


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
