package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class PadenJarko3 extends TicTacToePlayer
{
    public PadenJarko3(String name, int piece) {
        super(name, piece); 
    }  

   public int[] playTurn(){
      // set up self knowledge
      int peace = getPiece();
      int daOpps = peace;
      if(peace == 1){
         daOpps = 2;
      }
      else if(peace == 2){
         daOpps = 1;
      }
      int[][] board = GameController.game.getBoard();
      int high = -20;
      int row = 0;
      int col = 0;
      for(int i = 0; i < 3; i++){
         for(int j = 0; j < 3; j++){
            if(board[i][j] == 0){
               int[][] possibleBoard = copyBoard(board);
               possibleBoard[i][j] = peace;
               int choice = findPath(possibleBoard, peace, daOpps);
               if(high < choice){
                  high = choice;
                  row = i;
                  col = j;
               }
            }
         }
      }
      int[] move = {row, col};
      return move;
   }
   
   private int[][] copyBoard(int[][] board){
      int[][] copy = new int[3][3];
      for(int i = 0; i < 3; i++){
         for(int j = 0; j < 3; j++){
            copy[i][j] = board[i][j];
         }
      }
      return copy;
   }
   
   private boolean isMyTurn(int[][] board, int peace){
      //set up turn finder
      boolean myTurn = false;
      if(peace == 1){
         myTurn = true;
      }
      else if(peace == 2){
         myTurn = false;
      }
      
      //finding turn
      for(int i = 0; i < 3; i++){
         for(int j = 0; j < 3; j++){
            if(board[i][j] != 0){
               myTurn = !myTurn;
            }
         }
      }
      return myTurn;
   }
   
   private int gameIsOver(int[][] board, int peace, int daOpps){
      //victory conditions
      if(board[0][0] == peace && board[0][1] == peace && board[0][2] == peace){
         return 10;
      }
      else if(board[1][0] == peace && board[1][1] == peace && board[1][2] == peace){
         return 10;
      }
      else if(board[2][0] == peace && board[2][1] == peace && board[2][2] == peace){
         return 10;
      }
      else if(board[0][0] == peace && board[1][0] == peace && board[2][0] == peace){
         return 10;
      }
      else if(board[0][1] == peace && board[1][1] == peace && board[2][1] == peace){
         return 10;
      }
      else if(board[0][2] == peace && board[1][2] == peace && board[2][2] == peace){
         return 10;
      }
      else if(board[0][0] == peace && board[1][1] == peace && board[2][2] == peace){
         return 10;
      }
      else if(board[2][0] == peace && board[1][1] == peace && board[0][2] == peace){
         return 10;
      }
      //loss conditions
      else if(board[0][0] == daOpps && board[0][1] == daOpps && board[0][2] == daOpps){
         return -10;
      }
      else if(board[1][0] == daOpps && board[1][1] == daOpps && board[1][2] == daOpps){
         return -10;
      }
      else if(board[2][0] == daOpps && board[2][1] == daOpps && board[2][2] == daOpps){
         return -10;
      }
      else if(board[0][0] == daOpps && board[1][0] == daOpps && board[2][0] == daOpps){
         return -10;
      }
      else if(board[0][1] == daOpps && board[1][1] == daOpps && board[2][1] == daOpps){
         return -10;
      }
      else if(board[0][2] == daOpps && board[1][2] == daOpps && board[2][2] == daOpps){
         return -10;
      }
      else if(board[0][0] == daOpps && board[1][1] == daOpps && board[2][2] == daOpps){
         return -10;
      }
      else if(board[2][0] == daOpps && board[1][1] == daOpps && board[0][2] == daOpps){
         return -10;
      }
      //tie condition
      else if(board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0 && board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0 && board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0){
         return 0;
      }
      //not game over
      else{
         return -1;
      }
   }

   private int findPath(int[][] board, int peace, int daOpps){
      if(gameIsOver(board, peace, daOpps) != -1){
         return gameIsOver(board, peace, daOpps);
      }
      else{
         if(isMyTurn(board, peace)){
           int high = -20;
           
           for(int i = 0; i < 3; i++){
              for(int j = 0; j < 3; j++){
                 if(board[i][j] == 0){
                    int[][] possibleBoard = copyBoard(board);
                    possibleBoard[i][j] = peace;
                    int choice = findPath(possibleBoard, peace, daOpps);
                    if(high < choice){
                    high = choice;
                    }
                 }
               }
            }
            return high;
         }
         else{
           int low = 20;
           
           for(int i = 0; i < 3; i++){
              for(int j = 0; j < 3; j++){
                 if(board[i][j] == 0){
                    int[][] possibleBoard = copyBoard(board);
                    possibleBoard[i][j] = daOpps;
                    int choice = findPath(possibleBoard, peace, daOpps);
                    if(choice < low){
                    low = choice;
                    }
                 }
               }
            }
            return low;
         }
      }
   }


}
