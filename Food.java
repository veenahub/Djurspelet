package com.example.djurspelet;

public  abstract class Food {

	private int weightInKgs;

	public Food(int weightinkgs) {
		weightInKgs=weightinkgs;
	}
	public abstract int getKGFoodPrice();
	
	public int getweightInKgs() {
		return weightInKgs;
	}
}