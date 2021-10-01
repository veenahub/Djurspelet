package com.example.djurspelet;

public class Milk extends Food {

	public Milk(int weightinkgs) {
		super(weightinkgs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getKGFoodPrice() {
		return 80;
	}
}
