package com.company;

public class Currency {
    public Currency() {
        
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public enum Value { Gold, Silver, Cooper } private Value value;
    private int stock;

}
