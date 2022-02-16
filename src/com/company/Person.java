package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Person {
    public Person() {
        setName("");
        setHealth(50);
        setMana(100);
    }

    public void Say(String phrase) {
        System.out.println(getName() + " говорит: " + phrase);
    }
    public void MoveTo(Location location, int positionX, int positionY) {
        setLocation(location);
        setPositionX(positionX);
        setPositionY(positionY);
        System.out.println(getName() + " перемещается в локацию '" + getLocation().getName() + "' на координаты [" + getPositionX() + ";" + getPositionY() + "]");
    }
    public void LookAt(Person person) {
        if (person.getLocation() != this.getLocation()) {
            System.out.println(this.getName() + " не может посмотреть на " + person.getName());
            return;
        } else if (person.getPositionX() < (this.getPositionX() - 25) || person.getPositionX() > (this.getPositionX() + 25)) {
            System.out.println(this.getName() + " не может посмотреть на " + person.getName());
            return;
        } else if (person.getPositionY() < (this.getPositionY() - 25) || person.getPositionY() > (this.getPositionY() + 25)) {
            System.out.println(this.getName() + " не может посмотреть на " + person.getName());
            return;
        } else {
            System.out.println(this.getName() + " смотрит на " + person.getName());
            return;
        }
    }
    public void Loot(Person person) {
        if (!person.isDead()) {
            System.out.println("Невозможно подобрать добычу. Цель жива.");
        }
        else {
            return;
        }
    }
    public void Drop(Item item) {
        for (int i = 0; i < this.getBags().get(0).getItems().size(); i++) {
            if (this.getBags ().get (0).getItems ().get(i).get (0) == item) {
                if (this.getBags ().get (0).getItems ().get(i).size() == 1) {
                    this.getBags ().get (0).getItems ().remove (i);
                }
                else if (this.getBags ().get (0).getItems ().get(i).size() > 1) {
                    this.getBags ().get (0).getItems ().get (i).remove (0);
                }
                return;
            }
        }
        return;
    }
    public void ShiftItem(int fromBag, int fromItem, int toBag, int toItem) {
        ArrayList<Item> temp = new ArrayList<Item>();
        // Проверяем наличие предмета в слоте, куда переместим предмет
        if (this.getBags().get(toBag).getItems().get(toItem).size() != 0) {
            // Предметы идентичны
            if (this.getBags ().get (fromBag).getItems ().get (fromItem).get (0) == this.getBags ().get (toBag).getItems ().get (toItem).get (0)) {
                // Проверяем возможность стакнуть предметы
                if (this.getBags ().get (toBag).getItems ().get (toItem).size () + 1 <=
                        this.getBags ().get (toBag).getItems ().get (toItem).get (0).getLimitInStock ()) {
                    this.getBags ().get (toBag).getItems ().get (toItem).add (this.getBags ().get (fromBag).getItems ().get (fromItem).get (0));
                    this.getBags ().get (fromBag).getItems ().get (fromItem).remove (this.getBags ().get (fromBag).getItems ().get (fromItem).size () - 1);
                    return;
                }
            }
            else {
                temp = this.getBags().get(fromBag).getItems().get(fromItem);
                this.getBags().get(fromBag).getItems().set(fromItem, this.getBags().get(toBag).getItems().get(toItem));
                this.getBags().get(toBag).getItems().set(toItem, temp);
                return;
            }
        }
        temp = this.getBags().get(fromBag).getItems().get(fromItem);
        this.getBags().get(fromBag).getItems().set(fromItem, this.getBags().get(toBag).getItems().get(toItem));
        this.getBags().get(toBag).getItems().set(toItem, temp);
        return;
    }
    public void Take(Item item) {
        // Проверяем каждую сумку
        for (int i = 0; i < this.getBags().size(); i++) {
            // Ищем предмет, который идентичен подбираемому
            for (int j = 0; j < this.getBags().get(i).getItems().size(); j++) {
                // Ищем непустую ячейку
                if (this.getBags().get(i).getItems().get(j).size() > 0) {
                    // Предмет идентичен найденному
                    if (this.getBags().get(i).getItems().get(j).get(0) == item) {
                        // Проверяем можно ли положить подбираемые предмет в эту связку
                        if (this.getBags().get(i).getItems().get(j).size() + 1 <=
                                this.getBags().get(i).getItems().get(j).get(0).getLimitInStock()
                        ) {
                            this.getBags().get(i).getItems().get(j).add(item);
                            return;
                        }
                    }
                }
            }
            // Ищем пустую ячейку
            if (this.getBags().get(i).getItems().size() < this.getBags().get(i).getLimitInStock()) {
                this.getBags ().get(i).getItems ().add(new ArrayList<Item> ());
                this.getBags().get(i).getItems().get(this.getBags().get(i).getItems().size() - 1).add(item);
                return;
            }
        }
        System.out.println("Невозможно подобрать добычу. Все сумки переполнены");
        return;
    }
    public void TradeOffer(Person person, Item give, Item take) {

    }
    public void Learn(Spell spell) {
        if (getSpells().contains(spell)) {
            System.out.println(spell.getName() + " уже изучен.");
        }
        else {
            spells.add(spell);
            System.out.println(spell.getName() + " успешно изучен.");
        }
        return;
    }
    public float Cast(Spell spell) {
        if (!this.getSpells().contains(spell)) {
            System.out.println("Невозможно использовать это умение. Умение не выучено.");
            return 0;
        }
        else if (this.getMana() < spell.getManaCost()) {
            System.out.println("Невозможно использовать это умение. Недостаточно маны.");
            return 0;
        }
        else {
            System.out.println("Использовано умение " + spell.getName());
            return spell.getDamage();
        }
    }
    public void Attack(Person person) {
        if (this.getFraction() == person.getFraction()) {
            System.out.println("Невозможно атаковать. Цель состоит в вашей фракции.");
            return;
        }
        else if (person.isDead()) {
            System.out.println("Невозможно атаковать. Цель мертва.");
            return;
        }
        else if (person.getLocation() != this.getLocation()) {
            System.out.println("Невозможно атаковать. Цель слишком далеко.");
            return;
        }
        else {
            for (int i = 0; i < this.spells.size(); i++) {
                System.out.println((i + 1) + ". Использовать " + this.spells.get(i).getName());
            }
            InputChoice();

            Spell spell = this.spells.get(getChoice() - 1);
            System.out.println();

            if (spell.getRange() < Math.abs(person.getPositionX() - this.getPositionX())) {
                System.out.println("Невозможно атаковать. Цель слишком далеко.");
                return;
            }
            else if (spell.getRange() < Math.abs(person.getPositionY() - this.getPositionY())) {
                System.out.println("Невозможно атаковать. Цель слишком далеко.");
                return;
            }
            else {
                person.setHealth(person.getHealth() - this.Cast(spell));
                this.setMana(this.getMana() - spell.getManaCost());
                System.out.println("Текущее здоровье цели: " + person.getHealth());
                return;
            }
        }
    }
    private void InputChoice() {
        System.out.print("Выбрать: ");
        setChoice(getScanner().nextInt());
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getHealth() {
        return health;
    }
    public void setHealth(float health) {
        if (health < 0) {
            this.health = 0;
            this.setDead(true);
        }
        else {
            this.health = health;
        }
    }
    public float getMana() {
        return mana;
    }
    public void setMana(float mana) {
        this.mana = mana;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public boolean isDead() {
        return isDead;
    }
    public void setDead(boolean dead) {
        isDead = dead;
    }
    public ArrayList<Spell> getSpells() {
        return spells;
    }
    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }
    public int getChoice() {
        return choice;
    }
    public void setChoice(int choice) {
        this.choice = choice;
    }
    public Fraction getFraction() {
        return fraction;
    }
    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public ArrayList<Bag> getBags() {
        return bags;
    }
    public void setBags(ArrayList<Bag> bags) {
        this.bags = bags;
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

    private String name;
    private float health;
    private float mana;
    private Location location;
    private int positionX;
    private int positionY;
    private int level;
    private int choice;
    private boolean isDead;
    private ArrayList<Spell> spells = new ArrayList<Spell>();
    private ArrayList<Bag> bags = new ArrayList<Bag>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Fraction { Alliance, Horde } private Fraction fraction;
    public enum Kingdom { Abberation, Critter, Demon, Dragonkin, Elemental, Giant, Humanoid, Mechanical, Beast } private Kingdom kingdom;
    public enum Classification { Normal, Elite, Rare, RareElite, Boss } private Classification classification;
    private Scanner scanner = new Scanner(System.in);
    private String description;
}
