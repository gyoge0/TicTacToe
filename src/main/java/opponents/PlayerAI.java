package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class PlayerAI extends TicTacToePlayer {

	public PlayerAI(String name, int piece) {
		super(name, piece);
	}

	// 100% random
	// does not check if the space is occupied or not
	// total garbage
	@Override

	public int[] playTurn() {
		// int[] move = new int[2];
		int[][] board = GameController.game.getBoard();
		int letter = 0;
		int letterE = 0;
		int count = 0;
		int turns = GameController.getTurnCount();
		if (getPiece() == 1) {
			letter = 1;
			letterE = 2;
		} else {
			letter = 2;
			letterE = 1;
		}
		/*
		 * int[] move = new int[2]; move[0] = 0; move[1] = 0; return move;
		 */
		// ROW WIN
		if (turns == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		}
		if (turns == 1) {
			if (board[1][1] == letterE) {
				int[] move = new int[2];
				move[0] = 0;
				move[1] = 0;
				return move;
			} else {
				int[] move = new int[2];
				move[0] = 1;
				move[1] = 1;
				return move;
			}
		} else if (board[0][0] == letter && board[0][1] == letter && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		} else if (board[1][0] == letter && board[1][1] == letter && board[1][2] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 2;
			return move;
		} else if (board[2][0] == letter && board[2][1] == letter && board[2][2] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 2;
			return move;
		}
		// ROW WIN FIRST
		else if (board[0][1] == letter && board[0][2] == letter && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		} else if (board[1][1] == letter && board[1][2] == letter && board[1][0] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 0;
			return move;
		} else if (board[2][1] == letter && board[2][2] == letter && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		}
		// ROW WIN MIDDLE
		else if (board[0][0] == letter && board[0][2] == letter && board[0][1] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 1;
			return move;
		} else if (board[1][0] == letter && board[1][2] == letter && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		} else if (board[2][0] == letter && board[2][2] == letter && board[2][1] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 1;
			return move;
		}
		// COLUMN WIN
		else if (board[0][0] == letter && board[1][0] == letter && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		} else if (board[0][1] == letter && board[1][1] == letter && board[2][1] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 1;
			return move;
		} else if (board[0][2] == letter && board[1][2] == letter && board[2][2] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 2;
			return move;
		}
		// COLUMN WIN FIRST
		else if (board[1][0] == letter && board[2][0] == letter && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		} else if (board[1][1] == letter && board[2][1] == letter && board[0][1] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 1;
			return move;
		} else if (board[1][2] == letter && board[2][2] == letter && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		}
		// COLUMN WIN MIDDLE
		else if (board[0][0] == letter && board[2][0] == letter && board[1][0] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 0;
			return move;
		} else if (board[0][1] == letter && board[2][1] == letter && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		} else if (board[0][2] == letter && board[2][2] == letter && board[1][2] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 2;
			return move;
		}
		// DIAGONAL WIN
		else if (board[0][0] == letter && board[1][1] == letter && board[2][2] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 2;
			return move;
		} else if (board[0][0] == letter && board[2][2] == letter && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		} else if (board[0][2] == letter && board[2][0] == letter && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		} else if (board[0][2] == letter && board[1][1] == letter && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		} else if (board[2][0] == letter && board[1][1] == letter && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		} else if (board[2][2] == letter && board[1][1] == letter && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		}
		// CHECK IF THEY ARE GOING TO WIN
		if (board[0][0] == letterE && board[0][1] == letterE && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		} else if (board[1][0] == letterE && board[1][1] == letterE && board[1][2] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 2;
			return move;
		} else if (board[2][0] == letterE && board[2][1] == letterE && board[2][2] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 2;
			return move;
		}
		// ROW WIN FIRST
		else if (board[0][1] == letterE && board[0][2] == letterE && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		} else if (board[1][1] == letterE && board[1][2] == letterE && board[1][0] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 0;
			return move;
		} else if (board[2][1] == letterE && board[2][2] == letterE && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		}
		// ROW WIN MIDDLE
		else if (board[0][0] == letterE && board[0][2] == letterE && board[0][1] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 1;
			return move;
		} else if (board[1][0] == letterE && board[1][2] == letterE && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		} else if (board[2][0] == letterE && board[2][2] == letterE && board[2][1] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 1;
			return move;
		}
		// COLUMN WIN
		else if (board[0][0] == letterE && board[1][0] == letterE && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		} else if (board[0][1] == letterE && board[1][1] == letterE && board[2][1] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 1;
			return move;
		} else if (board[0][2] == letterE && board[1][2] == letterE && board[2][2] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 2;
			return move;
		}
		// COLUMN WIN FIRST
		else if (board[1][0] == letterE && board[2][0] == letterE && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		} else if (board[1][1] == letterE && board[2][1] == letterE && board[0][1] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 1;
			return move;
		} else if (board[1][2] == letterE && board[2][2] == letterE && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		}
		// COLUMN WIN MIDDLE
		else if (board[0][0] == letterE && board[2][0] == letterE && board[1][0] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 0;
			return move;
		} else if (board[0][1] == letterE && board[2][1] == letterE && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		} else if (board[0][2] == letterE && board[2][2] == letterE && board[1][2] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 2;
			return move;
		}
		// DIAGONAL WIN
		else if (board[0][0] == letterE && board[1][1] == letterE && board[2][2] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 2;
			return move;
		} else if (board[0][0] == letterE && board[2][2] == letterE && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 1;
			return move;
		} else if (board[0][2] == letterE && board[2][0] == letterE && board[1][1] == 0) {
			int[] move = new int[2];
			move[0] = 1;
			move[1] = 2;
			return move;
		} else if (board[0][2] == letterE && board[1][1] == letterE && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		} else if (board[2][0] == letterE && board[1][1] == letterE && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		} else if (board[2][2] == letterE && board[1][1] == letterE && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		}
		// STARTING
		else if (board[0][0] == letterE && board[1][1] == letter && board[2][2] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 2;
			return move;
		} else if (board[2][0] == letterE && board[1][1] == letter && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		} else if (board[0][2] == letterE && board[1][1] == letter && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		} else if (board[2][2] == letterE && board[1][1] == letter && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		} else if (board[1][2] == letterE && board[1][1] == letter && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		} else if (board[2][2] == letter && board[1][1] == letter && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		} else if (board[1][1] == letterE && board[2][2] == letterE && board[0][2] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 2;
			return move;
		} else if (board[1][1] == letterE && board[2][0] == letterE && board[0][0] == 0) {
			int[] move = new int[2];
			move[0] = 0;
			move[1] = 0;
			return move;
		} else if (board[1][1] == letterE && board[0][0] == letterE && board[2][0] == 0) {
			int[] move = new int[2];
			move[0] = 2;
			move[1] = 0;
			return move;
		}

		else {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 0) {
						int[] move = new int[2];
						move[0] = i;
						move[1] = j;
						return move;
					}
				}
			}
		}
		return null;

	}
}
