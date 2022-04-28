package opponents;

import java.util.HashMap;
import game.GameController;
import game.TicTacToePlayer;

public class BadTicTacToeBotThatIsVerySlow extends TicTacToePlayer{
    private HashMap<Integer, Integer> cache;
    private int move;
    private boolean isX;

    public BadTicTacToeBotThatIsVerySlow(String name, int piece) {
        super(name, piece);
        cache = new HashMap<>();
        isX = (piece == 1);
    }
    //half of this was transcribed from stackoverflow bc im bad at algorithms
    //get pos
    private int gp(int b, int r, int c) {
        return b / (int) Math.pow(3, c + r * 3) % 3;
    }

    private int gp(int b, int p) {
        return b / (int) Math.pow(3, p) % 3;
    }

    //count amt of rows by player
    public int getRowCountByPlayer(int r, int p, int b) {
        int x = 0;
        for (int i = 0; i < 3; i++) {
            if (gp(b, r, i) == p) {
                x++;
            }
        }
        return x;
    }

    public int getColCountByPlayer(int c, int p, int b) {
        int x = 0;
        for (int i = 0; i < 3; i++) {
            if (gp(b, i, c) == p) {
                x++;
            }
        }
        return x;
    }

    //get diagonal
    public boolean gd(int p, int b) {
        if (gp(b, 0, 0) == p
                && gp(b, 1, 1) == p
                && gp(b, 2, 2) == p) {
            return true;
        }

        if (gp(b, 0, 2) == p
                && gp(b, 1, 1) == p
                && gp(b, 2, 0) == p) {
            return true;
        }
        return false;
    }

    //game over
    public int isGO(int b) {
        for (int i = 0; i < 3; i++) {
            if (getRowCountByPlayer(i, 1, b) == 3 || getColCountByPlayer(i, 1, b) == 3 || gd(1, b)) return 1;
            if (getRowCountByPlayer(i, 2, b) == 3 || getColCountByPlayer(i, 2, b) == 3 || gd(2, b)) return 2;
        }

        for (int i = 0; i < 9; i++) {
            if (gp(b, i) == 0) return 0;
        }
        return 3;
    }

    //format so its applicable
    private int format(int[][] b, int t) {
        int f_s = 0;
        for (int i = 0; i < 9; i++) {
            f_s += b[i / 3][i % 3] * Math.pow(3, i);
        }
        
        return f_s * (t == 0 ? 1 : -1);
    }

    private int minimax(int b, int depth) {
        depth++;
        int s = isGO(Math.abs(b));
        //since tictactoe is 9 total moves, have depth of 9; min sep 3
        if(s == 3) return 0;
        else {
            if(s == 1) return isX ? 10 - depth : -10 + depth;
            else if (s == 2) return isX ? -10 + depth : 10 - depth;
        }

        //iter through max and min
        int t = (b > 0) ? 0 : 1;
        int bm = -1;
        boolean max = ((isX ? 0 : 1) == t);
        int bs = max ? Integer.MIN_VALUE : Integer.MAX_VALUE; //this will slowly shrink
        for (int i = 0; i < 9; i++) {
            if (gp(b, i) != 0) continue; //stolen from stack overflow, again.
            //evaluation
            int nb = (b < 0 ? 1 : -1)
                    * (Math.abs(b) + (int) Math.pow(3, i) * (t + 1));
            int score = minimax(nb, depth);

            //compare and shrink
            if ((max && (score > bs))
                    || (!max && (score < bs))) {
                bs = score;
                bm = i;
            }
        }

        move = bm;
        return bs;
    }

    public int[] playTurn() {
        int b = format(GameController.game.getBoard(), isX ? 0 : 1);

        //read from cache
        int m;
        if(!cache.containsKey(b)){
            minimax(b, 0);
            cache.put(b, move);
            m = move;
        } else {
            m = cache.get(b);
        }

        //return move
        return new int[] { m / 3, m % 3 };
    }
}
