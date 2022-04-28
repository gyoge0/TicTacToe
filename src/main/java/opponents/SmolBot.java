package opponents;
import game.GameController;
import game.TicTacToePlayer;

// Ella and Luz
public class SmolBot extends TicTacToePlayer {

	public SmolBot(String aName, int aPiece) {
		super(aName, aPiece);
	}

	@Override
	public int[] playTurn() {
		int[] move = new int[2];
		int[][] board = GameController.getBoard();
		//GameController.game.printBoard();
		if (getPiece() == 1) { // If we are first (X)
			// System.out.println("Turn: " + GameController.getTurnCount());
			if (GameController.getTurnCount() == 0) {
				// on first(zeroth) turn: take middle
				//System.out.println("player 1 taking middle");
				move[0] = 1;
				move[1] = 1;
			} else if (GameController.getTurnCount() == 2) {
				//System.out.println("Player 1 taking random corner");
				moveToEmptyCorner(move, board);
			} else {
				// if we need to block, then block
				if (findTargetPosition(board, 2) != null) { // change the two in this when copying it luz
					//System.out.println("Player 1 be blocking");
					move = findTargetPosition(board, 2); // change the two in this when copying it luz
				}
				// if not
				else {
					// see if we can make winning move
					if (findTargetPosition(board, 1) != null) { // change the one in this when copying it luz
						// if so, make it lol
						//System.out.println("Player 1 taking winning move");
						move = findTargetPosition(board, 1); // change the one in this when copying it luz
					}
					// if we can't make winning move
					else {
						// make sure there is a corner opening
						if (board[0][0] == 0 || board[2][0] == 0 || board[0][2] == 0 || board[2][2] == 0) {
							//System.out.println("Player 1 taking open corner");
							moveToEmptyCorner(move, board);
						} else {
							//System.out.println("Player 1 Finding random unoccupied Spot");
							int[] goal = new int[2];
							do {
								goal[0] = (int) (Math.random() * 3);
								goal[1] = (int) (Math.random() * 3);
								//System.out.println(java.util.Arrays.toString(goal));
							} while (board[goal[0]][goal[1]] != 0);
							move = goal;
						}
					}
				}
			}
		}

		// If we are second (O)
		else {

			// going second
			if (GameController.getTurnCount() == 1) {
				// if other player is at the center
				if (GameController.getBoard()[1][1] != 0) {
					//System.out.println("Player 2 taking random corner");
					moveToEmptyCorner(move, board);

				} else { // if other player is not at the center
					// go for the center
					//System.out.println("Player 2 taking center");
					move[0] = 1;
					move[1] = 1;
				}
			} else {
				// next turns, check to see if we need to block
				// if we need to block, then block
				if (findTargetPosition(board, 1) != null) { // change the two in this when copying it luz
					// I'm assuming it's the other piece
					//System.out.println("Player 2 be blocking");
					move = findTargetPosition(board, 1); // change the two in this when copying it luz
				}
				// if not
				else {
					// see if we can make winning move
					if (findTargetPosition(board, 2) != null) { // change the one in this when copying it luz
						// if so, FINISH THEM >:]
						//System.out.println("Player 2 making winning move");
						move = findTargetPosition(board, 2); // change the one in this when copying it luz
					}
					// if we can't make winning move
					else {
						// check for a random corner opening
						if (board[0][0] == 0 || board[2][0] == 0 || board[0][2] == 0 || board[2][2] == 0) {
							//System.out.println("Player 2 looking for empty corner to take");
							moveToEmptyCorner(move, board);
						} else {
							//System.out.println("Player 2 finding random location to take");
							int[] goal = new int[2];
							do {
								goal[0] = (int) (Math.random() * 3);
								goal[1] = (int) (Math.random() * 3);
								//System.out.println(java.util.Arrays.toString(goal));
							} while (board[goal[0]][goal[1]] != 0);
							move = goal;
						}
					}
				}
			}

		}


		return move;
	}

	private void moveToEmptyCorner(int[] move, int[][] board) {
		int corner = 0; // value that references a certain corner
		int[] goal = new int[2]; // goal location (could be occupied, based on the value of corner)
		do { // While loop that chooses a random corner until it finds one that is empty
			corner = (int) (Math.random() * 4);
			// If tree to convert corner value into an actual position on the board
			if (corner == 0) {
				goal[0] = 0;
				goal[1] = 0;
			} else if (corner == 1) {
				goal[0] = 0;
				goal[1] = 2;
			} else if (corner == 2) {
				goal[0] = 2;
				goal[1] = 0;

			} else {
				goal[0] = 2;
				goal[1] = 2;
			}

		} while (board[goal[0]][goal[1]] != 0); // if goal location is occupied, try again
		// set move to valid goal location :]
		move[0] = goal[0];
		move[1] = goal[1];
	}

	private int[] findTargetPosition(int[][] board, int IDToCheckForInLine) {
		// check if we need to block
		// array of possible lines a player may be trying to make
		int[][][] lines = new int[][][] {
				// Format for this is {{row position, column position}, {r, c}, {r,c}}
				{ { 0, 0 }, { 0, 1 }, { 0, 2 } }, // First row
				{ { 1, 0 }, { 1, 1 }, { 1, 2 } }, // Second row
				{ { 2, 0 }, { 2, 1 }, { 2, 2 } }, // Third row
				{ { 0, 0 }, { 1, 0 }, { 2, 0 } }, // First column
				{ { 0, 1 }, { 1, 1 }, { 2, 1 } }, // Second column
				{ { 0, 2 }, { 1, 2 }, { 2, 2 } }, // Third column
				{ { 0, 0 }, { 1, 1 }, { 2, 2 } }, // Top left to bottom right diagonal
				{ { 0, 2 }, { 1, 1 }, { 2, 0 } } // Top right to bottom left diagonal
		};
		// This for loop is really scuffed, but I hope it works - 8:11 PM sleep-deprived
		// Ella
		for (int[][] line : lines) {
			int opponentPiecesInLine = 0;
			int[] blockPosition = new int[0];
			for (int[] location : line) {
				if (board[location[0]][location[1]] == IDToCheckForInLine) {
					opponentPiecesInLine++;
				} else if (board[location[0]][location[1]] == 0) {
					blockPosition = location;
				} else {
					blockPosition = null;
				}
			}
			if (opponentPiecesInLine == 2) {
				return blockPosition;
			}
		}
		return null;
	}

}