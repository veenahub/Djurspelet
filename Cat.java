package com.example.djurspelet;

import java.util.Random;

public class Cat extends Animal{
    final float price = 30.00f;
    public Cat(String name,float health,char gender) {
        super(name,health,gender);
    }
    public float getPrice() {
        return price;
    }
   /* public char getGender() {
         super.getGender();
    }*/
    public void feed(Food food) {
        int foodKgs = food.getKGFoodPrice();
        health = foodKgs*10;

    }

    public Animal mate(Animal other) {

        Animal animal = null;
        if (other instanceof Cat) {
            if (Character.compare(this.getGender(), other.getGender()) != 0) {

                if (new Random().nextInt(2) == 0) {
                    if (new Random().nextInt(2) == 0) {
                        animal = new Cat("Cat", 100.00F, 'F');
                    } else {
                        animal = new Cat("Cat", 100.00F, 'F');

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