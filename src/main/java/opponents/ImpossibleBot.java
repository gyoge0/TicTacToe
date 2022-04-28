package opponents;
import game.GameController;
import game.TicTacToePlayer;

import java.util.*;
public class ImpossibleBot extends TicTacToePlayer {

    private int r, c, r2, c2, r3, c3, r4, c4;
    private int ro, co, r2o, c2o, r3o, c3o, r4o, c4o;
    private ArrayList<Boolean> firststep;
    private ArrayList<Boolean> secondstep;
    private ArrayList<Boolean> thirdstep;
    private ArrayList<Boolean> firstostep;
    private ArrayList<Boolean> secondostep;
    private ArrayList<Boolean> thirdostep;
 
 
    public ImpossibleBot(String name, int piece) {
        super(name, piece);
        firststep = new ArrayList<Boolean>();
        secondstep = new ArrayList<Boolean>();
        thirdstep = new ArrayList<Boolean>();
        firstostep = new ArrayList<Boolean>();
        secondostep = new ArrayList<Boolean>();
        thirdostep = new ArrayList<Boolean>();
        for (int i = 0; i < 13; i++) {
            firststep.add(false);
            secondstep.add(false);
            thirdstep.add(false);
            firstostep.add(false);
            secondostep.add(false);
            thirdostep.add(false);
        }
    }
 
