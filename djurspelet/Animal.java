package com.example.djurspelet;

import java.util.Scanner;

public abstract class Animal {
    private String name;
    private float health;
    private char gender;
    public Animal(String name,float health, char gender) {
        this.name = name;
        this.health = health;
        this.gender = gender;
    }
    public char getGender() { return gender;}
    public abstract void feed();
    public abstract float getPrice();
}
