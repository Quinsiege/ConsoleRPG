package com.company;

public class Location {
    public Location(String name) {
        setName(name);
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
