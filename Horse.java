package com.example.djurspelet;

import java.util.Random;

public class Horse extends Animal {
    final float price = 300.00f;

    public Horse(String name, float health, char gender) {
        super(name, health, gender);
    }

    public float getPrice() {
        return price;
    }

    public void feed(Food food) {
        int foodKgs = food.getKGFoodPrice();
        health = foodKgs * 10;
        if (health > 100.0f) {
            health = 100.0f;
        }
    }

    public Animal mate(Animal other) {

        Animal animal = null;
        if (other instanceof Horse) {
            if (Character.compare(this.getGender(), other.getGender()) != 0) {

                if (new Random().nextInt(2) == 0) {
                    if (new Random().nextInt(2) == 0) {
                        animal = new Horse("Dog", 100.00F, 'm');
                    } else {
                        animal = new Horse("Dog", 100.00F, 'f');

                    }

                }

            }
        }
        if (animal != null) {
            System.out.println("A New animal is born!");
        }
        return animal;
    }
}