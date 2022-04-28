package opponents;//Cole Strickland and Frey Williams
import game.GameController;
import game.TicTacToePlayer;

public class OptimalPlayer extends TicTacToePlayer {
	
	private int forcedWinCounter = 0;
	
	public OptimalPlayer(String name, int piece) {
		super(name, piece); 
	}
	

	public int[] playTurn() {
		int[] move = new int[2];
		int moveNumber = 0;
		int[][] board = GameController.game.getBoard();
		int[] forcedWinMove = winForced(board);
		int[] forcedBlockMove = blockForced(board);
		int firstSide = 0;
		int oppCornerCount = 0;
		int oppSideCount = 0;
		boolean move3EdgeTwo = false;
		boolean move3EdgeThree = false;
		boolean onTop = false;
		int diagDir = 2;
		// 0 = left
		// 1 = right
		int[] edgeCaseMove = new int[2];
		boolean move3EdgeCase = false;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 1) {
					if(i != 1 && j != 1) {
						if (oppCornerCount == 0) {
							if (i-j == 0) {
								diagDir = 1;
							}
							else {
								diagDir = 0;
							}
						}
						else if(diagDir == 1 && i-j == 0) {
							move3EdgeTwo = true;
						}
						else if(diagDir == 0 && i-j != 0) {
							move3EdgeTwo = true;
						}
						oppCornerCount++;
						
					}
					else if(i+j == 1 || i+j == 3) {
						if (i == 0) {
							onTop = true;
						}
						if (oppSideCount > 0) {
							if (Math.abs(j-firstSide) == 1) {
								move3EdgeThree = true;
							}
						}
						else {
							firstSide = j;
						}
						oppSideCount++;
						if (i == 1) {
							edgeCaseMove[0] = i+1;
							edgeCaseMove[1] = j;
						}
						else {
							edgeCaseMove[0] = i;
							edgeCaseMove[1] = j+1;
						}
					}
				}
			}
		}
		if (oppCornerCount > 0 && oppSideCount > 0) {
			move3EdgeCase = true;
		}
		if (forcedWinMove[0] != 3) {
			move = forcedWinMove;
		}
		else if(forcedBlockMove[0] != 3) {
			move = forcedBlockMove;
		}
		
		else {
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[0].length; j++) {
					if(board[i][j] != 0) {
						moveNumber++;
					}
				}
			}
			if (moveNumber == 0) {
				move[0] = 1;
				move[1] = 1;
			}
			else if (moveNumber == 1) {
				if (board[1][1] != 0) {
					move[0] = 0;
					move[1] = 0;
				}
				else {
					move[0] = 1;
					move[1] = 1;
				}
			}
			else if (moveNumber == 2) {
				int[] moveLocation = {0, 0};
				move[0] = 0;
				move[1] = 0;
				for(int i = 0; i < board.length; i++) {
					for(int j = 0; j < board[0].length; j++) {
						if(board[i][j] == 2) {
							moveLocation[0] = i;
							moveLocation[1] = j;
						}
					}
				}
				int section = moveLocation[0] + moveLocation[1];
				if (section == 0 || section == 3) {
					move[0] = 2;
					move[1] = 2;
				}
				if (section == 2) {
					move[0] = moveLocation[1];
					move[1] = moveLocation[0];
				}
			}
			else if(board[0][0] == 1 && board[1][1] == 2 && board[2][2] == 1 && moveNumber == 3) {
				move[0] = 0;
				move[1] = 1;
			}
			else if(move3EdgeCase && moveNumber == 3) {
				move[0] = edgeCaseMove[0];
				move[1] = edgeCaseMove[1];
			}
			else if(move3EdgeTwo && moveNumber == 3) {
				move[0] = 0;
				move[1] = 1;
			}
			else if (move3EdgeThree && moveNumber == 3) {
				if (onTop) {
					move[0] = 0;
				}
				else {
					move[0] = 2;
				}
				move[1] = 0;
			}
			else {
				boolean confirmedWinFound = false;
				boolean winFound = false;
				for(int i = 0; i < board.length; i++) {
					for(int j = 0; j < board[0].length; j++) {
						if (board[i][j] == 0) {
							board[i][j] = getPiece();
							if (winForced(board)[0] != 3) {
								if (forcedWinCounter >= 2) {
									confirmedWinFound = true;
									winFound = true;
									move[0] = i;
									move[1] = j;
								}
								if (!confirmedWinFound) {
									winFound = true;
									move[0] = i;
									move[1] = j;
								}
							}
							board[i][j] = 0;
						}
					}
				}	
				if (!winFound) {
					if(board[0][2] == 0) {
						move[0] = 0;
						move[1] = 2;
					}
					for(int i = 0; i < board.length; i++) {
						for(int j = 0; j < board[0].length; j++) {
							if(board[i][j] == 0) {
								move[0] = i;
								move[1] = j;
							}
						}
					}
				}
			}		
		}
		return move;
	}
	public int[] winForced(int[][] board) {
		forcedWinCounter = 0;
		int rowChosen = 3;
		int columnChosen = 3;
		int[] columns = new int[3];
		int[] rows = new int[3];
		int diagR = 0;
		int diagL = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if (board[i][j] == getPiece()) {
					columns[j]++;
					rows[i]++;
					if (i == 1 && j == 1) {
						diagR++;
						diagL++;
					}
					else if (Math.abs(i-j) == 0) {
						diagR++;
					}
					else if (Math.abs(i-j) == 2) {
						diagL++;
					}
				}
				else if (board[i][j] != getPiece() && board[i][j] != 0) {
					columns[j] = 3;
					rows[i] = 3;
					if (i == 1 && j == 1) {
						diagR = 3;
						diagL = 3;
					}
					else if (Math.abs(i-j) == 0) {
						diagR = 3;
					}
					else if (Math.abs(i-j) == 2) {
						diagL = 3;
					}
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (columns[i] == 2) {
				
				columnChosen = i;
				for(int j = 0; j < 3; j++) {
					if (board[j][i] == 0) {
						forcedWinCounter++;
						rowChosen = j;
					}
				}
			}
			else if (rows[i] == 2) {
				
				rowChosen = i;
				for(int j = 0; j < 3; j++) {
					if (board[i][j] == 0) {
						columnChosen = j;
						forcedWinCounter++;
					}
				}
			}
			else if (diagR == 2) {
				if (board[i][i] == 0) {
					forcedWinCounter++;
					columnChosen = i;
					rowChosen = i;
				}
				
			}
		
			else if (diagL == 2) {
				if (board[i][2-i] == 0) {
					forcedWinCounter++;
					rowChosen = i;
					columnChosen = 2-i;
				}
			}
		}
		int[] chosen = {rowChosen, columnChosen};
		return chosen;
	}
	
	public int[] blockForced(int[][] board) {
		int rowChosen = 3;
		int columnChosen = 3;
		int[] columns = new int[3];
		int[] rows = new int[3];
		int diagR = 0;
		int diagL = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if (board[i][j] != getPiece() && board[i][j] != 0) {
					columns[j]++;
					rows[i]++;
					if (i == 1 && j == 1) {
						diagR++;
						diagL++;
					}
					else if (Math.abs(i-j) == 0) {
						diagR++;
					}
					else if (Math.abs(i-j) == 2) {
						diagL++;
					}
				}
				else if (board[i][j] == getPiece()) {
					columns[j] = 3;
					rows[i] = 3;
					if (i == 1 && j == 1) {
						diagR = 3;
						diagL = 3;
					}
					else if (Math.abs(i-j) == 0) {
						diagR = 3;
					}
					else if (Math.abs(i-j) == 2) {
						diagL = 3;
					}
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (columns[i] == 2) {
				columnChosen = i;
				for(int j = 0; j < 3; j++) {
					if (board[j][i] == 0) {
						rowChosen = j;
					}
				}
			}
			else if (rows[i] == 2) {
				rowChosen = i;
				for(int j = 0; j < 3; j++) {
					if (board[i][j] == 0) {
						columnChosen = j;
					}
				}
			}
			else if (diagR == 2) {
				if (board[i][i] == 0) {
					columnChosen = i;
					rowChosen = i;
				}
			}
			else if (diagL == 2) {
				if (board[i][2-i] == 0) {
					columnChosen = 2-i;
					rowChosen = i;
				}
			}
		}
		int[] chosen = {rowChosen, columnChosen};
		return chosen;
	}
}