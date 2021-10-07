package com.example.djurspelet;

public enum FoodEnum {
    MILK(10), LEAVES(20), CARROT(30), CHICKEN(40), MEAT(50);
    private int kgFoodPrice;
    FoodEnum(int kgFoodPrice) {
        this.kgFoodPrice = kgFoodPrice;
    }
    public int getKGFoodPrice() {
        return kgFoodPrice;
    }
}
