package opponents;// Participants: Aaron Alex, Razvan Nicolae
import game.GameController;
import game.TicTacToePlayer;

public class IndianPlayer extends TicTacToePlayer {

	public IndianPlayer(String name, int piece) {
		super(name, piece); 
	}
	
	public Boolean rowWin(int row) {
		int[][] board = GameController.game.getBoard();
		int x=board[row][0];
		int y=board[row][1];
		int z=board[row][2];
		if(x+y+z == 2 && x != 2 && y != 2 && z != 2) {
			return true;
			
		}
		return false;
		
	}
	
	public Boolean colWin(int col) {
		int[][] board = GameController.game.getBoard();
		int x = board[0][col];
		int y = board[1][col];
		int z = board[2][col];
		if(x+y+z == 2 && x != 2 && y != 2 && z != 2) {
			return true;
			
		}
		return false;
		
	}
	
	public Boolean rightDiagonalWin() {
		int[][] board = GameController.game.getBoard();
		 	int x=board[2][2];
			int y=board[1][1];
			int z=board[0][0];
			if(x+y+z == 2 && x != 2 && y != 2 && z != 2) {
				return true;
			}

		return false;	
	}
	
	public Boolean leftDiagonalWin() {
		int[][] board = GameController.game.getBoard();
		 	int x=board[0][2];
			int y=board[1][1];
			int z=board[2][0];
			if(x+y+z == 2 && x != 2 && y != 2 && z != 2) {
				return true;
			}
		return false;	
	}


