package opponents;
import game.GameController;
import game.TicTacToePlayer;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.w3c.dom.html.HTMLTableRowElement;

public class HuskDestroyer3000 extends TicTacToePlayer
{
    public HuskDestroyer3000(String name, int piece) {
		super(name, piece); 
	}  

    public int[] playTurn() {
        int turnCount = 0;
        if(GameController.getTurnCount() < 2 )
        {
            if(GameController.getTurnCount() == 0)
            {
                turnCount = 1;
            }
            else
            {
                turnCount = 2;
            }
        }
        //System.out.println("I'm going in position " + turnCount);
        int[][] board = GameController.getBoard();
		int[] move = new int[] {1, 1};
        int[] vLoss = horizontalLossPossible();
        int piece = getPiece();
        int oppPiece = 3 - getPiece();
        if(winningPiece()[0] >= 0)
        {
            //System.out.println("Taking a dub");
            move[0] = winningPiece()[0];
            move[1] = winningPiece()[1];
        }else
        {
            if(horizontalLossPossible()[0] >= 0)
            {
                move[0] = horizontalLossPossible()[0];
                move[1] = horizontalLossPossible()[1];
            }
            
            else
            {
               

                if(board[1][1] == 0)
                {
                    move[0] = 1;
                    move[1] = 1;
                }
                else if(board[0][1] == 0 && board[2][1] == 0)
                {
                    move[0] = 0;
                    move[1] = 1;
                }
                else if(board[1][0] == 0 && board[1][2] == 0)
                {
                    move[0] = 1;
                    move[1] = 0;
                }
                else if(board[1][2] == 0 && board[1][0] == 0)
                {
                    move[0] = 1;
                    move[1] = 2;
                }
                else if(board[2][1] == 0 && board[0][1] == 0)
                {
                    move[0] = 2;
                    move[1] = 1;
                }else if(board[0][0] == 0 && board[2][2] == 0)
                {
                    move[0] = 0;
                    move[1] = 0;
                }
                else if(board[0][2] == 0 && board[2][0] == 0)
                {
                    move[0] = 0;
                    move[1] = 2;
                }
                 
                //Blocks configurations where the opponnent can 
                //Place one peice and threaten 2 wins at once
                if(board[1][0] == oppPiece && board[0][1] == oppPiece && board[0][0] == 0)
                {
                    move[0] = 0;
                    move[1] = 0;
                }
                else if(board[0][1] == oppPiece && board[1][2] == oppPiece && board[0][2] == 0)
                {
                    move[0] = 0;
                    move[1] = 0;
                }
                else if(board[1][2] == oppPiece && board[2][1] == oppPiece && board[2][2] == 0)
                {
                    move[0] = 2;
                    move[1] = 2;
                }
                else if(board[2][1] == oppPiece && board[1][0] == oppPiece && board[2][0] == 0)
                {
                    move[0] = 2;
                    move[1] = 0;
                }
    
                    else
                    {
                        while(board[move[0]][move[1]] != 0)
                        {
                            move[0] = (int) (Math.random() * 3);
                            move[1] = (int) (Math.random() * 3);
                        }
                    }
                
            }
        }
        if(winningPiece()[0] >= 0)
        {
            //System.out.println("Taking a dub");
            move[0] = winningPiece()[0];
            move[1] = winningPiece()[1];
        }
        //move[0] = 1;
        //move[1] = 2;
        //System.out.println("moving to " + move[0] + ", " + move[1]);
		return move;
	}

