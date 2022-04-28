package opponents;//if center is open play in center asap (should be within first 2 moves)
import game.GameController;
import game.TicTacToePlayer;
//otherwise check for rows of 2 which force either a block or win
//otherwise play in corners: prioritize corners with less of the opponent's pieces around
//otherwise play in mids: prioritize mids with less of the opponent's pieces around

public class StarWalker extends TicTacToePlayer{
    int[][] board = new int[3][3];
    int[][] savedBoard = board;
    int[] thisLastMove = new int[2];
    int piece;
    int turnCount = 0;

    public StarWalker(String aName, int aPiece) {
        super(aName, aPiece);
        piece = aPiece;
    }

    public int[] getLastMove() throws Exception {
        for (int row = 0; row < 3; row++) {
            for (int i = 0; i < 3; i++) {
                if (board[row][i] != savedBoard[row][i]) {
                    return new int[]{row, i};
                }
            }
        }
        throw new Exception("No move change");
    }

    //two in row, whether opponent or player
    public int[] twoInRow(int[] lastMove, int checkPiece) {
        if (lastMove.length != 2) {
            return new int[] {-1, -1};
        }

        //horizontal
        if (twoInRowHorizontal(checkPiece)[0] != -1) {
            return twoInRowHorizontal(checkPiece);
        }

        //vertical
        else if (twoInRowVertical(checkPiece)[0] != -1) {
            return twoInRowVertical(checkPiece);
        }
        
        //diagonal
        else if (twoInRowDiagonal(checkPiece)[0] != -1){
            return twoInRowDiagonal(checkPiece);
        }
        return new int[] {-1, -1};
    }

    public int[] twoInRowVertical (int checkPiece) {
        for (int column = 0; column < 3; column++) {
            //between
            if (board[0][column] == checkPiece && board[0][column] == board[2][column] && board[1][column] == 0){
                return new int[]{1, column};
            }
            //top
            if (board[1][column] == checkPiece && board[1][column] == board[2][column] && board[0][column] == 0) {
                return new int[]{0, column};
            }
            //bottom
            if (board[0][column] == checkPiece && board[0][column] == board[1][column] && board[2][column] == 0) {
                return new int[]{2, column};
            }
        }
        return new int[] {-1, -1};
    }

    public int[] twoInRowHorizontal (int checkPiece) {
        for (int row = 0; row < 3; row++) {
            //between
            if (board[row][0] == checkPiece && board[row][0] == board[row][2] && board[row][1] == 0){
                return new int[]{row, 1};
            }
            //left
            if (board[row][1] == checkPiece && board[row][1] == board[row][2] && board[row][0] == 0) {
                return new int[]{row, 0};
            }
            //right
            if (board[row][0] == checkPiece && board[row][0] == board[row][1] && board[row][2] == 0) {
                return new int[]{row, 2};
            }
        }
        return new int[] {-1, -1};
    }

    public int[] twoInRowDiagonal(int checkPiece) {
        if (board[1][1] == checkPiece) {
            for (int i = 0; i < 3; i+=2) {
                for (int j = 0; j < 3; j+=2){
                    if(board[i][j] == checkPiece && board[2-i][2-j] == 0) {
                        return new int[] {2-i, 2-j};
                    }
                }
            }
        }
        if (isInOppositeCorner(checkPiece) && board[1][1] == 0) {
            return new int[] {1, 1};
        }
        return new int[] {-1, -1};
    }

    public boolean isInOppositeCorner(int piece) {
        for (int i = 0; i < 3; i+=2) {
            for (int j = 0; j < 3; j+=2){
                if (board[i][j] == piece && board[2-i][2-j] == piece) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] playCorners() {
        for (int i = 0; i < 3; i+=2) {
            for (int j = 0; j < 3; j+=2){
                if (board[i][j] == 0 && board[2-i][2-j] != 0 && board[2-i][2-j] != piece) {
                    return new int[]{i, j};
                }
            }
        }

        for (int i = 0; i < 3; i+=2) {
            for (int j = 0; j < 3; j+=2){
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public int[] playSides() {
        for (int i = 0; i < 3; i++) {
            if (board[i][(i+1)%2] == 0) {
                return new int[]{i, (i+1)%2};
            }
            if (i==1){
                if (board[i][2] == 0) {
                    return new int[]{i, 2};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public void setAllValues(int[] move) {
        savedBoard[move[0]][move[1]] = piece;
        thisLastMove = move;
    }

    public void init () {
        savedBoard = new int[3][3];
        thisLastMove = new int[2];
        turnCount = 0;
    }

    public boolean isNewBoard(int[][] board) {
        int sum = 0;

        for (int[] row : board) {
            for (int i : row) {
                sum+=i;
            }
        }
        return sum < piece;
    }

    @Override
    public int[] playTurn() {
        board = GameController.game.getBoard();
        if (isNewBoard(board)) {
            init();
        }
        turnCount++;
        int[] move = new int[2];

        if (board[1][1] == 0) {
            move[0] = 1;
            move[1] = 1;
            setAllValues(move);
            return move;
        }

        if (isInOppositeCorner(3 - piece) && turnCount == 2 && piece == 2) {
            move = playSides();
            setAllValues(move);
            return move;
        }

        int[] lastMove = new int[0];

        try {
            lastMove = getLastMove();
        }
        catch (Exception e) {
//            System.out.println(e);
            // had to comment this out
        }

        if (twoInRow(thisLastMove, piece)[0] != -1) {
            move = twoInRow(thisLastMove, piece);
            setAllValues(move);
            return move;
        }

        //prioritizes attack over defense (own rows of 2 over opponent's)
        if (twoInRow(lastMove, 3-piece)[0] != -1) {
            move = twoInRow(lastMove, 3-piece);
            setAllValues(move);
            return move;
        }

        if (playCorners()[0] != -1) {
            move = playCorners();
            setAllValues(move);
            return move;
        }

        if (playSides()[0] != -1) {
            move = playSides();
            setAllValues(move);
            return move;
        }

        setAllValues(move);
        return move;
    }
}
