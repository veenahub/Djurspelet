package com.example.djurspelet;

/** This is the extented class for food class it returns Milk price per kg.
 * @author Srikanth,Veena.
 */
public class Milk extends Food {
    public Milk(int weightinkgs) {
        super(weightinkgs);
    }
    public int getKGFoodPrice() {
        return 10;
    }
}
