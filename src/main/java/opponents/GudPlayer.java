package opponents;
import game.GameController;
import game.TicTacToePlayer;

//Tejas and Arjun
public class GudPlayer extends TicTacToePlayer {
	public GudPlayer(String name, int piece) {
		super(name, piece);
	}

	public int[] playTurn() {
		int[] move = new int[2];
		int[][] board = GameController.game.getBoard();
		int piece = getPiece();
		for (int r = 0; r < board.length - 1; r++) {
			
			for (int c = 0; c < board[0].length - 1; c++) {
				if(board[r][c]==0&&(r==1)&&r-1!=piece&&r-1!=0&&r+1!=piece&&r+1!=0
						|| board[r][c]==0&&c==1&&c-1!=piece&&c-1!=0&&c+1!=piece&&c+1!=0
						|| board[r][c]==0&&(r==1)&&r-1!=piece&&r-1!=0&&r+1!=piece&&r+1!=0) {
				    move[0] = r;
					move[1] = c;
			}
				if((c == 0) && board[r][c] == 0 && board[r][c + 1] == piece && board[r][c + 2] == piece
						|| r==0 && board[r][c] == 0 && board[r+1][c] == piece&&board[r+2][c] == piece
						|| (c == 2) && board[r][c] == 0 && board[r][c-1] == piece && board[r][c - 2] == piece
						|| r==2 && board[r][c] == 0 && board[r-1][c] == piece&&board[r-2][c] == piece
						|| r==0 && c==0&&board[r][c] == 0 && board[r+1][c+1] == piece&&board[r+2][c+2] == piece
						|| r==0 && c==2&& board[r][c] == 0 && board[r+1][c-1] == piece&&board[r+2][c-2] == piece
						|| r==2 && c==2&&board[r][c] == 0 && board[r-1][c-1] == piece&&board[r-2][c-2] == piece
						|| r==2 && c==0 && board[r][c] == 0 && board[r-1][c+1] == piece&&board[r-2][c+2] == piece)
				{
					move[0] = r;
					move[1] = c;
				}
				else if ((board[r][c] == 0 && board[r + 1][c + 1] != piece && board[r + 1][c + 1] != 0)
						|| (board[r][c] == 0&&board[r][c + 1] != piece && board[r][c + 1] != 0 )
						|| (board[r][c] == 0&&board[r + 1][c] != piece && board[r + 1][c] != 0 )
						|| (board[r][c] == 0&&board[r + 1][c + 1] != piece && board[r + 1][c + 1] != 0)
						) {
					move[0] = r;
					move[1] = c;
				}
				else if(((r>0)&&board[r][c]==0&&board[r-0][c]!= piece&&board[r-0][c]!=0)
						|| ((c>0)&&board[r][c]==0&&board[r][c-0]!= piece&&board[r][c-0]!=0)
						|| ((r>0)&&(c>0)&&board[r][c]==0&&board[r-0][c-0]!= piece&&board[r-0][c-0]!=0))
						
						{
					move[0] = r;
					move[1] = c;
				}
				else {
					move[0] = (int) (Math.random() * 3);
					move[1] = (int) (Math.random() * 3);
				}
				
				
				}
				
		}
		// had to comment this out
//		System.out.println("My move: " + move[0] + " " + move[1]);

		return move;
	}
}
