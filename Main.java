package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game();
        Location location = new Location();
        location.setName("Город Мечей");

        game.CreatePerson();
        game.getPeople().get(0).MoveTo(location, 100, 100);

        System.out.println(game.getPeople().get(0).getName() + " сейчас находится в локации '" + game.getPeople().get(0).getLocation().getName() + "' на координатах [" + game.getPeople().get(0).getPositionX() + ";" + game.getPeople().get(0).getPositionY() + "]");

    }
}
