package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class ChimkenHamburger extends TicTacToePlayer {

	public ChimkenHamburger(String name, int piece) {
		super(name, piece);
	}

	public int[] playTurn() {
		int[] move = new int[2];
		int curTurn = GameController.getTurnCount();
		int apiece = getPiece();
		int[][] board = GameController.game.getBoard();
		int m1 = (int) Math.random() * 3;
		int m2 = (int) Math.random() * 3;

		if (apiece == 1) { // X
			if (curTurn == 0) {
				move[0] = 2;
				move[1] = 2;
			}
			// 2nd move
			if (curTurn == 2 && board[0][0] == 0) { // top left
				move[0] = 0;
				move[1] = 0;
			}

			else if (curTurn == 2 && board[0][0] == 2) { // top right
				move[0] = 2;
				move[1] = 0;
			}
			// 3rd move
			if (curTurn == 4 && board[0][2] == 0) { // top right
				move[0] = 0;
				move[1] = 2;
			}

			else if (curTurn == 4 && board[0][2] == 2 && board[2][0] == 0) { // bottom left
				move[0] = 2;
				move[1] = 0;
			}

			else if (curTurn == 4 && board[0][2] == 2 && board[2][0] == 2) { // middle
				move[0] = 1;
				move[1] = 1;
			}

			if (curTurn == 4 && board[0][2] == 0) {
				move[0] = 0;
				move[1] = 2;
			}

			else if (curTurn == 4 && board[2][1] == 0) {
				move[0] = 2;
				move[1] = 0;

			}

			// 4th move
			if (curTurn == 6 && board[0][0] == 1 && board[2][2] == 1 && board[1][1] == 0) {
				move[0] = 1;
				move[1] = 1;
			}

			else if (curTurn == 6 && board[0][0] == 1 && board[0][2] == 1 && board[0][1] == 0) {
				move[0] = 0;
				move[1] = 1;
			}

			else if (curTurn == 6 && board[0][0] == 1 && board[2][2] == 1 && board[2][1] == 0) {
				move[0] = 2;
				move[1] = 1;
			}
			
			else if(curTurn == 6 && board[0][0] == 1 && board[2][0] == 1 && board[1][0] == 0) {
				move[0] = 1;
				move[1] = 0;
			}

			// add more for 4th

		}

		if (apiece == 2) { // If your second, O
			// first move
			if (board[1][1] == 0) {
				move[0] = 1;
				move[1] = 1;
			}

			else if (curTurn == 1 && board[1][1] == 1) {
				move[0] = 2;
				move[1] = 0;
			}

			// second move
			if (curTurn == 3 && board[2][0] == 1 && board[0][2] == 1) {
				if (board[1][1] == 0) {
					move[0] = 1;
					move[1] = 1;
				}

				else {
					move[0] = 1;
					move[1] = 2;
				}
			}

			if (curTurn == 3 && board[2][0] == 1 && board[2][2] == 1) {
				move[0] = 2;
				move[1] = 1;
			}

			else if (curTurn == 3 && board[2][0] == 1 && board[0][0] == 1) {
				move[0] = 1;
				move[1] = 0;
			}

			if (curTurn == 3 && board[0][0] == 1 && board[0][2] == 1) {
				move[0] = 0;
				move[1] = 1;
			}

			else if (curTurn == 3 && board[1][1] == 1 && board[0][0] == 1) {
				move[0] = 2;
				move[1] = 2;
			}

			else if (curTurn == 3 && board[1][1] == 1 && board[0][2] == 1 && board[2][0] == 0) {
				move[0] = 2;
				move[1] = 0;
			}

			else if (curTurn == 3 && board[1][1] == 1 && board[0][2] == 1 && !(board[2][0] == 0)) {
				move[0] = 0;
				move[1] = 0;
			} 
			else {
				if (curTurn == 3 && board[1][1] == 2 && board[2][1] == 0) {
					move[0] = 2;
					move[1] = 1;
				}

				else if (curTurn == 3 && board[2][0] == 2 && board[1][0] == 0) {
					move[0] = 1;
					move[1] = 0;
				}

				// third move
				if(curTurn == 5 && board[1][1] == 2 && board[1][2] == 2 && board[1][0] == 0) {
					move[0] = 1;
					move[1] = 0;
				}
				
				else if(curTurn == 5 && board[1][1] == 2 && board[0][1] == 2 && board[2][1] == 0) {
					move[0] = 2;
					move[1] = 1;
				}
				
				else {
					if(curTurn == 5 && board[1][2] == 0) {
						move[0] = 1;
						move[1] = 2;
					}	
				}
				

			}

		}
		//after 3 moves on both pieces
		if (curTurn >= 7) {
			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[0].length; c++) {
					if (board[r][c] == 0) {
						move[0] = r;
						move[1] = c;

						return move;
					}
				}
			}
		}

		return move;
	}

}