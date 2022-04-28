package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class ToeTacinator extends TicTacToePlayer {
//this is not a PERFECT player however it does play decently
	private boolean topOrRightEdge = false;
	private boolean bottomOrLeftEdge = false;
	private boolean corner = false;
	private boolean middle = false;
	private boolean bottomRightCorner = false;
	private int piecesOnBoard;

	private boolean midLeft = false;
	private boolean midBottom = false;
	private boolean midTop = false;
	private boolean midRight = false;
	
	private boolean edgeWin = false;
	private boolean edge = false;
	private boolean edgeDraw = false;

	public ToeTacinator(String aName, int aPiece) {
		super(aName, aPiece);
		// TODO Auto-generated constructor stub
	}

	public int[] playTurn() {
//		GameController.game.printBoard();
//		System.out.println();
		int[] move = new int[2];
		int[][] board = GameController.game.getBoard();
		piecesOnBoard = 0;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (board[r][c] == 1 || board[r][c] == 2) {
					piecesOnBoard++;
				}
			}
		}
		if (getPiece() == 1) {
			if (piecesOnBoard == 0) { // always go top left corner on first turn
				move[0] = 0;
				move[1] = 0;
			}
			if (piecesOnBoard == 2) {
				if (board[2][2] == 2) { // if they choose bottom right corner route
					bottomRightCorner = true;
					move[0] = 2;
					move[1] = 0;
				} else if (board[1][1] == 2) { // if they did middle route
					middle = true;
					move[0] = 2;
					move[1] = 2;
				} else if (board[1][0] == 2 || board[2][1] == 2) { // if they pick left or bottom side
					bottomOrLeftEdge = true;
					move[0] = 0;
					move[1] = 2;
				} else if (board[0][1] == 2 || board[1][2] == 2) { // if they pick top or right side
					topOrRightEdge = true;
					move[0] = 2;
					move[1] = 0;
				} else if (board[0][2] == 2 || board[2][0] == 2) { // if they pick a corner
					corner = true;
					move[0] = 2;
					move[1] = 2;
				}
			}

			if (piecesOnBoard == 4) {
				if (bottomRightCorner) {
					if (board[1][0] == 0) {
						move[0] = 1;
						move[1] = 0;
					}
					if (board[0][2] == 0) {
						move[0] = 0;
						move[1] = 2;
					}
				}
				if (middle) {
					if (board[2][0] != 0) { // they choose right corner
						corner = true;
						middle = false;
						move[0] = 2;
						move[1] = 0;
					}
					if (board[0][2] != 0) { // they choose left corner
						corner = true;
						middle = false;
						move[0] = 0;
						move[1] = 2;
					}
					if (board[1][2] == 2) {
						midRight = true;
						move[0] = 1;
						move[1] = 0;
					}
					if (board[2][1] != 0) {
						midBottom = true;
						move[0] = 0;
						move[1] = 1;
					}
					if (board[1][0] != 0) {
						midLeft = true;
						move[0] = 1;
						move[1] = 2;
					}
					if (board[0][1] != 0) {
						midTop = true;
						move[0] = 2;
						move[1] = 1;
					}
				}
				if (bottomOrLeftEdge) {
					if (board[0][1] == 0) { // they don't block
						move[0] = 0;
						move[1] = 1;
					} else if (board[1][1] == 0) { // they block
						move[0] = 1;
						move[1] = 1;
					}
				}
				if (topOrRightEdge) {
					if (board[1][0] == 0) { // they block
						move[0] = 1;
						move[1] = 0;
					} else if (board[1][1] == 0) { // they don't block
						move[0] = 1;
						move[1] = 1;
					}
				}
				if (corner) {
					if (board[1][1] == 0) { // they block
						move[0] = 1;
						move[1] = 1;
					} else if (board[0][2] == 0) { // they don't block
						move[0] = 0;
						move[1] = 2;
					} else if (board[2][0] == 0) {
						move[0] = 2;
						move[1] = 0;
					}
				}
			}

			if (piecesOnBoard == 6) {
				if (bottomRightCorner) {
					if (board[0][1] == 0) { // they block top
						move[0] = 0;
						move[1] = 1;
					}
					if (board[1][1] == 0) { // they block middle or don't block
						move[0] = 1;
						move[1] = 1;
					}
				}
				if (middle) {
					if (board[2][0] == 2) { // they chose left corner
						if (board[0][1] == 2) { // they block top
							move[0] = 1;
							move[1] = 2;
						}
						if (board[0][1] == 0) { // they block right edge or don't block
							move[0] = 0;
							move[1] = 1;
						}
					}
					if (board[0][2] == 2) { // they chose right corner
						if (board[1][0] == 2) { // they block left
							move[0] = 2;
							move[1] = 1;
						}
						if (board[1][0] == 0) { // they block bottom edge or don't block
							move[0] = 1;
							move[1] = 0;
						}
					}
				}
				if (topOrRightEdge) {
					if (board[0][2] == 2) { // they block top
						move[0] = 2;
						move[1] = 2;
					}
					if (board[0][2] == 0) { // they block bottom or don't block
						move[0] = 0;
						move[1] = 2;
					}
				}
				if (bottomOrLeftEdge) {
					if (board[2][0] == 0) { // they block left
						move[0] = 2;
						move[1] = 0;
					}
					if (board[2][2] == 0) { // they block right or don't block
						move[0] = 2;
						move[1] = 2;
					}
				}
				if (corner) {
					if (board[0][2] == 1) { // they chose left corner on turn 1
						if (board[0][1] == 0) {
							move[0] = 0;
							move[1] = 1;
						} else if (board[1][2] == 0) { // they block top
							move[0] = 1;
							move[1] = 2;
						}
					}
					if (board[2][0] == 1) { // they chose right corner on turn 1
						if (board[2][1] == 0) {
							move[0] = 2;
							move[1] = 1;
						} else if(board[1][0] == 0) {
							move[0] = 1;
							move[1] = 0;
						}
					}
				}
				if (midTop) {
					if (board[2][0] == 0) {
						move[0] = 2;
						move[1] = 0;
					} else if (board[0][2] == 0) {
						move[0] = 0;
						move[1] = 2;
					}
				}
				if (midRight) {
					if (board[1][0] == 0) { // they didn't block
						move[0] = 1;
						move[1] = 0;
					} else if (board[0][2] == 0) {
						move[0] = 0;
						move[1] = 2;
					}
				}
				if (midLeft) {
					if (board[1][2] == 0) {
						move[0] = 1;
						move[1] = 2;
					} else if (board[2][0] == 0) {
						move[0] = 2;
						move[1] = 0;
					}
				}
				if (midBottom) {
					if (board[0][2] == 0) {
						move[0] = 0;
						move[1] = 2;
					} else if (board[2][0] == 0) {
						move[0] = 2;
						move[1] = 0;
					}
				}
			}
			if (piecesOnBoard == 8) {
				if (midTop) {
					if (board[1][0] == 0) {
						move[0] = 1;
						move[1] = 0;
					} else if (board[1][2] == 0) {
						move[0] = 1;
						move[1] = 2;
					}
				}
				if (midRight) {
					if (board[0][1] == 0) {
						move[0] = 0;
						move[1] = 1;
					} else if (board[2][1] == 0) {
						move[0] = 2;
						move[1] = 1;
					}
				}
				if (midLeft) {
					if (board[2][1] == 0) {
						move[0] = 2;
						move[1] = 1;
					} else if (board[0][1] == 0) {
						move[0] = 0;
						move[1] = 1;
					}
				}
				if (midBottom) {
					if (board[1][0] == 0) {
						move[0] = 1;
						move[1] = 0;
					} else if (board[1][2] == 0) {
						move[0] = 1;
						move[1] = 2;
					}
				}
			}
		}
		if (getPiece() == 2) {
			if (piecesOnBoard == 1) {
				if (board[0][0] != 0 || board[0][2] != 0 || board[2][0] != 0 || board[2][2] != 0) { //player 1 chose a corner
					corner = true;
					move[0] = 1;
					move[1] = 1;
				}
					if (board[1][1] != 0) { //player 1 chooses center
						middle = true;
						move[0] = 0;
						move[1] = 0;
				}	
					if (board[0][1] != 0 || board[1][0] != 0 || board[1][2] != 0 || board[2][1] != 0) { //player 1 choose an edge
						edge = true;
						move[0] = 1;
						move[1] = 1;
				}
			}
			
			if (piecesOnBoard == 3) {
				possibleBlocks(board, move, 1);
				if (corner) {
					if (board[2][2] != 0 && board[0][0] != 0 || board[0][2] != 0 && board[2][0] != 0) { //if they chose diagonals route
						move[0] = 0;
						move[1] = 1;
					}
					solver(board, move, 1, 1, 0, 0, 2, 0, 0, 0, 0, 0, 2);
				}
				if (edge) {
					if(board[0][1] == 1 && board[2][1] == 1) { //a vertical win is possible
						edgeWin = true;
						move[0] = 0;
						move[1] = 2;
					}
					if (board[1][0] == 1 && board[1][2] == 1) { //a horizontal win is possible
						edgeWin = true;
						move[0] = 0;
						move[1] = 0;
					}
				}
			}
			
			if (piecesOnBoard == 5) {
				possibleBlocks(board, move, 1);
				possibleBlocks(board, move, 2);
				if (edgeWin) {
					if (board[2][0] == 1 && board[2][0] == 0) { //vertical win
						move[0] = 2;
						move[1] = 0;
					}
					else if (board[2][0] == 1 && board[2][2] == 0) {
						move[0] = 2;
						move[1] = 2;
					}
					if (board[2][2] == 1) { //horizontal win
						move[0] = 0;
						move[1] = 2;
					}
				}
				if (corner) {
					if(board[2][2] == 1 && board[2][1] == 0 || board[0][2] == 1 && board[2][1] == 0) { //if they didn't block for diagonals route
						move[0] = 2;
						move[1] = 1;
					}
					else if(board[2][2] == 1 && board[2][1] != 0) { //if they blocked for diagonal top left-bottom right
						move[0] = 2;
						move[1] = 0;
					}
					else if (board[0][2] == 1 && board[2][1] != 0) { //if they blocked for diagonal bottom left- top right
						move[0] = 2;
						move[1] = 2;
					}
					solver(board, move, 1, 1, 2, 0, 2, 0, 1, 0, 0, 1, 0);
				}
			}
			
			if (piecesOnBoard == 7) {
				possibleBlocks(board, move, 1);
				possibleBlocks(board, move, 2);
				if (edgeWin) {
					if (board[1][2] == 1 && board[0][1] == 1 && board[2][1] == 1) { // if they blocked - WIN vertical
						move[0] = 0;
						move[1] = 0;
					}
					if (board[0][0] == 1 && board[0][1] == 1 && board[2][1] == 1) {//didn't block
						move[0] = 1;
						move[1] = 2;
					}
					if (board[0][1] == 1 && board[1][2] == 1 && board[1][0] == 1) { //WIN horizontal
						move[0] = 2;
						move[1] = 0;
					}
					else if (board[2][0] == 1 && board[1][2] == 1 && board[1][0] == 1) {
						move[0] = 0;
						move[1] = 1;
					}
				}
				if (corner) {
					if (board[2][2] == 1 && board[2][1] == 1 && board[0][2] == 0) { //they didn't block for diagonal top left - bottom right
						move[0] = 0;
						move[1] = 2;
					}
					else if (board[2][2] == 1 && board[2][1] == 1 && board[0][2] != 0) { //they blocked for diagonal top left - bottom right DRAW
						move[0] = 1;
						move[1] = 2;
					}
					else if (board[0][2] == 1 && board[2][1] == 1 && board[0][0] == 0) { //they didn't block for diagonal bottom left - top right
						move[0] = 0;
						move[1] = 0;
					}
					else if (board[0][2] == 1 && board[2][1] == 1 && board[0][0] != 0) { //they blocked for diagonal bottom left  - top right
						move[0] = 1;
						move[1] = 0;
					}
					solver(board, move, 1, 1, 2, 2, 2, 1, 1, 0, 0, 2, 1);
				}
			}
			
		}
		return move;
	}
	public void solver(int[][] board, int[] move, int r0c0, int r0c1, int r0c2, int r1c0, int r1c1, int r1c2, int r2c0, int r2c1, int r2c2, int r, int c) {
		if (board[0][0] == r0c0 && board[0][1] == r0c1 && board[0][2] == r0c2 &&
			board[1][0] == r1c0 && board[1][1] == r1c1 && board[1][2] == r1c2 &&
			board[2][0] == r2c0 && board[2][1] == r2c1 && board[2][2] == r2c2 && board[r][c] == 0) {
			move[0] = r;
			move[1] = c;
		}
	}
	//can be used to block OR get a win
	public void choose(int[][] board, int[] move, int r1, int c1, int r2, int c2 , int r, int c, int player)  { 
		if (board[r1][c1] == player && board[r2][c2] == player) {
			move[0] = r;
			move[1] = c;
		}
	}
	public void possibleBlocks(int[][]board, int[]move, int player) {
		/*horizontal blocks (look like):
		  |X|X| |    | |X|X|
		  | | | | or | | | |
		  | | | |    | | | |
		*/
		choose(board, move, 0, 0, 0, 1, 0, 2, player);
		choose(board, move, 1, 0, 1, 1, 1, 2, player);
		choose(board, move, 2, 0, 2, 1, 2, 2, player);
		choose(board, move, 0, 1, 0, 2, 0, 0, player);
		choose(board, move, 1, 1, 1, 2, 1, 0, player);
		choose(board, move, 2, 1, 2, 2, 2, 0, player);
		/*diagonal blocks (look like):
		  |X| | |    | | | |
		  | |X| | or | |X| |
		  | | | |    |X| | |
		*/
		choose(board, move, 0, 0, 1, 1, 2, 2, player);
		choose(board, move, 1, 1, 2, 2, 0, 0, player);
		choose(board, move, 2, 0, 1, 1, 0, 2, player);
		choose(board, move, 0, 2, 1, 1, 2, 0, player);
		/*vertical blocks (look like):
		  |X| | |    | | | |
		  |X| | | or |X| | |
		  | | | |    |X| | |
		*/
		choose(board, move, 0, 0, 1, 0, 2, 0, player);
		choose(board, move, 1, 0, 2, 0, 0, 0, player);
		choose(board, move, 0, 1, 1, 1, 2, 1, player);
		choose(board, move, 1, 1, 2, 1, 0, 1, player);
		choose(board, move, 0, 2, 1, 2, 2, 2, player);
		choose(board, move, 1, 2, 2, 2, 0, 2, player);
	}
}
