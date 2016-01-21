import java.awt.Font;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;


public class TicTacToe {
	
	private int move = 0;
	private int[][] board;
	private boolean cpuWin = false, playerWin = false;
	
	public TicTacToe()
	{
		
	}
	
	public static void main(String[] args)
	{
		TicTacToe app = new TicTacToe();
		app.setUp();
	}
	
	public void setUp()
	{
		// Allocate identifiers to represent game state
		//
		// Using an array of int so that summing along a row, a column or a
		// diagonal is a easy test for a win
		board = new int[3][3];
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = 0;
			}
		}

		// Setup graphics and draw empty board
		StdDraw.setPenRadius(0.02);					// draw thicker lines
		StdDraw.line(0, 0.33, 1, 0.33);
		StdDraw.line(0, 0.66, 1, 0.66);
		StdDraw.line(0.33, 0, 0.33, 1.0);
		StdDraw.line(0.66, 0, 0.66, 1.0);
		
		StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 64)); // Font SIZE!
		game();
	}
	
	public void game()
	{
		for(move = 0; move < 9; move++)
		{
			if(cpuWin)
			{
				break;
			}
			else if(playerWin)
			{
				//Could change this to print on top of game board rather than in console
				System.out.println("You won!!\n\nCongratulations!.");
				break;
			}
			else
			{
				if(move % 2 == 0)
				{
					cpuMove();
				}
				else
				{
					playerMove();
				}
			}
		}
		if(cpuWin)
		{
			//Could change this to print on top of game board rather than in console
			System.out.println("The computer won!\n\nBetter luck next time.");
		}
		if(move == 9 && !cpuWin && !playerWin)
		{
			//Could change this to print on top of game board rather than in console
			System.out.println("It's a draw!\n\nMaybe next time you'll win...");
		}
	}
	
	public void cpuMove()
	{
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Random numberGen = new Random();
		int col = 0, row = 0;
		boolean winningMoveFound = false;
		boolean winningMoveFoundInRow = false;
		boolean winningMoveFoundInColumn = false;
		boolean winningMoveFoundInDiagonal1 = false;
		boolean winningMoveFoundInDiagonal2 = false;
		boolean winningPlayerMoveFound = false;
		boolean winningPlayerMoveFoundInRow = false;
		boolean winningPlayerMoveFoundInColumn = false;
		boolean winningPlayerMoveFoundInDiagonal1 = false;
		boolean winningPlayerMoveFoundInDiagonal2 = false;
		if(move == 0)
		{
			row = numberGen.nextInt(3);
			col = numberGen.nextInt(3);
			double x = col * .33 + 0.15;
			double y = row * .33 + 0.15;
			StdDraw.text(x, y, "X" );
			board[col][row] = 1;
		}
		else
		{
			//checks columns for winning move
			for(int i = 0; i < 3; i++)
			{
				if((board[i][0] + board[i][1] + board[i][2]) == 2)
				{
					winningMoveFound = true;
					winningMoveFoundInColumn = true;
					col = i;
					break;
				}
			}
			if(!winningMoveFound)
			{
				//checks rows for winning move
				for(int i = 0; i < 3; i++)
				{
					if((board[0][i] + board [1][i] + board [2][i]) == 2)
					{
						winningMoveFound = true;
						winningMoveFoundInRow = true;
						row = i; //CHECK
						break;
					}
				}
			}
			if(!winningMoveFound)
			{
				//checks diagonals for winning move
				if((board[0][0] + board[1][1] + board[2][2]) == 2)
				{
					winningMoveFound = true;
					winningMoveFoundInDiagonal1 = true;
				}
				else if((board[2][0] + board[1][1] + board[0][2]) == 2)
				{
					winningMoveFound = true;
					winningMoveFoundInDiagonal2 = true;
				}
			}
			
			
			//checks for winning player move if no winning move for cpu available
			if(!winningMoveFound)
			{
				//checks columns for winning player move
				for(int i = 0; i < 3; i++)
				{
					if((board[i][0] + board[i][1] + board[i][2]) == -2)
					{
						winningPlayerMoveFound = true;
						winningPlayerMoveFoundInColumn = true;
						col = i;
						break;
					}
				}
				if(!winningPlayerMoveFound)
				{
					//checks rows for winning player move
					for(int i = 0; i < 3; i++)
					{
						if((board[0][i] + board [1][i] + board [2][i]) == -2)
						{
							winningPlayerMoveFound = true;
							winningPlayerMoveFoundInRow = true;
							row = i; //CHECK
							break;
						}
					}
				}
				if(!winningPlayerMoveFound)
				{
					//checks diagonals for winning player move
					if((board[0][0] + board[1][1] + board[2][2]) == -2)
					{
						winningPlayerMoveFound = true;
						winningPlayerMoveFoundInDiagonal1 = true;
					}
					else if((board[2][0] + board[1][1] + board[0][2]) == -2)
					{
						winningPlayerMoveFound = true;
						winningPlayerMoveFoundInDiagonal2 = true;
					}
				}
			}
			
			
			
			if(winningMoveFound)
			{
				if(winningMoveFoundInColumn)
				{
					if(board[col][0] == 0)
					{
						double x = col * .33 + 0.15;
						double y = 0 * .33 + 0.15;
						StdDraw.text(x, y, "X" );
						board[col][0] = 1;
					}
					else if(board[col][1] == 0)
					{
						double x = col * .33 + 0.15;
						double y = 1 * .33 + 0.15;
						StdDraw.text(x, y, "X" );
						board[row][1] = 1;
					}	
					else if(board[col][2] == 0)
					{
						double x = col * .33 + 0.15;
						double y = 2 * .33 + 0.15;
						StdDraw.text(x, y, "X" );
						board[col][2] = 1;
					}	
				}
				if(winningMoveFoundInRow)
				{
					if(board[0][row] == 0)
					{
						double x = 0 * .33 + .15;
						double y = row * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[0][row] = 1;
					}
					if(board[1][row] == 0)
					{
						double x = 1 * .33 + .15;
						double y = row * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[1][row] = 1;
					}
					if(board[2][row] == 0)
					{
						double x = 2 * .33 + .15;
						double y = row * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[2][row] = 1;
					}
				}
				if(winningMoveFoundInDiagonal1)
				{
					if(board[0][0] == 0)
					{
						double x = 0 * .33 + .15;
						double y = 0 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[0][0] = 1;
					}
					if(board[1][1] == 0)
					{
						double x = 1 * .33 + .15;
						double y = 1 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[1][1] = 1;
					}
					if(board[2][2] == 0)
					{
						double x = 2 * .33 + .15;
						double y = 2 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[2][2] = 1;
					}
				}
				if(winningMoveFoundInDiagonal2)
				{
					if(board[2][0] == 0)
					{
						double x = 2 * .33 + .15;
						double y = 0 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[2][0] = 1;
					}
					if(board[1][1] == 0)
					{
						double x = 1 * .33 + .15;
						double y = 1 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[1][1] = 1;
					}
					if(board[0][2] == 0)
					{
						double x = 0 * .33 + .15;
						double y = 2 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[0][2] = 1;
					}
				}
				cpuWin = true;
			}
			
			
			if(winningPlayerMoveFound)
			{
				if(winningPlayerMoveFoundInColumn)
				{
					if(board[col][0] == 0)
					{
						double x = col * .33 + 0.15;
						double y = 0 * .33 + 0.15;
						StdDraw.text(x, y, "X" );
						board[col][0] = 1;
					}
					else if(board[col][1] == 0)
					{
						double x = col * .33 + 0.15;
						double y = 1 * .33 + 0.15;
						StdDraw.text(x, y, "X" );
						board[row][1] = 1;
					}	
					else if(board[col][2] == 0)
					{
						double x = col * .33 + 0.15;
						double y = 2 * .33 + 0.15;
						StdDraw.text(x, y, "X" );
						board[col][2] = 1;
					}	
				}
				if(winningPlayerMoveFoundInRow)
				{
					if(board[0][row] == 0)
					{
						double x = 0 * .33 + .15;
						double y = row * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[0][row] = 1;
					}
					if(board[1][row] == 0)
					{
						double x = 1 * .33 + .15;
						double y = row * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[1][row] = 1;
					}
					if(board[2][row] == 0)
					{
						double x = 2 * .33 + .15;
						double y = row * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[2][row] = 1;
					}
				}
				if(winningPlayerMoveFoundInDiagonal1)
				{
					if(board[0][0] == 0)
					{
						double x = 0 * .33 + .15;
						double y = 0 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[0][0] = 1;
					}
					if(board[1][1] == 0)
					{
						double x = 1 * .33 + .15;
						double y = 1 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[1][1] = 1;
					}
					if(board[2][2] == 0)
					{
						double x = 2 * .33 + .15;
						double y = 2 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[2][2] = 1;
					}
				}
				if(winningPlayerMoveFoundInDiagonal2)
				{
					if(board[2][0] == 0)
					{
						double x = 2 * .33 + .15;
						double y = 0 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[2][0] = 1;
					}
					if(board[1][1] == 0)
					{
						double x = 1 * .33 + .15;
						double y = 1 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[1][1] = 1;
					}
					if(board[0][2] == 0)
					{
						double x = 0 * .33 + .15;
						double y = 2 * .33 + .15;
						StdDraw.text(x, y, "X" );
						board[0][2] = 1;
					}
				}
			}
			
			
			//random move if no winning move can be found
			if(!winningMoveFound && !winningPlayerMoveFound)
			{
				boolean validMove = false;
				while(!validMove)
				{
					col = numberGen.nextInt(3);
					row = numberGen.nextInt(3);
					if(board[col][row] == 0)
					{
						double x = col * .33 + 0.15;
						double y = row * .33 + 0.15;
						StdDraw.text(x, y, "X" );
						board[col][row] = 1;
						validMove = true;
					}
				}
			}	
		}
	}
	
	public void playerMove()
	{
		boolean mousePressed = false;
		 int col = 5, row = 5;
		 
        do {

            if (StdDraw.mousePressed()) {

                col = (int) (StdDraw.mouseX() * 3);	

                row = (int) (StdDraw.mouseY() * 3);

                mousePressed = true;

            }

        }while(!mousePressed || board[col][row] != 0);

        board[col][row] = -1;   // valid move (empty slot)
        double x = col * .33 + 0.15;
        double y = row * .33 + 0.15;
        StdDraw.text(x, y, "O" );
        
        for(int i = 0; i < 3; i++)
        {
        	if((board[i][0] + board[i][1] + board[i][2]) == -3)
        	{
        		playerWin = true;
        	}
        	if((board[0][i] + board[1][i] + board[2][i]) == -3)
        	{
        		playerWin = true;
        	}
        }
        if((board[0][0] + board[1][1] + board[2][2]) == -3)
        {
        	playerWin = true;
        }
        if((board[0][2] + board [1][1] + board[2][0]) == -3)
        {
        	playerWin = true;
        }
	}

}
