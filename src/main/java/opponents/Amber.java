package opponents;

import game.GameController;
import game.TicTacToePlayer;

public class Amber extends TicTacToePlayer {
	
	private static int[][] board;

	public Amber(String aName, int aPiece) {
		super(aName, aPiece);
		// TODO Auto-generated constructor stub
	}

	public int[] playTurn() {
		
		board = GameController.game.getBoard();
		
		int[] move = new int[2];
		int turn = GameController.getTurnCount();
		
		int b = 0;
		int x = 1;
		int o = 2;
		
		
		if(turn == 0)  {//bottom right
			move[0] = 2;
			move[1] = 2;
		}
		else if(turn == 3)  {
			if(board[0][0] == x || board[0][2] == x || board[2][0] == x || board[2][2] == x)  {
				move[0] = 1;
				move[1] = 1;
			}
			else if(board[0][1] == x)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[1][2] == x || board[2][1] == x)  {
				move[0] = 2;
				move[1] = 2;
			}
			else if(board[1][0] == x)  {
				move[0] = 2;
				move[1] = 0;
			}
			else if(board[1][1] == x)  {
				move[0] = 2;
				move[1] = 0;
			}
		}
		else if(turn == 2)  {
			if(board[0][0] == o || board[0][2] == o || board[1][0] == o)  {//if the opponent fills [0, 0] or [0, 2] or [1, 0]
				move[0] = 2;
				move[1] = 0; //then fills [2, 0]
			}
			else if(board[0][1] == o || board[2][0] == o){//if the opponent fills [0, 1] or [2, 0]
				move[0] = 0;
				move[1] = 2;//then fills [0, 2]
			}
			else if(board[1][1] == o){//if the opponent fills [1, 1]
				move[0] = 0;
				move[1] = 0;//then fills [0, 0]
			}
			else if(board[1][2] == o){//if the opponent fills [1, 2]
				move[0] = 2;
				move[1] = 1;//then fills [2, 1]
			}
			else if(board[2][1] == o){//if the opponent fills [2, 1] 
				move[0] = 1;
				move[1] = 2;//then fills [1, 2]
			}
		}
		else if(turn == 3)  {
			move[0] = (int) (Math.random() * 3);
			move[1] = (int) (Math.random() * 3);
		}
		else if(turn == 4)  {
			if(board[0][0] == o && board[2][1] == b && board[2][0] == x)  { // if opponent fills [0, 0] but not [2, 1]
				move[0] = 2;
				move[1] = 1;//then fills [2, 1]
			}
			else if(board[0][0] == o && board[2][1] == o && board[2][0] == x)  {// the otherwise
				move[0] = 0;
				move[1] = 2;//then fills [0, 2]
			}
			else if(board[0][1] == o && board[1][2] == b && board[0][2] == x)  { // if opponent fills [0, 1] but not [1, 2]
				move[0] = 1;
				move[1] = 2;//then fills [1, 2]
			}
			else if(board[0][1] == o && board[1][2] == o && board[0][2] == x)  {// the otherwise
				move[0] = 2;
				move[1] = 0;//then fills [2, 0]
			}
			else if(board[0][2] == o && board[2][1] == b && board[1][1] == o && board[2][0] == x)  { // if opponent fills [0, 1] but not [1, 2]
				move[0] = 2;
				move[1] = 1;//then fills [1, 2]
			}
			else if(board[0][2] == o && board[2][1] == o && board[2][0] == x && board[2][0] == x)  {// the otherwise
				move[0] = 0;
				move[1] = 0;//then fills [2, 0]
			}
			else if(board[1][0] == o && board[2][1] == b && board[2][0] == x)  {
				move[0] = 2;
				move[1] = 1;
			}
			else if(board[1][0] == o && board[2][1] == o && board[2][0] == x)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[0][1] == o && board[0][0] == x)  {
				move[0] = 2;
				move[1] = 1;
			}
			else if(board[1][1] == o && board[0][2] == o && board[0][0] == x)  {
				move[0] = 2;
				move[1] = 0;
			}
			else if(board[1][1] == o && board[1][0] == o && board[0][0] == x)  {
				move[0] = 1;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[1][2] == o && board[1][0] == b)  {
				move[0] = 1;
				move[1] = 0;
			}
			else if(board[1][1] == o && board[2][0] == o && board[0][2] == b)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[2][1] == o && board[0][1] == b && board[0][0] == x)  {
				move[0] = 0;
				move[1] = 1;
			}
			else if(board[1][2] == o && board[2][1] == x && board[2][0] == b)  {
				move[0] = 2;
				move[1] = 0;
			}
			else if(board[1][2] == o && board[2][1] == x && board[2][0] == o)  {
				move[0] = 1;
				move[1] = 1;
			}
			else if(board[2][0] == o && board[0][2] == x && board[1][2] == b)  {
				move[0] = 1;
				move[1] = 2;
			}
			else if(board[2][0] == o && board[0][2] == x && board[1][2] == o)  {
				move[0] = 0;
				move[1] = 0;
			}
			else if(board[2][1] == o && board[1][2] == x && board[0][2] == b)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[2][1] == o && board[1][2] == x && board[0][2] == o)  {
				move[0] = 1;
				move[1] = 1;
			}
		}
		else if(turn == 5)  {
			move[0] = (int) (Math.random() * 3);
			move[1] = (int) (Math.random() * 3);
		}
		else if(turn == 6)  {
			if(board[0][0] == o && board[2][1] == o && board[2][0] == x && board[0][2] == x && board[1][1] == b)  {
				move[0] = 1;
				move[1] = 1;
			}
			else if(board[0][0] == o && board[2][1] == o && board[1][1] == o && board[0][2] == x && board[1][2] == b)  {
				move[0] = 1;
				move[1] = 2;
			}
			else if(board[0][1] == o && board[2][1] == o && board[0][2] == x && board[2][0] == x && board[1][1] == b)  { // if opponent fills [0, 0] [2, 1] but not [1, 1]
				move[0] = 1;
				move[1] = 1;//then fills [1, 1]
			}
			else if(board[0][1] == o && board[1][2] == o && board[0][2] == x && board[2][0] == x && board[1][1] == o)  { // if opponent fills [0, 0] [2, 1] but not [1, 1]
				move[0] = 2;
				move[1] = 1;//then fills [1, 1]
			}
			else if(board[0][2] == o && board[2][1] == o && board[1][1] == b && board[1][0] == o && board[0][0] == x)  {
				move[0] = 1;
				move[1] = 1;
			}
			else if(board[0][2] == o && board[2][1] == o && board[1][1] == o && board[1][0] == b && board[0][0] == x && board[2][0] == x)  {
				move[0] = 1;
				move[1] = 0;
			}
			else if(board[1][0] == o && board[2][1] == o && board[1][2] == b && board[1][1] == o && board[0][2] == x) {
				move[0] = 1;
				move[1] = 2;
			}
			else if(board[1][0] == o && board[2][1] == o && board[1][2] == o && board[1][1] == b && board[0][2] == x) {
				move[0] = 1;
				move[1] = 1;
			}
			else if(board[1][1] == o && board[0][1] == o && board[2][0] == b && board[0][0] == x && board[2][1] == x)  {
				move[0] = 2;
				move[1] = 0;
			}
			else if(board[1][1] == o && board[0][1] == o && board[2][0] == o && board[0][0] == x && board[2][1] == x)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[0][2] == o && board[1][0] == b && board[2][0] == x)  {
				move[0] = 1;
				move[1] = 0;
			}
			else if(board[1][1] == o && board[0][2] == o && board[2][1] == b && board[2][0] == x)  {
				move[0] = 2;
				move[1] = 1;
			}
			else if(board[1][1] == o && board[1][0] == o && board[0][2] == b && board[1][2] == x)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[1][0] == o && board[0][2] == o && board[1][2] == x)  {
				move[0] = 2;
				move[1] = 0;
			}
			else if(board[1][1] == o && board[1][2] == o && board[1][0] == x && board[2][0] == b)  {
				move[0] = 2;
				move[1] = 0;
			}
			else if(board[1][1] == o && board[1][2] == o && board[1][0] == x && board[2][0] == o)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[2][0] == o && board[0][2] == x && board[0][1] == b)  {
				move[0] = 0;
				move[1] = 1;
			}
			else if(board[1][1] == o && board[2][0] == o && board[0][2] == x && board[0][1] == o)  {
				move[0] = 1;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[2][1] == o && board[0][1] == x && board[0][2] == b)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[2][1] == o && board[0][1] == x && board[0][2] == o)  {
				move[0] = 2;
				move[1] = 0;
			}
			else if(board[1][2] == o && board[2][1] == x && board[2][0] == o && board[1][1] == x && board[0][1] == b)  {
				move[0] = 0;
				move[1] = 1;
			}
			else if(board[1][2] == o && board[2][1] == x && board[2][0] == o && board[1][1] == x && board[0][1] == o)  {
				move[0] = 0;
				move[1] = 0;
			}
			else if(board[2][0] == o && board[0][2] == x && board[1][2] == o && board[0][0] == x && board[0][2] == b)  {
				move[0] = 0;
				move[1] = 2;
			}
			else if(board[2][0] == o && board[0][2] == x && board[1][2] == o && board[0][0] == x && board[0][2] == o)  {
				move[0] = 1;
				move[1] = 1;
			}
			else if(board[2][1] == o && board[1][2] == x && board[0][2] == b && board[0][2] == x && board[0][0] == b)  {
				move[0] = 0;
				move[1] = 0;
			}
			else if(board[2][1] == o && board[1][2] == x && board[0][2] == b && board[0][2] == x && board[0][0] == o)  {
				move[0] = 0;
				move[1] = 1;
			}
		}
		else if (turn == 7)  {
			move[0] = (int) (Math.random() * 3);
			move[1] = (int) (Math.random() * 3);
		}
		else if(turn == 8)  {
			if(board[1][1] == o && board[0][1] == o && board[2][0] == o && board[1][2] == b && board[0][0] == x)  {
				move[0] = 1;
				move[1] = 2;
			}
			else if(board[1][1] == o && board[0][1] == o && board[2][0] == o && board[1][2] == o && board[2][1] == x)  {
				move[0] = 1;
				move[1] = 0;
			}
			else if(board[1][1] == o && board[1][0] == o && board[0][2] == o && board[1][2] == x && board[2][1] == b)  {
				move[0] = 2;
				move[1] = 1;
			}
			else if(board[1][1] == o && board[1][0] == o && board[0][2] == o && board[1][2] == x && board[2][1] == o)  {
				move[0] = 0;
				move[1] = 1;
			}
			else if(board[1][1] == o && board[1][2] == o && board[1][0] == x && board[2][0] == o && board[0][1] == b)  {
				move[0] = 0;
				move[1] = 1;
			}
			else if(board[1][1] == o && board[1][2] == o && board[1][0] == x && board[2][0] == o && board[2][1] == b)  {
				move[0] = 2;
				move[1] = 1;
			}
			else if(board[1][0] == o && board[2][1] == o && board[0][1] == x && board[0][2] == o && board[2][0] == x)  {
				move[0] = 1;
				move[1] = 2;
			}
			else if(board[1][0] == b && board[2][1] == o && board[0][1] == x && board[0][2] == o && board[2][0] == x)  {
				move[0] = 1;
				move[1] = 0;
			}
		}
		else if(turn ==9)  {
			move[0] = (int) (Math.random() * 3);
			move[1] = (int) (Math.random() * 3);
		}
		
		
		

		return move;
	}  
	
	public int check()  {
		return 0; 
	}

}
