package com.example.djurspelet;

public enum FoodEnum {
	Milk(100), Leaves(200), Carrot(300), Chicken(400), Meat(500);

	private int kgFoodPrice;

	FoodEnum(int kgFoodPrice) {
		this.kgFoodPrice = kgFoodPrice;
	}

	public int getKGFoodPrice() {
		return kgFoodPrice;
	}

}
