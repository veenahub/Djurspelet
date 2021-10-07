package com.example.djurspelet;

/** This is the extented class for food class it returns Meat price per kg.
 * @author Srikanth,Veena.
 */
public class Meat extends Food {
    public Meat(int weightinkgs) {
        super(weightinkgs);
    }
    public int getKGFoodPrice() {
        return 50;
    }
}