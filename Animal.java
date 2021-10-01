package com.example.djurspelet;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
   
public abstract class Animal {
    private String name;
    protected float health;
    private char gender;
    public Animal(String name,float health, char gender) {
        this.name = name;
        this.health = health;
        this.gender = gender;
    }
    public boolean isDead() {
    	return health == 0.0f;
    }
    public String getName() { return name;}
    public char getGender() { return gender;}
    public abstract void feed(Food food);
    public abstract float getPrice();

	public abstract Animal mate(Animal other);
}
