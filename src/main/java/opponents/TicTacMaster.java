package opponents;
import game.GameController;
import game.TicTacToePlayer;

//Worked With Jaden Park He Is In A Different Class
public class TicTacMaster extends TicTacToePlayer {

	public TicTacMaster(String name, int piece) {
		super(name, piece);
	}

	public int[] playTurn() {
		int[] move = new int[] { 1, 1 };
		int[] vLoss = horizontalLossPossible();
		int piece = getPiece();
		if (winningPiece()[0] >= 0) {
			// had to comment this out
//			System.out.println("ex win");
			move[0] = winningPiece()[0];
			move[1] = winningPiece()[1];
		} else if (vLoss[0] >= 0) {
			move[0] = vLoss[0];
			move[1] = vLoss[1];
		}

		else {
			if (GameController.getBoard()[1][1] == 0) {
				move[0] = 1;
				move[1] = 1;
			}
			while (GameController.getBoard()[move[0]][move[1]] != 0) {
				move[0] = (int) (Math.random() * 3);
				move[1] = (int) (Math.random() * 3);
			}
		}
		return move;
	}

	private int[] horizontalLossPossible() {
		int[][] board = GameController.game.getBoard();
		int piece = getPiece();

		int oppPiece = 3 - piece;

		// Checks for a horizontal loss
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == oppPiece && board[i][1] == oppPiece && board[i][2] == 0) {
				// had to comment this out
//				System.out.println("loss row 2");
				return new int[] { i, 2 };
			} else if (board[i][1] == oppPiece && board[i][2] == oppPiece && board[i][0] == 0) {
				// had to comment this out
//				System.out.println("loss row 0");
				return new int[] { i, 0 };
			} else if (board[i][0] == oppPiece && board[i][2] == oppPiece && board[i][1] == 0) {
				// had to comment this out
//				System.out.println("Loss row 1");
				return new int[] { i, 1 };
			}
		}

		// Checks for a vertical loss
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == oppPiece && board[1][i] == oppPiece && board[2][i] == 0) {
				// had to comment this out
//				System.out.println("loss column 2");
				return new int[] { 2, i };
			} else if (board[1][i] == oppPiece && board[2][i] == oppPiece && board[0][i] == 0) {
				// had to comment this out
//				System.out.println("loss column 0");
				return new int[] { 0, i };
			} else if (board[0][i] == oppPiece && board[2][i] == oppPiece && board[1][i] == 0) {
				// had to comment this out
//		System.out.println("Loss column 1");
				return new int[] { 1, i };
			}
		}

		// Checks for a diagonal loss
		if (board[0][0] == oppPiece && board[1][1] == oppPiece && board[2][2] == 0) {
			return new int[] { 2, 2 };
		} else if (board[0][0] == oppPiece && board[2][2] == oppPiece && board[1][1] == 0) {
			return new int[] { 1, 1 };
		} else if (board[1][1] == oppPiece && board[2][2] == oppPiece && board[0][0] == 0) {
			return new int[] { 0, 0 };
		} else if (board[0][2] == oppPiece && board[1][1] == oppPiece && board[2][0] == 0) {
			return new int[] { 2, 0 };
		} else if (board[0][2] == oppPiece && board[2][0] == oppPiece && board[1][1] == 0) {
			return new int[] { 1, 1 };
		} else if (board[1][1] == oppPiece && board[2][0] == oppPiece && board[0][2] == 0) {
			return new int[] { 0, 2 };
		}

		// had to comment this out
//System.out.println("No Loss");
		return new int[] { -1, -1 };
	}

	private int[] winningPiece() {
		int[][] board = GameController.game.getBoard();
		int piece = getPiece();

		// Checks if horizontal win is possible, if yes makes winning move
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == piece && board[i][1] == piece && board[i][2] == 0) {
				// had to comment this out
//		System.out.println("Dub row 2");
				return new int[] { i, 2 };
			} else if (board[i][1] == piece && board[i][2] == piece && board[i][0] == 0) {
				// had to comment this out
//		System.out.println("Dub row 0");
				return new int[] { i, 0 };
			} else if (board[i][0] == piece && board[i][2] == piece && board[i][1] == 0) {
				// had to comment this out
//		System.out.println("Dub row 1");
				return new int[] { i, 1 };
			}
		}

		// Checks if a win is possible vertically
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == piece && board[1][i] == piece && board[2][i] == 0) {
				// had to comment this out
//		System.out.println("dub column 2");
				return new int[] { 2, i };
			} else if (board[1][i] == piece && board[2][i] == piece && board[0][i] == 0) {
				// had to comment this out
//		System.out.println("Dub column 0");
				return new int[] { 0, i };
			} else if (board[0][i] == piece && board[2][i] == piece && board[1][i] == 0) {
				// had to comment this out
//		System.out.println("Dub column 1");
				return new int[] { 1, i };
			}
		}

		return new int[] { -1, 1 };
	}
}
