package opponents;

import game.GameController;
import game.TicTacToePlayer;
public class BigL extends TicTacToePlayer {

	public BigL(String aName, int aPiece) {
		super(aName, aPiece);
		// TODO Auto-generated constructor stub

	}

	@Override
	public int[] playTurn() {
		// TODO Auto-generated method stub
		//This is the final int I'll return
		int[] choice = new int[2];
		//pChoice[3] and oChoice[3] stand for priority value, 
		//the more priority means the more the bot should go for that space over others
		//[1] and [2] are for the location on the array of the space that should be prioritized.
		int[] pChoice = new int[3];
		int[] oChoice = new int[3];
		int[][] board = GameController.game.getBoard();
		int openSpace = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {	
			if (board[r][c] == 0) {
				openSpace++;
				}
			}
		}
		if (openSpace > 0) {
			choice[0] = 2;
			choice[1] = 2;
			return choice;
		}
		for (int i = 4; i > 0; i--) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {	
			    if(board[r][c] == 0) {
			    	pChoice[0] = r;
			    	pChoice[1] = c;
			    	pChoice[3] += 1;
			    	if(board[r + (board.length-1 - r)][c] == 0){
			    		pChoice[3] += 1;
			    		   if(board[r + 1 + (board.length-1 - r)][c] == 0) {
			    			   pChoice[3] += 1;
			    		   }
			    		}
			    	if(board[r][c + (board.length-1 - c)] == 0) {
			    		pChoice[3] += 1;
			    		}
			    	if(!(r == 0)) {
			    	if(board[r - 1][c] == 0) {
			    		pChoice[3] += 1;
			    			}
			    		}
			    	if(!(c == 0)) {
				    	if(board[r][c - 1] == 0) {
				    		pChoice[3] += 1;
				    			}
				    		}
			    	}
			    if(pChoice[3] == i) {
			    	choice[0] = pChoice[0];
			    	choice[1] = pChoice[1];
			    	return choice;
			   
			}
		choice[0] = pChoice[0];
		choice[1] = pChoice[1];
		return choice;
	
		}

		}
		
		}
		choice[0] = pChoice[0];
    	choice[1] = pChoice[1];
		return choice;
	}
}