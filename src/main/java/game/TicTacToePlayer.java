package game;

/**
 * Defines general behavior of all players (AI and Human)
 */
public abstract class TicTacToePlayer {

    private String name;  //Player's name
    private int piece; //Piece type, 1 = X, 2 = O

    public TicTacToePlayer(String aName, int aPiece) {
        name = aName;
        piece = aPiece;
    }

    public String getName() {
        return name;
    }

    public int getPiece() {
        return piece;
    }

    //All players must be able to play a turn
    public abstract int[] playTurn();
}