package com.gyoge.itcs.ttt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import game.GameController;
import game.TicTacToePlayer;

public class GrandMaster extends TicTacToePlayer {

    public GrandMaster(String aName, int aPiece) {
        super(aName, aPiece);
    }

    HashMap<int[][], int[]> cache = new HashMap<>();

    @Override
    public int[] playTurn() {
        int[][] board = GameController.game.getBoard();
        if (cache.containsKey(board)) {
            return cache.get(board);
        }

        for (int[] row : board) {
            for (int i = 0; i < row.length; i++) {
                row[i] = row[i] == 2 ? -1 : row[i];
            }
        }
        Integer[] move = new Position(getPiece() == 2 ? -1 : getPiece(), board).bestMove();
        cache.put(board, new int[]{move[0], move[1]});
        return new int[]{move[0], move[1]};
    }
}

class Position {

    private final int[][] board;
    private final int turn;

    public Position() {
        this.turn = 1;
        this.board = new int[3][3];
    }

    public Position(int turn) {
        this.turn = turn;
        this.board = new int[3][3];
    }

    public Position(int turn, int[][] board) {
        this.turn = turn;
        this.board = board;
    }

    public int getTurn() {
        return turn;
    }

    @SuppressWarnings("unused")
    public int[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Position move(Integer[] move) {
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, 3);
        }

        newBoard[move[0]][move[1]] = turn;

        return new Position(-turn, newBoard);
    }

    public Integer[][] possibleMoves() {
        List<Integer[]> moves = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    moves.add(new Integer[]{i, j});
                }
            }
        }

        return moves.toArray(new Integer[moves.size()][]);
    }


    /**
     * @param idx    the column index
     * @param player the player to check for
     * @return whether the column has a win for the player
     */
    private boolean columnWin(int idx, int player) {
        for (int[] row : board) {
            if (row[idx] != player) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param player The player to check for
     * @return whether the board has a win for the player
     */
    public boolean isWin(int player) {
        for (int[] row : board) {
            if (Arrays.stream(row).allMatch(i -> i == player)) {
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (columnWin(i, player)) {
                return true;
            }
        }

        // hard coded logic ig
        return (board[0][0] == player
            && board[1][1] == player
            && board[2][2] == player)
            || (board[0][2] == player
            && board[1][1] == player
            && board[2][0] == player);

    }

    public int miniMax(int alpha, int beta) {
        if (isWin(1)) {
            return 100;
        } else if (isWin(-1)) {
            return -100;
        } else if (possibleMoves().length == 0) {
            return 0;
        }

        Integer miniMax = null;
        for (Integer[] move : possibleMoves()) {
            int score = move(move).miniMax(alpha, beta);
            if (miniMax == null || turn == 1 && score > miniMax || turn == -1 && score < miniMax) {
                miniMax = score;
            }
            if (turn == 1 && score > alpha) {
                alpha = score;
            } else if (turn == -1 && score < beta) {
                beta = score;
            }

            if (turn == 1 && alpha >= beta || turn == -1 && alpha <= beta) {
                break;
            }
        }

        if (miniMax == null) {
            throw new RuntimeException("No moves found");
        }

        // If it's our turn, penalize 1 for the depth (miniMax - 1))
        // If its the opponent's turn, penalize -1 for the depth (miniMax - (-1))
        // turn is going to be what we want to subtract, so we get this neat solution
        return miniMax - turn;
    }

    public Integer[] bestMove() {
        Integer miniMax = null;
        Integer[] bestMove = null;
        Integer[][] possibleMoves = possibleMoves();
        for (Integer[] move : possibleMoves) {
            int score = move(move).miniMax(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (miniMax == null || turn == 1 && score > miniMax || turn == -1 && score < miniMax) {
                miniMax = score;
                bestMove = move;
            }
        }

        if (miniMax == null) {
            throw new RuntimeException("No moves found");
        }

        return bestMove;
    }

}
