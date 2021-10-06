package djurspelet;

public abstract class Food {

    private int weightInKgs;

    public Food(int weightinkgs) {
        weightInKgs = weightinkgs;
    }

    public abstract int getKGFoodPrice();

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
