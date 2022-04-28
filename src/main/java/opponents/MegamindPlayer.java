package opponents;
import game.GameController;
import game.TicTacToePlayer;

// Defines general behavior of all players (AI and Human)
public class MegamindPlayer extends TicTacToePlayer {

	public MegamindPlayer(String aName, int aPiece) {
		super(aName, aPiece);
	}
	
	
	// All players must be able to play a turn	
	public int[] playTurn() {
		int[] move = new int[2];
		int turn = GameController.getTurnCount();
		int piece = getPiece();
		int[][] board = GameController.game.getBoard();
		move[0] = -1;
		move[1] = -1;
		
		
		if (piece == 1) {
			if (turn == 0) {
				move[0] = 0;
				move[1] = 0;
			}
			else if (turn == 2) {
				if (board[2][2] == 0) {
					move[0] = 2;
					move[1] = 2;
				}
				else {
					move[0] = 1;
					move[1] = 1;
				}
			}
			else if (turn >= 4) {
				if (arrayEqual(winMove(board, piece), move)) {
					if (arrayEqual(winMove(board, 2), move)) {
						move[0] = (int)(Math.random() * 3);
						move[1] = (int)(Math.random() * 3);
						while (board[move[0]][move[1]] != 0) {
							move[0] = (int)(Math.random() * 3);
							move[1] = (int)(Math.random() * 3);
						}
					}
					else {
						return winMove(board, 2);
					}
				}
				else {
					return winMove(board, piece);
				}
			}
		}
		else if (piece == 2) {
			if (arrayEqual(winMove(board, piece), move)) {
				if (arrayEqual(winMove(board, 1), move)) {
					move[0] = (int)(Math.random() * 3);
					move[1] = (int)(Math.random() * 3);
					while (board[move[0]][move[1]] != 0) {
						move[0] = (int)(Math.random() * 3);
						move[1] = (int)(Math.random() * 3);
					}
				}
				else {
					return winMove(board, 1);
				}
			}
			else {
				return winMove(board, piece);
			}
		}
		
		return move;
	}
	
	public boolean arrayEqual(int[] array1, int[] array2) {
		if (array1.length == array2.length) {
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] != array2[i]) {
					return false;
				}
			}
		
		return true;
		}
		else {
			return false;
		}
	}
	
	// Finds the move that wins the situation.
	public int[] winMove(int[][] board, int piece) {
		int[] bestMove = new int[2];
		
		// Check each possible win.
		
		// First win: top left corner pathways.
		if (board[0][0] == piece) {
			
			// Middle
			if (board[1][1] == piece) {
				
				// win if space free.
				if (board[2][2] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// top right corner
			if (board[0][2] == piece) {
				
				// win if space free
				if (board[0][1] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			// bottom left corner
			if (board[2][0] == piece) {
			
				// win if space free
				if (board[1][0] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// bottom right corner
			if (board[2][2] == piece) {
				
				// win if space free
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			
		}
		// Win 2: top right corner pathways
		if (board[0][2] == piece) {
			// top left piece
			if (board[0][0] == piece) {
				// if space inbetween is open win
				if (board[0][1] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			// middle
			if (board[1][1] == piece) {
				// if bottom left is clear win
				if (board[2][0] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// bottom left piece
			if (board[2][0] == piece) {
				// if middle is clear, win
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			// bottom right piece
			if (board[2][2] == piece) {
				// if inbetween is clear, win
				if (board[1][2] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			
		}
		// Win 3: middle piece
		if (board[1][1] == piece) {
			// top left piece
			if (board[0][0] == piece) {
				// if bottom left is clear place a piece and win
				if (board[2][2] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// top right piece
			if (board[0][2] == piece) {
				// if bottom left clear win
				if (board[2][0] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// bottom left piece
			if (board[2][0] == piece) {
				// top right clear, win
				if (board[0][2] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// bottom right piece
			if (board[2][2] == piece) {
				// if top left clear, win
				if (board[0][0] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 0;
					return bestMove;
				}
			}
		}
		// Win 4: bottom left
		if (board[2][0] == piece) {
			// bottom right piece
			if (board[2][2] == piece) {
				// if bottom middle clear, win
				if (board[2][1] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			// middle piece
			if (board[1][1] == piece) {
				// if top right clear, win
				if (board[0][2] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// top left piece
			if (board[0][0] == piece) {
				// if left middle clear, win
				if (board[1][0] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// top right piece
			if (board[0][2] == piece) {
				// if middle clear, win
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
		}
		// Win 5: bottom right piece
		if (board[2][2] == piece) {
			
			// top left piece
			if (board[0][0] == piece) {
				// if middle clear, win
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			// middle piece
			if (board[1][1] == piece) {
				// if top left clear, win
				if (board[0][0] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// top right piece
			if (board[0][2] == piece) {
				// if right middle clear, win
				if (board[1][2] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// bottom left piece
			if (board[2][0] == piece) {
				// if bottom middle clear, win
				if (board[2][1] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 1;
					return bestMove;
				}
			}
		}
		// Win 6: top middle
		if (board[0][1] == piece) {
			// top left piece
			if (board[0][0] == piece) {
				// if top right clear, win
				if (board[0][2] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// top right piece
			if (board[0][2] == piece) {
				// if top left clear, win
				if (board[0][0] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// middle piece
			if (board[1][1] == piece) {
				// if bottom middle clear, win
				if (board[2][1] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			// bottom middle piece
			if (board[2][1] == piece) {
				// if left middle clear, win
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
		}
		// Win 7: left middle
		if (board[1][0] == piece) {
			// top left piece
			if (board[0][0] == piece) {
				// if bottom left clear, win
				if (board[2][0] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// bottom left piece
			if (board[0][0] == piece) {
				// if top left clear, win
				if (board[0][0] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// middle piece
			if (board[1][1] == piece) {
				// if right middle clear, win
				if (board[1][2] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// right middle piece
			if (board[1][2] == piece) {
				// if middle clear, win
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
		}
		// Win 8: bottom middle
		if (board[2][1] == piece) {
			// bottom left piece
			if (board[2][0] == piece) {
				// if bottom right clear, win
				if (board[2][2] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// bottom right piece
			if (board[2][2] == piece) {
				// if bottom left clear, win
				if (board[2][0] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// middle piece
			if (board[1][1] == piece) {
				// if top middle clear, win
				if (board[0][1] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 1;
					return bestMove;
				}
			}
			// top middle piece
			if (board[0][1] == piece) {
				// if middle clear, win
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
		}
		// Win 9: right middle
		if (board[1][2] == piece) {
			
			// top right piece
			if (board[0][2] == piece) {
				// if bottom right clear, win
				if (board[2][2] == 0) {
					bestMove[0] = 2;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// top bottom right piece
			if (board[2][2] == piece) {
				// if top right clear, win
				if (board[0][2] == 0) {
					bestMove[0] = 0;
					bestMove[1] = 2;
					return bestMove;
				}
			}
			// middle piece
			if (board[1][1] == piece) {
				// if left middle clear, win
				if (board[1][0] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 0;
					return bestMove;
				}
			}
			// left middle piece
			if (board[1][0] == piece) {
				// if middle clear, win
				if (board[1][1] == 0) {
					bestMove[0] = 1;
					bestMove[1] = 1;
					return bestMove;
				}
			}
		}
		
		bestMove[0] = -1;
		bestMove[1] = -1;
		return bestMove;
	}
	
}