	@Override
	public int[] playTurn() {
		int piece = getPiece();
		int[] move = new int[2];	
		int[][] board = GameController.game.getBoard();
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j] == 0) {
					move[0] = i;
					move[1] = j;
				}
			}
		}
		
		int turns = GameController.getTurnCount();
		if(piece == 1) {
			if(turns == 0) {
				move[0] = 1;
				move [1] = 1;
			} 
			else if(turns == 2) {
				if(board[0][2] == 2 || board[2][0] == 2 || board[2][2] == 2 || board[0][0] == 2) {
					int check1 = 0;
					for (int k = 0; k < 3; k++) {
						if(board[k][0] != 2) {  
							check1++;
						}
					}
					if(check1 == 3) {
						move[1] = 0;
					} else {
						move[1] = 2;
					}
						check1 = 0;
					for (int k = 0; k < 3; k++) {
						if(board[0][k] != 2) {  
							check1++;
						}
					}
					if(check1 == 3) {
						move[0] = 0 ;
					} else {
						move[0] = 2;
					}
				}
				else if( board[0][1] == 2 || board [2][1] == 2 || board [1][2] == 2 || board [1][0] == 2) {
					int check1 = 0;
					for (int k = 0; k < 3; k++) {
						if(board[k][0] != 2) {  
							check1++;
						}
					}
					if(check1 == 3) {
						move[1] = 0;
					} else {
						move[1] = 2;
					}
						check1 = 0;
					for (int k = 0; k < 3; k++) {
						if(board[0][k] != 2) {  
							check1++;
						}
					}
					if(check1 == 3) {
						move[0] = 0 ;
					} else {
						move[0] = 2;
					}
				}
					
			}
			else if(turns == 4) {
				
				
				for(int i = 0; i<3; i++) {
					for(int j = 0; j< 3; j++) {
						if(board[i][j] == 2) {
							for(int k = 0; k<3; k++) {
								if(board[i][k]==1) {
									for(int h = 0; h<3; h++) {
										if(board[h][j]==1) {
											if(board[0][0] == 0 && board[2][2] == 0) {
												if(i >  Math.abs(i - 2)) {
													move[0] = 0;
													move[1] = 0;
												} else {
													move[0] = 2;
													move[1] = 2;
												}
											} else {
												if(j >  Math.abs(j - 2)) {
													move[0] = 2;
													move[1] = 0;
												} else {
													move[0] = 0;
													move[1] = 2;
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
				for(int i = 0; i < 3; i++) {
					int check1 = 0;
					for (int k = 0; k < 3; k++) {
						if(board[i][k] == 2) {  
							check1++;
						}
					}
					if(check1 == 2) {
						for(int j = 0; j < 3; j++) {
							if(board[i][j] == 0) {
								move[0] = i;
								move[1] = j;
							}
						}
					}
				}
				for(int i = 0; i < 3; i++) {
					int check1 = 0;
					for (int k = 0; k < 3; k++) {
						if(board[k][i] == 2) {  
							check1++;
						}
					}
					if(check1 == 2) {
						for(int j = 0; j < 3; j++) {
							if(board[j][i] == 0) {
								move[1] = i;
								move[0] = j;
							}
						}
					}
				}
				
			} else {
				int count = 0;
				
				
				count = 0;
				for(int column = 0; column < 3; column++) {
					count = 0;
					for(int row = 0; row < 3; row++) {
						if(board[row][column] == 2) {
							count ++;
						}
					}
					if(count == 2) {
						for(int j = 0; j< 3; j++ ) {
							if(board[j][column] == 0) {
								move[0]= j;
								move[1] = column;
							}
						}
					}
				}
				
				for(int i = 0; i<3; i++) {
					count = 0;
					for(int j = 0; j<3; j++) {
						if(board[i][j] == 1) {
							count++;
						}
					}
					if(count == 2) {
						for(int h = 0; h<3; h++) {
							if(board[i][h] == 0) {
								move[0] = i;
								move[1] = h;
							}
						}
					}
				}
				
				count = 0;
				for(int i = 0; i< 3; i++) {
					count = 0;
					if(board[i][i] == 1) {
						count++;
					}
				}
				if(count == 2) {
					for(int j = 0; j<3; j++) {
						if(board[j][j] == 0) {
							move[0] = j;
							move[1] = j;
						}
					}
				}
				count = 0; 
				if(board[2][0] == 1) {
					count++;
				}
				if(board[1][1] == 1) {
					count++;
				}
				if(board[0][2] == 1) {
					count++;
				}
				if(count == 2) {
					if(board[2][0] == 0) {
						move[0] = 2;
						move[1] = 0;
					}
					if(board[1][1] == 0) {
						move[0] = 1;
						move[1] = 1;
					}
					if(board[0][2] == 0) {
						move[0] = 0;
						move[1] = 2;
					}
				}
				
				count = 0;
				for(int column = 0; column < 3; column++) {
					count = 0;
					for(int row = 0; row < 3; row++) {
						if(board[row][column] == 1) {
							count ++;
						}
					}
					if(count == 2) {
						for(int j = 0; j< 3; j++ ) {
							if(board[j][column] == 0) {
								move[0]= j;
								move[1] = column;
								return move;
							}
						}
					}
				}
				
			}
			return move;
		}
		else if( piece == 2) {
			if (piece == 2) {
				if (rowWin(0)) {
					int spaces = 0;
					while(board[0][spaces] != 0) {
						spaces = (int)(Math.random() * 3);
					}
					move[0] = 0;
					move[1] = spaces;
					
				}
				
				else if (rowWin(1)) {
					int spaces = 1;
					while(board[1][spaces] != 0) {
						spaces = (int)(Math.random() * 3);
					}
					move[0] = 1;
					move[1] = spaces;
					
				}
				
				else if (rowWin(2)) {
					int spaces = 1;
					while(board[2][spaces] != 0) {
						spaces = (int)(Math.random() * 3);
					}
					move[0] = 2;
					move[1] = spaces;
					
				}
				
				else if (colWin(0)) {
					int spaces = 1;
					while(board[spaces][0] != 0) {
						spaces = (int)(Math.random() * 3);
					}
					move[0] = spaces;
					move[1] = 0;
					
				}
				else if (colWin(1)) {
					int spaces = 1;
					while(board[spaces][1] != 0) {
						spaces = (int)(Math.random() * 3);
					}
					move[0] = spaces;
					move[1] = 1;
					
				}
				else if (colWin(2)) {
					int spaces = 1;
					while(board[spaces][2] != 0) {
						spaces = (int)(Math.random() * 3);
					}
					move[0] = spaces;
					move[1] = 2;
					
				}
				else if (rightDiagonalWin()) {
					if (board[2][2] == 0) {
						move[0] = 2;
						move[1] = 2;
					}
					else if (board[1][1] == 0) {
						move[0] = 1;
						move[1] = 1;
					}
					else if (board[0][0] == 0) {
						move[0] = 0;
						move[1] = 0;
					}
					
				}
				
				else if (leftDiagonalWin()) {
					if (board[2][0] == 0) {
						move[0] = 2;
						move[1] = 0;
					}
					else if (board[1][1] == 0) {
						move[0] = 1;
						move[1] = 1;
					}
					else if (board[0][2] == 0) {
						move[0] = 0;
						move[1] = 2;
					}
					
				}
				else {
					int row = 1;
					int col = 1;
					while(board[row][col] != 0) {
						row = (int) (Math.random() * 3);
						col = (int) (Math.random() * 3);
					
					}
						move[0] = row;
						move[1] = col;
					}
				
			}
				
			
					
			
				
			
			return move;

		}
		return null;
	}
}

