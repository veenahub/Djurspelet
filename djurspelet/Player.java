package com.example.djurspelet;
import java.lang.String;
import java.util.ArrayList;

public class Player {
    private String name;
    private float money;
    Store store = new Store();
    Animal animal;
    float animalPrice;
    ArrayList<Animal> UserAnimalList = new ArrayList<Animal>();
    public Player(String name,float money) {
        this.name = name;
        this.money = money;
    }
    public String getName() { return name;}
    public void chooseAnimal() {
        animal = store.buyAnimal();
        animalPrice = animal.getPrice();
        System.out.println(" your chosen animal price is : " + animalPrice );
        float RemainingMoney = (money - animalPrice);
        money = RemainingMoney;
        System.out.println("your Remaining amount " + money);
        UserAnimalList.add(animal);
    }
    public void userAnimalList() {
        System.out.println("your  animals list");
        for (Animal animal : UserAnimalList) {
            String userchoice = animal.getClass().getName();
            int length_of_the_string = userchoice.length();
            System.out.println( userchoice.substring(23,length_of_the_string));
        }
    }
    public float getMoney() {
        return  money;
    }

}
