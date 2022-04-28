package opponents;//Ted Lantow + Hayden Patel
import game.GameController;
import game.TicTacToePlayer;

public class GaydenPlayer extends TicTacToePlayer{
    private String name;  //Player's name
    private int piece; //Piece type, 1 = X, 2 = O

    public GaydenPlayer(String aName, int aPiece) {
        super(aName, aPiece);
        piece = aPiece;
        name = aName;
    }

    public String getName() {
        return name;
    }

    public int getPiece() {
        return piece;
    }

    //All players must be able to play a turn
    public int[] playTurn(){
        int[][] board = GameController.game.getBoard();
        int[] move = new int[2];

        if(piece == 1){
            if(board[0][0] == 0){
                move[0] = 0;
                move[1] = 0;;
                return move;
            }
            if(board[1][1] == 0){
                move[0] = 1;
                move[1] = 1;
                return move;
            }else if(board[2][2] == 0){
                move[0] = 2;
                move[1] = 2;
                return move;
            }

            //Checks if we are in corners.
            if(board[0][2] == 1 && board[2][2] == 1 && board[1][2] == 0){
                move[0] = 1;
                move[1] = 2;
                return move;
            }else if(board[2][0] == 1 && board[2][2] == 1  && board[2][1] == 0){
                move[0] = 2;
                move[1] = 1;
                return move;
            }

            //Checks center and blocks
            if(board[1][1] == 2){
                if(board[0][1] == 2 && board[2][1] == 0){
                    move[0] = 2;
                    move[1] = 1;
                    return move;
                }else if(board[2][1] == 2 && board[0][1] == 0){
                    move[0] = 0;
                    move[1] = 1;
                    return move;
                }else if(board[1][0] == 2 && board[1][2] == 0){
                    move[0] = 1;
                    move[1] = 2;
                    return move;
                }else if(board[1][2] == 2 && board[1][0] == 0){
                    move[0] = 1;
                    move[1] = 0;
                    return move;
                }
            }

            if(board[2][2] == 2 && board[2][1] == 2 && board[2][0] == 0){
                move[0] = 2;
                move[1] = 0;
                return move;
            }else if(board[2][2] == 2 && board[1][2] == 2 && board[0][2] == 0){
                move[0] = 0;
                move[1] = 2;
                return move;
            }

            //Checks if they are in corners
            //Moves if not in corners
            if(board[0][2] == 2 && board[2][2] == 2 && board[1][2] == 0){
                move[0] = 1;
                move[1] = 2;
                return move;
            }else if(board[2][0] == 2 && board[2][2] == 2 && board[2][1] == 0){
                move[0] = 2;
                move[1] = 1;
                return move;
            }else{
                if(board[0][2] == 0){
                    move[0] = 0;
                    move[1] = 2;
                    return move;
                }else if(board[2][0] == 0){
                    move[0] = 2;
                    move[1] = 0;
                    return move;
                }
            }
        }


        if(piece == 2){
            if(board[1][1] == 0){
                move[0] = 1;
                move[1] = 1;
                return move;
            }

            //Checks if we are in corners.
            if(board[0][2] == 2 && board[2][2] == 2 && board[1][2] == 0){
                move[0] = 1;
                move[1] = 2;
                return move;
            }else if(board[2][0] == 2 && board[2][2] == 2  && board[2][1] == 0){
                move[0] = 2;
                move[1] = 1;
                return move;
            }

            //Wins if owns two pieces in middle
            if(board[1][1] == 2){
                if(board[0][1] == 2 && board[2][1] == 0){
                    move[0] = 2;
                    move[1] = 1;
                    return move;
                }else if(board[2][1] == 2 && board[0][1] == 0){
                    move[0] = 0;
                    move[1] = 1;
                    return move;
                }else if(board[1][2] == 2 && board[1][0] == 0){
                    move[0] = 1;
                    move[1] = 0;
                    return move;
                }else if(board[1][0] == 2 && board[1][2] == 0){
                    move[0] = 1;
                    move[1] = 2;
                    return move;
                }
            }

            //Checks center and blocks
            if(board[1][1] == 1){
                if(board[0][1] == 1 && board[2][1] == 0){
                    move[0] = 2;
                    move[1] = 1;
                    return move;
                }else if(board[2][1] == 1 && board[0][1] == 0){
                    move[0] = 0;
                    move[1] = 1;
                    return move;
                }else if(board[1][0] == 1 && board[1][2] == 0){
                    move[0] = 1;
                    move[1] = 2;
                    return move;
                }else if(board[1][2] == 1 && board[1][0] == 0){
                    move[0] = 1;
                    move[1] = 0;
                    return move;
                }
            }


            //Checks for two in a row on edges
            if(board[2][2] == 1 && board[2][1] == 1 && board[2][0] == 0){
                move[0] = 2;
                move[1] = 0;
                return move;
            }else if(board[2][2] == 1 && board[1][2] == 1 && board[0][2] == 0){
                move[0] = 0;
                move[1] = 2;
                return move;
            }else if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 0){
                move[0] = 2;
                move[1] = 2;
                return move;
            }else if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 0){
                move[0] = 2;
                move[1] = 2;
                return move;
            }else if(board[2][0] == 1 && board[1][0] == 1 && board[0][0] == 0){
                move[0] = 0;
                move[1] = 0;
                return move;
            }else if(board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 0){
                move[0] = 2;
                move[1] = 0;
                return move;
            }else if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 0){
                move[0] = 0;
                move[1] = 2;
                return move;
            }else if(board[0][0] == 0 && board[0][1] == 1 && board[0][2] == 1){
                move[0] = 0;
                move[1] = 0;
                return move;
            }

            //Checks if they are in corners
            //Moves if not in corners
            if(board[0][2] == 1 && board[2][2] == 1 && board[1][2] == 0){
                move[0] = 1;
                move[1] = 2;
                return move;
            }else if(board[2][0] == 1 && board[2][2] == 1 && board[2][1] == 0){
                move[0] = 2;
                move[1] = 1;
                return move;
            }else if(board[0][0] == 1 && board[2][0] == 1 && board[1][0] == 0){
                move[0] = 1;
                move[1] = 0;
                return move;
            }else{
                if(board[0][2] == 0){
                    move[0] = 0;
                    move[1] = 2;
                    return move;
                }else if(board[2][0] == 0){
                    move[0] = 2;
                    move[1] = 0;
                    return move;
                }else if(board[0][0] == 0){
                    move[0] = 0;
                    move[1] = 0;
                    return move;
                }
            }
            //second move go next to other players corner piece
        }
        return move;
    }
}
