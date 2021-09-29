package com.example.djurspelet;

import java.util.Scanner;

public class Game {
    Scanner userInput = new Scanner(System.in);
    private int noOfRounds;
    private int noOfPlayers;
    private int i,j;
    public void start() {
        getNoOfRounds();
        getNoOfPlayers();
        Player player[] = new Player[noOfPlayers];
        for (this.i = 0; this.i < noOfPlayers; this.i++) {
            player[this.i] = new Player("Player" + this.i, 1000.00f);
            for (j = 0; j < noOfRounds; j++) {
                System.out.println("Hi " + player[this.i].getName() + " you have " + player[this.i].getMoney() + " sek\n" +
                        "What you want to choose?\n" +
                        "1.Buy Animal 2.Buy Food 3.Feed Animal 4.Make Mate 5.Sell Animal");
                int userChoice = userInput.nextInt();
                switch (userChoice) {
                    case 1:
                        player[this.i].chooseAnimal();
                        player[this.i].userAnimalList();
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Enter the value between 1 to 6");
                }
            }
        }
    }
    public void  getNoOfRounds() {
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
