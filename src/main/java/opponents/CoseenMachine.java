package opponents;
import game.GameController;
import game.TicTacToe;
import game.TicTacToePlayer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A triplet is any row, column or diagonal on the game board (named triplet because it's 3 elements).
 * Each triplet has an integer id from 0-7.
 * Ids from 0-2 represent columns, where the column number is id.
 * Ids from 3-5 represent rows, where the row number is id-3.
 * Ids 6 and 7 represent diagonals. 6 is the downward diagonal (n, n), and 7 is the upward diagonal (n, 2-n).
 * A given triplet can be read with tripletValues(board, id).
 * The array of indices in a given triplet can be read by tCoords[id].
 * The nth cell of a triplet can be read with valAt(board, id, n).
 * @author 880376
 *
 */
public class CoseenMachine extends TicTacToePlayer {

	private int opponent;
	private int[] startingSquare = {1, 1};//TODO reset to {0, 0};
	private boolean findingWinningStarter = false;//TODO reset to true;
	private TicTacToe game;
	
	private static int[][][] tCoords; //All sets of coordinates in every triplet
	
	public CoseenMachine(String name, int piece) {
		super(name, piece);
		
		opponent = 3 - piece; //1 -> 2, 2 -> 1

		//Populate tCoords
		if (tCoords == null) {
			tCoords = new int[8][3][2];
			for (int id = 0; id < 8; id++) {
				if (id < 6) {
					for (int i = 0; i < 3; i++) {
						tCoords[id][i][id / 3] = i;
						tCoords[id][i][1 - (id / 3)] = id % 3;
					}
				} else {
					for (int i = 0; i < 3; i++) {
						tCoords[id][i][0] = i;
						tCoords[id][i][1] = ((id==6)?i:(2-i));
					}
				}
			}
		}
	}
	
	/**
	 * Exploits time of getName() call in GameController to set game after static field GameController.game has been initialized.
	 * Canont be done in constructor because each player is initialized before the TicTacToe instance.
	 * @return The name
	 */
	@Override
	public String getName() {
		game = GameController.game;
		return super.getName();
	}
	
	/**
	 * Counts the number of times the given player has played in a given triplet
	 * @param board The board to look through
	 * @param id The id of the triplet to check
	 * @param player The player to look for
	 * @return The number of `player` instances in the triplet
	 */
	private int count(int[][] board, int id, int player) {
		int count = 0;
		for (int i : tripletValues(board, id)) {
			if (i == player) count++;
		}
		return count;
	}
	
	private int valAt(int[][] board, int[] coords) {
		return board[coords[0]][coords[1]];
	}
	
	private int valAt(int[][] board, int id, int index) {
		return valAt(board, tCoords[id][index]);
	}
	
	private int[] tripletValues(int[][] board, int id) {
		int[] ans = new int[3];
		for (int i = 0; i < 3; i++) {
			ans[i] = valAt(board, id, i);
		}
		
		return ans;
	}
	
	/**
	 * Gives the coordinates at the intersection of 2 triplets, or `null` if the triplets are parallel or equal.
	 * @param t1 The first triplet
	 * @param t2 The second triplet
	 * @return The intersection of `t1` and `t2`, or `null`.
	 */
	private int[] intersection(int t1, int t2) {
		for (int[] i : tCoords[t1]) { //Every point in t1
			for (int[] j : tCoords[t2]) { //Every point in t2
				if (i[0] == j[0] && i[1] == j[1]) return i;
			}
		}
		return null;
	}
	
	/**
	 * Returns the move a given player needs to play to win in one turn, or `null` if no such move exists.
	 * @param board The board to check.
	 * @param player The player to check.
	 * @return The coordinates of the winning move, or `null`.
	 */
	private int[] winningSquare(int[][] board, int player) {
		for (int id = 0; id < 8; id++) {
//			System.out.println(id + ": " + Arrays.toString(tripletValues(board, id)) + " - coords " +
//				Arrays.toString(tCoords[id][0]) + ", " +
//				Arrays.toString(tCoords[id][1]) + ", " + 
//				Arrays.toString(tCoords[id][2]));
			if (count(board, id, player) == 2) {
				for (int i = 0; i < 3; i++) {
					if (valAt(board, id, i) == 0) {
						return tCoords[id][i]; 
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Finds a move that "checkmates" the opponent, or `null` if no such move exists.
	 * @param board The board to check
	 * @return The coordinates of the first found fork move, or `null`.
	 */
	private int[] fork(int[][] board) {
		boolean foundMe;
		boolean foundOpp;
		int val;
		
		boolean[] canFork = new boolean[8]; //For every triplet, determines if a fork could exist involving that row
		for (int i = 0; i < 8; i++) {
			foundMe = false;
			foundOpp = false;
			for (int j = 0; j < 3; j++) {
				val = valAt(board, i, j);
				
				if (val == opponent) foundOpp = true;
				else if (val == getPiece()) foundMe = true;
			}
			
			canFork[i] = !foundOpp && foundMe;
		}
		
		for (int i = 3; i < 8; i++) {
			if (canFork[i]) {
				for (int j = 0; j < ((i<6)?3:i); j++) {
					if (canFork[j]) {
						int[] intersection = intersection(i, j);
						if (intersection != null && valAt(board, intersection) == 0) return intersection;
					}
				}
			}
		}
		
		return null;
	}
	
	//Entire failed approach
	//How do you expect me to live laugh love in these conditions
	/*private int[] fork(int[][] board) {
		boolean foundMe = false;
		boolean foundOpp = false;
		for (int i = 0; i < 3; i++) { //All rows
			for (int j = 0; j < 3; j++) { //All columns that intersect with said row
				foundMe = false;
				foundOpp = false;
				openSpot = null;
				for (int k = 0; k < 3; k++) {
					if (board[i][k] == opponent || board[k][j] == opponent) {
						foundOpp = true;
						break;
					}
					if (board[i][k] == getPiece() || board[k][j] == getPiece()) {
						foundMe = true;
					}
					if (board[i][k] == 0) openSpot = new int[] {i, k};
					else if (board[k][j] == 0) openSpot = new int[] {k, j};
				}
				if (!foundOpp && foundMe) return openSpot;
			}
		}
		
		//t6
		foundOpp = false;
		for (int i = 0; i < 3; i++) {
			if (board[i][i] == opponent) foundOpp = true;
		}
		
		if (!foundOpp)
		for (int i = 0; i < 6; i++) { //All rows/columns that intersect with t6
			if (board[i%3][i%3] == 0) continue;
			
		}
		
		//t7
		foundOpp = false;
		for (int i = 0; i < 3; i++) {
			if (board[i][2-i] == opponent) foundOpp = true;
		}
		
		if (!foundOpp)
		for (int i = 0; i < 6; i++) { //All rows/columns that intersect with t7
			if (board[i%3][2-i%3] != getPiece()) continue;
		}
		
		//This is all unnecessary because t6xt7 would just be a win
		//How am I supposed to live laugh love in these conditions
		/* //t6 x t7
		if (!foundOpp && board[1][1] == getPiece() && board[0][2] != opponent && board[2][0] != opponent) {
			openSpot = null;
			foundMe = false;
			for (int i = 0; i < 3; i+=2) {
				for (int j = 0; j < 3; j+=2) {
					if (board[i][j] == getPiece()) foundMe = true;
					else if (openSpot == null) openSpot = new int[] {i, j};
				}
			}
			
			if (foundMe) return openSpot;
		}/
		
		return null;
	}*/
	
	
	private int[] fillLine(int[][] board) {
		for (int i = 5; i >= 0; i--) {
			if (i % 3 != 1) {
				if (count(board, i, opponent) == 0) {
					if (valAt(board, i, 2) == 0) return tCoords[i][2];
					if (valAt(board, i, 0) == 0) return tCoords[i][0];
					if (valAt(board, i, 1) == 0) return tCoords[i][1];
				}
			}
		}
		return null;
	}

	@Override
	public int[] playTurn() {
		return new int[2]; // coseen machine disqualified for throwing errors
//		int[][] board = game.getBoard();
//		int turn = GameController.getTurnCount();
//
//		if (turn < 2) {
////			int[] temp = Arrays.copyOf(startingSquare, 2);
////			if (findingWinningStarter) {
////				if (startingSquare[1] == 2) {
////					startingSquare[1] = 0;
////					startingSquare[0]++;
////					if (startingSquare[0] == 3) {
////						//giveUp(); //no starter tricks their algorithm, sad
////						startingSquare = new int[] {1, 1};
////						findingWinningStarter = false;
////					}
////				} else {
////					startingSquare[1]++;
////				}
////			}
////			if (game.isLegalMove(startingSquare[0], startingSquare[1]))
////				return temp;
////			else {
////				startingSquare = temp;
//				if (game.isLegalMove(1, 1)) return new int[] {1, 1};
//				else return new int[] {0, 2};
////			}
//		}
//
//		int[] win = winningSquare(board, getPiece());
//		if (win != null) { //Win!
//			findingWinningStarter = false;
//			return win;
//		}
//
//		int[] block = winningSquare(board, opponent);
//		if (block != null) return block;
//
//		int[] fork = fork(board);
//		if (fork != null) return fork;
//
//		int[] line = fillLine(board);
//		if (line != null) return line;
//
//		return null;
	}

}