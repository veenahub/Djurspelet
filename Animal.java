package djurspelet;

public abstract class Animal {
    private String name;
    protected float health;

    protected float previousRoundHealth;
    private char gender;
    private AnimalType animalType;

    public Animal(String name, float health, char gender, AnimalType animalType) {
        this.name = name;
        this.health = health;
        this.previousRoundHealth = health;
        this.gender = gender;
        this.animalType = animalType;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public boolean isDead() {
        return health == 0.0f;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public float getHealth() {
        return health;
    }

    public float getPreviousRoundHealth() {
        return previousRoundHealth;
    }

    public void setPreviousRoundHealth(float health) {
        previousRoundHealth = health;
    }

    public abstract void feed(Food food);

    public abstract float getPrice();

    public abstract Animal mate(Animal other);
}
