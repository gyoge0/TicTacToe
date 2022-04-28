package opponents;

import game.GameController;
import game.TicTacToePlayer;
public class asianbot extends TicTacToePlayer {
//worked with somil	
	private int[][] board = new int[2][2];
	private int a = 0;
	private int boardPosition = 0;
	private int boardPosition2 = 0;
	private int b = 0;
	private int c = 0;

	public asianbot(String name, int piece) {
		super(name, piece); 
	}
	
	public int[] playTurn() {
		int[] move = new int[2];
		if (getPiece() == 1) {
		if (getPiece() == 1 && GameController.getTurnCount() == 0) {
			move[0] = 1;
			move[1] = 1;
		}
		if (getPiece() == 1 && GameController.getTurnCount() == 2) {
			if (GameController.game.getBoard()[0][1] == 2) {
				move[0] = 1;
				move[1] = 0;
				a = 1;
			}
			else if (GameController.game.getBoard()[1][0] == 2) {
				move[0] = 2;
				move[1] = 1;
				a = 2;
			}
			else if (GameController.game.getBoard()[2][1] == 2) {
				move[0] = 1;
				move[1] = 2;
				a = 3;
			}
			else if (GameController.game.getBoard()[1][2] == 2) {
				move[0] = 0;
				move[1] = 1;
				a = 4;
			}
			
			else if (GameController.game.getBoard()[0][0] == 2) {
				move[0] = 2;
				move[1] = 0;
				a = 5;
			}
			else if (GameController.game.getBoard()[0][2] == 2) {
				move[0] = 0;
				move[1] = 0;
				a = 6;
			}
			else if (GameController.game.getBoard()[2][2] == 2) {
				move[0] = 0;
				move[1] = 2;
				a = 7;
			}
			else if (GameController.game.getBoard()[2][0] == 2) {
				move[0] = 2;
				move[1] = 2;
				a = 8;
			}
			else {
				move[0] = 1;
				move[1] = 0;
				a = 9;
			}
		}
		if (getPiece() == 1 && GameController.getTurnCount() == 4) {
			if (a == 1) {
				if (GameController.getBoard()[1][2] == 2) {
					move[0] = 2;
					move[1] = 0;
				}
				else {
					move[0] = 1;
					move[1] = 2;
				}
			}
			if (a == 2) {
				if (GameController.getBoard()[0][1] == 2) {
					move[0] = 2;
					move[1] = 2;
				}
				else {
					move[0] = 0;
					move[1] = 1;
				}
			}
			if (a == 3) {
				if (GameController.getBoard()[1][0] == 2) {
					move[0] = 0;
					move[1] = 2;
				}
				else {
					move[0] = 1;
					move[1] = 0;
				}
			}
			if (a == 4) {
				if (GameController.getBoard()[2][1] == 2) {
					move[0] = 0;
					move[1] = 0;
				}
				else {
					move[0] = 2;
					move[1] = 1;
				}
			}
			
			if (a == 5) {
				if (GameController.getBoard()[0][2] == 2) {
					move[0] = 0;
					move[1] = 1;
				}
				else {
					move[0] = 0;
					move[1] = 2;
				}
			}
			if (a == 6) {
				if (GameController.getBoard()[2][2] == 2) {
					move[0] = 1;
					move[1] = 2;
				}
				else {
					move[0] = 2;
					move[1] = 2;
				}
			}
			if (a == 7) {
				if (GameController.getBoard()[2][0] == 2) {
					move[0] = 2;
					move[1] = 1;
				}
				else {
					move[0] = 2;
					move[1] = 0;
				}
			}
			if (a == 8) {
				if (GameController.getBoard()[0][0] == 2) {
					move[0] = 1;
					move[1] = 0;
				}
				else {
					move[0] = 0;
					move[1] = 0;
				}
			}
			if (a == 9) {
				if (GameController.getBoard()[1][2] == 2) {
					move[0] = 2;
					move[1] = 0;
				}
				else {
					move[0] = 1;
					move[1] = 2;
				}
			}
		}
		if (getPiece() == 1 && GameController.getTurnCount() == 6) {
			if (a == 1) {
				if (GameController.getBoard()[0][0] == 2) {
					move[0] = 0;
					move[1] = 2;
				}
				else if (GameController.getBoard()[0][2] == 2) {
					move[0] = 0;
					move[1] = 1;
				}
				else {
					move[0] = 0;
					move[1] = 2;
				}
			}
			if (a == 2) {
				if (GameController.getBoard()[0][0] == 2) {
					move[0] = 2;
					move[1] = 0;
				}
				else if (GameController.getBoard()[2][0] == 2) {
					move[0] = 0;
					move[1] = 0;
				}
				else {
					move[0] = 2;
					move[1] = 0;
				}
			}
			if (a == 3) {
				if (GameController.getBoard()[2][0] == 2) {
					move[0] = 2;
					move[1] = 2;
				}
				else if (GameController.getBoard()[2][2] == 2) {
					move[0] = 2;
					move[1] = 0;
				}
				else {
					move[0] = 2;
					move[1] = 2;
				}
			}
			if (a == 4) {
				if (GameController.getBoard()[0][2] == 2) {
					move[0] = 2;
					move[1] = 2;
				}
				else if (GameController.getBoard()[2][2] == 2) {
					move[0] = 0;
					move[1] = 2;
				}
				else {
					move[0] = 2;
					move[1] = 2;
				}
			}
			
			if (a == 5) {
				if (GameController.getBoard()[2][1] == 2) {
					move[0] = 1;
					move[1] = 2;
				}
				else {
					move[0] = 2;
					move[1] = 1;
				}
			}
			if (a == 6) {
				if (GameController.getBoard()[1][0] == 2) {
					move[0] = 2;
					move[1] = 1;
				}
				else {
					move[0] = 1;
					move[1] = 0;
				}
			}
			if (a == 7) {
				if (GameController.getBoard()[0][1] == 2) {
					move[0] = 1;
					move[1] = 0;
				}
				else {
					move[0] = 0;
					move[1] = 1;
				}
			}
			if (a == 8) {
				if (GameController.getBoard()[1][2] == 2) {
					move[0] = 0;
					move[1] = 1;
				}
				else {
					move[0] = 1;
					move[1] = 2;
				}
			}
			if (a == 9) {
				if (GameController.getBoard()[0][0] == 2) {
					move[0] = 0;
					move[1] = 2;
				}
				else {
					move[0] = 0;
					move[1] = 0;
				}
			}
		}
		if (getPiece() == 1 && GameController.getTurnCount() == 8) {
			if (a == 5) {
				if (GameController.getBoard()[1][0] == 2) {
					move[0] = 2;
					move[1] = 2;
				}
				else {
					move[0] = 1;
					move[1] = 0;
				}
			}
			if (a == 6) {
				if (GameController.getBoard()[0][1] == 2) {
					move[0] = 2;
					move[1] = 0;
				}
				else {
					move[0] = 0;
					move[1] = 1;
				}
			}
			if (a == 7) {
				if (GameController.getBoard()[1][2] == 2) {
					move[0] = 0;
					move[1] = 0;
				}
				else {
					move[0] = 1;
					move[1] = 2;
				}
			}
			if (a == 8) {
				if (GameController.getBoard()[2][1] == 2) {
					move[0] = 0;
					move[1] = 2;
				}
				else {
					move[0] = 2;
					move[1] = 1;
				}
			}
		}
		}
		else if (getPiece() == 2) {
		if (GameController.getTurnCount() == 1 && boardPosition2 == 0 && GameController.getBoard()[1][1] == 0 && GameController.getBoard()[0][0] != 0) {
			move[0] = 1;
			move[1] = 1;
			boardPosition2 = 1;
		} else if (GameController.getTurnCount() == 1 && boardPosition2 == 0 && GameController.getBoard()[1][1] == 0 && GameController.getBoard()[0][1] != 0) {
			move[0] = 1;
			move[1] = 1;
			boardPosition2 = 2;
		} else if (GameController.getTurnCount() == 1 && boardPosition2 == 0 && GameController.getBoard()[1][1] == 0 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 1;
			boardPosition2 = 4;
		} else if (GameController.getTurnCount() == 1 && boardPosition2 == 0 && GameController.getBoard()[1][1] == 0 && GameController.getBoard()[1][2] != 0) {
			move[0] = 1;
			move[1] = 1;
			boardPosition2 = 6;
		} else if (GameController.getTurnCount() == 1 && boardPosition2 == 0 && GameController.getBoard()[1][1] == 0 && GameController.getBoard()[2][0] != 0) {
			move[0] = 1;
			move[1] = 1;
			boardPosition2 = 7;
		} else if (GameController.getTurnCount() == 1 && boardPosition2 == 0 && GameController.getBoard()[1][1] == 0 && GameController.getBoard()[2][1] != 0) {
			move[0] = 1;
			move[1] = 1;
			boardPosition2 = 8;
		} else if (GameController.getTurnCount() == 1 && boardPosition2 == 0 && GameController.getBoard()[1][1] == 0 && GameController.getBoard()[2][2] != 0) {
			move[0] = 1;
			move[1] = 1;
			boardPosition2 = 9;
		}

		else if (GameController.getTurnCount() == 1 && boardPosition == 0 && GameController.getBoard()[1][1] != 0) {
			move[0] = 2;
			move[1] = 0;
			boardPosition = 1;
		}
		if (GameController.getTurnCount() == 3 && boardPosition == 1 && GameController.getBoard()[0][0] != 0) {
			move[0] = 2;
			move[1] = 2;
			boardPosition = 3;

		} else if (GameController.getTurnCount() == 3 && boardPosition == 1 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 2;

			boardPosition = 4;
		} else if (GameController.getTurnCount() == 3 && boardPosition == 1 && GameController.getBoard()[1][2] != 0) {
			move[0] = 1;
			move[1] = 0;
			boardPosition = 5;
		} else if (GameController.getTurnCount() == 3 && boardPosition == 1 && GameController.getBoard()[0][1] != 0) {
			move[0] = 2;
			move[1] = 1;
			boardPosition = 6;
		} else if (GameController.getTurnCount() == 3 && boardPosition == 1 && GameController.getBoard()[2][1] != 0) {
			move[0] = 0;
			move[1] = 1;
			boardPosition = 7;
		} else if (GameController.getTurnCount() == 3 && boardPosition == 1 && GameController.getBoard()[0][2] != 0) {
			move[0] = 2;
			move[1] = 2;
			boardPosition = 8;
		} else if (GameController.getTurnCount() == 3 && boardPosition == 1 && GameController.getBoard()[2][2] != 0) {
			move[0] = 0;
			move[1] = 0;
			boardPosition = 9;
		}
		// if user puts 0 0 on second turn win conditions
		else if (GameController.getTurnCount() == 5 && boardPosition == 3 && GameController.getBoard()[2][1] == 0) {
			move[0] = 2;
			move[1] = 1;

		} else if (GameController.getTurnCount() == 5 && boardPosition == 3 && GameController.getBoard()[2][1] != 0) {
			move[0] = 0;
			move[1] = 1;
			boardPosition = 10;
			// had to comment this out
//			System.out.println(boardPosition);
		} else if (GameController.getTurnCount() == 7 && boardPosition == 10 && GameController.getBoard()[1][0] != 0) {
			// had to comment this out
//			System.out.println("hi");
			move[0] = 1;
			move[1] = 2;
			boardPosition = 11;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 10 && GameController.getBoard()[1][2] != 0) {
			// had to comment this out
//			System.out.println("hi");
			move[0] = 1;
			move[1] = 0;
			boardPosition = 11;
		} else if (GameController.getTurnCount() == 9 && boardPosition == 11) {
			while (GameController.getTurnCount() == 9) {
				if (GameController.getBoard()[(int) (Math.random() * 3)][(int) (Math.random() * 3)] == 0) {
					return move;
				}
			}
		}
		// if opponent goes 1 0

		else if (GameController.getTurnCount() == 5 && boardPosition == 4 && GameController.getBoard()[0][1] != 0) {
			move[0] = 2;
			move[1] = 1;
			boardPosition = 12;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 4 && GameController.getBoard()[2][1] != 0) {
			move[0] = 0;
			move[1] = 1;
			boardPosition = 12;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 4 && GameController.getBoard()[0][1] != 0) {
			move[0] = 2;
			move[1] = 1;
			boardPosition = 12;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 4 && GameController.getBoard()[2][2] != 0) {
			move[0] = 0;
			move[1] = 0;
			boardPosition = 13;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 4 && GameController.getBoard()[0][0] != 0) {
			move[0] = 2;
			move[1] = 2;
			boardPosition = 13;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 13 && GameController.getBoard()[0][1] != 0) {
			move[0] = 2;
			move[1] = 1;
			boardPosition = 15;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 13 && GameController.getBoard()[2][1] != 0) {
			move[0] = 0;
			move[1] = 1;
			boardPosition = 15;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 12 && GameController.getBoard()[0][0] != 0) {
			move[0] = 2;
			move[1] = 2;
			boardPosition = 15;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 12 && GameController.getBoard()[2][2] != 0) {
			move[0] = 0;
			move[1] = 0;
			boardPosition = 15;
			// had to comment this out
//			System.out.println("hi");
		} else if (GameController.getTurnCount() == 9 && boardPosition == 15) {
			while (GameController.getTurnCount() == 9) {
				if (GameController.getBoard()[(int) (Math.random() * 3)][(int) (Math.random() * 3)] == 0) {
					return move;
				}
			}
		}
		// if opponent goes 1 2
		else if (GameController.getTurnCount() == 5 && boardPosition == 5 && GameController.getBoard()[0][0] == 0) {
			move[0] = 0;
			move[1] = 0;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 5 && GameController.getBoard()[0][0] != 0) {
			move[0] = 2;
			move[1] = 2;
			boardPosition = 16;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 16 && GameController.getBoard()[2][1] == 0) {
			move[0] = 2;
			move[1] = 1;

		} else if (GameController.getTurnCount() == 7 && boardPosition == 16 && GameController.getBoard()[2][1] != 0) {
			move[0] = 0;
			move[1] = 1;
		}
		// if opponent goes 0 1
		else if (GameController.getTurnCount() == 5 && boardPosition == 6 && GameController.getBoard()[2][2] == 0) {
			move[0] = 2;
			move[1] = 2;

		} else if (GameController.getTurnCount() == 5 && boardPosition == 6 && GameController.getBoard()[2][2] != 0) {
			move[0] = 0;
			move[1] = 0;
			boardPosition = 17;
			// had to comment this out
//			System.out.println(boardPosition);
		} else if (GameController.getTurnCount() == 7 && boardPosition == 17 && GameController.getBoard()[1][0] == 0) {
			move[0] = 1;
			move[1] = 0;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 17 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 2;
		}
		// if opponent goes 2 1
		else if (GameController.getTurnCount() == 5 && boardPosition == 7 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 2;
			boardPosition = 18;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 7 && GameController.getBoard()[1][2] != 0) {
			move[0] = 1;
			move[1] = 0;
			boardPosition = 18;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 7 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 2;
			boardPosition = 18;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 7 && GameController.getBoard()[2][2] != 0) {
			move[0] = 0;
			move[1] = 0;
			boardPosition = 19;
		} else if (GameController.getTurnCount() == 5 && boardPosition == 7 && GameController.getBoard()[0][0] != 0) {
			move[0] = 2;
			move[1] = 2;
			boardPosition = 19;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 19 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 2;
			boardPosition = 18;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 19 && GameController.getBoard()[1][2] != 0) {
			move[0] = 1;
			move[1] = 0;
			boardPosition = 18;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 18 && GameController.getBoard()[2][2] != 0) {
			move[0] = 0;
			move[1] = 0;
			boardPosition = 19;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 18 && GameController.getBoard()[0][0] != 0) {
			move[0] = 2;
			move[1] = 2;
			boardPosition = 19;
		}
		// if opponent starts 0 2
		else if (GameController.getTurnCount() == 5 && boardPosition == 8 && GameController.getBoard()[2][1] == 0) {
			move[0] = 2;
			move[1] = 1;

		} else if (GameController.getTurnCount() == 5 && boardPosition == 8 && GameController.getBoard()[2][1] != 0) {
			move[0] = 0;
			move[1] = 1;
			boardPosition = 20;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 20 && GameController.getBoard()[1][2] != 0) {
			move[0] = 1;
			move[1] = 0;

		} else if (GameController.getTurnCount() == 7 && boardPosition == 20 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 2;
		}
		// if opponent starts at 2 2
		else if (GameController.getTurnCount() == 5 && boardPosition == 9 && GameController.getBoard()[1][0] == 0) {
			move[0] = 1;
			move[1] = 0;

		} else if (GameController.getTurnCount() == 5 && boardPosition == 9 && GameController.getBoard()[1][0] != 0) {
			move[0] = 1;
			move[1] = 2;
			boardPosition = 21;
		} else if (GameController.getTurnCount() == 7 && boardPosition == 21 && GameController.getBoard()[0][1] != 0) {
			move[0] = 2;
			move[1] = 1;

		} else if (GameController.getTurnCount() == 7 && boardPosition == 21 && GameController.getBoard()[2][1] != 0) {
			move[0] = 0;
			move[1] = 1;

		}
		
		
		
		if (getPiece() == 2 && GameController.getTurnCount() == 1) {
			if (GameController.game.getBoard()[0][0] == 1) {
				move[0] = 1;
				move[1] = 1;
				b = 1;				
			}
			if (GameController.game.getBoard()[0][2] == 1) {
				move[0] = 1;
				move[1] = 1;
				b = 2;				
			}
			if (GameController.game.getBoard()[2][2] == 1) {
				move[0] = 1;
				move[1] = 1;
				b = 3;				
			}
			if (GameController.game.getBoard()[2][0] == 1) {
				move[0] = 1;
				move[1] = 1;
				b = 4;				
			}
		}
		if (getPiece() == 2 && GameController.getTurnCount() == 3) {
			if (b == 1) {
				if (GameController.getBoard()[2][2] == 1) {
					move[0] = 2;
					move[1] = 1;
					c = 1;
				}
				else if (GameController.getBoard()[2][0] == 1) {
					move[0] = 1;
					move[1] = 0;
					c = 2;
				}
				else if (GameController.getBoard()[0][2] == 1) {
					move[0] = 0;
					move[1] = 1;
					c = 3;
				}
				else if (GameController.getBoard()[0][1] == 1) {
					move[0] = 0;
					move[1] = 2;
					c = 4;
				}
				else if (GameController.getBoard()[1][0] == 1) {
					move[0] = 2;
					move[1] = 0;
					c = 5;
				}
				else if (GameController.getBoard()[1][2] == 1) {
					move[0] = 2;
					move[1] = 1;
					c = 6;
				}
				else if (GameController.getBoard()[2][1] == 1) {
					move[0] = 1;
					move[1] = 2;
					c = 7;
				}
			}
			if (b == 2) {
				if (GameController.getBoard()[2][0] == 1) {
					move[0] = 2;
					move[1] = 1;
					c = 1;
				}
				else if (GameController.getBoard()[2][2] == 1) {
					move[0] = 1;
					move[1] = 2;
					c = 2;
				}
				else if (GameController.getBoard()[0][0] == 1) {
					move[0] = 0;
					move[1] = 1;
					c = 3;
				}
				else if (GameController.getBoard()[1][2] == 1) {
					move[0] = 2;
					move[1] = 2;
					c = 4;
				}
				else if (GameController.getBoard()[0][1] == 1) {
					move[0] = 0;
					move[1] = 0;
					c = 5;
				}
				else if (GameController.getBoard()[2][1] == 1) {
					move[0] = 1;
					move[1] = 0;
					c = 6;
				}
				else if (GameController.getBoard()[1][0] == 1) {
					move[0] = 2;
					move[1] = 1;
					c = 7;
				}
			}
			if (b == 3 || b == 4) {
				while (GameController.getTurnCount() == 3) {
					if (GameController.getBoard()[(int) (Math.random() * 3)][(int) (Math.random() * 3)] == 0) {
						return move;
					}
				}
			}
		}
		if (getPiece() == 2 && GameController.getTurnCount() == 5) {
			if (b == 1) {
				if (c == 1) {
					if (GameController.getBoard()[0][1] == 1) {
						move[0] = 0;
						move[1] = 2;
					}
					else {
						move[0] = 0;
						move[1] = 1;
					}
				}
				if (c == 2) {
					if (GameController.getBoard()[1][2] == 1) {
						move[0] = 2;
						move[1] = 1;
					}
					else {
						move[0] = 1;
						move[1] = 2;
					}
				}
				if (c == 3) {
					if (GameController.getBoard()[2][1] == 1) {
						move[0] = 1;
						move[1] = 0;
					}
					else {
						move[0] = 2;
						move[1] = 1;
					}
				}
				if (c == 4) {
					if (GameController.getBoard()[2][0] == 1) {
						move[0] = 1;
						move[1] = 0;
					}
					else {
						move[0] = 2;
						move[1] = 0;
					}
				}
				if (c == 5) {
					if (GameController.getBoard()[2][2] == 1) {
						move[0] = 1;
						move[1] = 2;
					}
					else {
						move[0] = 2;
						move[1] = 2;
					}
				}
				if (c == 6) {
					if (GameController.getBoard()[0][1] == 1) {
						move[0] = 0;
						move[1] = 2;
					}
					else {
						move[0] = 0;
						move[1] = 1;
					}
				}
				if (c == 7) {
					if (GameController.getBoard()[1][0] == 1) {
						move[0] = 2;
						move[1] = 0;
					}
					else {
						move[0] = 1;
						move[1] = 0;
					}
				}
			}	
			if (b == 2) {
				if (c == 1) {
					if (GameController.getBoard()[0][1] == 1) {
						move[0] = 0;
						move[1] = 0;
					}
					else {
						move[0] = 0;
						move[1] = 1;
					}
				}
				if (c == 2) {
					if (GameController.getBoard()[1][0] == 1) {
						move[0] = 0;
						move[1] = 1;
					}
					else {
						move[0] = 1;
						move[1] = 0;
					}
				}
				if (c == 3) {
					if (GameController.getBoard()[2][1] == 1) {
						move[0] = 1;
						move[1] = 0;
					}
					else {
						move[0] = 2;
						move[1] = 1;
					}
				}
				if (c == 4) {
					if (GameController.getBoard()[0][0] == 1) {
						move[0] = 0;
						move[1] = 1;
					}
					else {
						move[0] = 0;
						move[1] = 0;
					}
				}
				if (c == 5) {
					if (GameController.getBoard()[2][2] == 1) {
						move[0] = 1;
						move[1] = 2;
					}
					else {
						move[0] = 2;
						move[1] = 2;
					}
				}
				if (c == 6) {
					if (GameController.getBoard()[1][2] == 1) {
						move[0] = 2;
						move[1] = 2;
					}
					else {
						move[0] = 1;
						move[1] = 2;
					}
				}
				if (c == 7) {
					if (GameController.getBoard()[0][1] == 1) {
						move[0] = 0;
						move[1] = 0;
					}
					else {
						move[0] = 0;
						move[1] = 1;
					}
				}
			}
			if (b == 3 || b == 4) {
				while (GameController.getTurnCount() == 5) {
					if (GameController.getBoard()[(int) (Math.random() * 3)][(int) (Math.random() * 3)] == 0) {
						return move;
					}
				}
			}
		}
		if (getPiece() == 2 && GameController.getTurnCount() == 7) {
			if (b == 1) {
				if (c == 1) {
					if (GameController.getBoard()[2][0] == 1) {
						move[0] = 1;
						move[1] = 0;
					}
					else {
						move[0] = 2;
						move[1] = 0;
					}
				}
				if (c == 2) {
					if (GameController.getBoard()[0][1] == 1) {
						move[0] = 0;
						move[1] = 2;
					}
					else {
						move[0] = 0;
						move[1] = 1;
					}
				}
				if (c == 3) {
					if (GameController.getBoard()[1][2] == 1) {
						move[0] = 2;
						move[1] = 2;
					}
					else {
						move[0] = 1;
						move[1] = 2;
					}
				}
				if (c == 4) {
					if (GameController.getBoard()[2][1] == 1) {
						move[0] = 1;
						move[1] = 0;
					}
					else {
						move[0] = 2;
						move[1] = 1;
					}
				}
				if (c == 5) {
					if (GameController.getBoard()[2][1] == 1) {
						move[0] = 1;
						move[1] = 2;
					}
					else {
						move[0] = 2;
						move[1] = 1;
					}
				}
				if (c == 6) {
					if (GameController.getBoard()[2][0] == 1) {
						move[0] = 1;
						move[1] = 0;
					}
					else {
						move[0] = 2;
						move[1] = 0;
					}
				}
				if (c == 7) {
					if (GameController.getBoard()[0][2] == 1) {
						move[0] = 0;
						move[1] = 1;
					}
					else {
						move[0] = 0;
						move[1] = 2;
					}
				}
			}
			if (b == 2) {
				if (c == 1) {
					if (GameController.getBoard()[2][2] == 1) {
						move[0] = 1;
						move[1] = 2;
					}
					else {
						move[0] = 2;
						move[1] = 2;
					}
				}
				if (c == 2) {
					if (GameController.getBoard()[2][1] == 1) {
						move[0] = 2;
						move[1] = 0;
					}
					else {
						move[0] = 2;
						move[1] = 1;
					}
				}
				if (c == 3) {
					if (GameController.getBoard()[1][2] == 1) {
						move[0] = 2;
						move[1] = 2;
					}
					else {
						move[0] = 1;
						move[1] = 2;
					}
				}
				if (c == 4) {
					if (GameController.getBoard()[1][0] == 1) {
						move[0] = 2;
						move[1] = 0;
					}
					else {
						move[0] = 1;
						move[1] = 0;
					}
				}
				if (c == 5) {
					if (GameController.getBoard()[1][0] == 1) {
						move[0] = 2;
						move[1] = 1;
					}
					else {
						move[0] = 1;
						move[1] = 0;
					}
				}
				if (c == 6) {
					if (GameController.getBoard()[0][0] == 1) {
						move[0] = 0;
						move[1] = 1;
					}
					else {
						move[0] = 0;
						move[1] = 0;
					}
				}
				if (c == 7) {
					if (GameController.getBoard()[2][2] == 1) {
						move[0] = 1;
						move[1] = 2;
					}
					else {
						move[0] = 2;
						move[1] = 2;
					}
				}
			}
			if (b == 3 || b == 4) {
				while (GameController.getTurnCount() == 7) {
					if (GameController.getBoard()[(int) (Math.random() * 3)][(int) (Math.random() * 3)] == 0) {
						return move;
					}
				}
			}
		}
		}
		return move;
	}
}