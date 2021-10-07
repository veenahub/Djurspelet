package com.example.djurspelet;

/** This is the extented class for food class it returns Leaves price per kg.
 * @author Srikanth,Veena.
 */
public class Leaves extends Food {
    public Leaves(int weightinkgs) {
        super(weightinkgs);
    }
    public int getKGFoodPrice() {
        return 20;
    }
}
