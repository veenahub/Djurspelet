package djurspelet;

public enum FoodEnum {
    Milk(10), Leaves(20), Carrot(10), Chicken(20), Meat(30);

    private int kgFoodPrice;

    FoodEnum(int kgFoodPrice) {
        this.kgFoodPrice = kgFoodPrice;
    }

    public int getKGFoodPrice() {
        return kgFoodPrice;
    }

}
