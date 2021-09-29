package com.example.djurspelet;

public class Dog extends Animal{
    final float price = 30.00f;
    public Dog(String name, float health,char gender) {
        super(name,health,gender);
    }
    public float getPrice() {
        return price;
    }
    public void feed() {

    }
}
