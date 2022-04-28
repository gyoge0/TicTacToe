package competition;

import game.TicTacToe;

/** {@link TicTacToe} but without the illegal move prints */
public class TicTacToeCompetition extends TicTacToe {

    @Override
    //this method will place a game piece (X or 0) at the row/column
    //piece will be 1 for an X, 2 for an O
    //moves are submitted as a length 2 integer array, first number is the row, second is the column
    public void placePiece(int[] move, int piece) {
        //if a null move is submitted, exit skipping the player's turn
        if (move == null) {
            return;
        }
        int row = move[0];
        int column = move[1];
        if (isLegalMove(row, column)) {
            this.board[row][column] = piece;
        }
    }
}
