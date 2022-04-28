package game;

/**
 * This is the main class that contains code for the game
 * <p>
 * Empty space will be represented by a 0 X's will be represented by a 1 O's will be represented by
 * a 2 Anything higher (3+) or lower (-1-) should not be added to the board
 */
public class TicTacToe {

    // modified to "protected" so that TicTacToeCompetition can access it
    protected int[][] board; //the TicTacToe board

    public TicTacToe() {
        board = new int[3][3];
    }

    //given a row and column, determine if placing a piece there is valid
    //the space must be within the bounds of the board, AND empty
    //return true if it is a legal move, false if illegal
    public boolean isLegalMove(int row, int column) {
        if (row < 0 || row >= 3) {
            return false;
        }
        if (column < 0 || column >= 3) {
            return false;
        }
        if (board[row][column] != 0) {
            return false;
        }
        return true;
    }

    //this method will place a game piece (X or 0) at the row/column
    //piece will be 1 for an X, 2 for an O
    //moves are submitted as a length 2 integer array, first number is the row, second is the column
    public void placePiece(int[] move, int piece) {
        //if a null move is submitted, exit skipping the player's turn
        if (move == null) {
            System.out.println("Illegal Move Attempted");
            return;
        }
        int row = move[0];
        int column = move[1];
        if (isLegalMove(row, column)) {
            board[row][column] = piece;
        } else {
            System.out.println("Illegal Move Attempted");
        }
    }


    //print out the current board state so the humans can read it
    public void printBoard() {
        int current = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                current = board[i][j];
                if (current == 0) {
                    System.out.print(" " + " | ");
                } else if (current == 1) {
                    System.out.print("X" + " | ");
                } else if (current == 2) {
                    System.out.print("O" + " | ");
                }
            }
            System.out.println();

        }
    }

    //examines the current board and determines if the game is over
    //returns 0 if the game is still going
    //returns 1 if X player wins
    //returns 2 if O player wins
    //returns 3 if the game is a tie
    public int gameOver() {

        for (int i = 0; i < 3; i++) {
            //check if X player has 3 in a row anywhere
            if (getRowCount(i, 1) == 3 || getColumnCount(i, 1) == 3 || getDiagonal(1)) {
                return 1; //X player won
            }

            //check if O player has 3 in a row anywhere
            if (getRowCount(i, 2) == 3 || getColumnCount(i, 2) == 3 || getDiagonal(2)) {
                return 2; //O player won
            }
        }

        //if no player has 3 in a row, check for tie
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return 0; //there is an empty space on the board, game is still going.

                    //Yes I know sometimes draws are inevitable even if there are squares
                    //but we play until the board is full because I don't want to code the rest
                }
            }
        }

        //The game has tied
        return 3;
    }

    //returns the number of spaces a given player occupies in a given row
    //row is the row to check, 0 = first, 1 = second, 2 = third
    //player will be 1 for X player 2 for O player
    public int getRowCount(int row, int player) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (board[row][i] == player) {
                counter++;
            }
        }

        return counter;
    }

    //same as getRowCount but for columns
    public int getColumnCount(int column, int player) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][column] == player) {
                counter++;
            }
        }

        return counter;
    }

    //checks if the given player has 3 in a row diagonal
    public boolean getDiagonal(int player) {
        //left to right diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        //right to left diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    //returns a COPY of the current board for the AI's to read
    //This prevents AI's from having direct access to the board, to cheat for example
    public int[][] getBoard() {
        int[][] boardCopy = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        return boardCopy;
    }

    //resets the board to all 0s (empty)
    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }
}