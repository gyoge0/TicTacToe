package opponents;
import game.GameController;
import game.TicTacToePlayer;

//new player
public class WPlayer extends TicTacToePlayer {
	private int[][] board;
	private int dCount = 0;
	private int rowCount;
	private int columnCount;

	public WPlayer(String name, int piece) {
		super(name, piece);
	}

	public int getRowCount(int row, int player) {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if (board[row][i] == player) {
				counter++;
			}
		}

		return counter;
	}

	public int getColumnCount(int column, int player) {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if (board[i][column] == player) {
				counter++;
			}
		}

		return counter;
	}

	public boolean checkRow(int a) {
		for (int i = 0; i < 3; i++) {
			if (board[a][i] == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean checkColumn(int a) {
		for (int i = 0; i < 3; i++) {
			if (board[i][a] == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonal(boolean isLeft) {
		if (isLeft) {
			for (int i = 0; i < 3; i++) {
				if (board[i][i] == 0) {
					return true;
				}
			}
		}

		else {
			for (int i = 0; i < 3; i++) {
				if (board[2 - i][i] == 0) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean getDiagonal(int player) {
		// left to right
		// checks for all empty spaces in between the diagonals
		if (board[0][0] == player && board[2][2] == player) {
			return true;
		}

		if (board[0][0] == player && board[1][1] == player) {
			return true;
		}

		if (board[2][2] == player && board[1][1] == player) {
			return true;
		}
		// right to left
		if (board[0][2] == player && board[2][0] == player) {
			return true;
		}

		if (board[1][1] == player && board[2][0] == player) {
			return true;
		}

		if (board[1][1] == player && board[0][2] == player) {
			return true;
		}

		return false;
	}

	public int[] playTurn() {

		int opponent = getPiece();

		if (opponent == 2) {
			opponent = 1;
		}

		else {
			opponent = 2;
		}

		int me = getPiece();
		int rCount = 0;
		int cCount = 0;

		int mRCount = 0;
		int mCCount = 0;

		int rowCount = 0;
		int columnCount = 0;

		board = GameController.game.getBoard();

		int curTurn = GameController.getTurnCount();

		int[] move = new int[2];

		// goes through board
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {

				// checks if empty
				if (board[k][j] == 0 && curTurn >= 2) {

					// to block opponent
					// checks if there are two or more in a row or column to block
					// checking if the space is empty, to put the move there since the rest are
					// filled(to block)

					if (getPiece() == 1) {

						if (board[k][j] == 0) {
							move[0] = 1;
							move[1] = 1;
						}

						if (board[k][j] == 0 && getPiece() == 1) {
							move[0] = (int) (Math.random() * 3);
							move[1] = (int) (Math.random() * 3);
						}

						for (int i = 0; i < 3; i++) {
							if (getRowCount(i, opponent) >= 1) {
								rCount++;
							}
						}

						if (rCount >= 2) {
							move[0] = k;
							move[1] = j;
						}

						for (int i = 0; i < 3; i++) {
							if (getColumnCount(i, opponent) >= 1) {
								cCount++;
							}
						}

						if (cCount >= 2) {
							move[0] = k;
							move[1] = j;
						}

						if (getDiagonal(opponent)) {
							move[0] = k;
							move[1] = j;
						}

					}

					if (getPiece() == 2) {

						if (board[k][j] == 0) {
							move[0] = 0;
							move[1] = 0;
							// had to comment this out
//					System.out.println("Hello");
						}

						else if (board[k][j] == 0) {
							move[0] = (int) (Math.random() * 3);
							move[1] = (int) (Math.random() * 3);
							// had to comment this out
//					System.out.println("Hello1");
						}

						//else if (board[k][j] == 0) {

						 if (getRowCount(k, me) >= 1  
									|| getColumnCount(j, me) >= 1
									|| getDiagonal(me) && getPiece() == me ) {
								move[0] = k;
								move[1] = j;
							 // had to comment this out
//						System.out.println("Hello2");
							}
							
						    
			


						}
					
				}

			}
		}

		// GameController.game.printBoard();
		//System.out.println("My move: " + move[0] + " " + move[1]);
		return move;
	}
}