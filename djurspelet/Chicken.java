package com.example.djurspelet;
/** This is the extented class for food class it returns chicken price per kg.
 * @author Srikanth,Veena.
 */
public class Chicken extends Food {
    public Chicken(int weightinkgs) {
        super(weightinkgs);
    }
    public int getKGFoodPrice() {
        return 40;
    }
}
