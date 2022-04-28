package opponents;
import game.GameController;
import game.TicTacToePlayer;

import java.util.ArrayList;

public class Jellyfish extends TicTacToePlayer {
	private static int[][] board;
	int[] move = new int[2];
	int Opp = 3 - getPiece();

	public Jellyfish(String name, int piece) {
		super(name, piece);
	}

	public int[] playTurn() {
		//GameController.game.printBoard();

		board = GameController.game.getBoard();
		int Tnum = GameController.getTurnCount();

		// GameController.game.printBoard();
		//System.out.println("---");

//		if(getPiece()==1) {
//		
//			if (Tnum == 0) {
//				move[0] = 0;
//				move[1] = 0;
//			}
//			else if (Tnum == 2) {
//				if (board[2][2] == 0) {// Opp NOT bottom right
//					move[0] = 2;
//					move[1] = 2;
//				} else if(board[2][2] == 3-getPiece()){// Opp bottom right
//					move[0] = 2;
//					move[1] = 0;
//				}
//				else {
//					randMove();
//				}
//			}  else if (Tnum == 4) {
//				// System.out.println(board[1][2]);
//				if (board[2][2] == getPiece() && board[1][1] != 0) {
//					if (board[0][2] != 0 && board[0][2] != getPiece()) {
//						move[0] = 2;
//						move[1] = 0;
//					} else if (board[2][0] != 0 && board[2][0] != getPiece()) {
//						move[0] = 0;
//						move[1] = 2;
//					} else if (board[1][0] != 0) {
//						move[0] = 1;
//						move[1] = 2;
//					} else if (board[1][2] != 0) {
//						move[0] = 1;
//						move[0] = 0;
//					} else if (board[0][1] != 0) {
//						move[0] = 2;
//						move[1] = 1;
//					} else if (board[2][1] != 0) {
//						move[0] = 0;
//						move[1] = 1;
//					}
//					else {
//						randMove();
//					}
//	
//				} else if (board[2][0] == getPiece()) {
//					if (board[1][0] == 0) {// Opp NOT left middle
//						move[0] = 1;
//						move[1] = 0;
//					} else {
//						move[0] = 1;
//						move[1] = 1;
//					}
//				} else {
//					move[0] = 1;
//					move[1] = 1;
//				}
//			} //else if (Tnum==6) {
//	//		
//	//			
//	//		} 
//			else {
//				move[0] = (int) (Math.random() * 3);
//				move[1] = (int) (Math.random() * 3);
//				while (board[move[0]][move[1]] != 0) {
//					move[0] = (int) (Math.random() * 3);
//					move[1] = (int) (Math.random() * 3);
//				}
//				move[0] = 0;
//				move[1] = 2;
//				System.out.println(Tnum);
//	
//			}
//			
//			if(!checkWin(getPiece())) {
//				checkWin(3-getPiece());
//			}
//		}

		if (getPiece() == 1) {
			if (Tnum == 0) {
				// occupy top left corner
				move[0] = 0;
				move[1] = 0;
			} else if (Tnum == 2) {
				if (board[2][2] == 0) {
					move[0] = 2;
					move[1] = 2;
				} else {
					move[0] = 2;
					move[1] = 0;
				}
			} else {
				ArrayList<int[]> winnablePositions = getWinnableLocations(Opp);

				ArrayList<int[]> bestPositionForMe = getWinnableLocations(getPiece());

				if (bestPositionForMe.size() > 0) {
					// had to comment this out
//					System.out.println(
//							"bestPositionForMe" + bestPositionForMe.get(0)[0] + ", " + bestPositionForMe.get(0)[1]);
					move = bestPositionForMe.get(0);
				} else if (winnablePositions.size() > 0) {
					move = winnablePositions.get(0);
					// had to comment this out
//					System.out.println(
//							"Winnable positions" + winnablePositions.get(0)[0] + ", " + winnablePositions.get(0)[1]);
				} else if (board[0][2] == 0) {
					move[0] = 0;
					move[1] = 2;
				} else {
					randMove();
				}
			}
		}

		else {// SECOND PLAYER HERE EHRHERHEHREHRHERHE
			if (Tnum == 1) {
				if (centerOccupied()) {
					move[0] = 2;
					move[1] = 2;
				} else {
					move[0] = 1;
					move[1] = 1;
				}
			} else {
				ArrayList<int[]> winnablePositions = getWinnableLocations(Opp);

				if (winnablePositions.size() == 0) {
					move = getEmptyCorner();
				} else if (winnablePositions.size() > 1) {
					move = winnablePositions.get(0);
				} else {
					ArrayList<int[]> bestPositionForMe = getWinnableLocations(getPiece());

					if (bestPositionForMe.size() == 0) {
						randMove(); // COULD BE OPTIMIZED COME BACK TO THIS LATER RAYNA MAKE SURE TO DO THIS
					} else if (bestPositionForMe.size() > 0) {
						move = bestPositionForMe.get(0);
					}
				}
			}
		}

		return move;

	}

	private int[] getEmptyCorner() {
		int[] corner = new int[2];
		if (board[0][0] == 0) {
			corner[0] = 0;
			corner[1] = 0;
		} else if (board[2][0] == 0) {
			corner[0] = 2;
			corner[1] = 0;
		} else if (board[0][2] == 0) {
			corner[0] = 0;
			corner[1] = 2;
		} else if (board[2][2] == 0) {
			corner[0] = 2;
			corner[1] = 2;
		}
		return corner;
	}

