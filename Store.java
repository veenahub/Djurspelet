package djurspelet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    Scanner userInput = new Scanner(System.in);
    int animalPrice;

    public List<Animal> buyAnimal(String pet, int gender, List<String> animalNames, int countOfAnimals) {
        /*
         * System.out.println("we have Dog,Cat,Horse,Rabbit,Mouse \n" +
         * "Please write here which animal you want to buy?"); String pet =
         * userInput.next().toLowerCase();
         * System.out.println("Choose which gender you want 1.Female 2.Male "); int
         * gender = userInput.nextInt(); System.out.println("How many you want:"); int
         * countOfAnimals = userInput.nextInt(); List<String> animalNames = new
         * ArrayList<>(); for(int i=1; i <= countOfAnimals; i++) {
         * System.out.println("What is the name of the Animal-" +i +":"); String name =
         * userInput.next().toLowerCase(); animalNames.add(name); }
         */
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
            if (foodTypeToBuy == FoodEnum.Milk) {
                food = new Milk(kgstobuy);
            } else if (foodTypeToBuy == FoodEnum.Chicken) {
                food = new Chicken(kgstobuy);

            } else if (foodTypeToBuy == FoodEnum.Meat) {
                food = new Meat(kgstobuy);
            } else if (foodTypeToBuy == FoodEnum.Leaves) {
                food = new Leaves(kgstobuy);
            } else if (foodTypeToBuy == FoodEnum.Carrot) {
                food = new Carrot(kgstobuy);
            }

        }
        return food;
    }
}
