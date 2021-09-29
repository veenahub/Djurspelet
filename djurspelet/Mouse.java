package com.example.djurspelet;

public class Mouse extends Animal{
    final float price = 20.00f;
    public Mouse(String name, float health,char gender) {
        super(name,health,gender);
    }
    public float getPrice() {
        return price;
    }
    public void feed() {

    }
}
