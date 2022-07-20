package org.example;

public class LogicTicTacToe extends Logic {
	
	public LogicTicTacToe(){
		board = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
		currentPlayer = Player.X;
		gameOver = false;
	}

	public boolean makeTurn(int x, int y) {
		if(!board[x][y].equals("-")){
			return false;
		} else {
			if(currentPlayer == Player.X){
				board[x][y] = "X";
				if(checkVictoryCondition(Player.X) != null){
					gameOver = true;
				}
				currentPlayer = Player.O;
			} else {
				board[x][y] = "O";
				if(checkVictoryCondition(Player.O) != null){
					gameOver = true;
				}
				currentPlayer = Player.X;
			}	
			return true; 
		}
	}

	public int[][] checkVictoryCondition(Player player){
		if(board[0][0].equals(player.toString()) && board[1][1].equals(player.toString()) && board[2][2].equals(player.toString()))
			return new int[][]{{0,0},{1,1},{2,2}};
		else if(board[0][2].equals(player.toString()) && board[1][1].equals(player.toString()) && board[2][0].equals(player.toString()))
			return new int[][]{{0,2},{1,1},{2,0}};
		else {
			for (int i = 0; i<3; i++){
				if (board[0][i].equals(player.toString()) && board[1][i].equals(player.toString()) && board[2][i].equals(player.toString()))
					return new int[][]{{0,i},{1,i},{2,i}};
				else if (board[i][0].equals(player.toString()) && board[i][1].equals(player.toString()) && board[i][2].equals(player.toString()))
					return new int[][]{{i,0},{i,1},{i,2}};
			}
		}
		return null;		
	}
}
