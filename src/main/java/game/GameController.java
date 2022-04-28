package game;

import com.gyoge.itcs.ttt.*;
import com.gyoge.itcs.ttt.MinimaxPlayer;

import java.util.Scanner;

import opponents.*;

/**
 * This class's job is to coordinate between the players and the game code, it is the middle man A
 * game object is created, followed by two player objects, then the game is run as the players take
 * turns and interact with the game code.
 */
public class GameController {

    // **PLAYERS ARE SET UP HERE** //
    // To test your bot, replace one of the human players with your bot and play against it
    // p1 is X and goes first
    // p2 is 0 and goes second
    private static TicTacToePlayer p1 = new GrandMaster("Mr. Cool", 1);
    private static TicTacToePlayer p2 = new MinimaxPlayer("Ms. Wissler", 2);

    // Copy of the board from TicTacToe.java for players to access
    private static int[][] board;
    private static int turnTimer = 0;

    // initialize the game
    public static TicTacToe game = new TicTacToe();

    // gets a copy of the game board
    public static int[][] getBoard() {
        board = game.getBoard();
        return board;
    }

    public static int getTurnCount() {
        return turnTimer;
    }

    // plays a single game, returns the number of the player who won, 3 if tie
    private static int playGame() {
        turnTimer = 0;
        // game plays
        int state = 0; // 0 = ongoing, 1 = X win, 2 = O win, 3 = tie
        while (state == 0) {
            game.placePiece(p1.playTurn(), 1); // x player goes
            turnTimer++;

            // check state after X goes to see if the game ended
            state = game.gameOver();
            if (state != 0) {
                break;
            }

            game.placePiece(p2.playTurn(), 2); // O player goes
            turnTimer++;

            state = game.gameOver(); // update state after O goes, while loop condition will handle the check

            if (turnTimer > 50) {
                state = 3;
                System.out.println("Max Turns reached, game ending.");
            }
        }

        // declare winner
        if (state == 1) {
            System.out.println(p1.getName() + " Won!");
            return 1;
        } else if (state == 2) {
            System.out.println(p2.getName() + " Won!");
            return 2;
        } else {
            System.out.println("A Strange game. The only winning move is not to play.");
            return 3;
        }

    }

    public static void main(String[] args) {
        System.out.println("+++++++++++++++++++++++");
        System.out.println(p1.getName() + " VS " + p2.getName());
        System.out.println("+++++++++++++++++++++++" + "\n");

        System.out.println("How Many Games?");
        Scanner s = new Scanner(System.in);
        int numGames = s.nextInt();
        System.out.println("BEGIN\n");

        int p1Victories = 0;
        int p2Victories = 0;
        int ties = 0;
        int curWinner = 0;
        for (int i = 0; i < numGames; i++) {
            curWinner = playGame();
            if (curWinner == 1) {
                p1Victories++;
            } else if (curWinner == 2) {
                p2Victories++;
            } else {
                ties++;
            }

            // resets the board before the next game is played
            game.resetBoard();
        }

        System.out.println("\n++++++++++++");
        System.out.println("FINAL TALLY");
        System.out.println("++++++++++++");
        System.out.println(p1.getName() + " Won " + p1Victories + " Games!");
        System.out.println(p2.getName() + " Won " + p2Victories + " Games!");
        System.out.println("There were " + ties + " Tie Games!");

    }

}
