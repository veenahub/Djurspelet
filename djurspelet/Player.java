package com.example.djurspelet;

/** This program have all logic for players and it contains all details of the player.
 * which animlas  player have and what food player brought from store and which animals he can mate
 * and how much money player have at starting of the game and end of the game.
 * Using his list player can sell which animals he has and which animals he wants to feed.
 * @author Srikanth,Veena.
 */

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Player {
    private String name;
    private float money;
    Store store = new Store();
    Animal animal;
    float animalPrice;
    Scanner userInput = new Scanner(System.in);
    ArrayList<Animal> userAnimalList = new ArrayList<Animal>();
    Milk milkAvailable = new Milk(0);
    Leaves leavesAvailable = new Leaves(0);
    Carrot carrotsAvailable = new Carrot(0);
    Chicken chickenAvailable = new Chicken(0);
    Meat meatAvailable = new Meat(0);
    public Player(String name, float money) {
        this.name = name;
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public float getMoney() {
        return money;
    }
    public void chooseAnimal() {
        System.out.println("we have Dog,Cat,Horse,Rabbit,Mouse \n" + "Please write here which animal you want to buy?");
        String pet = userInput.next().toLowerCase();
        System.out.println("Choose which gender you want 1.Female 2.Male ");
        int gender = userInput.nextInt();
        System.out.println("How many you want:");
        int countOfAnimals = userInput.nextInt();
        List<String> animalNames = new ArrayList<>();
        for (int i = 1; i <= countOfAnimals; i++) {
            String animalName = null;
            do {
                System.out.println("What is the name of the Animal-" + i + ":");
                String name = userInput.next().toLowerCase();
                for (Animal animal : userAnimalList) {
                    if (animal.getName().equalsIgnoreCase(name)) {
                        System.out.println("An animal with the name already exists. Please select another name.");
                        name = null;
                        break;
                    }
                }
                if(animalNames.contains(name)) {
                    System.out.println("An animal with the name already exists. Please select another name.");
                    name = null;
                }
                if (name != null) {
                    animalName = name;
                }
            } while (animalName == null);
            animalNames.add(animalName);
        }
        List<Animal> newAnimals = store.buyAnimal(pet, gender, animalNames, countOfAnimals);
        Animal animal = newAnimals.get(0);
        float animalPrice = animal.getPrice();
        if(money >= animalPrice * newAnimals.size()) {
            System.out.println(" your chosen animal price is : " + animalPrice + ", You have successfully purchased " + newAnimals.size() + " animals.");
            float RemainingMoney = (money - (animalPrice * newAnimals.size()));
            money = RemainingMoney;
            System.out.println("your Remaining amount " + money);
            userAnimalList.addAll(newAnimals);
            if (newAnimals.size() > 0) {
                System.out.println("Do you want to buy more Animals? (y/n)");
                String buyMoreAnimals = userInput.next().toLowerCase();
                if ("y".equalsIgnoreCase(buyMoreAnimals)) {
                    chooseAnimal();
                }
            }
        } else {
            System.out.println("You don't have sufficient money to buy this animal");
        }
    }
    public void userAnimalList() {
        System.out.println("your  animals list");
        for (Animal animal : userAnimalList) {
            if (animal != null) {
                System.out.println(animal.getName() + ",Gender " + animal.getGender() + ",Health " + animal.getHealth()
                        + ", Change from Previous round: -" + (animal.getPreviousRoundHealth()-animal.getHealth()) + "%");
            }
            else {
                System.out.println("You don't have any own animals");
            }
        }
    }
    public void informFoodDetails() {
        if(milkAvailable.getweightInKgs() == 0 && leavesAvailable.getweightInKgs() == 0 &&
                carrotsAvailable.getweightInKgs() == 0 && chickenAvailable.getweightInKgs() == 0 && meatAvailable.getweightInKgs() == 0) {
            System.out.println("No food available.");
        } else {
            System.out.println("your available food details:");
            if(milkAvailable.getweightInKgs() > 0) {
                System.out.println("Milk = "+ milkAvailable.getweightInKgs() + " kgs");
            }
            if(leavesAvailable.getweightInKgs() > 0) {
                System.out.println("Leaves = "+ leavesAvailable.getweightInKgs() + " kgs");
            }
            if(carrotsAvailable.getweightInKgs() > 0) {
                System.out.println("Carrots = "+ carrotsAvailable.getweightInKgs() + " kgs");
            }
            if(chickenAvailable.getweightInKgs() > 0) {
                System.out.println("Chicken = "+ chickenAvailable.getweightInKgs() + " kgs");
            }
            if(meatAvailable.getweightInKgs() > 0) {
                System.out.println("Meat"+ meatAvailable.getweightInKgs() + " kgs");
            }
        }
    }
    public Animal userAnimal(AnimalType animalType, String gender) {
        for (Animal animal : userAnimalList) {
            AnimalType userchoice = animal.getAnimalType();
            if (animalType == userchoice
                    && gender.equalsIgnoreCase(String.valueOf(animal.getGender()))) {
                return animal;
            }
        }
        return null;
    }
    public boolean animalsToMate() {
        System.out.println("Animals that can mate:");
        Map<AnimalType, String> animalAndGenderMap = new HashMap<>();
        boolean canAnimalsMate = false;
        for (Animal animal : userAnimalList) {
            AnimalType userchoice = animal.getAnimalType();
            if (animalAndGenderMap.containsKey(userchoice)) {
                String existingAnimalGender = animalAndGenderMap.get(userchoice);
                if (!String.valueOf(animal.getGender()).equals(existingAnimalGender)) {
                    // int length_of_the_string = userchoice.length();
                    System.out.println(userchoice);// .substring(23, length_of_the_string));
                    canAnimalsMate = true;
                }
            } else {
                animalAndGenderMap.put(userchoice, String.valueOf(animal.getGender()));
            }
        }
        return canAnimalsMate;
    }
    public void mateAnimals(String pet) {
        switch (pet) {
            case "dog":
                Dog maleDog = (Dog) userAnimal(AnimalType.DOG, "m");
                Dog femaleDog = (Dog) userAnimal(AnimalType.DOG, "f");
                Animal newdog = maleDog.mate(femaleDog);
                if (newdog != null) {
                    userAnimalList.add(newdog);
                }
                break;
            case "cat":
                Cat maleCat = (Cat) userAnimal(AnimalType.CAT, "m");
                Cat femaleCat = (Cat) userAnimal(AnimalType.CAT, "f");
                Animal newcat = maleCat.mate(femaleCat);
                if (newcat != null) {
                    userAnimalList.add(newcat);
                }
                break;
            case "horse":
                Horse maleHorse = (Horse) userAnimal(AnimalType.HORSE, "m");
                Horse femaleHorse = (Horse) userAnimal(AnimalType.HORSE, "f");
                Animal newhorse = maleHorse.mate(femaleHorse);
                if (newhorse != null) {
                    userAnimalList.add(newhorse);
                }
                break;
            case "rabbit":
                Rabbit maleRabbit = (Rabbit) userAnimal(AnimalType.RABBIT, "m");
                Rabbit femaleRabbit = (Rabbit) userAnimal(AnimalType.RABBIT, "f");
                Animal newrabbit = maleRabbit.mate(femaleRabbit);
                if (newrabbit != null) {
                    userAnimalList.add(newrabbit);
                }
                break;
            case "mouse":
                Mouse maleMouse = (Mouse) userAnimal(AnimalType.MOUSE, "m");
                Mouse femaleMouse = (Mouse) userAnimal(AnimalType.MOUSE, "f");
                Animal newmouse = maleMouse.mate(femaleMouse);
                if (newmouse != null) {
                    userAnimalList.add(newmouse);
                }
                break;
            default:
                System.out.println("Please select animals from above list.");
        }
    }

    public void buyFood(int foodChoice, int noOfkgsToBuy) {
        FoodEnum foodType = FoodEnum.MILK;
        if (foodChoice == 1) {
            foodType = FoodEnum.MILK;
        } else if (foodChoice == 2) {
            foodType = FoodEnum.LEAVES;
        } else if (foodChoice == 3) {
            foodType = FoodEnum.CARROT;
        } else if (foodChoice == 4) {
            foodType = FoodEnum.CHICKEN;
        } else if (foodChoice == 5) {
            foodType = FoodEnum.MEAT;
        }
        if (foodType.getKGFoodPrice() > (money * noOfkgsToBuy)) {
            System.out.println("You don't have sufficient money to buy food.");
        } else {
            int moneyToPay = foodType.getKGFoodPrice() * noOfkgsToBuy;
            Food food = store.buy(foodType, moneyToPay);
            if (food == null) {
                System.out.println("You don't have sufficient money to buy food.");
            } else {
                money = money - moneyToPay;
                if (foodChoice == 1) {
                    milkAvailable.addweightInKgs(food.getweightInKgs());
                } else if (foodChoice == 2) {
                    leavesAvailable.addweightInKgs(food.getweightInKgs());
                } else if (foodChoice == 3) {
                    carrotsAvailable.addweightInKgs(food.getweightInKgs());
                } else if (foodChoice == 4) {
                    chickenAvailable.addweightInKgs(food.getweightInKgs());
                } else if (foodChoice == 5) {
                    meatAvailable.addweightInKgs(food.getweightInKgs());
                }
                System.out.println("You bought the food successfully.");
            }
        }
    }
    private Animal getAnimal(String animalType) {
        for(Animal animal : userAnimalList) {
            if (animal.getName().equalsIgnoreCase(animalType) && animal.getHealth() > 0.0f && animal.getHealth() < 100.0f) {
                return animal;
            }
        }
        return null;
    }
    public void feedAnimals() {
        if (userAnimalList.size() == 0) {
            System.out.println("You don't have animals to feed.");
        } else {
            if (milkAvailable.getweightInKgs() == 0 && leavesAvailable.getweightInKgs() == 0
                    && carrotsAvailable.getweightInKgs() == 0 && chickenAvailable.getweightInKgs() == 0
                    && meatAvailable.getweightInKgs() == 0) {
                System.out.println("You don't have food to feed the animals");
            } else {
                userAnimalList();
                System.out.println("You have the following food available:");
                if (milkAvailable.getweightInKgs() > 0) {
                    System.out.println("Milk in KGs:" + milkAvailable.getweightInKgs());
                }
                if (leavesAvailable.getweightInKgs() > 0) {
                    System.out.println("Leaves in KGs:" + leavesAvailable.getweightInKgs());
                }
                if (carrotsAvailable.getweightInKgs() > 0) {
                    System.out.println("Carrots in KGs:" + carrotsAvailable.getweightInKgs());
                }
                if (chickenAvailable.getweightInKgs() > 0) {
                    System.out.println("Chicken in KGs:" + chickenAvailable.getweightInKgs());
                }
                if (meatAvailable.getweightInKgs() > 0) {
                    System.out.println("Meat in KGs:" + meatAvailable.getweightInKgs());
                }
                System.out.println("Which Animal you want to feed(Enter name of animal):");

                Scanner userInput = new Scanner(System.in);
                String pet = userInput.next().toLowerCase();
                Animal animalToFeed = null;
                do {
                    for(Animal animal:userAnimalList) {
                        if(animal.getName().equalsIgnoreCase(pet)) {
                            animalToFeed = animal;
                            break;
                        }
                    }
                    if(animalToFeed == null) {
                        System.out.println("Please enter a valid name of the animal.");
                    }

                } while (animalToFeed == null);
                System.out.println("What food you want to feed:");
                String foodSelected = userInput.next().toLowerCase();
                String[] foods = animalToFeed.getAnimalType().getFoods();
                boolean isMatchFound = false;
                for(String food: foods){
                    if(food.equalsIgnoreCase(foodSelected)) {
                        isMatchFound = true;
                        break;
                    }
                }
                if(!isMatchFound) {
                    System.out.println(pet + " cannot eat " + foodSelected + ". Please select again.");
                    feedAnimals();
                }
                //pet
                System.out.println("How many Kgs you want to feed:");
                int kgsToFeed = userInput.nextInt();
                Food foodToFeed = null;
                if (foodSelected.equalsIgnoreCase("carrot")) {
                    foodToFeed = new Carrot(kgsToFeed);
                    getAnimal(pet).feed(foodToFeed);
                    carrotsAvailable.reduceweightInKgs(kgsToFeed);
                } else if (foodSelected.equalsIgnoreCase("milk")) {
                    foodToFeed = new Milk(kgsToFeed);
                    getAnimal(pet).feed(foodToFeed);
                    milkAvailable.reduceweightInKgs(kgsToFeed);
                } else if (foodSelected.equalsIgnoreCase("meat")) {
                    foodToFeed = new Meat(kgsToFeed);
                    getAnimal(pet).feed(foodToFeed);
                    meatAvailable.reduceweightInKgs(kgsToFeed);
                } else if (foodSelected.equalsIgnoreCase("chicken")) {
                    foodToFeed = new Chicken(kgsToFeed);
                    getAnimal(pet).feed(foodToFeed);
                    chickenAvailable.reduceweightInKgs(kgsToFeed);
                } else if (foodSelected.equalsIgnoreCase("leaves")) {
                    foodToFeed = new Leaves(kgsToFeed);
                    getAnimal(pet).feed(foodToFeed);
                    leavesAvailable.reduceweightInKgs(kgsToFeed);
                }
                System.out.println("Animal feeding complete");

            }
        }

    }
    public void sellAnimals() {
        int sellingNoOfAnimals;
        userAnimalList();
        System.out.println(" How many animals you want to sell?");
        sellingNoOfAnimals = userInput.nextInt();
        if (sellingNoOfAnimals > 0 && sellingNoOfAnimals <= userAnimalList.size()) {
            for (int i = 1; i <= sellingNoOfAnimals; i++) {
                System.out.println(" which animal you want to sell? Enter only one animal name here");
                String animalName = userInput.next().toLowerCase();
                for (Animal animal : userAnimalList) {
                    String n = animal.getName();
                    if (n.equals(animalName)) {
                        animalPrice = animal.getPrice();
                        float sellingPrice = animalPrice * animal.getHealth();
                        money = money + sellingPrice ;
                        userAnimalList.remove(animal);
                        System.out.println(animal.getName() + "sold and you got your money");
                        break;
                    }
                }
            }
        } else{
            System.out.println("Please enter proper number in the range of how many animals you have.");
        }
    }
}