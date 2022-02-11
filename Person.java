package com.company;

import java.util.ArrayList;
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
    public void LookAtPerson(Person person) {
        if (person.getLocation() != this.getLocation()) {
            System.out.println(this.getName() + " не может посмотреть на " + person.getName());
            return;
        }
        else if (person.getPositionX() < (this.getPositionX() - 25) || person.getPositionX() > (this.getPositionX() + 25)) {
            System.out.println(this.getName() + " не может посмотреть на " + person.getName());
            return;
        }
        else if (person.getPositionY() < (this.getPositionY() - 25) || person.getPositionY() > (this.getPositionY() + 25)) {
            System.out.println(this.getName() + " не может посмотреть на " + person.getName());
            return;
        }
        else {
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

    public void Learn(Spell spell) {
        if (getSpells().contains(spell)) {
            System.out.println(spell.getName() + " уже изучен.");
            return;
        }

        spells.add(spell);
        System.out.println(spell.getName() + " успешно изучен.");
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
            System.out.println("Использовано умение " + spell.getName() + ", наносящее " + spell.getDamage() + " ед. урона");
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

    public void ShowInfo() {
        System.out.println("Имя: " + this.getName());
        System.out.println("Здоровье: " + this.getHealth());
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

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
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
    private ArrayList<Currency> currencies = new ArrayList<Currency>();
    public enum Fraction { Alliance, Horde } private Fraction fraction;
    private Scanner scanner = new Scanner(System.in);
    public enum React { Alliance, Horde, Both } private React react;


    public React getReact() {
        return react;
    }

    public void setReact(React react) {
        this.react = react;
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
}
