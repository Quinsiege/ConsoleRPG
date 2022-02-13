package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game();

        Weapon weapon = new Weapon("Меч", Weapon.Type.OneHandMaces, Weapon.Slot.MainHand);
        Weapon weapon1 = new Weapon("Булава", Weapon.Type.OneHandMaces, Weapon.Slot.MainHand);

        weapon.setLimitInStock(17);
        weapon1.setLimitInStock(17);
        game.CreatePerson();

        game.getPeople().get(0).getBags().add(new Bag("Моя сумка"));
        game.getPeople().get(0).getBags().add(new Bag("Моя сумка №2"));
        game.getPeople().get(0).getBags().get(0).setLimitInStock(12);
        game.getPeople().get(0).getBags().get(1).setLimitInStock(8);

        for (int i = 0; i < game.getPeople().get(0).getBags().get(0).getLimitInStock(); i++) {
            game.getPeople().get(0).getBags().get(0).getItems().add(new ArrayList<Item>());
        }


        for (int i = 0; i < 5; i++) {
            game.getPeople().get(0).Take(weapon);
        }
        for (int i = 0; i < 25; i++) {
            game.getPeople().get(0).Take(weapon1);
        }
        game.getPeople().get(0).getBags().get(0).Info();

        game.getPeople().get(0).ShiftItem(0,0, 0, 2);
        game.getPeople().get(0).getBags().get(0).Info();
    }
}
