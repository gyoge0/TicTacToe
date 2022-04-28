package opponents;
import game.GameController;
import game.TicTacToePlayer;

public class KeebPlayer2 extends TicTacToePlayer {
	
	public KeebPlayer2(String name, int piece) {
		super(name, piece); 
	}
	
	public int[] playTurn() {
		int[][] board = GameController.game.getBoard();
		int[] move = new int[2];
		
		int enemy;
		if (getPiece() == 1) {
			enemy = 2;
		} else {
			enemy = 1;
		}
		
		int turn = GameController.getTurnCount();
		
		if (turn == 0) {
			setMove(move, 2, 0);
		} 
		
		else if (turn == 1) {
			if (board[1][1] != 0) {
				setMove(move, 2, 2);
			} else {
				setMove(move, 1, 1);
			}
		}
		
		else if (turn == 2) {
			if (board[1][1] == 2) {
				setMove(move, 0, 2);
			} else {
				if (board[1][0] == 2 || board[0][0] == 2) {
					setMove(move, 2, 2);
				} else {
					setMove(move, 0, 0);
				}
			}
		}
		
		else if (turn == 3) {
			if (!check(move, enemy)) {
				if (board[0][0] == 1) {
					setMove(move, 0, 2);
				} else {
					int[] random = random();
					setMove(move, random[0], random[1]);	
				}
			}
		}
		
		else if (turn == 4) {
			if (!check(move, getPiece())) {
				if (!check(move, enemy)) {
					if (board[0][1] == 2){
						setMove(move, 2, 2);
					} else if (board[1][1] == 0) {
						setMove(move, 1, 1);
					} else if (board[0][0] == 0 && board[0][1] == 0 && board[1][0] == 0) {
						setMove(move, 0, 0);
					} else if (board[2][2] == 0) { 
						setMove(move, 2, 2);
					} else if (board[0][2] == 0) {
						setMove(move, 0, 2);
					} else {
						int[] random = random();
						setMove(move, random[0], random[1]);
					}
				}
			}
		}
		
		else {
			if (!check(move, getPiece())) {
				if (!check(move, enemy)) {
					int[] random = random();
					setMove(move, random[0], random[1]);
				}
			}
		}
		
		return move;
	}
	
	public void setMove(int[] move, int x, int y) {
		move[0] = x;
		move[1] = y;
	}
	
	public boolean check(int[] move, int piece) {
		if (!checkRow(move, piece)) {
			if (!checkCol(move, piece)) {
				if (!checkLR(move, piece)) {
					if (!checkRL(move, piece)) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean checkRow (int[] move, int piece) {
		int[][] board = GameController.game.getBoard();
		
		int enemy;
		if (piece == 1) {
			enemy = 2;
		} else {
			enemy = 1;
		}
		
		for (int r = 0; r < 3; r++) {
			
			String row = "";
			int num = 0;
			
			for (int c = 0; c < 3; c++) {
				row += board[r][c] + "";
				num += board[r][c];
			}
						
			if (!row.contains(enemy + "")) {
				if (num == piece*2) {
					setMove(move, r, row.indexOf("0"));
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkCol (int[] move, int piece) {
		int[][] board = GameController.game.getBoard();
		
		int enemy;
		if (piece == 1) {
			enemy = 2;
		} else {
			enemy = 1;
		}
		
		for (int c = 0; c < 3; c++) {
			
			String col = "";
			int num = 0;
			
			for (int r = 0; r < 3; r++) {
				col += board[r][c] + "";
				num += board[r][c];
			}
						
			if (!col.contains(enemy + "")) {
				if (num == piece*2) {
					setMove(move, col.indexOf("0"), c);
					return true;
				}
			} 
		}
		
		return false;
	}
	
	public boolean checkLR (int[] move, int piece) {
		int[][] board = GameController.game.getBoard();
		
		int enemy;
		if (piece == 1) {
			enemy = 2;
		} else {
			enemy = 1;
		}
		
		String LR = "";
		int lr = 0;
		for (int x = 0; x < 3; x++) {
			LR += board[x][x] + "";
			lr += board[x][x];			
		}
		
		if (!LR.contains(enemy + "")) {
			if (lr == piece*2) {
				setMove(move, LR.indexOf("0"), LR.indexOf("0"));
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkRL (int[] move, int piece) {
		int[][] board = GameController.game.getBoard();
		
		int enemy;
		if (piece == 1) {
			enemy = 2;
		} else {
			enemy = 1;
		}
		
		String RL = "";
		int rl = 0;
		for (int c = 2; c >= 0; c--) {
			RL += board[Math.abs(2-c)][c] + "";
			rl += board[Math.abs(2-c)][c];			
		}
		
		if (!RL.contains(enemy + "")) {
			if (rl == piece*2) {
				setMove(move, RL.indexOf("0"), Math.abs(2-RL.indexOf("0")));
				return true;
			}
		} 
		
		return false;
	}
	
	public int[] random() {
		int[][] board = GameController.game.getBoard();
		
		int x = (int) (Math.random() * 3);
		int y = (int) (Math.random() * 3);
		
		if (board[x][y] != 0) {
			while (board[x][y] != 0) {
				x = (int) (Math.random() * 3);
				y = (int) (Math.random() * 3);
			}
		}
		
		int[] coord = {x, y};
		
		return coord;
	}
}
