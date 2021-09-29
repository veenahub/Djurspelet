package com.example.djurspelet;

public class Horse extends Animal{
    final float price = 300.00f;
    public Horse(String name, float health,char gender) {
        super(name,health, gender);
    }
    public float getPrice() {
        return price;
    }
    public void feed() {

    }
}
