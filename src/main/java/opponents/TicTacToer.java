package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class TicTacToer extends TicTacToePlayer {

    public TicTacToer(String aName, int aPiece) {
        super(aName, aPiece);
    }

    //int[][] board = GameController.game.getBoard();
    //      the board as a 2d array
    //      0 = empty space; 1 = X; 2 = 0
    //
    //int piece = getPiece();
    //      what peice you are
    //      1 = X; 2 = 0
    //
    //GameController.game.printBoard();
    //      prints the board
    //
    //int curTurn = GameController.getTurnCount();
    //      Get the number of turns that have elapsed in the current game.
    //      The turn counter is incremented each time either player plays a piece.

    public int[] playTurn() {
        int[] move = null;
        if(move == null) {
            move = firstMove();
        }
        if(move == null) {
            move = block();
        }
        if(move == null) {
            move = buildFork();
        }
        if(move == null) {
            move = emptySpot();
        }

        return move;
    }

    public int[] firstMove() {
        int[][] board = GameController.game.getBoard();

        if(GameController.getTurnCount() < 2) {
            if (GameController.getTurnCount() == 0) {
                return emptySpot();
            } else {
                //if it only contains 0s and 2s then it's a corner
                //if it has one 1 it's a side
                //if it has only 1s it's the center
                int[] playedSpace = new int[] {-1, -1};
                for (int r = 0; r < board.length; r++) {
                    for (int c = 0; c < board[0].length; c++) {
                        if (board[r][c] != 0) {
                            playedSpace = new int[] {r, c};
                        }
                    }
                }

                if(playedSpace.equals(new int[]{1, 1})) {   //if they played the center, play a corner
                    return emptySpot();
                }
                if(playedSpace[0] == 1) {   //if they played a side, play the opposite side
                    if(playedSpace[1] == 0) {
                        return new int[] {1, 2};
                    }
                    return new int[] {1, 0};
                }
                if(playedSpace[1] == 1) {   //if they played a side, play the opposite side
                    if(playedSpace[0] == 0) {
                        return new int[] {2, 1};
                    }
                    return new int[] {0, 1};
                }   //if they played a corner, play the center
                return new int[] {1, 1};
            }
        }
        return null;
    }

    private int[] emptySpot() {
        int[][] board = GameController.game.getBoard();

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == 0) {
                    return new int[] {r, c};
                }
            }
        }
        return new int[] {0, 0};
    }

    public int[] block() {
        int[][] board = GameController.game.getBoard();

        for(int r = 0; r < board.length; r++) {
            if (board[r][0] != 0 && board[r][0] == board[r][1] && board[r][2] == 0) {
                return new int[]{r, 2};
            }
            if (board[r][1] != 0 && board[r][1] == board[r][2] && board[r][0] == 0) {
                return new int[]{r, 0};
            }
            if (board[r][2] != 0 && board[r][2] == board[r][0] && board[r][1] == 0) {
                return new int[]{r, 1};
            }
        }
        for(int c = 0; c < board[0].length; c++) {
            if (board[0][c] != 0 && board[0][c] == board[1][c] && board[2][c] == 0) {
                return new int[]{2, c};
            }
            if (board[1][c] != 0 && board[1][c] == board[2][c] && board[0][c] == 0) {
                return new int[]{0, c};
            }
            if (board[2][c] != 0 && board[2][c] == board[0][c] && board[1][c] == 0) {
                return new int[]{1, c};
            }
        }
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[2][2] == 0) {
            return new int[]{2, 2};
        }
        if (board[1][1] != 0 && board[1][1] == board[2][2] && board[0][0] == 0) {
            return new int[]{0, 0};
        }
        if (board[2][0] != 0 && board[2][0] == board[1][1] && board[0][2] == 0) {
            return new int[]{0, 2};
        }
        if (board[1][1] != 0 && board[1][1] == board[0][2] && board[2][0] == 0) {
            return new int[]{2, 0};
        }
        return null;
    }

    public int[] buildFork() {
        int[][] board = GameController.game.getBoard();

        for(int r = 0; r < board.length; r++) {     //checks rows
            int emptySpaces = 0;
            int ourPieceColumn = -1;
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == getPiece()) {
                    ourPieceColumn = c;
                } else if(board[r][c] == 0) {
                    emptySpaces++;
                }
            }
            if (emptySpaces == 2 && ourPieceColumn != -1) {
                for(int c2 = 0; c2 < board.length; c2++) {
                    if(c2 != ourPieceColumn && hasTheirPieceColumn(c2)) {
                        return new int[] {r, c2};
                    }
                }
                return new int[] {r, ourPieceColumn == 0? 2 : 0};
            }
        }

        for(int c = 0; c < board.length; c++) {     //checks columns
            int emptySpaces = 0;
            int ourPieceRow = -1;
            for(int r = 0; r < board[0].length; r++) {
                if(board[r][c] == getPiece()) {
                    ourPieceRow = r;
                } else if(board[r][c] == 0) {
                    emptySpaces++;
                }
            }
            if (emptySpaces == 2 && ourPieceRow != -1) {
                for(int r2 = 0; r2 < board.length; r2++) {
                    if(r2 != ourPieceRow && hasTheirPieceRow(r2)) {
                        return new int[] {r2, c};
                    }
                }
                return new int[] {ourPieceRow == 0? 2 : 0, c};
            }
        }

        int emptySpaces = 0;
        int ourPiecePos = -1;
        for(int i = 0; i < board.length; i++) {     //checks the diagonal going from top left to bottom right
            if(board[i][i] == getPiece()) {
                ourPiecePos = i;
            } else if(board[i][i] == 0) {
                emptySpaces++;
            }
        }
        if (emptySpaces == 2 && ourPiecePos != -1) {
            if (ourPiecePos == 0) {
                if (hasTheirPieceColumn(1)) {
                    return new int[]{1, 1};
                }
                return new int[]{2, 2};
            }
            if (ourPiecePos == 1) {
                if (hasTheirPieceColumn(0)) {
                    return new int[]{0, 0};
                }
                return new int[]{2, 2};
            }
            if (hasTheirPieceColumn(0)) {
                return new int[]{0, 0};
            }
            return new int[]{1, 1};
        }

        emptySpaces = 0;
        ourPiecePos = -1;
        for(int i = 0; i < board.length; i++) {     //checks the diagonal going from bottom left to top right
            if(board[i][2 - i] == getPiece()) {
                ourPiecePos = i;
            } else if(board[i][2 - i] == 0) {
                emptySpaces++;
            }
        }
        if (emptySpaces == 2 && ourPiecePos != -1) {
            if (ourPiecePos == 0) {
                if (hasTheirPieceRow(1)) {
                    return new int[]{1, 1};
                }
                return new int[]{2, 0};
            }
            if (ourPiecePos == 1) {
                if (hasTheirPieceRow(0)) {
                    return new int[]{2, 0};
                }
                return new int[]{2, 0};
            }
            if (hasTheirPieceRow(0)) {
                return new int[]{2, 0};
            }
            return new int[]{1, 1};
        }
        return null;
    }

    public boolean hasTheirPieceRow(int r) {
        int[][] board = GameController.game.getBoard();

        for(int c = 0; c < board[0].length; c++) {
            if(board[r][c] != 0 && board[r][c] != getPiece()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTheirPieceColumn(int c) {
        int[][] board = GameController.game.getBoard();

        for(int r = 0; r < board[0].length; r++) {
            if(board[r][c] != 0 && board[r][c] != getPiece()) {
                return true;
            }
        }
        return false;
    }
}