	private boolean centerOccupied() {
		return board[1][1] != 0;
	}

//	private boolean centerOccupiedOpponent() {
//		return board[1][1] == Opp;
//	}

	public void randMove() {
		boolean moved = false;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 0) {
					move[0] = row;
					move[1] = col;
					moved = true;
					break;
				}
			}
			if (moved) {
				break;
			}
		}
	}

//	public boolean checkWin(int player) {
//		int there = 0;
//		String[] NULL = {null, null};
//		int[] choice = new int [2];
//		for (int i = 0; i < 3; i++) {
//			//check if X player has 3 in a row anywhere
//			if (getRowCount(i, player) == 2 || getColumnCount(i, player) == 2 || getLDiag(player)==2 || getRDiag(player)==2) {
//	
//				if(getRowCount(i, player) == 2 && getRowCount(i,0)==1) {
//					 for (int c = 0; c < 3; c++) {
//						 if(board[i][c] == 0) {
//							 choice[0] = i;
//							 choice[1] = c;
//							 there +=1;
//						 }
//					 }
//				}
//				else if(getColumnCount(i, player) == 2 && getColumnCount(i,0)==1) {
//					 for (int r = 0; r < 3; r++) {
//						 if(board[r][i] == 0) {
//							 choice[0] = r;
//							 choice[1] = i;
//							 there++;
//						 }
//					 }
//				}
//				else if(getLDiag(player)==2 && getLDiag(0)==1) {
//					if(board[i][i]==0) {
//						choice[0]=i;
//						choice[1]=i;
//						there++;
//					}
//				}//Ok idk how this is going to work but just try. Nothing wrong with trying, right? right?! RIGHT??!?!?
//				else if(getRDiag(player)==2 && getRDiag(0)==1) {
//					if(board[i][2-i]==0) {
//						choice[0]=1;
//						choice[1]=2-1;
//						there++;
//					}
//				}
//			}
//			
//		}
//		if(there >0) {
//			return true;
//		}
//		else {
//			return false;
//		}
//
//	}
//	
	public ArrayList<int[]> getWinnableLocations(int player) {
		int possibleWins = 0;
		ArrayList<int[]> possibleWinLocations = new ArrayList<int[]>();
		int[] choice = new int[2];
		for (int i = 0; i < 3; i++) {
			if (getRowCount(i, player) == 2 || getColumnCount(i, player) == 2 || getLDiag(player) == 2
					|| getRDiag(player) == 2) {

				if (getRowCount(i, player) == 2 && getRowCount(i, 0) == 1) {
					for (int c = 0; c < 3; c++) {
						if (board[i][c] == 0) {
							choice[0] = i;
							choice[1] = c;
							possibleWins += 1;
							possibleWinLocations.add(choice);
						}
					}
				} else if (getColumnCount(i, player) == 2 && getColumnCount(i, 0) == 1) {
					for (int r = 0; r < 3; r++) {
						if (board[r][i] == 0) {
							choice[0] = r;
							choice[1] = i;
							possibleWins++;
							possibleWinLocations.add(choice);
						}
					}
				} else if (getLDiag(player) == 2 && getLDiag(0) == 1) {
					if (board[i][i] == 0) {
						choice[0] = i;
						choice[1] = i;
						possibleWins++;
						possibleWinLocations.add(choice);
					}
				} // Ok idk how this is going to work but just try. Nothing wrong with trying,
					// right? right?! RIGHT??!?!?
				else if (getRDiag(player) == 2 && getRDiag(0) == 1) {
					if (board[i][2 - i] == 0) {
						choice[0] = i;
						choice[1] = 2 - i;
						possibleWins++;
						possibleWinLocations.add(choice);
					}
				}
			}

		}
		return possibleWinLocations;
	}

	public int getColumnCount(int column, int player) {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if (board[i][column] == player) {
				counter++;
			}
		}

		return counter;
	}

	public int getLDiag(int player) {
		int counter = 0;
		if (board[0][0] == player) {
			counter += 1;
		}
		if (board[1][1] == player) {
			counter += 1;
		}
		if (board[2][2] == player) {
			counter += 1;
		}
		return counter;
	}

	public int getRDiag(int player) {
		int counter = 0;
		if (board[2][0] == player) {
			counter += 1;
		}
		if (board[1][1] == player) {
			counter += 1;
		}
		if (board[0][2] == player) {
			counter += 1;
		}
		return counter;
	}

	public int getRowCount(int row, int player) {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if (board[row][i] == player) {
				counter++;
			}
		}

		return counter;
	}

//	public int[] blockWin(){
//		int[] block = new int[2];
//		int val=0;
//		int opp=0;
//		int valSim=0;
//		int oppSim=0;
//		// horizontal check
//		for (int c = 0; c < 3; c++) {
//			if(c==0) {
//				val = board[0][c];
//				valSim+=1;
//			}
//			if(c!=0) {
//				if(board[0][c] == val) {
//					//TWO IN A ROW - MAKE SURE IT STAYS THAT WAY AND DOESNT GO TO THREE
//					if (c==1) {
//						block[0]=0;
//						block[1]=3;
//					}
//					else if (c==2) {
//					
//					}
//				}
//				else if(board[0][c] != val) {
//					val = board[0][c];
//					valSim=1;
//				}
//			}
//
//		}
//		return block;
//	}
//	
}
