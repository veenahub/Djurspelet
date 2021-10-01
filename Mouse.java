package com.example.djurspelet;

import java.util.Random;

public class Mouse extends Animal{
    final float price = 20.00f;
    public Mouse(String name, float health,char gender) {
        super(name,health,gender);
    }
    public float getPrice() {
        return price;
    }
    public void feed(Food food) {

    }
    public Animal mate(Animal other) {

        Animal animal = null;
        if (other instanceof Mouse) {
            if (Character.compare(this.getGender(), other.getGender()) != 0) {

                if (new Random().nextInt(2) == 0) {
                    if (new Random().nextInt(2) == 0) {
                        animal = new Mouse("Dog", 100.00F, 'F');
                    } else {
                        animal = new Mouse("Dog", 100.00F, 'F');

                    }

                }

            }
        }
        if(animal!=null) {
            System.out.println("A New animal is born!");
        }
        return animal;
    }
}