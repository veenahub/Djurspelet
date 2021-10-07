package com.example.djurspelet;
/** This program allow player to play Djurspelet game and this program  is the entry point to the game
*  here we create object for game and we will call it as a startGame
*  Using object we will call start method then game result method.
*  start method will give all possible options to the player and result method will display
*  who is the winner in this game
*  @author veena,Srikanth.
*/
public class Main {
    public static void main(String[] args) {
      Game startGame = new Game();
      startGame.start();       //game will start.
      startGame.gameResult();  //gameresult will display.
    }
}
