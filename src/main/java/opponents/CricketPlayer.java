package opponents;
import game.GameController;
import game.TicTacToePlayer;

//doesn't work well
public class CricketPlayer extends TicTacToePlayer {
	
	private boolean didTwoEdgesTrap;
	private boolean didEdgeProtocol;
	
	public CricketPlayer(String name, int piece) {
		super(name, piece); 
	}
	
	public int[] playTurn() {
		//GameController.game.printBoard();
		int[] move = new int[2];
		int[][] grid = GameController.game.getBoard();
		int turn = GameController.getTurnCount();
		if(turn<2) {
			didTwoEdgesTrap=false;
			didEdgeProtocol=true;
		}
		int piece = getPiece();
		int opponent = getPiece();
		if(opponent==2) {
			opponent=1;
		}
		else {
			opponent=2;
		}
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				move[0]=y;
				move[1]=x;
				if(winningMove(move, piece)) {//if it can win, win
					//System.out.println("Winning");
					return move;
				}
			}
		}
		int[][] count = getGraph(opponent);
		int biggest = -1;
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				if(count[y][x]>biggest) {//if the opponent will win next turn, block it
					biggest=count[y][x];
					move[0]=y;
					move[1]=x;
				}
			}
		}
		if(biggest==0) {
			if(turn%2==0) {
				//System.out.println("Protocol");
				if(turn==0) {
					move[0]=2;
					move[1]=0;
					return move;
				}
				else if(turn==2) {
					if(grid[1][1]==opponent) {
						move[0]=0;
						move[1]=2;
						return move;
					}
					else {
						int[] opponentMove= {-1,-1};
						for(int y=0;y<2;y++) {
							for(int x=1;x<3;x++) {
								if(grid[y][x]==opponent) {
									opponentMove[0]=y;
									opponentMove[1]=x;
								}
							}
						}
						if(opponentMove[0]<2&&opponentMove[1]>0) {
							move[0]=0;
							move[1]=0;
							return move;
						}
						else {
							move[0]=0;
							move[1]=2;
							return move;
						}
					}
				}
				else if(turn==4) {
					if(grid[0][2]==piece) {
						if(grid[0][0]==0) {
							move[0]=0;
							move[1]=0;
							return move;
						}
						else {
							move[0]=2;
							move[1]=2;
							return move;
						}
					}
					else {
						move[0]=2;
						move[1]=2;
						return move;
					}
				}
			}
			else {
				if(turn==1) {
					//System.out.println("Protocol");
					if(grid[1][1]==opponent) {
						move[0]=2;
						move[1]=0;
						return move;
					}
					else {
						didEdgeProtocol=false;
						move[0]=1;
						move[1]=1;
						return move;
					}
				}
				if(turn==3) {
					if(inCorner(opponent, grid)) {
						if(!onEdge(opponent, grid)) {
							if(!didEdgeProtocol) {
								didEdgeProtocol=true;
								//System.out.println("Center-Edge Protocol");
								if(grid[1][0]==0) {
									move[0]=1;
									move[1]=0;
									return move;
								}
								else {
									move[0]=0;
									move[1]=1;
									return move;
								}
							}
						}
						else {
							//System.out.println("L trap");
							int[] edgeSpot = getEdgeSpot(opponent, grid);
							int[] cornerSpot = getCornerSpot(opponent, grid);
							int x = 1;
							if(edgeSpot[1]==1) {
								x=cornerSpot[1];
							}
							int y = 1;
							if(edgeSpot[0]==1) {
								y=cornerSpot[0];
							}
							move[0]=y;
							move[1]=x;
							return move;
						}
					}
				}
			}
			if(edgeCount(opponent, grid)==2) {
				if(!didTwoEdgesTrap) {
					didTwoEdgesTrap=true;
					//System.out.println("Two edges trap");
					int[] spot1=getEdgeSpot(opponent, grid);
					int[] spot2 = {0,0};
					for(int y=0;y<3;y++) {
						for(int x=0;x<3;x++) {
							if(y!=x&&(y==1||x==1)&&!(y==spot1[0]&&x==spot1[1])) {
								if(grid[y][x]==opponent) {
									spot2[0]=y;
									spot2[1]=x;
								}
							}
						}
					}
					if(spot1[0]!=spot2[0]&&spot1[1]!=spot2[1]) {
						if(spot1[0]!=1) {
							move[0]=spot1[0];
							move[1]=spot2[1];
							return move;
						}
						else {
							move[0]=spot2[0];
							move[1]=spot1[1];
							return move;
						}
					}
				}
			}
		}
		
		while(grid[move[0]][move[1]]!=0) {
			move[0]=(int)(Math.random()*3);
			move[1]=(int)(Math.random()*3);
		}
		// had to manually comment this
//		System.out.println("Random");
		return move;
	}
	
	public boolean winningMove(int[] move, int piece) {
		int[][] grid=GameController.game.getBoard();
		if(grid[move[0]][move[1]]==0) {
			grid[move[0]][move[1]]=piece;
		}
		for(int i=0;i<3;i++) {
			if(grid[i][0]==piece&&grid[i][1]==piece&&grid[i][2]==piece) {
				return true;
			}
		}
		for(int i=0;i<3;i++) {
			if(grid[0][i]==piece&&grid[1][i]==piece&&grid[2][i]==piece) {
				return true;
			}
		}
		if(grid[0][0]==piece&&grid[1][1]==piece&&grid[2][2]==piece) {
			return true;
		}
		if(grid[2][0]==piece&&grid[1][1]==piece&&grid[0][2]==piece) {
			return true;
		}
		return false;
	}
	
	public int[][] getGraph(int opponent) {
		int[][] grid=GameController.game.getBoard();
		int[][] count = {{0,0,0},{0,0,0},{0,0,0}};
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				if(grid[y][x]==0) {
					int[] move = {y, x};
					if(winningMove(move, opponent)) {
						count[y][x]++;
					}
				}
			}
		}
		return count;
	}
	
	public boolean inCorner(int piece, int[][]grid) {
		if(grid[0][0]==piece||grid[0][2]==piece||grid[2][0]==piece||grid[2][2]==piece) {
			return true;
		}
		return false;
	}
	public boolean onEdge(int piece, int[][]grid) {
		if(grid[1][0]==piece||grid[0][1]==piece||grid[2][1]==piece||grid[1][2]==piece) {
			return true;
		}
		return false;
	}
	public int[] getEdgeSpot(int piece, int[][] grid) {
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				if(y!=x&&(y==1||x==1)) {
					if(grid[y][x]==piece) {
						int[] spot = {y, x};
						return spot;
					}
				}
			}
		}
		return null;
	}
	public int[] getCornerSpot(int piece, int[][] grid) {
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				if(y!=1&&x!=1) {
					if(grid[y][x]==piece) {
						int[] spot = {y, x};
						return spot;
					}
				}
			}
		}
		return null;
	}
	public int edgeCount(int piece, int[][] grid) {
		int count = 0;
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				if(y!=x&&(y==1||x==1)) {
					if(grid[y][x]==piece) {
						count++;
					}
				}
			}
		}
		return count;
	}
}