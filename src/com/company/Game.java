package com.company;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game implements ActionListener {

    JFrame frame = new JFrame();

    public Game() {
        frame.setTitle("Beyond the Truth");
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 4.5), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 6));
        setPlayers(new ArrayList<Player>());
        JLabel systemMessage = new JLabel("");
        systemMessage.setBounds(20, 160, 180, 30);
        systemMessage.setOpaque(true);
        systemMessage.setHorizontalAlignment(SwingConstants.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(810, 520);
        frame.setResizable(false);

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
        JComboBox<String> playerDeleteList = new JComboBox<String>(playersInfo);

        DefaultComboBoxModel<ArrayList<Item>> bags = new DefaultComboBoxModel<> ();
        DefaultComboBoxModel<String> bagsInfo = new DefaultComboBoxModel<> ();
        JComboBox<String> bagInfo = new JComboBox<String>(bagsInfo);
        JComboBox<ArrayList<Item>> bag = new JComboBox<ArrayList<Item>>(bags);

        DefaultComboBoxModel<String> spellsInfo = new DefaultComboBoxModel<> ();
        JComboBox<String> spellInfo = new JComboBox<String>(spellsInfo);

        DefaultComboBoxModel<String> equippmentInfo = new DefaultComboBoxModel<> ();
        JComboBox<String> equippmentList = new JComboBox<String>(equippmentInfo);

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

        // JPanel -> МЕНЮ ПЕРСОНАЖА
        JPanel playerMenu = new JPanel();
        playerMenu.setLayout(null);
        playerMenu.setVisible(false);
        // МЕНЮ ИНВЕНТАРЯ
        JLabel bagName = new JLabel("Предметы");
        JButton useItem = new JButton("Использовать");
        JButton showItemDesc = new JButton("Информация о предмете");
        bagName.setBounds(590, 20, 180, 15);
        bagInfo.setBounds(590, 40, 180, 30);
        useItem.setBounds(590, 80, 180, 30);
        showItemDesc.setBounds (590, 120, 180, 30);
        JLabel itemDesc = new JLabel("");
        itemDesc.setBounds(590, 140, 180, 200);
        bagInfo.setVisible(false);
        bagName.setVisible(false);
        useItem.setVisible(false);
        showItemDesc.setVisible(false);
        itemDesc.setVisible(false);
        // МЕНЮ УМЕНИЙ
        JLabel spellsName = new JLabel("Умения");
        JButton useSpell = new JButton("Использовать");
        spellsName.setBounds(590, 20, 180, 15);
        spellInfo.setBounds(590, 40, 180, 30);
        useSpell.setBounds(590, 80, 180, 30);
        spellInfo.setVisible(false);
        spellsName.setVisible(false);
        showItemDesc.setVisible(false);
        useSpell.setVisible(false);
        // МЕНЮ ТАРГЕТА
        JComboBox targets = new JComboBox();
        JLabel targetsName = new JLabel("Текущий таргет");
        JButton lootTarget = new JButton ("Подобрать добычу");
        targetsName.setBounds(210, 20, 180, 15);
        targets.setBounds(210, 40, 180, 30);
        lootTarget.setBounds(210, 80, 180, 30);
        JLabel equippmentName = new JLabel("Экипировка");
        equippmentName.setVisible(false);
        equippmentList.setVisible(false);
        equippmentName.setBounds(590, 20, 180, 15);
        equippmentList.setBounds(590, 40, 180, 30);
        JLabel playerInfo = new JLabel ();
        JButton showSpells = new JButton("Список умений");
        JButton showAchievements = new JButton("Список достижений");
        showAchievements.setEnabled(false);
        JButton showInventory = new JButton("Инвентарь");
        JButton back = new JButton("Вернуться назад");
        JButton showQuests = new JButton("Список заданий");
        showQuests.setEnabled(false);
        JButton showEquippment = new JButton ("Экипировка");
        playerMenu.setBounds(0, 0, 810, 520);
        playerInfo.setBounds(20, -20, 180, 400);
        showSpells.setBounds(20, 440, 180, 30);
        showAchievements.setBounds(210, 440, 180, 30);
        showInventory.setBounds(400, 440, 180, 30);
        back.setBounds(590, 440, 180, 30);
        showQuests.setBounds(20, 400, 180, 30);
        showEquippment.setBounds(210, 400, 180, 30);
        playerMenu.add(playerInfo);
        playerMenu.add(showSpells);
        playerMenu.add(showAchievements);
        playerMenu.add(showInventory);
        playerMenu.add(back);
        playerMenu.add(showQuests);
        playerMenu.add(showEquippment);
        playerMenu.add(bagInfo);
        playerMenu.add(bagName);
        playerMenu.add(useItem);
        playerMenu.add(showItemDesc);
        playerMenu.add(itemDesc);
        playerMenu.add(spellInfo);
        playerMenu.add(spellsName);
        playerMenu.add(useSpell);
        playerMenu.add(targetsName);
        playerMenu.add(targets);
        playerMenu.add(lootTarget);
        playerMenu.add(equippmentName);
        playerMenu.add(equippmentList);

        // JPanel -> МЕНЮ УДАЛЕНИЕ ПЕРСОНАЖА
        JPanel deleteMenu = new JPanel();
        deleteMenu.setLayout(null);
        deleteMenu.setVisible(false);
        deleteMenu.setBounds(10, 100, 200, 200);
        JButton deleteButton = new JButton("Удалить");
        playerDeleteList.setBounds(10, 100, 180, 30);
        deleteButton.setBounds(10, 140, 180, 30);
        deleteMenu.add(playerDeleteList);
        deleteMenu.add(deleteButton);

        // JPanel -> МЕНЮ ВЫБОРА ПЕРСОНАЖА
        JPanel chooseMenu = new JPanel();
        chooseMenu.setLayout(null);
        chooseMenu.setVisible(false);
        chooseMenu.setBounds(10, 100, 200, 200);
        JButton chooseButton = new JButton("Выбрать");
        playerInfoList.setBounds(10, 100, 180, 30);
        chooseButton.setBounds (10, 140, 180, 30);
        chooseMenu.add(playerInfoList);
        chooseMenu.add(chooseButton);

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

        systemMessage.setVisible(false);
        systemMessage.setForeground(Color.WHITE);
        systemMessage.setBackground(Color.decode("#323232"));


        // ОБРАБОТЧИКИ СОБЫТИЙ
        createCharacter.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                creationMenu.setVisible(true);
                deleteMenu.setVisible(false);
                chooseMenu.setVisible(false);
                systemMessage.setVisible(false);
            }
        });
        chooseCharacter.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                creationMenu.setVisible(false);
                deleteMenu.setVisible(false);
                chooseMenu.setVisible(true);
                systemMessage.setVisible(false);
            }
        });
        deleteCharacter.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMenu.setVisible(true);
                creationMenu.setVisible(false);
                chooseMenu.setVisible(false);
                systemMessage.setVisible(false);
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
                systemMessage.setVisible(true);
                systemMessage.setText("Персонаж создан");
                systemMessage.setBounds(20, 140, 180, 30);
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
                systemMessage.setVisible(false);
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
                systemMessage.setVisible(false);
            }
        });
        deleteButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getPlayers().size() > 0) {
                    getPlayers().remove(playerInfoList.getSelectedIndex ());
                    playerList.removeItemAt (playerInfoList.getSelectedIndex ());
                    playerInfoList.removeItemAt (playerInfoList.getSelectedIndex ());
                    systemMessage.setVisible(true);
                    systemMessage.setText("Персонаж удалён");
                    systemMessage.setBounds(20, 140, 180, 30);
                }
                deleteMenu.setVisible(false);
            }
        });
        chooseButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerInfoList.getSelectedIndex() >= 0) {
                    setCurrentPlayer (getPlayers ().get (playerInfoList.getSelectedIndex ()));
                    bagInfo.removeAllItems ();
                    for (int i = 0; i < getCurrentPlayer ().getBags ().get (0).getItems ().size (); i++) {
                        bagInfo.addItem (getCurrentPlayer ().getBags ().get (0).getItems ().get (i).get (0).getName () + " (" + getCurrentPlayer ().getBags ().get (0).getItems ().get (i).size () + " шт)");
                    }
                    spellInfo.removeAllItems ();
                    for (int i = 0; i < getCurrentPlayer ().getSpells ().size (); i++) {
                        spellsInfo.addElement (getCurrentPlayer ().getSpells ().get (i).getName () + " (" + getCurrentPlayer ().getSpells ().get (i).getLevel () + " ур)");
                    }
                    equippmentList.removeAllItems ();
                    for (int i = 0; i < getCurrentPlayer ().getWeapons ().size(); i++) {
                        equippmentList.addItem(getCurrentPlayer ().getWeapons ().get (i).getName () + " (Слот: " + getCurrentPlayer ().getWeapons ().get (i).getSlot () + ")");
                    }
                    for (int i = 0; i < getCurrentPlayer ().getArmor ().size(); i++) {
                        equippmentList.addItem(getCurrentPlayer ().getArmor ().get (i).getName () + " (Слот: " + getCurrentPlayer ().getArmor ().get (i).getSlot () + ")");
                    }
                    buttons.setVisible (false);
                    chooseMenu.setVisible (false);
                    playerInfo.setText("<html>" + getCurrentPlayer ().getDescription () + "</html>");
                    playerMenu.setVisible (true);
                }
                else {
                    chooseMenu.setVisible (false);
                }
                systemMessage.setVisible(false);
            }
        });
        back.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMenu.setVisible(false);
                buttons.setVisible(true);
                systemMessage.setVisible(false);
            }
        });
        showInventory.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                bagInfo.setVisible(true);
                bagName.setVisible(true);
                useItem.setVisible(true);
                showItemDesc.setVisible(true);
                itemDesc.setVisible(false);

                spellInfo.setVisible(false);
                spellsName.setVisible(false);
                useSpell.setVisible(false);

                equippmentName.setVisible(false);
                equippmentList.setVisible (false);

                systemMessage.setVisible(false);
            }
        });
        showSpells.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                bagInfo.setVisible(false);
                bagName.setVisible(false);
                useItem.setVisible(false);
                showItemDesc.setVisible(false);
                itemDesc.setVisible(false);

                spellInfo.setVisible(true);
                spellsName.setVisible(true);
                useSpell.setVisible(true);

                equippmentName.setVisible(false);
                equippmentList.setVisible (false);

                systemMessage.setVisible(false);
            }
        });
        showEquippment.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                bagInfo.setVisible(false);
                bagName.setVisible(false);
                useItem.setVisible(false);
                showItemDesc.setVisible(false);
                itemDesc.setVisible(false);

                spellInfo.setVisible(false);
                spellsName.setVisible(false);
                useSpell.setVisible(false);

                equippmentName.setVisible(true);
                equippmentList.setVisible (true);

                systemMessage.setVisible(false);

                equippmentList.removeAllItems ();
                for (int i = 0; i < getCurrentPlayer ().getWeapons ().size(); i++) {
                    equippmentList.addItem(getCurrentPlayer ().getWeapons ().get (i).getName () + " (Слот: " + getCurrentPlayer ().getWeapons ().get (i).getSlot () + ")");
                }
                for (int i = 0; i < getCurrentPlayer ().getArmor ().size(); i++) {
                    equippmentList.addItem(getCurrentPlayer ().getArmor ().get (i).getName () + " (Слот: " + getCurrentPlayer ().getArmor ().get (i).getSlot () + ")");
                }
            }
        });
        Weapon weapon = new Weapon (1);
        Weapon weapon1 = new Weapon (2);
        lootTarget.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (targets.getSelectedItem () == null) {
                    systemMessage.setBounds(210, 120, 180, 30);
                    systemMessage.setText ("Цель не выбрана");
                    systemMessage.setVisible(true);
                }
                for (int i = 0; i < getCurrentPlayer ().getBags ().get (0).getItems ().size (); i++) {
                    bagInfo.addItem (getCurrentPlayer ().getBags ().get (0).getItems ().get (i).get (0).getName () + " (" + getCurrentPlayer ().getBags ().get (0).getItems ().get (i).size () + " шт)");
                    bag.addItem(getCurrentPlayer ().getBags ().get (0).getItems ().get (i));
                }
            }
        });
        useItem.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                systemMessage.setVisible(false);
                if (bagInfo.getSelectedItem() != null) {
                    if (getCurrentPlayer ().getBags ().get (0).getItems ().get (bagInfo.getSelectedIndex ()).get (0).getCategory () == Item.Category.Weapon) {
                        getCurrentPlayer ().EquipWeapon ((Weapon) getCurrentPlayer ().getBags ().get (0).getItems ().get (bagInfo.getSelectedIndex ()).get (0));
                    } else if (getCurrentPlayer ().getBags ().get (0).getItems ().get (bagInfo.getSelectedIndex ()).get (0).getCategory () == Item.Category.Armor) {
                        getCurrentPlayer ().EquipArmor ((Armor) getCurrentPlayer ().getBags ().get (0).getItems ().get (bagInfo.getSelectedIndex ()).get (0));
                    }
                    bag.removeAllItems ();
                    bagInfo.removeAllItems ();
                    for (int i = 0; i < getCurrentPlayer ().getBags ().get (0).getItems ().size (); i++) {
                        bagInfo.addItem (getCurrentPlayer ().getBags ().get (0).getItems ().get (i).get (0).getName () + " (" + getCurrentPlayer ().getBags ().get (0).getItems ().get (i).size () + " шт)");
                        bag.addItem (getCurrentPlayer ().getBags ().get (0).getItems ().get (i));
                    }
                }
            }
        });
        showItemDesc.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                systemMessage.setVisible(false);
                if (bagInfo.getSelectedItem() != null) {
                    itemDesc.setVisible(true);
                    itemDesc.setText ("<html>" + "<h4 style='color: red;'>Описание предмета:</h4>" + getCurrentPlayer ().getBags ().get (0).getItems ().get (bagInfo.getSelectedIndex ()).get (0).getDescription () + "</html>");
                }
            }
        });

        frame.add(systemMessage);
        frame.add(buttons);
        frame.add(creationMenu);
        frame.add(deleteMenu);
        frame.add(chooseMenu);
        frame.add(playerMenu);

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
    private Player currentPlayer;
    private ArrayList<NPC> npcs;
    private int choice;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
