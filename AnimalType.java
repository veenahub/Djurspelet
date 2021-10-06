package djurspelet;

public enum AnimalType {

    CAT(new String[] { "Milk", "Chicken" }), DOG(new String[] { "Milk", "Chicken", "Meat" }),
    RABBIT(new String[] { "Carrot", "Leaves" }), HORSE(new String[] { "Carrot", "Leaves" }),
    MOUSE(new String[] { "Milk", "Chicken" });

    private String[] foods;

    AnimalType(String[] foods) {

        this.foods = foods;
    }

    public String[] getFoods() {
        return foods;
    }

    public static AnimalType getAnimalType(String animalTypename) {
        AnimalType animalType=null;
        AnimalType[] animalTypes = AnimalType.values();
        for(AnimalType a: animalTypes) {
            if(a.name().equalsIgnoreCase(animalTypename)) {
                animalType = a;
            }
        }
        return animalType;
    }
}