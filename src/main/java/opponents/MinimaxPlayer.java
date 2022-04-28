package opponents;// Adam + Yogesh
import game.GameController;
import game.TicTacToePlayer;

import java.util.HashMap;

public class MinimaxPlayer extends TicTacToePlayer {
    private boolean amIX;
    private int moveChoice;

    private HashMap<Integer, Integer> cache;

    public MinimaxPlayer(String name, int piece) {
        super(name, piece);
        amIX = piece == 1;
        cache = new HashMap<>();
    }

    private int getPosition(int board, int row, int column) {
        return board / (int) Math.pow(3, row * 3 + column) % 3;
    }

    private int getPosition(int board, int position) {
        return board / (int) Math.pow(3, position) % 3;
    }

    // Stolen straight from `TicTacToe`

    public int getRowCount(int row, int player, int board) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (getPosition(board, row, i) == player) {
                counter++;
            }
        }

        return counter;
    }

    public int getColumnCount(int column, int player, int board) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (getPosition(board, i, column) == player) {
                counter++;
            }
        }

        return counter;
    }

    public boolean getDiagonal(int player, int board) {
        // left to right diagonal
        if (getPosition(board, 0, 0) == player && getPosition(board, 1, 1) == player
                && getPosition(board, 2, 2) == player) {
            return true;
        }
        // right to left diagonal
        if (getPosition(board, 0, 2) == player && getPosition(board, 1, 1) == player
                && getPosition(board, 2, 0) == player) {
            return true;
        }
        return false;
    }

    // examines the current board and determines if the game is over
    // returns 0 if the game is still going
    // returns 1 if X player wins
    // returns 2 if O player wins
    // returns 3 if the game is a tie
    public int isGameOver(int board) {
        for (int i = 0; i < 3; i++) {
            // check if X player has 3 in a row anywhere
            if (getRowCount(i, 1, board) == 3 || getColumnCount(i, 1, board) == 3 || getDiagonal(1, board)) {
                return 1; // X player won
            }

            // check if O player has 3 in a row anywhere
            if (getRowCount(i, 2, board) == 3 || getColumnCount(i, 2, board) == 3 || getDiagonal(2, board)) {
                return 2; // O player won
            }
        }

        // if no player has 3 in a row, check for tie
        for (int i = 0; i < 9; i++) {
            if (getPosition(board, i) == 0) {
                return 0; // there is an empty space on the board, game is still going.
            }
        }

        // The game has tied
        return 3;
    }

    private int encodeBoard(int[][] board, int turn) {
        int id = 0;

        for (int i = 0; i < 9; i++) {
            id += board[i / 3][i % 3] * Math.pow(3, i);
        }

        return id * (turn == 0 ? 1 : -1);
    }

    private int minimax(int board, int depth) {
        depth += 1;
        // Return score if game is over
        switch (isGameOver(Math.abs(board))) {
        case 1:
            return amIX ? 10 - depth : -10 + depth;
        case 2:
            return amIX ? -10 + depth : 10 - depth;
        case 3:
            return 0;
        }

        int turn = board > 0 ? 0 : 1;

        boolean maxing = (amIX ? 0 : 1) == turn;

        int bestMove = -1;
        int bestScore = maxing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 9; i++) {
            if (getPosition(board, i) != 0) {
                continue;
            }

            int newBoard = (board < 0 ? 1 : -1) * (Math.abs(board) + (int) Math.pow(3, i) * (turn + 1));

            int score = minimax(newBoard, depth);

            if ((maxing && score > bestScore) || (!maxing && score < bestScore)) {
                bestScore = score;
                bestMove = i;
            }
        }

        moveChoice = bestMove;
        return bestScore;
    }

    public int[] playTurn() {
        int move = cache.computeIfAbsent(encodeBoard(GameController.game.getBoard(), amIX ? 0 : 1), k -> {
            minimax(k, 0);
            return moveChoice;
        });
        return new int[] { move / 3, move % 3 };
    }
}
