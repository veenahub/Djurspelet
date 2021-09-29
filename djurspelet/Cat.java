package com.example.djurspelet;

public class Cat extends Animal{
    final float price = 30.00f;
    public Cat(String name,float health,char gender) {
        super(name,health,gender);
    }
    public float getPrice() {
        return price;
    }
   /* public char getGender() {
         super.getGender();
    }*/
    public void feed() {

    }
}
