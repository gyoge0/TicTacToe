package opponents;//Made with love by Debrah and Clare
import game.GameController;
import game.TicTacToePlayer;

public class PlayerGarmadon extends TicTacToePlayer{

	private int[][] board; 
	private int piece;
	
	public PlayerGarmadon(String aName, int aPiece) {
		
		super(aName, aPiece);
	
	}

	public int[] playTurn() {
		int[] move = new int[2];
		int enemyPiece = 0;
		board = GameController.game.getBoard();
		piece = getPiece();
		int curTurn = GameController.getTurnCount();
		// had to comment this out
//		System.out.println("turn: "+curTurn);
		
		if(piece == 1) {
			enemyPiece = 2;
		}
		else {
			
			enemyPiece = 1;
			
		}
		int row = (int) (Math.random() * 3);
		int col = (int) (Math.random() * 3);
		//if specific spot is taken 
		
//		if (checkIfCornersFree() == true) {
//			
//			move = goToRandomCorner();
//			
//		}
		
//		else {
			
			while(board[row][col] != 0) {
				
				row = (int) (Math.random() * 3);
				col = (int) (Math.random() * 3);
				
			}
			
		//}
		
		move[0] = row;
		move[1] = col;
		
		if(checkForWinningMove(enemyPiece) == true) {
			
			move = winningMove();
			
		}
		
		else if(checkBlock(enemyPiece) == true) {
			
			move = block(enemyPiece);
			
		}
		
		if(curTurn == 0) {
			
			move[0] = 1;
			move[1] = 1;
			//System.out.println("here at first turn");
			
		}
		
		else if(curTurn == 1) {
			
			if(board[1][1] != 0) {
				
				move[0] = 0;
				move[1] = 0;
				// had to comment this out
//				System.out.println("move to corner");
				
			}
			else {
				
				move[0] = 1;
				move[1] = 1;
				// had to comment this out
//				System.out.println("move to middle");
			
			}
			//System.out.println("here at first turn");
			
		}
//		
//		if(board[1][1] != 0) {
//			
//			move[0] = 1;
//			move[1] = 1;
//			
//		}

//		 had to comment this out
//		System.out.println(move[0] + ", "+ move[1]);
		return move;
	}
	
