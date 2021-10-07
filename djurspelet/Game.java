package com.example.djurspelet;
/**This program will allow player to take how many players and how many rounds player wants to play
* player can choose buy animals, buy food, feeding animal, mating animals and selling animals
* when you select appropriate choice the result will store in appropriate method
* If you select 1. Buy animal player will get 5 different options like dog, cat,horse,rabbit and mouse
* If you select 2. Buy food player will get 5 different options like 1. milk 2. leaves 3. Carrot 4. chicken 5. meat
* If you select 3. Feed animal it will ask player which animal you want to feed based on the available animals
* If you select 4. Mate It will show “you have the following animals” and Animals that can mate
* If you select 5. Sell animals it will ask how which animals you want to sell and player can sell how many he can
* @author Srikanth,Veena.
*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner userInput = new Scanner(System.in);
    private int noOfRounds;
    private int noOfPlayers;
    private int i, j;
    private float playerMoney;
    ArrayList<Float> playersMoney = new ArrayList<Float>();  // contains all players money what player have once player finished his/her game

    // Start method it will give to player all possible options
    public void start() {
        getNoOfRounds();    // user can select how many rounds player wants
        getNoOfPlayers();   // user can select how many players.
        Player player[] = new Player[noOfPlayers];
        for (this.i = 0; this.i < noOfPlayers; this.i++) {
            boolean breakLoop = true;
            while (breakLoop) {
                for (j = 0; j < noOfRounds; j++) {
                    System.out.println("\n\nRound:" + (j + 1) + " started.");
                    if (j == 0) {
                        player[this.i] = new Player("Player" + this.i, 1000.00f);
                    } else {
                        for (Animal animal : player[this.i].userAnimalList) {
                            if (animal != null) {
                                System.out.println(animal.getName() + "," + animal.getGender() + ",Health " + animal.getHealth());
                                animal.setHealth();
                                if (animal.isDead())
                                    System.out.println(animal.getName() + "this animal is dead");
                            }
                        }
                        player[this.i].informFoodDetails();
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
                            boolean canAnimalsMate = player[this.i].animalsToMate();
                            if (canAnimalsMate) {
                                System.out.println("Select animal to Mate:  ");
                                String pet = userInput.next().toLowerCase();
                                player[this.i].mateAnimals(pet);
                            } else {
                                System.out.println("     Nothing to Mate");
                            }
                            break;
                        case 5:
                            player[this.i].sellAnimals();
                            break;
                        default:
                            System.out.println("Enter the value between 1 to 6");
                    }
                if (player[this.i].getMoney() == 0 && player[this.i].userAnimalList.size() == 0)  {
                    System.out.println("you don't have any money so you loose the game");
                    breakLoop = false;
                    break;
                }
                }
                break;
            }
            float playerMoney = player[this.i].getMoney(); // once player finished his game it will
            playersMoney.add(playerMoney);
        }
    }
    // will calculate which player has maximum money and display the result.
    public void gameResult() {
        float maximum = playersMoney.get(0);
        int winner;
        for(int k=0; k < playersMoney.size(); k++) {
                if (playersMoney.get(k) > maximum) {
                    maximum = playersMoney.get(k) ;
                }
            }
        winner = playersMoney.indexOf(maximum);
        System.out.println("The Game winner is player" + winner);
        }
    // user can select how many players.
    public void getNoOfPlayers() {
        System.out.println("How many players?");
        try {
            noOfPlayers = userInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR!!!!!!! Please Enter The Number between 1 to 4");
            userInput.next();
        }
        if (!(noOfPlayers >= 1 && noOfPlayers <= 4)) {
            System.out.println("Please Enter The Number between 1 to 4");
            noOfPlayers = userInput.nextInt();
        }
    }
    // user can select how many rounds player wants
    public void  getNoOfRounds() {
        System.out.println("How many rounds you want to play?");
        try {
            noOfRounds = userInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR!!!!!!! Please Enter The Number between 5 to 30 ");
            userInput.next();
        }
        if (!(noOfRounds >= 5 && noOfRounds <= 30)) {
            System.out.println("Please Enter The Number between 5 to 30");
            noOfRounds = userInput.nextInt();
        }
    }
}