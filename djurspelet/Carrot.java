package com.example.djurspelet;

/** This is the extented class for food class it returns carrot price per kg.
 * @author Srikanth,Veena.
 */
public class Carrot extends Food {
    public Carrot(int weightinkgs) {
        super(weightinkgs);
    }
    public int getKGFoodPrice() {
        return 30;
    }
}
