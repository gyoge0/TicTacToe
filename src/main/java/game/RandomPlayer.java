package game;

/** Example player */
public class RandomPlayer extends TicTacToePlayer {

    public RandomPlayer(String name, int piece) {
        super(name, piece);
    }

    //100% random
    //does not check if the space is occupied or not
    //total garbage
    public int[] playTurn() {
        int[] move = new int[2];
        move[0] = (int) (Math.random() * 3);
        move[1] = (int) (Math.random() * 3);
        return move;
    }
}
