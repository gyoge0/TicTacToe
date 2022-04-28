package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class Ryobi_Ai extends TicTacToePlayer {
	final int EMPTY = 0;
	final int X = 1;
	final int O = 2;

	public Ryobi_Ai(String name, int piece) {
		super(name, piece);
	}

	public int[] playTurn() {
		int[] move = new int[2];
		int[][] tempBoard = GameController.game.getBoard();
		if (getPiece() == 1) { // if it goes first | THIS IS X (x is at (0,0))
			if (GameController.getTurnCount() == 0) {
				move[0] = 0; // y
				move[1] = 0; // x
			}
			if (GameController.getTurnCount() == 2) {
				int pRow = 0;
				int pCol = 0;
				boolean Xrow = false;
				boolean Xcol = false;

				for (int i = 0; i < 3; i++) {
					if (getRowCount(i, 1) == 2) {
						Xrow = true;
					}
				}

				for (int j = 0; j < 3; j++) {
					if (getColumnCount(j, 1) == 2) {
						Xcol = true;
					}
				}
				// main idea : if the are two x's in a row the code will favor the block
				// algorithm for rows else if for columns
				if (Xrow == true) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						for (int row = 0; row < tempBoard.length; row++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[row][0] == O || tempBoard[row][1] == O || tempBoard[row][2] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				} else if (Xcol == true) {
					for (int row = 0; row < tempBoard.length; row++) {
						for (int col = 0; col < tempBoard[0].length; col++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[0][col] == O || tempBoard[1][col] == O || tempBoard[2][col] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				}
				if (tempBoard[0][0] == O && tempBoard[2][2] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				if (tempBoard[0][2] == O && tempBoard[2][0] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				move[0] = pRow;
				move[1] = pCol;
			}
			if (GameController.getTurnCount() == 4) {
				int pRow = 0;
				int pCol = 0;
				boolean Xrow = false;
				boolean Xcol = false;

				for (int i = 0; i < 3; i++) {
					if (getRowCount(i, 1) == 2) {
						Xrow = true;
					}
				}

				for (int j = 0; j < 3; j++) {
					if (getColumnCount(j, 1) == 2) {
						Xcol = true;
					}
				}
				// main idea : if the are two x's in a row the code will favor the block
				// algorithm for rows else if for columns
				if (Xrow == true) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						for (int row = 0; row < tempBoard.length; row++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[row][0] == O || tempBoard[row][1] == O || tempBoard[row][2] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				} else if (Xcol == true) {
					for (int row = 0; row < tempBoard.length; row++) {
						for (int col = 0; col < tempBoard[0].length; col++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[0][col] == O || tempBoard[1][col] == O || tempBoard[2][col] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				}
				if (tempBoard[0][0] == O && tempBoard[2][2] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				if (tempBoard[0][2] == O && tempBoard[2][0] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				move[0] = pRow;
				move[1] = pCol;
			}
			if (GameController.getTurnCount() == 6) {
				int pRow = 0;
				int pCol = 0;
				boolean Xrow = false;
				boolean Xcol = false;

				for (int i = 0; i < 3; i++) {
					if (getRowCount(i, 1) == 2) {
						Xrow = true;
					}
				}

				for (int j = 0; j < 3; j++) {
					if (getColumnCount(j, 1) == 2) {
						Xcol = true;
					}
				}
				// main idea : if the are two x's in a row the code will favor the block
				// algorithm for rows else if for columns
				if (Xrow == true) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						for (int row = 0; row < tempBoard.length; row++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[row][0] == O || tempBoard[row][1] == O || tempBoard[row][2] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				} else if (Xcol == true) {
					for (int row = 0; row < tempBoard.length; row++) {
						for (int col = 0; col < tempBoard[0].length; col++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[0][col] == O || tempBoard[1][col] == O || tempBoard[2][col] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				}
				if (tempBoard[0][0] == O && tempBoard[2][2] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				if (tempBoard[0][2] == O && tempBoard[2][0] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				move[0] = pRow;
				move[1] = pCol;
			}
			if (GameController.getTurnCount() == 8) {
				int pRow = 0;
				int pCol = 0;
				boolean Xrow = false;
				boolean Xcol = false;

				for (int i = 0; i < 3; i++) {
					if (getRowCount(i, 1) == 2) {
						Xrow = true;
					}
				}

				for (int j = 0; j < 3; j++) {
					if (getColumnCount(j, 1) == 2) {
						Xcol = true;
					}
				}
				// main idea : if the are two x's in a row the code will favor the block
				// algorithm for rows else if for columns
				if (Xrow == true) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						for (int row = 0; row < tempBoard.length; row++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[row][0] == O || tempBoard[row][1] == O || tempBoard[row][2] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				} else if (Xcol == true) {
					for (int row = 0; row < tempBoard.length; row++) {
						for (int col = 0; col < tempBoard[0].length; col++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[0][col] == O || tempBoard[1][col] == O || tempBoard[2][col] == O)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				}
				if (tempBoard[0][0] == O && tempBoard[2][2] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				if (tempBoard[0][2] == O && tempBoard[2][0] == O) {
					move[0] = 0;
					move[1] = 1;
				}
				move[0] = pRow;
				move[1] = pCol;
			}
			if (GameController.getTurnCount() > 8) {
				int pRow = 0;
				int pCol = 0;
				for (int row = 0; row < tempBoard.length; row++) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						if (tempBoard[row][col] == EMPTY) {
							pRow = row;
							pCol = col;
						}
					}
				}
				move[0] = pRow;
				move[1] = pCol;
			}
		}
		if (getPiece() == 2) { // if it goes second | THIS IS O
			if (GameController.getTurnCount() == 1) {
				if (tempBoard[1][1] == EMPTY) {
					move[0] = 1;
					move[1] = 1;
				} else {
					move[0] = 0;
					move[1] = 0;
				}
			}
			if (GameController.getTurnCount() == 3) {
				int pRow = 0;
				int pCol = 0;
				boolean Xrow = false;
				boolean Xcol = false;

				for (int i = 0; i < 3; i++) {
					if (getRowCount(i, 1) == 2) {
						Xrow = true;
					}
				}

				for (int j = 0; j < 3; j++) {
					if (getColumnCount(j, 1) == 2) {
						Xcol = true;
					}
				}
				// main idea : if the are two x's in a row the code will favor the block
				// algorithm for rows else if for columns
				if (Xrow == true) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						for (int row = 0; row < tempBoard.length; row++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[row][0] == X || tempBoard[row][1] == X || tempBoard[row][2] == X)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				} else if (Xcol == true) {
					for (int row = 0; row < tempBoard.length; row++) {
						for (int col = 0; col < tempBoard[0].length; col++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[0][col] == X || tempBoard[1][col] == X || tempBoard[2][col] == X)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				}
				if (tempBoard[0][0] == X && tempBoard[2][2] == X) {
					move[0] = 0;
					move[1] = 1;
				}
				if (tempBoard[0][2] == X && tempBoard[2][0] == X) {
					move[0] = 0;
					move[1] = 1;
				}
				move[0] = pRow;
				move[1] = pCol;
			}
			if (GameController.getTurnCount() == 5) {
				int pRow = 0;
				int pCol = 0;
				boolean Xrow = false;
				boolean Xcol = false;

				for (int i = 0; i < 3; i++) {
					if (getRowCount(i, 1) == 2) {
						Xrow = true;
					}
				}

				for (int j = 0; j < 3; j++) {
					if (getColumnCount(j, 1) == 2) {
						Xcol = true;
					}
				}
				// main idea : if the are two x's in a row the code will favor the block
				// algorithm for rows else if for columns
				if (Xrow == true) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						for (int row = 0; row < tempBoard.length; row++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[row][0] == X || tempBoard[row][1] == X || tempBoard[row][2] == X)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				} else if (Xcol == true) {
					for (int row = 0; row < tempBoard.length; row++) {
						for (int col = 0; col < tempBoard[0].length; col++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[0][col] == X || tempBoard[1][col] == X || tempBoard[2][col] == X)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				}
				if (tempBoard[0][0] == X && tempBoard[2][2] == X) {
					move[0] = 0;
					move[1] = 1;
				}
				if (tempBoard[0][2] == X && tempBoard[2][0] == X) {
					move[0] = 0;
					move[1] = 1;
				}
				move[0] = pRow;
				move[1] = pCol;
			}
			if (GameController.getTurnCount() == 7) {
				int pRow = 0;
				int pCol = 0;
				boolean Xrow = false;
				boolean Xcol = false;

				for (int i = 0; i < 3; i++) {
					if (getRowCount(i, 1) == 2) {
						Xrow = true;
					}
				}

				for (int j = 0; j < 3; j++) {
					if (getColumnCount(j, 1) == 2) {
						Xcol = true;
					}
				}
				// main idea : if the are two x's in a row the code will favor the block
				// algorithm for rows else if for columns
				if (Xrow == true) {
					for (int col = 0; col < tempBoard[0].length; col++) {
						for (int row = 0; row < tempBoard.length; row++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[row][0] == X || tempBoard[row][1] == X || tempBoard[row][2] == X)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				} else if (Xcol == true) {
					for (int row = 0; row < tempBoard.length; row++) {
						for (int col = 0; col < tempBoard[0].length; col++) {
							if (tempBoard[row][col] == EMPTY
									&& (tempBoard[0][col] == X || tempBoard[1][col] == X || tempBoard[2][col] == X)) {
								pRow = row;
								pCol = col;
								break;
							}
						}
					}
				}
				if (tempBoard[0][0] == X && tempBoard[2][2] == X) {
					move[0] = 0;
					move[1] = 1;
				}
				if (tempBoard[0][2] == X && tempBoard[2][0] == X) {
					move[0] = 0;
					move[1] = 1;
				}
				move[0] = pRow;
				move[1] = pCol;
			}
		}
		if (GameController.getTurnCount() > 7) {
			int pRow = 0;
			int pCol = 0;
			for (int row = 0; row < tempBoard.length; row++) {
				for (int col = 0; col < tempBoard[0].length; col++) {
					if (tempBoard[row][col] == EMPTY) {
						pRow = row;
						pCol = col;
					}
				}
			}
			move[0] = pRow;
			move[1] = pCol;
		}
		return move;
	}

	// I stole your methods sorry lol
	public int getRowCount(int row, int player) {
		int[][] tempBoard = GameController.game.getBoard();
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if (tempBoard[row][i] == player) {
				counter++;
			}
		}

		return counter;
	}

// I stole your methods sorry lol
	public int getColumnCount(int column, int player) {
		int[][] tempBoard = GameController.game.getBoard();
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if (tempBoard[i][column] == player) {
				counter++;
			}
		}

		return counter;
	}
}