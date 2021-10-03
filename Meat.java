package com.example.djurspelet;

public class Meat extends Food {

    public Meat(int weightinkgs) {
        super(weightinkgs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getKGFoodPrice() {
        return 30;
    }
}
