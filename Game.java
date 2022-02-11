package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Game() {
        setLaunched(true);
    }

    public void MainMenu() {
        System.out.println("1. Меню создания");
        System.out.println("2. Закрыть программу");
        InputChoice();

        switch (getChoice()) {
            case 1:
                CreationMenu();
                break;
            case 2:
                setLaunched(false);
                break;
        }
    }
    public void CreationMenu() {
        System.out.println("1. Создать существо");
        System.out.println("2. Создать объект");
        InputChoice();

        switch (getChoice()) {
            case 1:
                CreatePerson();
                break;
            case 2:
                CreateObject();
                break;
        }
    }

    public void CreatePerson() {
        System.out.println("1. Игрок");
        System.out.println("2. НПС");
        InputChoice();

        switch (getChoice()) {
            case 1:
                String name;

                System.out.print("Введите имя игрока: ");
                name = scanner.next();

                people.add(new Player(name));
                break;
            case 2:
                System.out.print("Введите имя НПС: ");
                scanner.nextLine();
                name = scanner.nextLine();
                people.add(new NPC(name));
                break;
            default:
                break;
        }
    }

    public void CreateObject() {
        System.out.println("1. Подземелье");
        System.out.println("2. Рейд");
        System.out.println("3. Город");
        System.out.println("4. Здание");
        InputChoice();

        switch (getChoice()) {
            case 1:
                objects.add(new Dungeon());
                break;
            case 2:
                objects.add(new Raid());
                break;
            case 3:
                objects.add(new City());
                break;
            case 4:
                objects.add(new Building());
                break;
        }
    }

    private void InputChoice() {
        System.out.print("Выбрать: ");
        setChoice(scanner.nextInt());
    }

    private Scanner scanner = new Scanner(System.in);
    private boolean isLaunched = false;
    private ArrayList<Object> objects = new ArrayList<Object>();
    private ArrayList<Person> people = new ArrayList<Person>();
    private int choice;

    public boolean isLaunched() {
        return isLaunched;
    }

    public void setLaunched(boolean launched) {
        isLaunched = launched;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
