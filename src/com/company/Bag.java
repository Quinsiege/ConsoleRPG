package com.company;
import java.util.ArrayList;

public class Bag extends Item {
    public Bag(String name) {
        setName(name);
    }

    public void Info() {
        System.out.println("Количество слотов: " + this.getLimitInStock());
        for (int i = 0; i < this.getItems().size(); i++) {
            if (this.getItems().get(i).size() != 0) {
                System.out.println("Слот №" + (i + 1) + ": " + this.getItems().get(i).get(0).getName()
                        + " (" + this.getItems().get(i).size() + " ед.)");
            }
        }
    }
    public ArrayList<ArrayList<Item>> getItems() {
        return items;
    }

    public void setItems(ArrayList<ArrayList<Item>> items) {
        this.items = items;
    }
    private ArrayList<ArrayList<Item>> items = new ArrayList<ArrayList<Item>>();
}
