package com.example.djurspelet;
import java.lang.Math;

/**This is the abstract class for animals
 * It contains setter and getter methods.
 * @author Srikanth,Veena.
 */

public abstract class Animal {
    private String name;
    protected float health;
    private char gender;
    protected float previousRoundHealth;
    private AnimalType animalType;

    public Animal(String name, float health, char gender, AnimalType animalType) {
        this.name = name;
        this.health = health;
        this.previousRoundHealth = health;
        this.gender = gender;
        this.animalType = animalType;
    }
    public float setHealth() {
        //Here math.random() is using for system choice in the game.
        float computerChoice = (float) (Math.random() * 30) + 10;
        float decreasingHealth = (health*computerChoice)/100;
        this.health = health-decreasingHealth;
        return this.health;
    }
    public AnimalType getAnimalType() {
        return animalType;
    }
    public float getPreviousRoundHealth() {
        return previousRoundHealth;
    }

    public void setPreviousRoundHealth(float health) {
        previousRoundHealth = health;
    }
    public float getHealth() { return health;};
    public char getGender() { return gender;}
    public String getName() { return name;}
    public boolean isDead() { return health == 0.0f; }
    public abstract void feed(Food food);
    public abstract Animal mate(Animal other);
    public abstract float getPrice();
}
