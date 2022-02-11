package com.company;
import java.util.ArrayList;
public class Proffesion {
    public Proffesion() {

    }

    private String name;
    private int points;
    private ArrayList<Recipe> recipe = new ArrayList<Recipe>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ArrayList<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
    }
}
