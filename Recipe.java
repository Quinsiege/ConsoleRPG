package com.company;
import java.util.ArrayList;

public class Recipe {

    private int requirePoints;
    private ArrayList<Item> requireItems = new ArrayList<Item>();

    public int getRequirePoints() {
        return requirePoints;
    }

    public void setRequirePoints(int requirePoints) {
        this.requirePoints = requirePoints;
    }

    public ArrayList<Item> getRequireItems() {
        return requireItems;
    }

    public void setRequireItems(ArrayList<Item> requireItems) {
        this.requireItems = requireItems;
    }
}