    // impossible bot
    // this bot will never lose
    public int[] playTurn() {
 
        int[] move = new int[2];
        int[][] board = GameController.game.getBoard();
 
 
        if (getPiece() == 1) {// if piece is X
            if (GameController.getTurnCount() == 0) {//first turn is always at the bottom left corner
                move[0] = 2;
                move[1] = 0;
            }
            else if (GameController.getTurnCount() == 2) {    //second turn
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[0].length; col++) {//loops thru the array to find where the opponent's first O is
                        if (board[row][col] == 2) {
                            r = row;// r = row of opponents O
                            c = col;//c = column of opponents O
                        }
                    }
                }
                if (r == 0 && c == 1) {// if the O is at the top middle edge
                    firststep.remove(0);
                    firststep.add(0, true);
                    move[0] = 0;//next move is at top left corner
                    move[1] = 0;
                } 
                else if (r == 2 && c == 1) {// if the O is at the bottom middle edge
                    firststep.remove(1);
                    firststep.add(1, true);
                    move[0] = 0;//next move is at top left corner
                    move[1] = 0;
                }             
                else if (r == 1 && c == 0) {// if O is at the left edge
                    firststep.remove(2);
                    firststep.add(2, true);
                    move[0] = 2;//next move is at bottom right corner
                    move[1] = 2;
                }
                else if (r == 1 && c == 2) {// if O is at the right edge
                    firststep.remove(3);
                    firststep.add(3, true);
                    move[0] = 2;//next move is at bottom right corner
                    move[1] = 2;
                }
                else if (r == 0 && c == 0) {// if the O is at the top left corner
                    firststep.remove(4);
                    firststep.add(4, true);
                    move[0] = 0;//next move is at top right corner
                    move[1] = 2;
                }
                else if (r == 2 && c == 2) {//if the O is at the bottom right corner
                    firststep.remove(5);
                    firststep.add(5, true);
                    move[0] = 0;//next move is at top right corner
                    move[1] = 2;
                }
                else if (r == 0 && c == 2) {//if the O is at the top right corner
                    firststep.remove(6);
                    firststep.add(6, true);
                    move[0] = 2;//next move is at the bottom right corner
                    move[1] = 2;
                }
                else if (r == 1 && c == 1) {//if the O is at the center
                    firststep.remove(7);
                    firststep.add(7, true);
                    move[0] = 0;//next move is at the top right corner
                    move[1] = 2;
                }
            }
            else if (GameController.getTurnCount() == 4) { //third turn
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[0].length; col++) {
                        if (board[row][col] == 2) {
                           if (row != r && col != c) {
                               r2 = row;
                               c2 = col;
                           }
                        }
                    }
                }
                if (firststep.get(0) && (r2 != 1) && (c2 != 0)) {// if the next O is not on the left edge
                    move[0] = 1;//next move is at left edge and wins
                    move[1] = 0;
                }
                else if (firststep.get(0) && (r2 == 1) && (c2 == 0)) {// if the next O is on the left edge
                    secondstep.remove(0);
                    secondstep.add(0, true);
                    move[0] = 2;//next move is at bottom right corner and guaranteed win on next move
                    move[1] = 2;
                }
                else if (firststep.get(1) && (r2 != 1) && (c2 != 0)) {// if the next O is not on the left edge
                    move[0] = 1;//next move is at left edge and wins
                    move[1] = 0;
                }
                else if (firststep.get(1) && (r2 == 1) && (c2 == 0)) {// if the next O is on the left edge
                    secondstep.remove(1);
                    secondstep.add(1, true);
                    move[0] = 2;//next move is at top right corner and guaranteed win on next move
                    move[1] = 0;
                }
                else if (firststep.get(2) && (r2 != 2) && (c2 != 1)) {// if the next O is not on the bottom edge
                    move[0] = 2;//next move is at bottom edge and wins
                    move[1] = 1;
                }
                else if (firststep.get(2) && (r2 == 2) && (c2 == 1)) {// if the next O is on the bottom edge
                    secondstep.remove(2);
                    secondstep.add(2, true);
                    move[0] = 0;//next move is at top right corner and guaranteed win on next move
                    move[1] = 2;
                }
                else if (firststep.get(3) && (r2 != 2) && (c2 != 1)) {// if the next O is not on the bottom edge
                    move[0] = 2;//next move is at bottom edge and wins
                    move[1] = 1;
                }
                else if (firststep.get(3) && (r2 == 2) && (c2 == 1)) {// if the next O is on the bottom edge
                    secondstep.remove(3);
                    secondstep.add(3, true);
                    move[0] = 0;//next move is at top left corner and guaranteed win on next move
                    move[1] = 0;
                }
                else if (firststep.get(4) && (r2 != 1) && (c2 != 1)) {// if the next O is not at the center
                    move[0] = 1;//next move is at the center and wins
                    move[1] = 1;
                }
                else if (firststep.get(4) && (r2 == 1) && (c2 == 1)) {// if the next O is at the center
                    secondstep.remove(4);
                    secondstep.add(4, true);move[0] = 2;//next move is at the bottom right corner and guaranteed win on next move
                    move[1] = 2;
                }
                else if (firststep.get(5) && (r2 != 1) && (c2 != 1)) {// if the next O is not at the center
                    move[0] = 1;//next move is at the center and wins
                    move[1] = 1;
                }
                else if (firststep.get(5) && (r2 == 1) && (c2 == 1)) {// if the next O is at the center
                    secondstep.remove(5);
                    secondstep.add(5, true);
                    move[0] = 0;//next move is at the top left corner and guaranteed win on next move
                    move[1] = 0;
                }
                else if (firststep.get(6) && (r2 != 1) && (c2 != 1)) {// if the next O is not at the center
                    move[0] = 1;//next move is at the center and wins
                    move[1] = 1;
                }
                else if (firststep.get(6) && (r2 == 1) && (c2 == 1)) {// if the next O is at the center
                    secondstep.remove(6);
                    secondstep.add(6, true);
                    move[0] = 0;//next move is at the top left corner and guaranteed win on next move
                    move[1] = 0;
                }
                else if (firststep.get(7) && (r2 == 0) && (c2 == 0)) {// if the next O is at the top left corner
                    secondstep.remove(7);
                    secondstep.add(7, true);
                    move[0] = 2;//next move is at the bottom right corner and guaranteed win on next move
                    move[1] = 2;
                }
                else if (firststep.get(7) && (r2 == 2) && (c2 == 2)) {// if the next O is at the bottom right corner
                    secondstep.remove(8);
                    secondstep.add(8, true);
                    move[0] = 0;//next move is at the top left corner and guaranteed win on next move
                    move[1] = 0;
                }
                else if (firststep.get(7) && (r2 == 0) && (c2 == 1)) {// if the next O is at the top edge
                    secondstep.remove(9);
                    secondstep.add(9, true);
                    move[0] = 2;//next move is at the bottom edge to block, because its a draw
                    move[1] = 1;
                }
                else if (firststep.get(7) && (r2 == 2) && (c2 == 1)) {// if the next O is at the bottom edge
                    secondstep.remove(10);
                    secondstep.add(10, true);
                    move[0] = 0;//next move is at the top edge to block, because its a draw
                    move[1] = 1;
                }
                else if (firststep.get(7) && (r2 == 1) && (c2 == 0)) {// if the next O is at the left edge
                    secondstep.remove(11);
                    secondstep.add(11, true);
                    move[0] = 1;//next move is at the right edge to block, because its a draw
                    move[1] = 2;
                }
                else if (firststep.get(7) && (r2 == 1) && (c2 == 2)) {// if the next O is at the right edge
                    secondstep.remove(12);
                    secondstep.add(12, true);
                    move[0] = 1;//next move is at the left edge to block, because its a draw
                    move[1] = 0;
                }
            }
            else if (GameController.getTurnCount() == 6){ //fourth and final turn
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[0].length; col++) {//loops thru the array to find where the opponent's first O is
                        if (board[row][col] == 2) {
                            if (row != r && row != r2 && col != c && col != c2) {
                                r3 = row;
                                c3 = col;
                            }
                        }
                    }
                }
                if (secondstep.get(0) && (r3 != 1) && (c3 != 1)) {// if the next O is not on the center to block
                    move[0] = 1;//we put it in the center to win
                    move[1] = 1;
                }
                else if (secondstep.get(0) && (r3 == 1) && (c3 == 1)) {// if the next O is on the center to block
                    move[0] = 1;//we put it in the right edge to win
                    move[1] = 2;
                }
                else if (secondstep.get(1) && (r3 != 1) && (c3 != 1)) {// if the next O is not on the center to block
                    move[0] = 1;//we put it in the center to win
                    move[1] = 1;
                }
                else if (secondstep.get(1) && (r3 != 1) && (c3 != 1)) {// if the next O is not on the top edge to block
                    move[0] = 0;//we put it in the top edge to win
                    move[1] = 1;
                }
                else if (secondstep.get(2) && (r3 != 1) && (c3 != 1)) {// if the next O is not on the center to block
                    move[0] = 1;//we put it in the center to win
                    move[1] = 1;
                }
                else if (secondstep.get(2) && (r3 != 1) && (c3 != 2)) {// if the next O is not on the right edge to block
                    move[0] = 1;//we put it in the right edge to win
                    move[1] = 2;
                }
                else if (secondstep.get(3) && (r3 != 1) && (c3 != 1)) {// if the next O is not on the center to block
                    move[0] = 1;//we put it in the center to win
                    move[1] = 1;
                }
                else if (secondstep.get(3) && (r3 != 1) && (c3 != 0)) {// if the next O is not on the left edge to block
                    move[0] = 1;//we put it in the left edge to win
                    move[1] = 0;
                }
                else if (secondstep.get(4) && (r3 != 2) && (c3 != 1)) {// if the next O is not on the bottom edge to block
                    move[0] = 2;//we put it in the bottom edge to win
                    move[1] = 1;
                }
                else if (secondstep.get(4) && (r3 != 1) && (c3 != 2)) {// if the next O is not on the right edge to block
                    move[0] = 1;//we put it in the right edge to win
                    move[1] = 2;
                }
                else if (secondstep.get(5) && (r3 != 1) && (c3 != 1)) {// if the next O is not on the center to block
                    move[0] = 1;//we put it in the center to win
                    move[1] = 1;
                }
                else if (secondstep.get(5) && (r3 != 1) && (c3 != 0)) {// if the next O is not on the left edge to block
                    move[0] = 1;//we put it in the left edge to win
                    move[1] = 0;
                }
                else if (secondstep.get(6) && (r3 != 0) && (c3 != 1)) {// if the next O is not on the top edge to block
                    move[0] = 0;//we put it in the top edge to win
                    move[1] = 1;
                }
                else if (secondstep.get(6) && (r3 != 1) && (c3 != 0)) {// if the next O is not on the left edge to block
                    move[0] = 1;//we put it in the left edge to win
                    move[1] = 0;
                }

                else if (secondstep.get(7) && (r3 != 2) && (c3 != 1)) {// if the next O is not on the bottom edge to block
                    move[0] = 2;//we put it in the bottom edge to win
                    move[1] = 1;
                }
                else if (secondstep.get(8) && (r3 != 0) && (c3 != 1)) {// if the next O is not on the top edge to block
                    move[0] = 0;//we put it in the top edge to win
                    move[1] = 1;
                }
                else if (secondstep.get(8) && (r3 == 0) && (c3 == 1)) {// if the next O is on the top edge to block
                    move[0] = 1;//we put it in the left edge to win
                    move[1] = 0;
                }
                else if (secondstep.get(9) && (r3 != 2) && (c3 != 2)) {// if the next O is not on the bottom right corner
                    move[0] = 2;//next move is at the bottom right corner to win
                    move[1] = 2;
                }
                else if (secondstep.get(9) && (r3 == 2) && (c3 == 2)) {// if the next O is on the bottom right corner
                    thirdstep.remove(0);
                    thirdstep.add(0, true);
                    move[0] = 0;//next move is at the top left corner to block and its a draw
                    move[1] = 0;
                }
                else if (secondstep.get(10) && (r3 != 0) && (c3 != 0)) {// if the next O is not on the top left corner
                    move[0] = 0;//next move is at the top left corner to win
                    move[1] = 0;
                }
                else if (secondstep.get(10) && (r3 == 0) && (c3 == 0)) {// if the next O is on the top left corner
                    thirdstep.remove(1);
                    thirdstep.add(1, true);
                    move[0] = 2;//next move is at the bottom right corner to block and its a draw
                    move[1] = 2;
                }
                else if (secondstep.get(11) && (r3 != 2) && (c3 != 2)) {// if the next O is not on the bottom right corner
                    move[0] = 2;//next move is at the bottom right corner to win
                    move[1] = 2;
                }
                else if (secondstep.get(11) && (r3 == 2) && (c3 == 2)) {// if the next O is on the bottom right corner
                    thirdstep.remove(2);
                    thirdstep.add(2, true);
                    move[0] = 0;//next move is at the top left corner to block and its a draw
                    move[1] = 0;
                }
                else if (secondstep.get(12) && (r3 != 0) && (c3 != 0)) {// if the next O is not on the top left corner
                    move[0] = 0;//next move is at the top left corner to win
                    move[1] = 0;
                }
                else if (secondstep.get(12) && (r3 == 0) && (c3 == 0)) {// if the next O is on the bottom right corner
                    thirdstep.remove(3);
                    thirdstep.add(3, true);
                    move[0] = 2;//next move is at the bottom right corner to block and its a draw
                    move[1] = 2;
                }
            }
            else if (GameController.getTurnCount() == 8) {// fifth optional turn
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[0].length; col++) {//loops thru the array to find where the opponent's first O is
                        if (board[row][col] == 2) {
                            if (row != r && row != r2 && row != r3 && col != c && col != c2 && col != c3) {
                                r4 = row;
                                c4 = col;
                            }
                        }
                    }
                }
                if (thirdstep.get(0) && (r4 != 1) && (c4 != 0)) {// if the next O is not on the left edge
                    move[0] = 1;//next move is at the left edge to win
                    move[1] = 0;
                }
                else if (thirdstep.get(0) && (r4 == 1) && (c4 == 0)) {// if the next O is on the left edge
                    move[0] = 1;//next move is at the right edge and draw
                    move[1] = 2;
                }
                else if (thirdstep.get(1) && (r4 != 1) && (c4 != 2)) {// if the next O is not on the right edge
                    move[0] = 1;//next move is at the right edge to win
                    move[1] = 2;
                }
                else if (thirdstep.get(1) && (r4 == 1) && (c4 == 2)) {// if the next O is on the right edge
                    move[0] = 1;//next move is at the left edge and draw
                    move[1] = 0;
                }
                else if (thirdstep.get(2) && (r4 != 1) && (c4 != 0)) {// if the next O is not on the left edge
                    move[0] = 1;//next move is at the left edge to win
                    move[1] = 0;
                }
                else if (thirdstep.get(2) && (r4 == 1) && (c4 == 0)) {// if the next O is on the left edge
                    move[0] = 1;//next move is at the right edge and draw
                    move[1] = 2;
                }
                else if (thirdstep.get(3) && (r4 != 1) && (c4 != 2)) {// if the next O is not on the right edge
                    move[0] = 1;//next move is at the right edge to win
                    move[1] = 2;
                }
                else if (thirdstep.get(3) && (r4 == 1) && (c4 == 2)) {// if the next O is on the right edge
                    move[0] = 1;//next move is at the left edge and draw
                    move[1] = 0;
                }

            }
        }

       /* else if (getPiece() == 2) {//if piece is O
            if (GameController.getTurnCount() == 1) {
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[0].length; col++) {//loops thru the array to find where the opponent's first O is
                        if (board[row][col] == 2) {
                            ro = row;// r = row of opponents x
                            co = col;//c = column of opponents x
                        }
                    }
                }
                if (ro != 1 && co != 1) {// if the X is not at the center
                    firstostep.remove(0);
                    firstostep.add(0, true);
                    move[0] = 1;//next move is at the center
                    move[1] = 1;
                } 
                else if (ro == 1 && co == 1) {// if the X is at the center
                    firstostep.remove(1);
                    firstostep.add(1, true);
                    move[0] = 2;//next move is at the bottom left corner
                    move[1] = 0;
                } 

                
            }
        }
        */

 
        return move;
 
    }
}