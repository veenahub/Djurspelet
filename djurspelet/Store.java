package com.example.djurspelet;

import java.util.Scanner;

public class Store {
    Scanner userInput = new Scanner(System.in);
    int animalPrice;
    Animal animal;
    public Animal buyAnimal() {
        System.out.println("we have Dog,cat,Horse,Rabbit,Fish \n" +
                            "Please write here which animal you want to but?");
        String  pet = userInput.next().toLowerCase();
        System.out.println("Choose which gender you want 1.Female 2.Male ");
        int gender = userInput.nextInt();
        switch(pet) {
            case "dog" :
                if (gender == 1) {
                    animal = new Dog("Dog", 100.00F, 'F');
                } else if (gender == 2)
                    animal = new Dog("Dog", 100.00F, 'M');
                else {
                    System.out.println("Please enter either 1 or 2");
                }
                break;
            case "cat" :
                animal =  new Cat("cat", 100.00F,'m');
                break;
            case "horse" :
                animal = new Horse("Horse", 100.00F,'f');
                break;
            case "rabbit" :
                animal = new Rabbit("Rabbit", 100.00F,'m');
                break;
            case "mouse" :
                animal = new Mouse("Mouse", 100.00F,'f');
                break;
            default :
                System.out.println("Please select animals from above list.");
        }
    return animal;
    }

}
