package com.example.djurspelet;

import java.util.Random;
import java.util.Scanner;

/** This is the extented cat class for animal abstract class it contains feed,mate and getprice methods.
 * @author Veena,Srikanth.
 */
public class Cat extends Animal{
    final float price = 30.00f;
    public Cat(String name,float health,char gender) {
        super(name,health,gender,AnimalType.CAT);
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
        if (other instanceof Cat) {
            if (new Random().nextInt(2) == 0) {
                if (new Random().nextInt(2) == 0) {
                    System.out.println("A New male animal is born! Enter the name of the animal:");
                    String animalName = new Scanner(System.in).next().toLowerCase();
                    animal = new Cat(animalName, 100.00F, 'm');
                } else {
                    System.out.println("A New female animal is born! Enter the name of the animal:");
                    String animalName = new Scanner(System.in).next().toLowerCase();
                    animal = new Cat(animalName, 100.00F, 'f');
                }
            }
        }
        if(animal!=null) {
            System.out.println("A New animal is born!");
        }
        return animal;
    }
}
