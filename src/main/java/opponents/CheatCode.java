package opponents;
import game.GameController;
import game.TicTacToePlayer;

//Example player
//Example player
public class CheatCode extends TicTacToePlayer {

    public CheatCode(String name, int piece) {
        super(name, piece);
    }

    //100% random
    //does not check if the space is occupied or not
    //total garbage
    public int[] playTurn() {
        int[] move = new int[2];
        int[][] board = GameController.game.getBoard();
        int piece = getPiece();

        //example
        //left: enemy

        //if (board[1][1] != piece && board[1][1] != 0) {};

        // starts from bottom left
        move [0] = 2;
        move [1] = 0;

        //left series
        if (board[0][0] != 0 || board[0][1] != 0 || board [1][0] != 0){
            move [0] = 2;
            move [1] = 2;
            //[1][0]: enemy [0][0] spot
            if (board [1][0] != 0 && board[0][0] == piece){
                move [0] = 0;
                move [1] = 2;
                if (board [0][1] == 0 && board [1][1]!=0){
                    move [0] = 0;
                    move [1] = 1;
                }
                else if (board [0][1] != 0 && board [1][1]==0){
                    move [0] = 1;
                    move [1] = 1;
                }
            }
            else if (board [0][0] == 0 && board [1][0] != 0){
                move [0] = 2;
                move [1] = 2;
                if (board [2][1] != 0){
                    move[0] = 0;
                    move[1] = 2;
                    if (board [1][1] !=0 && board [1][2] == 0){
                        move [0] = 1;
                        move [1] = 2;
                    }
                    else if (board [1][1] ==0 && board [1][2] != 0){
                        move [0] = 1;
                        move [1] = 1;
                    }
                }
            }
            else if (board [0][0] !=0 && board [0][1] == 0){
                move [0] = 2;
                move [1] = 2;
                if (board [2][1] != 0){
                    move[0] = 0;
                    move[1] = 2;
                    if (board [1][1] !=0 && board [1][2] == 0){
                        move [0] = 1;
                        move [1] = 2;
                    }
                    else if (board [1][1] ==0 && board [1][2] != 0){
                        move [0] = 1;
                        move [1] = 1;
                    }
                }
            }
            else if (board [0][1] !=0){
                move [0] = 2;
                move [1] = 2;
                if (board [2][1] != 0) {
                    move[0] = 0;
                    move[1] = 2;

                        move[0] = 1;
                        move[1] = 1;
                        if (board[0][2] !=0 && board[0][0] ==0){
                            move[0] = 0;
                            move[1] = 0;
                        }
                        else if (board[0][2] == 0 && board[0][0] != 0){
                            move[0] = 0;
                            move[1] = 2;
                        }
                }
            }
        }

        //right series
        else if (board [2][2] != 0 || board [2][1] != 0|| board [1][2] != 0){
            move [0] = 0;
            move [1] = 0;
           if (board [1][0] != 0 && board [2][2] != 0){
               move [0] = 0;
               move [1] = 2;
               if (board [1][1] == 0 && board[0][1] !=0){
                   move [0] = 1;
                   move [1] = 1;
               }
               else if (board [1][1] != 0 && board [0][1] == 0){
                   move [0] = 0;
                   move [1] = 1;
               }
           }
        }



       /*else if (board [2][1] != 0 ){
           move [0] = 0;
           move [1] = 2;
       }*/
       /*if (board [1][1] == piece || board [1][2] == piece){
           move [0] = 1;
           move [1] = (int)(Math.random()*2)+1;
       }*/

      /*if (move[0] == 0 && move[1] == 1){
          move[0] = 1;
          move[1] = 0;
      }*/
        return move;
    }
}

