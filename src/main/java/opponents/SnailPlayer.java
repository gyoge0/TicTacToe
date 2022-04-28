package opponents;
import game.GameController;
import game.TicTacToePlayer;

//Example player
public class SnailPlayer extends TicTacToePlayer {

	private boolean first = false;
	private int[] branch = new int[4];
	private int turn = 0;

	public SnailPlayer(String name, int piece) {
		super(name, piece);
	}

	public int[] playTurn() {
		int[][] board = GameController.game.getBoard();
		turn = GameController.getTurnCount();
		int move[] = new int[2];
		int row = -1;
		int col = -1;
		
		
		if (turn == 0) {
			first = true;
		}
		
		if (first) { // player goes first

			if (turn == 0) { // first turn go bl corner
				branch[0] = 1;
				int[] go = { 2, 0 };

				move = go;
			}

			else if (turn == 2) { // next turn

				if (board[1][1] != 0) { // if opp went center
					int[] go = { 0, 0 }; // go tl corner
					move = go;
					branch[1] = 1;
				}

				else { // opp did not go center

					branch[1] = 2;

					if (board[2][1] == 0 && board[2][2] == 0) { // find corner w/ open space and gap btw x's
						int[] go = { 2, 2 };
						move = go;
					} else if (board[0][0] == 0 && board[1][0] == 0) {
						int[] go = { 0, 0 };
						move = go;
					}
				}
			}

			else if (turn == 4) {
				if (branch[1] == 1) {
					move = checkWins(board);
				}
				else {
					if (checkWins(board)[0] >= 0) {
						move = checkWins(board);
					}
					else {
						int[] go = { 1, 1 };
						move = go;
					}
				}
			}
			
			else {
				if (checkWins(board)[0] < 0) {
					boolean cont = true;
					while (cont) {
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++) {
								if (board[i][j] == 0) {
									int[] go = {i, j};
									move = go;
									cont = false;
								}
							}
						}
					}
				} else {
					move = checkWins(board);
				}
			}

		} else { // player goes second

			if (turn == 1) { // first turn check opp play
				
				if (board[1][1] == 1) { //opp player went center
					int[] go = {0, 0};
					move = go;
				}
				else {
					int[] go = {1, 1};
					move = go;
				}
				
			}
			else {
				if (checkWins(board)[0] < 0) {
					boolean cont = true;
					while (cont) {
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++) {
								if (board[i][j] == 0) {
									int[] go = {i, j};
									move = go;
									cont = false;
								}
							}
						}
					}
				} else {
					move = checkWins(board);
				}
			}
		}
		
		if (row >= 0 && col >= 0) {
			move[0] = row;
			move[1] = col;
		}
		
		return move;


	}

	public int[] checkWins(int[][] board) {

		int[] clear = {-1, -1};
		
		int s = 0;
		int e = 0;
		int m = 0;
		
		if (first) {
			s = 1;
			m = 1;
		}
		else {
			s = 2;
			m = -1;
		}

		for (int a = 0; a < 2; a++) {
			int k = s + (m*a);
			
			for (int i = 0; i < 3; i++) { // rows
				
				clear[0] = -1;
				clear[1] = -1;
				
				int o = 0;
				
				for (int j = 0; j < 3; j++) {
					if (board[i][j] == k) {
						o++;
					} else if (board[i][j] == 0) {
						clear[0] = i;
						clear[1] = j;
					}
				}
				if (o == 2 && clear[0] >= 0) {
					return clear;
				}
			}

			for (int i = 0; i < 3; i++) { // columns
				
				clear[0] = -1;
				clear[1] = -1;
				
				int o = 0;
				for (int j = 0; j < 3; j++) {
					if (board[j][i] == k) {
						o++;
					} else if (board[j][i] == 0) {
						clear[0] = j;
						clear[1] = i;
					}
				}
				if (o == 2 && clear[0] >= 0) {
					return clear;
				}
			}
			
			clear[0] = -1;
			clear[1] = -1;
			int o = 0;
			// left diag
			for (int i = 0; i < 3; i++) {
				if (board[i][i] == k) {
					o++;
				} else if (board[i][i] == 0) {
					clear[0] = i;
					clear[1] = i;
				}
			}
			
			if (o == 2 && clear[0] >= 0) {
				return clear;
			}

			clear[0] = -1;
			clear[1] = -1;
			o = 0;
			// right diag
			for (int i = 0; i < 3; i++) {
				if (board[i][2 - i] == k) {
					o++;
				} else if (board[i][2 - i] == 0) {
					clear[0] = i;
					clear[1] = 2 - i;
				}
			}
			
			if (o == 2 && clear[0] >= 0) {
				return clear;
			}
		}
		return clear;
	}

}
