package com.example.djurspelet;

/**This is the abstract class for food it contains setter and getter methods.
 * @author Srikanth,Veena.
 */
public abstract class Food {
    private int weightInKgs;
    public abstract int getKGFoodPrice();
    public Food(int weightinkgs) {
        weightInKgs = weightinkgs;
    }
    public int getweightInKgs() {
        return weightInKgs;
    }
    public void addweightInKgs(int addKgs) {
        weightInKgs = weightInKgs + addKgs;
    }
    public void reduceweightInKgs(int addKgs) {
        weightInKgs = weightInKgs - addKgs;
    }
}









