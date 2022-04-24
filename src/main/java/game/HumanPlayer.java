package game;

import java.util.Scanner;

/**
 * this allows a human to play the game
 */
public class HumanPlayer extends TicTacToePlayer {

    public HumanPlayer(String name, int piece) {
        super(name, piece);
    }

    public int[] playTurn() {
        //print the board
        GameController.game.printBoard();

        //get input
        int[] move = new int[2];
        Scanner s = new Scanner(System.in);

        System.out.println("Where would " + getName() + " like to move?");
        System.out.println("Row?");
        move[0] = s.nextInt();
        System.out.println("Column?");
        move[1] = s.nextInt();

        return move;
    }

}