    private int[] horizontalLossPossible()
    {
        int[][] board = GameController.game.getBoard();
        int piece = getPiece();

        int oppPiece = 3 - piece;

        //Checks for a horizontal loss
        for(int i = 0; i < 3; i++)
        {
            if(board[i][0] == oppPiece && board[i][1] == oppPiece && board[i][2] == 0)
            {
                //System.out.println("loss row 2");
                return new int[] {i, 2};
            }
            else if(board[i][1] == oppPiece && board[i][2] == oppPiece && board[i][0] == 0)
            {
                //System.out.println("loss row 0");
                return new int[] {i, 0};
            }
            else if(board[i][0] == oppPiece && board[i][2] == oppPiece && board[i][1] == 0)
            {
                //System.out.println("Loss row 1");
                return new int[] {i, 1};
            }
        }

        //Checks for a vertical loss
        for(int i = 0; i < 3; i++)
        {
            if(board[0][i] == oppPiece && board[1][i] == oppPiece && board[2][i] == 0)
            {
                //System.out.println("loss column 2");
                return new int[] {2, i};
            }
            else if(board[1][i] == oppPiece && board[2][i] == oppPiece && board[0][i] == 0)
            {
                //System.out.println("loss column 0");
                return new int[] {0, i};
            }
            else if(board[0][i] == oppPiece && board[2][i] == oppPiece && board[1][i] == 0)
            {
                //System.out.println("Loss column 1");
                return new int[] {1, i};
            }
        }

        //Checks for a diagonal loss
        if(board[0][0] == oppPiece && board[1][1] == oppPiece && board[2][2] == 0)
        {
            //System.out.println("DLoss");
            return new int[] {2, 2};
        }
        else if (board[0][0] == oppPiece && board[2][2] == oppPiece && board[1][1] == 0)
        {
            //System.out.println("DLoss");
            return new int[] {1, 1};
        }else if (board[1][1] == oppPiece && board[2][2] == oppPiece && board[0][0] == 0)
        {
            //System.out.println("DLoss");
            return new int[] {0, 0};
        }
        else if(board[0][2] == oppPiece && board[1][1] == oppPiece && board[2][0] == 0)
        {
            //System.out.println("DLoss");
            return new int[] {2, 0};
        }
        else if (board[0][2] == oppPiece && board[2][0] == oppPiece && board[1][1] == 0)
        {
            //System.out.println("DLoss");
            return new int[] {1, 1};
        }else if (board[1][1] == oppPiece && board[2][0] == oppPiece && board[0][2] == 0)
        {
            //System.out.println("DLoss");
            return new int[] {0, 2};
        }

        //System.out.println("No Loss");
        //GameController.game.printBoard();
        return new int[] {-1, -1};
    }

    private int[] winningPiece()
    {
        int[][] board = GameController.game.getBoard();
        int piece = getPiece();

        //System.out.println("My piece is " + piece);
        //Checks if horizontal win is possible, if yes makes winning move
        for(int i = 0; i < 3; i++)
        {
            if(board[i][0] == piece && board[i][1] == piece && board[i][2] == 0)
            {
                //System.out.println("Dub row " + i);
                return new int[] {i, 2};
            }
            else if(board[i][1] == piece && board[i][2] == piece && board[i][0] == 0)
            {
                if(board[i][1] == piece)
                {
                    //System.out.println("I have a piece at " + i + ", " + 1);
                    //System.out.println("My piece is " + piece);
                }
                //System.out.println("Dub row " + i);
                return new int[] {i, 0};
            }
            else if(board[i][0] == piece && board[i][2] == piece && board[i][1] == 0)
            {
                //System.out.println("Dub row " + i);
                return new int[] {i, 1};
            }else if(board[1][0] == piece && board[1][1] == piece && board[1][2] == 0)
            {
                //System.out.println("Fixed it");
                return new int[] {1, 2};
            }
        }

        //Checks if a win is possible vertically
        for(int i = 0; i < 3; i++)
        {
            if(board[0][i] == piece && board[1][i] == piece && board[2][i] == 0)
            {
                //System.out.println("dub column 2");
                return new int[] {2, i};
            }
            else if(board[1][i] == piece && board[2][i] == piece && board[0][i] == 0)
            {
                //System.out.println("Dub column 0");
                return new int[] {0, i};
            }
            else if(board[0][i] == piece && board[2][i] == piece && board[1][i] == 0)
            {
                //System.out.println("Dub column 1");
                return new int[] {1, i};
            }
        }

        //Checks for a diagonal dub
        if(board[0][0] == piece && board[1][1] == piece && board[2][2] == 0)
        {
            return new int[] {2, 2};
        }
        else if (board[0][0] == piece && board[2][2] == piece && board[1][1] == 0)
        {
            return new int[] {1, 1};
        }else if (board[1][1] == piece && board[2][2] == piece && board[0][0] == 0)
        {
            return new int[] {0, 0};
        }
        else if(board[0][2] == piece && board[1][1] == piece && board[2][0] == 0)
        {
            return new int[] {2, 0};
        }
        else if (board[0][2] == piece && board[2][0] == piece && board[1][1] == 0)
        {
            return new int[] {1, 1};
        }else if (board[1][1] == piece && board[2][0] == piece && board[0][2] == 0)
        {
            return new int[] {0, 2};
        }
        return new int[] {-1, 1};
    }
}
