package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Game implements ActionListener {

    JFrame frame = new JFrame();

    public Game() {
        setPlayers(new ArrayList<Player>());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);

        // ЗАПОЛНЕНИЕ COMBOBOX МЕНЮ СОЗДАНИЯ ПЕРСОНАЖА
        JTextField textField = new JTextField();

        DefaultComboBoxModel<Player.Gender> genders = new DefaultComboBoxModel<Player.Gender>();
        for (Player.Gender gender: Player.Gender.values()) {
            genders.addElement(gender);
        }
        JComboBox<Player.Gender> genderList = new JComboBox<Player.Gender>(genders);

        DefaultComboBoxModel<Player.Fraction> fractions = new DefaultComboBoxModel<Player.Fraction>();
        for (Player.Fraction fraction: Player.Fraction.values()) {
            fractions.addElement(fraction);
        }
        JComboBox<Player.Fraction> fractionList = new JComboBox<Player.Fraction>(fractions);

        DefaultComboBoxModel<Player.Race> races = new DefaultComboBoxModel<Player.Race>();
        JComboBox<Player.Race> raceList = new JComboBox<Player.Race>(races);

        DefaultComboBoxModel<Player.Class> classes = new DefaultComboBoxModel<Player.Class>();
        JComboBox<Player.Class> classList = new JComboBox<Player.Class>(classes);

        DefaultComboBoxModel<Player> players = new DefaultComboBoxModel<Player>();
        DefaultComboBoxModel<String> playersInfo = new DefaultComboBoxModel<String>();
        JComboBox<Player> playerList = new JComboBox<Player>(players);
        JComboBox<String> playerInfoList = new JComboBox<String>(playersInfo);

        JButton acceptButton = new JButton("Подтвердить");


        // JPanel -> МЕНЮ СОЗДАНИЯ ПЕРСОНАЖА
        JPanel creationMenu = new JPanel();
        creationMenu.setLayout(null);
        creationMenu.setVisible(false);
        creationMenu.setBounds (10, 100, 200, 400);
        textField.setBounds(10, 100, 180, 30);
        genderList.setBounds(10, 140, 180, 30);
        fractionList.setBounds(10, 180, 180, 30);
        raceList.setBounds(10, 220, 180, 30);
        classList.setBounds(10, 260, 180, 30);
        acceptButton.setBounds(10, 300, 180, 30);
        creationMenu.add(textField);
        creationMenu.add(genderList);
        creationMenu.add(raceList);
        creationMenu.add(fractionList);
        creationMenu.add(classList);
        creationMenu.add(acceptButton);

        // JPanel -> МЕНЮ ВЫБОРА ПЕРСОНАЖА
        JPanel chooseMenu = new JPanel();
        chooseMenu.setLayout(null);
        chooseMenu.setVisible(false);
        chooseMenu.setBounds(20, 200, 180, 100);
        JButton chooseButton = new JButton("Выбрать");
        playerInfoList.setBounds(20, 200, 180, 30);
        chooseButton.setBounds (20, 240, 180, 30);
        chooseMenu.add(playerInfoList);
        chooseMenu.add(chooseButton);

        // JPanel -> МЕНЮ УДАЛЕНИЕ ПЕРСОНАЖА
        JPanel deleteMenu = new JPanel();
        deleteMenu.setLayout(null);
        deleteMenu.setVisible(false);
        deleteMenu.setBounds(20, 200, 180, 100);
        JButton deleteButton = new JButton("Удалить");
        playerInfoList.setBounds(20, 200, 180, 30);
        deleteButton.setBounds (20, 240, 180, 30);
        deleteMenu.add(playerInfoList);
        deleteMenu.add(deleteButton);

        // JPanel -> МЕНЮ КНОПОК
        JPanel buttons = new JPanel();
        buttons.setLayout(null);
        buttons.setBounds(10, 10, 200, 120);
        JButton createCharacter = new JButton("Создать персонажа");
        JButton deleteCharacter = new JButton("Удалить персонажа");
        JButton chooseCharacter = new JButton("Выбрать персонажа");
        createCharacter.setBounds(10, 10, 180, 30);
        deleteCharacter.setBounds(10, 50, 180, 30);
        chooseCharacter.setBounds(10, 90, 180, 30);
        buttons.add(createCharacter);
        buttons.add(deleteCharacter);
        buttons.add(chooseCharacter);

        // ОБРАБОТЧИКИ СОБЫТИЙ
        createCharacter.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                creationMenu.setVisible(true);
                chooseMenu.setVisible(false);
                deleteMenu.setVisible(false);
            }
        });
        chooseCharacter.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                creationMenu.setVisible(false);
                deleteMenu.setVisible(false);
                chooseMenu.setVisible(true);
            }
        });
        deleteCharacter.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                creationMenu.setVisible(false);
                chooseMenu.setVisible(false);
                deleteMenu.setVisible(true);
            }
        });
        acceptButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                players.removeAllElements();
                playersInfo.removeAllElements();
                getPlayers().add(new Player(textField.getText(), (Player.Gender)genderList.getSelectedItem(), (Person.Fraction)fractionList.getSelectedItem(), (Player.Race) raceList.getSelectedItem(), (Player.Class) classList.getSelectedItem()));
                for (Player player : getPlayers()) {
                    players.addElement(player);
                    playersInfo.addElement(player.getName() + " (" + player.getaClass () + ")\t Ур. " + player.getLevel());
                }
                creationMenu.setVisible(false);
            }
        });
        raceList.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox jComboBox = (JComboBox)e.getSource();
                Player.Race race = (Player.Race)jComboBox.getSelectedItem();
                classes.removeAllElements();

                switch (race) {
                    case Human:
                        classes.addElement(Player.Class.Warrior);
                        classes.addElement(Player.Class.Mage);
                        classes.addElement(Player.Class.Priest);
                        classes.addElement(Player.Class.Paladin);
                        break;
                    case NightElf:
                        classes.addElement(Player.Class.Priest);
                        classes.addElement(Player.Class.Paladin);
                        break;
                    case Orc:
                        classes.addElement(Player.Class.Warrior);
                        classes.addElement(Player.Class.Mage);
                        break;
                    default:
                        break;
                }
            }
        });
        fractionList.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox jComboBox = (JComboBox)e.getSource();
                Player.Fraction fraction = (Person.Fraction)jComboBox.getSelectedItem();
                races.removeAllElements();
                switch (fraction) {
                    case Alliance:
                        races.addElement(Player.Race.Human);
                        races.addElement(Player.Race.Dwarf);
                        races.addElement(Player.Race.NightElf);
                        races.addElement(Player.Race.Gnome);
                        races.addElement(Player.Race.Draenei);
                        races.addElement(Player.Race.Worgen);
                        races.addElement(Player.Race.Pandaren);
                        break;
                    case Horde:
                        races.addElement(Player.Race.Orc);
                        races.addElement(Player.Race.Tauren);
                        races.addElement(Player.Race.Troll);
                        races.addElement(Player.Race.Undead);
                        races.addElement(Player.Race.BloodElf);
                        races.addElement(Player.Race.Goblin);
                        races.addElement(Player.Race.Pandaren);
                        break;
                    default:
                        break;
                }
            }
        });
        deleteButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getPlayers().size() > 0) {
                    getPlayers ().remove (playerInfoList.getSelectedIndex ());
                    playerList.removeItemAt (playerInfoList.getSelectedIndex ());
                    playerInfoList.removeItemAt (playerInfoList.getSelectedIndex ());
                    deleteMenu.setVisible (false);
                }
            }
        });


        frame.add(buttons);
        frame.add(creationMenu);
        frame.add(chooseMenu);
        frame.add(deleteMenu);

        frame.setVisible(true);
    }

    // GETTERS & SETTERS
    public boolean isLaunched() {
        return isLaunched;
    }
    public void setLaunched(boolean launched) {
        isLaunched = launched;
    }
    public int getChoice() {
        return choice;
    }
    public void setChoice(int choice) {
        this.choice = choice;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public ArrayList<Object> getObjects() {
        return objects;
    }
    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public ArrayList<NPC> getNpcs() {
        return npcs;
    }
    public void setNpcs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
    }

    // ПОЛЯ И ОБЪЕКТЫ
    private boolean isLaunched = false;
    private ArrayList<Object> objects;
    private ArrayList<Player> players;
    private ArrayList<NPC> npcs;
    private int choice;
}
