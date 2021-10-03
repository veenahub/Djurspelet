package com.example.djurspelet;

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private float money;
    Store store = new Store();
    Animal animal;
    float animalPrice;
    Milk milkAvailable = new Milk(0);
    Leaves leavesAvailable = new Leaves(0);
    Carrot carrotsAvailable = new Carrot(0);
    Chicken chickenAvailable = new Chicken(0);
    Meat meatAvailable = new Meat(0);
    ArrayList<Animal> UserAnimalList = new ArrayList<>();

    public Player(String name, float money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void chooseAnimal() {
        animal = store.buyAnimal();
        animalPrice = animal.getPrice();
        System.out.println(" your chosen animal price is : " + animalPrice);
        float RemainingMoney = (money - animalPrice);
        money = RemainingMoney;
        System.out.println("your Remaining amount " + money);
        UserAnimalList.add(animal);
    }

    public void userAnimalList() {
        System.out.println("your  animals list");
        for (Animal animal : UserAnimalList) {
            if(animal.getHealth() > 0) {
                String userchoice = animal.getName() + ", Gender:" + animal.getGender() + ", Health:" + animal.getHealth();
                //int length_of_the_string = userchoice.length();
                System.out.println(userchoice);//.substring(23, length_of_the_string));
            }
        }
    }

    public Animal userAnimal(String animalType, String gender) {
        for (Animal animal : UserAnimalList) {
            String userchoice = animal.getName();
            if (animalType.equalsIgnoreCase(userchoice) && gender.equalsIgnoreCase(String.valueOf(animal.getGender()))) {
                return animal;
            }
        }
        return null;
    }

    public boolean animalsToMate() {
        System.out.println("Animals that can mate:");
        Map<String, String> animalAndGenderMap = new HashMap<>();
        boolean canAnimalsMate = false;

        for (Animal animal : UserAnimalList) {
            String userchoice = animal.getName();

            if (animalAndGenderMap.containsKey(userchoice)) {
                String existingAnimalGender = animalAndGenderMap.get(userchoice);
                if (!String.valueOf(animal.getGender()).equals(existingAnimalGender)) {
                    //int length_of_the_string = userchoice.length();
                    System.out.println(userchoice);//.substring(23, length_of_the_string));
                    canAnimalsMate = true;
                }
            } else {
                animalAndGenderMap.put(userchoice, String.valueOf(animal.getGender()));
            }

        }
        return canAnimalsMate;
    }

    public float getMoney() {
        return money;
    }

    public void mateAnimals(String pet) {
        switch (pet) {
            case "dog":
                Dog maleDog = (Dog) userAnimal("Dog", "m");
                Dog femaleDog = (Dog) userAnimal("Dog", "f");
                Animal newdog = maleDog.mate(femaleDog);
                if (newdog != null) {
                    UserAnimalList.add(newdog);
                }
                break;
            case "cat":
                Cat maleCat = (Cat) userAnimal("Cat", "m");
                Cat femaleCat = (Cat) userAnimal("Cat", "f");
                Animal newcat = maleCat.mate(femaleCat);
                if (newcat != null) {
                    UserAnimalList.add(newcat);
                }
                break;
            case "horse":
                Horse maleHorse = (Horse) userAnimal("Horse", "m");
                Horse femaleHorse = (Horse) userAnimal("Horse", "f");
                Animal newhorse = maleHorse.mate(femaleHorse);
                if (newhorse != null) {
                    UserAnimalList.add(newhorse);
                }
                break;
            case "rabbit":
                Rabbit maleRabbit = (Rabbit) userAnimal("Rabbit", "m");
                Rabbit femaleRabbit = (Rabbit) userAnimal("Rabbit", "f");
                Animal newrabbit = maleRabbit.mate(femaleRabbit);
                if (newrabbit != null) {
                    UserAnimalList.add(newrabbit);
                }
                break;
            case "mouse":
                Mouse maleMouse = (Mouse) userAnimal("Mouse", "m");
                Mouse femaleMouse = (Mouse) userAnimal("Mouse", "f");
                Animal newmouse = maleMouse.mate(femaleMouse);
                if (newmouse != null) {
                    UserAnimalList.add(newmouse);
                }
                break;
            default:
                System.out.println("Please select animals from above list.");
        }

    }

    public void buyFood(int foodChoice, int noOfkgsToBuy) {
        FoodEnum foodType = FoodEnum.Milk;
        if (foodChoice == 1) {
            foodType = FoodEnum.Milk;
        } else if (foodChoice == 2) {
            foodType = FoodEnum.Leaves;
        } else if (foodChoice == 3) {
            foodType = FoodEnum.Carrot;
        } else if (foodChoice == 4) {
            foodType = FoodEnum.Chicken;
        } else if (foodChoice == 5) {
            foodType = FoodEnum.Meat;
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

    public void endOfRound() {
        Random rand = new Random();
        for (Animal animal : UserAnimalList) {
            int randomNum = rand.nextInt((30 - 10) + 1) + 10;
            animal.health = animal.health - randomNum;
        }

    }

    public void feedAnimals() {
        if(UserAnimalList.size() ==0) {
            System.out.println("You don't have animals to feed.");
        } else {
            if(milkAvailable.getweightInKgs() == 0 && leavesAvailable.getweightInKgs() == 0
                    && carrotsAvailable.getweightInKgs() == 0  &&chickenAvailable.getweightInKgs() == 0 &&meatAvailable.getweightInKgs() == 0 ) {
                System.out.println("You don't have food to feed the animals");
            } else {
                userAnimalList();
                System.out.println("You have the following food available:");
                if(milkAvailable.getweightInKgs() > 0 ) {
                    System.out.println("Milk in KGs:" +milkAvailable.getweightInKgs());
                }
                if(leavesAvailable.getweightInKgs() > 0 ) {
                    System.out.println("Leaves in KGs:" +leavesAvailable.getweightInKgs());
                }
                if(carrotsAvailable.getweightInKgs() > 0 ) {
                    System.out.println("Carrots in KGs:" +carrotsAvailable.getweightInKgs());
                }
                if(chickenAvailable.getweightInKgs() > 0 ) {
                    System.out.println("Chicken in KGs:" +chickenAvailable.getweightInKgs());
                }
                if(meatAvailable.getweightInKgs() > 0 ) {
                    System.out.println("Meat in KGs:" +meatAvailable.getweightInKgs());
                }
                System.out.println("Which Animal you want to feed:");

                Scanner userInput = new Scanner(System.in);
                String pet = userInput.next().toLowerCase();
                System.out.println("What food you want to feed:");
                String foodToFeed = userInput.next().toLowerCase();

                System.out.println("How many Kgs you want to feed:");
                int kgsToFeed = userInput.nextInt();
                //Food foodToFeed = new Food
                switch (pet) {
                    case "dog":

                        break;
                    case "cat":

                        break;
                    case "horse":

                        break;
                    case "rabbit":

                        break;
                    case "mouse":

                        break;
                    default:
                        System.out.println("Please select animals from above list.");
                }

            }
        }

    }


}