	private boolean checkBlock(int enemyP) {
		
		for(int r = 0; r < board.length; r++) {
			
			for(int c = 0; c < board[0].length; c++) {
				
				if((enemyP == board[1][c]) && ((enemyP == board[2][c] && piece != board[0][c]) || (enemyP == board[0][c] && piece != board[2][c]))) {
					
					return true;
					
				}
				
				else if ((enemyP == board[r][1]) && ((enemyP == board[r][2] && piece != board[r][0]) || (enemyP == board[r][0] && piece != board[r][2]))) {
					
					return true;
					
				}
				
				else if(((enemyP == board[r][0]) && (enemyP == board[r][2]) && piece != board[r][1]) || ((enemyP == board[0][c]) && (enemyP == board[2][c]) && piece != board[1][c])) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;	

	}
	
	private int[] block(int enemyP) {
		
		int[] move = new int[2];
		int row = 0;
		int col = 0;
		for(int r = 0; r < board.length; r++) {
			
			for(int c = 0; c < board[0].length; c++) {
				
				//checks up and down combo
				if((enemyP == board[1][c]) && (enemyP == board[2][c]) && piece != board[0][c]) {

					col = c;
					row = 0;
					//System.out.println("block up combo");
					
				}
				
				else if ((enemyP == board[1][c]) && (enemyP == board[0][c]) && piece != board[2][c]) {
					
					row = 2;
					col = c;
					//System.out.println("block down combo");
					
				}
				//checks side to side combo
				else if((enemyP == board[r][1]) && (enemyP == board[r][2]) && piece != board[r][0]) {
					
					col = 0;
					row = r;
					//System.out.println("block left combo");
					
				}
				
				else if ((enemyP == board[r][1]) && (enemyP == board[r][0]) && piece != board[r][2]) {
					
					col = 2; 
					row = r;
					//System.out.println("block right combo");
					
				}
				
				//checks horizontal middle combo
				else if((enemyP == board[r][0]) && (enemyP == board[r][2]) && piece != board[r][1]) {
					
					col = 1;
					row = r;
					//System.out.println("block horizontal middle combo");
					
				}
				
				//checks vertical middle combo
				else if ((enemyP == board[0][c]) && (enemyP == board[2][c]) && piece != board[1][c]) {
					
					col = c; 
					row = 1;
					//System.out.println("block vertical middle combo");
					
				}
			
			}
		
		}
		move[0] = row;
		move[1] = col;
		// had to comment this out
//		System.out.println("Attempt to block at "+row +", "+ col);
		return move;
		
	}
	
	private boolean checkForWinningMove(int enemyPiece) {
		
		for(int r = 0; r < board.length; r++) {
			
			for(int c = 0; c < board[0].length; c++) {
				
				//checks for up and down combo
				if((piece == board[1][c]) && (piece == board[2][c]) && enemyPiece != board[0][c]) {
					
					return true;
					
				}
				
				else if ((piece == board[1][c]) && (piece == board[0][c]) && enemyPiece != board[2][c]) {
					
					return true;
					
				}
				//checks side to side combo
				else if((piece == board[r][1]) && (piece == board[r][2]) && enemyPiece != board[r][0]) {
					
					return true;
					
				}
				
				else if ((piece == board[r][0]) && (piece == board[r][1]) && enemyPiece != board[r][2]) {
					
					return true;
					
				}
				
				//checks for horizontal middle win 
				else if ((piece == board[r][0]) && (piece == board[r][2]) && enemyPiece != board[r][1]) {
					
					return true;
					
				}
				
				//checks for vertical middle win
				else if ((piece == board[0][c]) && (piece == board[2][c]) && enemyPiece != board[1][c]) {
					
					return true;
					
				}
				
			}
			
		}	
		
		return false;
		
	}
	
	private int[] winningMove() {
		
		int[] move = new int[2];
		int row = 0;
		int col = 0;
		
		for(int r = 0; r < board.length; r++) {
			
			for(int c = 0; c < board[0].length; c++) {
				
				if((piece == board[1][c]) && (piece == board[2][c])) {

					col = c;
					row = 0;
					// had to comment this out
//					System.out.println("Bottom vertical combo");
					
				}
				
				else if ((piece == board[1][c]) && (piece == board[0][c])) {
					
					row = 2;
					col = c;
//					System.out.println("Top vertical combo");
					// had to comment this out

				}
				//checks side to side combo
				else if((piece == board[r][1]) && (piece == board[r][2])) {
					
					col = 0;
					row = r;
//					System.out.println("left horizontal combo");
					// had to comment this out

				}
				
				else if ((piece == board[r][0]) && (piece == board[r][1])) {
					
					col = 2; 
					row = r;
//					System.out.println("Right horizontal combo");
					// had to comment this out

				}
				
				//checks for horizontal middle win 
				else if ((piece == board[r][0]) && (piece == board[r][2])) {
					
					col = 1; 
					row = r;
//					System.out.println("Middle horizontal combo");
					// had to comment this out

				}
				
				//checks for vertical middle win
				else if ((piece == board[0][c]) && (piece == board[2][c])) {
					
					col = c; 
					row = 1;
//					System.out.println("middle vertical combo");
					// had to comment this out

				}
				
			}
			
		}	
		
		move[0] = row;
		move[1] = col;
//		System.out.println("winning move at " +row + ", "+col);
		// had to comment this out

		return move;
		
	}
	
	private boolean checkIfCornersFree() {
		
		if(board[0][0] != 0 && board[0][2] != 0 && board[2][0] != 0 && board[2][2] != 0) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	private int[] goToRandomCorner() {
		
		int[] move = new int[2];
		int row = 0;
		int col = 0;
		//place holders
		int rowP = 0;
		int colP = 0;
		
		while(board[row][col] != 0) {
			
			rowP = (int) (Math.random()*(1-0+1)+0);
			colP = (int) (Math.random()*(1-0+1)+0);
			
			if(rowP == 0) {
				
				row = 0;
				
			}
			else if (rowP == 1) {
				
				row = 2;
				
			}
			
			if(colP == 0) {
				
				col = 0;
				
			}
			else if (colP == 1) {
				
				col = 2;
				
			}
			
		}
		
		move[0] = row;
		move[1] = col;
//		System.out.print("move to random corner at "+ row +", "+ col);
		// had to comment this out
		return move;
		
	}

}
