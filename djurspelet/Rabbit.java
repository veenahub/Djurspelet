package com.example.djurspelet;

public class Rabbit extends Animal{
    final float price = 50.00f;
    public Rabbit(String name, float health,char gender) {
        super(name,health,gender);
    }
    public float getPrice() {
        return price;
    }
    public void feed() {

    }
}