package opponents;

import java.util.ArrayList;

import game.GameController;
import game.TicTacToePlayer;

//Example player
public class BadTicTacToe extends TicTacToePlayer {
	
	public BadTicTacToe(String name, int piece) {
		super(name, piece); 
	}
	
	//100% random
	//does not check if the space is occupied or not
	//total garbage
	public int[] playTurn() {
		int[] move = new int[2];
		int[][] board = GameController.game.getBoard();
		int piece = getPiece();
		int curTurn = GameController.getTurnCount();
		
		int[] rows = new int[3];
		int[] cols = new int[3];
		int[] diags = new int [2];
		int total = 0;
		
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				total += board[r][c];
			}
			rows[r] = total;
			total = 0;
		}
		
		for(int c = 0; c < board.length; c++) {
			for(int r = 0; r < board[0].length; r++) {
				total += board[r][c];
			}
			cols[c] = total;
			total = 0;
		}
		
		for(int r = 0; r < board.length; r++) {
			total += board[r][r];	
		}
		diags[0] = total;
		total = 0;
		
		for(int r = 2; r > -1; r--) {
			total += board[r][r];	
		}
		diags[1] = total;
		total = 0;



		// had to comment this out
//System.out.println(checkBlock(rows, cols, diags));
		
		
		if (board[1][1] == 0){
			move[0] = 1;
			move[1] = 1;
		}
		else if(board[0][0] == 0 && checkBlock(rows, cols, diags) == false) {
			move[0] = 0;
			move[1] = 0;
		}
		else if(board[2][2] == 0 && checkBlock(rows, cols, diags) == false) {
			move[0] = 2;
			move[1] = 2;	
		}
		else if(board[0][2] == 0 && checkBlock(rows, cols, diags) == false) {
			move[0] = 0;
			move[1] = 2;
		}
		else if(board[2][0] == 0 && checkBlock(rows, cols, diags) == false) {
			move[0] = 2;
			move[1] = 0;
		}
		else if (checkBlock(rows, cols, diags) == true && checkBlock(rows, cols, diags) == false) {
			block(move, rows, cols, diags);
		}
		else {
			bestMove(move, rows, cols, diags);
		}
		
		return move;
	}
	
	public boolean checkBlock(int[] rows, int[] cols, int[] diags) {
		for	(int i = 0; i < 3; i++) {
			if(rows[i] == 2 || cols[i] == 2) {
				return true;
			}
		}
		for	(int i = 0; i < 2; i++) {
			if(diags[i] == 2) {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean checkWin(int[] rows, int[] cols, int[] diags) {
		int piece = getPiece();
		
		for	(int i = 0; i < 3; i++) {
			if(rows[i] == 2 && piece == 1 || cols[i] == 2 && piece == 1) {
				return true;
			}
			else if(rows[i] == 4 && piece == 2 || cols[i] == 4 && piece == 2 ) {
				return true;
			}
		}
		for	(int i = 0; i < 2; i++) {
			if(diags[i] == 2 && piece == 1) {
				return true;
			}
			else if(diags[i] == 4 && piece == 2) {
				return true;
			}
		}
		
		return false;
	}
	
	public void block (int[] move, int[] rows, int[] cols, int[] diags) {
		int[][] board = GameController.game.getBoard();
		int piece = getPiece();
			
		
			//blocks diagonals
			if(diags[0] == 2 && piece == 2 || diags[0] == 4 && piece == 1) {
				for(int r = 0; r > board.length; r++) {
					if(board[r][r] == 0) {
						move[0] = r;
						move[1] = r;
					}
				}
			}
			if(diags[1] == 2 && piece == 2 || diags[1] == 4 && piece == 1) {
				for(int r = 2; r > -1; r--) {
					if(board[r][r] == 0) {
						move[0] = r;
						move[1] = r;
					}
				}
			}
			
			
		
			//blocks any row with 2 X's
			for(int r = 0; r < board.length; r++) {
				if(rows[r] == 2 && piece == 2) {
					move[0] = r;
					for(int c = 0; c < board.length; c++) {
						if(board[r][c] == 0) {
							move[1] = c;
						}
					}
				}
				else if(rows[r] == 4 && piece == 1){
					for(int c = 0; c < board.length; c++) {
						if(board[r][c] == 0) {
							move[1] = c;
						}
					}
				}
				
			}
			
			//blocks any col with 2 X's
			for(int c = 0; c < board.length; c++) {
				if(cols[c] == 2 && piece == 2) {
					move[1] = c;
					for(int r = 0; r < board.length; r++) {
						if(board[r][c] == 0) {
							move[0] = r;
						}
					}
				}
				else if(cols[c] == 4 && piece == 1) {
					for(int r = 0; r < board.length; r++) {
						if(board[r][c] == 0) {
							move[0] = r;
						}
					}
				}
				
			}
			
			
		
	}
	
	public void bestMove(int[] move, int[] rows, int[] cols, int[] diags) {
		int piece = getPiece();
		int[][] board = GameController.game.getBoard();
		
		for(int r = 0; r < board.length; r++) {
			if(rows[r] == 2 && piece == 1) {
				for(int c = 0; c < board.length; c++) {
					if(board[r][c] == 0) {
						move[0] = r;
						move[1] = c;
					}
				}
			}
			else {
				for(int c = 0; c < board.length; c++) {
					if(board[r][c] == 0) {
						move[0] = r;
						move[1] = c;
					}
				}
			}
		}
		
		//blocks any col with 2 X's
		for(int c = 0; c < board.length; c++) {
			if(cols[c] == 2 && piece == 1) {
				for(int r = 0; r < board.length; r++) {
					if(board[r][c] == 0) {
						move[0] = r;
						move[1] = c;
					}
				}
			}
			else {
				for(int r = 0; r < board.length; r++) {
					if(board[r][c] == 0) {
						move[0] = r;
						move[1] = c;
					}
				}
			}
		}
		
		
		
		
	}
}
