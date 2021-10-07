package com.example.djurspelet;

import java.util.ArrayList;
import java.util.List;

/** This is the store class from this class player can choose which animal and which gender player wants
 *  from this class player can choose which food player wants to buy.
 * @author Veena,Srikanth.
 */

public class Store {
    public List<Animal> buyAnimal(String pet, int gender, List<String> animalNames, int countOfAnimals) {
        ArrayList<Animal> animalList = new ArrayList<>();
        for (int i = 1; i <= countOfAnimals; i++) {
            Animal animal = null;
            String name = animalNames.get(i-1);
            switch (pet) {
                case "dog":
                    if (gender == 1) {
                        animal = new Dog(name, 100.00F, 'F');
                    } else if (gender == 2)
                        animal = new Dog(name, 100.00F, 'M');
                    else {
                        System.out.println("Please enter either 1 or 2");
                    }
                    break;
                case "cat":
                    if (gender == 1) {
                        animal = new Cat(name, 100.00F, 'F');
                    } else if (gender == 2)
                        animal = new Cat(name, 100.00F, 'M');
                    else {
                        System.out.println("Please enter either 1 or 2");
                    }
                    break;
                case "horse":
                    if (gender == 1) {
                        animal = new Horse(name, 100.00F, 'F');
                    } else if (gender == 2)
                        animal = new Horse(name, 100.00F, 'M');
                    else {
                        System.out.println("Please enter either 1 or 2");
                    }
                    break;
                case "rabbit":
                    if (gender == 1) {
                        animal = new Rabbit(name, 100.00F, 'F');
                    } else if (gender == 2)
                        animal = new Rabbit(name, 100.00F, 'M');
                    else {
                        System.out.println("Please enter either 1 or 2");
                    }
                    break;
                case "mouse":
                    if (gender == 1) {
                        animal = new Mouse(name, 100.00F, 'F');
                    } else if (gender == 2)
                        animal = new Mouse(name, 100.00F, 'M');
                    else {
                        System.out.println("Please enter either 1 or 2");
                    }
                    break;
                default:
                    System.out.println("Please select animals from above list.");
            }
            if(animal !=null) {
                animalList.add(animal);
            }
        }
        return animalList;
    }

    public Food buy(FoodEnum foodTypeToBuy, int buyingAmount) {
        Food food = null;
        if (buyingAmount >= foodTypeToBuy.getKGFoodPrice()) {
            int kgstobuy = buyingAmount / foodTypeToBuy.getKGFoodPrice();
            if (foodTypeToBuy == FoodEnum.MILK) {
                food = new Milk(kgstobuy);
            } else if (foodTypeToBuy == FoodEnum.CHICKEN) {
                food = new Chicken(kgstobuy);
            } else if (foodTypeToBuy == FoodEnum.MEAT) {
                food = new Meat(kgstobuy);
            } else if (foodTypeToBuy == FoodEnum.LEAVES) {
                food = new Leaves(kgstobuy);
            } else if (foodTypeToBuy == FoodEnum.CARROT) {
                food = new Carrot(kgstobuy);
            }
        }
        return food;
    }
}