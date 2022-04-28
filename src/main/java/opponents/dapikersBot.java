package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class dapikersBot extends TicTacToePlayer {
	
	public dapikersBot(String name, int piece) {
		super(name, piece); 
	}
	
	public int[] playTurn() {
		int[][] board = GameController.game.getBoard();
		int piece = getPiece();
		int[] move = new int[2];
		
		//Defense if player 1
		if (getPiece() == 1 && board[1][1] == 0) {
			if (board[1][0] == 2 && board[1][2] == 2 || board[0][1] == 2 && board[2][1] == 2 || board[0][0] == 2 && board[2][2] == 2 || board[0][2] == 2 && board[2][0] == 2) {
				move[0] = 1;
				move[1] = 1;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[0][0] == 0) {
			if (board[0][1] == 2 && board[0][2] == 2 || board[1][0] == 2 && board[2][0] == 2 || board[1][1] == 2 && board[2][2] == 2) {
				move[0] = 0;
				move[1] = 0;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[0][2] == 0) {
			if (board[0][0] == 2 && board[0][1] == 2 || board[1][2] == 2 && board[2][2] == 2 || board[1][1] == 2 && board[2][0] == 2) {
				move[0] = 0;
				move[1] = 2;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[2][0] == 0) {
			if (board[2][1] == 2 && board[2][2] == 2 || board[0][0] == 2 && board[1][0] == 2 || board[1][1] == 2 && board[0][2] == 2) {
				move[0] = 2;
				move[1] = 0;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[2][2] == 0) {
			if (board[2][0] == 2 && board[2][1] == 2 || board[0][2] == 2 && board[1][2] == 2 || board[1][1] == 2 && board[0][0] == 2) {
				move[0] = 2;
				move[1] = 2;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[0][1] == 0) {
			if (board[0][0] == 2 && board[0][2] == 2 || board[1][1] == 2 && board[2][1] == 2) {
				move[0] = 0;
				move[1] = 1;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[2][1] == 0) {
			if (board[2][0] == 2 && board[2][2] == 2 || board[1][1] == 2 && board[0][1] == 2) {
				move[0] = 2;
				move[1] = 1;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[1][0] == 0) {
			if (board[0][0] == 2 && board[2][0] == 2 || board[1][1] == 2 && board[1][2] == 2) {
				move[0] = 1;
				move[1] = 0;
				return move;
			}
		}
		
		if (getPiece() == 1 && board[1][2] == 0) {
			if (board[0][2] == 2 && board[2][2] == 2 || board[1][1] == 2 && board[1][0] == 2) {
				move[0] = 1;
				move[1] = 2;
				return move;
			}
		}
		
		
		
		//Defense if player 2
		if (getPiece() == 2 && board[1][1] == 0) {
			if (board[1][0] == 1 && board[1][2] == 1 || board[0][1] == 1 && board[2][1] == 1 || board[0][0] == 1 && board[2][2] == 1 || board[0][2] == 1 && board[2][0] == 1) {
				move[0] = 1;
				move[1] = 1;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[0][0] == 0) {
			if (board[0][1] == 1 && board[0][2] == 1 || board[1][0] == 1 && board[2][0] == 1 || board[1][1] == 1 && board[2][2] == 1) {
				move[0] = 0;
				move[1] = 0;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[0][2] == 0) {
			if (board[0][0] == 1 && board[0][1] == 1 || board[1][2] == 1 && board[2][2] == 1 || board[1][1] == 1 && board[2][0] == 1) {
				move[0] = 0;
				move[1] = 2;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[2][0] == 0) {
			if (board[2][1] == 1 && board[2][2] == 1 || board[0][0] == 1 && board[1][0] == 1 || board[1][1] == 1 && board[0][2] == 1) {
				move[0] = 2;
				move[1] = 0;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[2][2] == 0) {
			if (board[2][0] == 1 && board[2][1] == 1 || board[0][2] == 1 && board[1][2] == 1 || board[1][1] == 1 && board[0][0] == 1) {
				move[0] = 2;
				move[1] = 2;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[0][1] == 0) {
			if (board[0][0] == 1 && board[0][2] == 1 || board[1][1] == 1 && board[2][1] == 1) {
				move[0] = 0;
				move[1] = 1;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[2][1] == 0) {
			if (board[2][0] == 1 && board[2][2] == 1 || board[1][1] == 1 && board[0][1] == 1) {
				move[0] = 2;
				move[1] = 1;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[1][0] == 0) {
			if (board[0][0] == 1 && board[2][0] == 1 || board[1][1] == 1 && board[1][2] == 1) {
				move[0] = 1;
				move[1] = 0;
				return move;
			}
		}
		
		if (getPiece() == 2 && board[1][2] == 0) {
			if (board[0][2] == 1 && board[2][2] == 1 || board[1][1] == 1 && board[1][0] == 1) {
				move[0] = 1;
				move[1] = 2;
				return move;
			}
		}
		
		
		
		//Offense
		if (board[1][1] == 0) {
			move[0] = 1;
			move[1] = 1;
			return move;
		}
		
		else if (getPiece() == 2) {
			if (board[1][1] == 1 && board[0][0] == 0) {
				move[0] = 0;
				move[1] = 0;
				return move;
			}
		}
		
		if (getPiece() == 2) {
			if (board[0][2] == 1 && board[2][0] == 0) {
				move[0] = 2;
				move[1] = 0;
				return move;
			}
		}
		if (getPiece() == 2) {
			if (board[2][0] == 1 && board[0][2] == 0) {
				move[0] = 0;
				move[1] = 2;
				return move;
			}
		}
		if (getPiece() == 2) {
			if (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 0) {
				move[0] = 1;
				move[1] = 2;
				return move;
			}
		}
		if (getPiece() == 2) {
			if (board[1][2] == 1 && board[1][1] == 1 && board[1][0] == 0) {
				move[0] = 1;
				move[1] = 0;
				return move;
			}
		}
		if (getPiece() == 1) {
			if (board[1][1] == 1 && board[0][0] == 2 && board[2][0] == 0) {
				move[0] = 2;
				move[1] = 0;
				return move;
			}
		}
		if (getPiece() == 1) {
			if (board[1][1] == 1 && board[0][2] == 2 && board[2][2] == 0) {
				move[0] = 2;
				move[1] = 2;
				return move;
			}
		}
		if (getPiece() == 1) {
			if (board[1][1] == 1 && board[2][0] == 2 && board[2][2] == 0) {
				move[0] = 2;
				move[1] = 2;
				return move;
			}
		}
		if (getPiece() == 1) {
			if (board[1][1] == 1 && board[2][2] == 2 && board[2][0] == 0) {
				move[0] = 2;
				move[1] = 0;
				return move;
			}
		}
		
		for (int r=0; r<3; r++) {
			for (int c=0; c<3; c++) {
				if (board[r][c] == 0) {
					move[0] = r;
					move[1] = c;
					return move;
				}
			}
		}
		return move;
	}
}