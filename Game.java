package com.example.djurspelet;

import java.util.Scanner;

public class Game {
    Scanner userInput = new Scanner(System.in);
    private int noOfRounds;
    private int noOfPlayers;
    private int i, j;

    public void start() {
        getNoOfRounds();
        getNoOfPlayers();
        Player player[] = new Player[noOfPlayers];
        for (j = 0; j < noOfRounds; j++) {
            for (this.i = 0; this.i < noOfPlayers; this.i++) {
                if(j == 0) {
                    player[this.i] = new Player("Player" + this.i, 1000.00f);
                }
                System.out.println("Hi " + player[this.i].getName() + " you have " + player[this.i].getMoney() + " sek\n" +
                        "What you want to choose?\n" +
                        "1.Buy Animal 2.Buy Food 3.Feed Animal 4.Make Mate 5.Sell Animal");
                int userChoice = userInput.nextInt();
                switch (userChoice) {
                    case 1:
                        player[this.i].chooseAnimal();
                        player[this.i].userAnimalList();
                        break;
                    case 2:
                        System.out.println("your Remaining amount:" + player[this.i].getMoney());
                        if (player[this.i].getMoney() > 0.0f) {
                            System.out.println("what Food you want to buy: 1.Milk\t2.Leaves\t3.Carrot\t4.Chicken\t5.Meat");
                            int foodChoice = userInput.nextInt();
                            System.out.println("How many Kgs you want to buy");
                            int noOfkgsToBuy = userInput.nextInt();
                            player[this.i].buyFood(foodChoice, noOfkgsToBuy);

                        } else {
                            System.out.println("You don't have sufficient money to buy food.");
                        }
                        break;
                    case 3:
                        player[this.i].feedAnimals();

                        break;
                    case 4:

                        // Mate Animals
                        System.out.println("You have the following Animals.");
                        int i = 0;
                        boolean canAnimalsMate = player[this.i].animalsToMate();
                        if (canAnimalsMate) {
                            System.out.println("Select animal to Mate:");
                            String pet = userInput.next().toLowerCase();
                            player[this.i].mateAnimals(pet);

                        }
                        /*
                         * Animal animal1 = player.getAnimals().get(1); Animal animal2 =
                         * player.getAnimals().get(2); try { Optional<Animal> animal =
                         * animal1.mate(animal2); animal.ifPresent(s -> player.getAnimals().add(s)); }
                         * catch (CustomException e) { // TODO Auto-generated catch block
                         * e.printStackTrace(); }
                         */

                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Enter the value between 1 to 6");
                }
            }

            for (this.i = 0; this.i < noOfPlayers; this.i++) {

                player[this.i].endOfRound();
            }
        }
    }

    public void getNoOfRounds() {
        System.out.println("How many rounds you want to play?");
        noOfRounds = userInput.nextInt();
        if (!(noOfRounds >= 1 && noOfRounds <= 30)) {
            System.out.println("Please Enter The Number between 5 to 30");
            noOfRounds = userInput.nextInt();
        }
    }

    public void getNoOfPlayers() {
        System.out.println("How many players?");
        noOfPlayers = userInput.nextInt();
        if (!(noOfPlayers >= 1 && noOfPlayers <= 4)) {
            System.out.println("Please Enter The Number between 1 to 4");
            noOfPlayers = userInput.nextInt();
        }
    }
}
