package opponents;//Worked with Hassaan as partner
import game.GameController;
import game.TicTacToePlayer;

public class DavidSLemons extends TicTacToePlayer	{
	
	private int lastMove[] = {0, 0};

	public DavidSLemons(String name, int piece) {
		super(name, piece); 
	}
	
	public int[] playTurn() {
		int[][] board = GameController.game.getBoard();
		int[] move = new int[2];
		
		//if the bot goes first, it places a piece in the middle
		if(GameController.getTurnCount() == 0)	{
			move[0] = 1;
			move[1] = 1;
		}
		
		//checks if bot goes second, makes it's first move
		else if(GameController.getTurnCount() == 1) {
			
			//if middle is taken, put piece in a random spot
			if(board[1][1] != 0)	{
				move[0] = (int) (Math.random() * 3);
				move[1] = (int) (Math.random() * 3);
				
				//checks if the random position is the middle
					if(move[0] == 1 && move[1] == 1) {
						move[0] -= 1;
					}
			}
			
			//if middle is NOT taken, put piece in the middle
			else	{
				move[0] = 1;
				move[1] = 1;
			}
		}
		
		
		//Moves after the first two
		
		if(GameController.getTurnCount() > 1) {
			//if top left and middle left are taken 
			if(board[0][0] != 0 && board[0][1] != 0 && board[0][2] == 0 && board[0][0] == board[0][1])	{
				move[0] = 0;
				move[1] = 2;
			}
			
			//if top middle and top right are taken 
			else if(board[0][1] != 0 && board[0][2] != 0 && board[0][0] == 0 && board[0][1] == board[0][2])	{
				move[0] = 0;
				move[1] = 0;
			}
			
			//if top left and top right are taken 
			else if(board[0][0] != 0 && board[0][2] != 0 && board[0][1] == 0 && board[0][0] == board[0][2])	{
				move[0] = 0;
				move[1] = 1;
			}
			
			
			
			
			
			//if middle left and center are taken 
			else if(board[1][0] != 0 && board[1][1] != 0 && board[1][2] == 0 && board[1][0] == board[1][1])	{
				move[0] = 1;
				move[1] = 2;
			}
			
			//if center and middle right are taken 
			else if(board[1][1] != 0 && board[1][2] != 0 && board[1][0] == 0 && board[1][1] == board[1][2])	{
				move[0] = 1;
				move[1] = 0;
			}
			
			//if middle left and middle right are taken 
			else if(board[1][0] != 0 && board[1][2] != 0 && board[1][1] == 0 && board[1][0] == board[1][2])	{
				move[0] = 1;
				move[1] = 1;
			}
			
			
			
			
			
			//if bottom left and bottom middle are taken 
			else if(board[2][0] != 0 && board[2][1] != 0 && board[2][2] == 0 && board[2][0] == board[2][1])	{
				move[0] = 2;
				move[1] = 2;
			}
			
			//if bottom middle and bottom right are taken 
			else if(board[2][1] != 0 && board[2][2] != 0 && board[2][0] == 0 && board[2][1] == board[2][2])	{
				move[0] = 2;
				move[1] = 0;
			}
			
			//if bottom left and bottom right are taken 
			else if(board[2][0] != 0 && board[2][2] != 0 && board[2][1] == 0 && board[2][0] == board[2][2])	{
				move[0] = 2;
				move[1] = 1;
			}
			
			
			
			
			
			//if top left and middle left are taken 
			else if(board[0][0] != 0 && board[1][0] != 0 && board[2][0] == 0 && board[0][0] == board[1][0])	{
				move[0] = 2;
				move[1] = 0;
			}
			
			//if middle left and bottom left are taken *******
			else if(board[1][0] != 0 && board[2][0] != 0 && board[0][0] == 0 && board[1][0] == board[2][0])	{
				move[0] = 0;
				move[1] = 0;
			}
			
			//if top left and bottom left are taken 
			else if(board[0][0] != 0 && board[2][0] != 0 && board[1][0] == 0 && board[0][0] == board[2][0])	{
				move[0] = 1;
				move[1] = 0;
			}
			
			
			
			
			
			//if top middle and center are taken 
			else if(board[0][1] != 0 && board[1][1] != 0 && board[2][1] == 0 && board[0][1] == board[1][1])	{
				move[0] = 2;
				move[1] = 1;
			}
			
			//if center and bottom middle are taken 
			else if(board[1][1] != 0 && board[2][1] != 0 && board[0][1] == 0 && board[1][1] == board[2][1])	{
				move[0] = 0;
				move[1] = 1;
			}
			
			//if top middle and bottom middle are taken 
			else if(board[0][1] != 0 && board[2][1] != 0 && board[1][1] == 0 && board[0][1] == board[2][1])	{
				move[0] = 1;
				move[1] = 1;
			}
			
			
			
			
			
			//if top right and middle right are taken 
			else if(board[0][2] != 0 && board[1][2] != 0 && board[2][2] == 0 && board[0][2] == board[1][2])	{
				move[0] = 2;
				move[1] = 2;
			}
			
			//if middle right and bottom right are taken 
			else if(board[1][2] != 0 && board[2][2] != 0 && board[0][2] == 0 && board[1][2] == board[2][2])	{
				move[0] = 0;
				move[1] = 2;
			}
			
			//if top right and bottom right are taken 
			else if(board[0][2] != 0 && board[2][2] != 0 && board[1][2] == 0 && board[0][2] == board[2][2])	{
				move[0] = 1;
				move[1] = 2;
			}
			
			
			
			
			
			//if top left and center are taken 
			else if(board[0][0] != 0 && board[1][1] != 0 && board[2][2] == 0 && board[0][0] == board[1][1])	{
				move[0] = 2;
				move[1] = 2;
			}
			
			//if center and bottom right are taken 
			else if(board[1][1] != 0 && board[2][2] != 0 && board[0][0] == 0 && board[1][1] == board[2][2])	{
				move[0] = 0;
				move[1] = 0;
			}
			
			//if top left and bottom right are taken 
			else if(board[0][0] != 0 && board[2][2] != 0 && board[1][1] == 0 && board[0][0] == board[2][2])	{
				move[0] = 1;
				move[1] = 1;
			}
			
			
			
			
			
			//if top right and center are taken 
			else if(board[0][2] != 0 && board[1][1] != 0 && board[2][0] == 0 && board[0][2] == board[1][1])	{
				move[0] = 2;
				move[1] = 0;
			}
			
			//if center and bottom left are taken 
			else if(board[1][1] != 0 && board[2][0] != 0 && board[0][2] == 0 && board[1][1] == board[2][0])	{
				move[0] = 0;
				move[1] = 2;
			}
			
			//if top right and bottom left are taken 
			else if(board[0][2] != 0 && board[2][0] != 0 && board[1][1] == 0 && board[0][2] == board[2][0])	{
				move[0] = 1;
				move[1] = 1;
			}
			
			
			
			//if none of the if statements above trigger, that means that the bot does not need to play defense,
			//(which likely means it's going first) and can play offensive
			
			
			else if(GameController.game.isLegalMove(lastMove[0] + 1, lastMove[1] + 1) == true)	{
				move[0] = lastMove[0] + 1;
				move[1] = lastMove[1] + 1;
			}
			
			else if(GameController.game.isLegalMove(lastMove[0] - 1, lastMove[1] - 1) == true)	{
				move[0] = lastMove[0] - 1;
				move[1] = lastMove[1] - 1;
			}
			
			else if(GameController.game.isLegalMove(lastMove[0] + 1, lastMove[1] - 1) == true)	{
				move[0] = lastMove[0] + 1;
				move[1] = lastMove[1] - 1;
			}
			
			else if(GameController.game.isLegalMove(lastMove[0] - 1, lastMove[1] + 1) == true)	{
				move[0] = lastMove[0] - 1;
				move[1] = lastMove[1] + 1;
			}
			
			else if(GameController.game.isLegalMove(lastMove[0], lastMove[1] - 1) == true)	{
				move[0] = lastMove[0];
				move[1] = lastMove[1] - 1;
			}
			
			else if(GameController.game.isLegalMove(lastMove[0], lastMove[1] + 1) == true)	{
				move[0] = lastMove[0];
				move[1] = lastMove[1] + 1;
			}
			
			else if(GameController.game.isLegalMove(lastMove[0] - 1, lastMove[1]) == true)	{
				move[0] = lastMove[0] - 1;
				move[1] = lastMove[1];
			}
			
			else if(GameController.game.isLegalMove(lastMove[0] + 1, lastMove[1]) == true)	{
				move[0] = lastMove[0] + 1;
				move[1] = lastMove[1];
			}
			
		}
				
		lastMove[0] = move[0];
		lastMove[1] = move[1];
			
			
		return move;
	}
	
}
