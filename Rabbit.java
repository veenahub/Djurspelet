package djurspelet;


import java.util.Random;
import java.util.Scanner;

public class Rabbit extends Animal {
    final float price = 50.00f;

    public Rabbit(String name, float health, char gender) {
        super(name, health, gender, AnimalType.RABBIT);
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
        if (other instanceof Rabbit) {
            if (this.getGender() != other.getGender()) {

                if (new Random().nextInt(2) == 0) {
                    if (new Random().nextInt(2) == 0) {
                        System.out.println("A New male animal is born! Enter the name of the animal:");
                        String animalName = new Scanner(System.in).next().toLowerCase();
                        animal = new Rabbit(animalName, 100.00F, 'm');

                    } else {
                        System.out.println("A New female animal is born! Enter the name of the animal:");
                        String animalName = new Scanner(System.in).next().toLowerCase();
                        animal = new Rabbit(animalName, 100.00F, 'f');

                    }
                }
            }
        }
        return animal;
    }
}