package org.example;

public abstract class Logic {


	protected String[][] board;			// unser logisches Spielbrett, Felder werden standardm��ig mit "-" besetzt
	protected Player currentPlayer;		// aktueller Spieler, X oder O
	protected boolean gameOver;			// true wenn das Spiel zu ende ist
	
	public String[][] getBoard() {
		return board;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean isGameOver(){
		return gameOver;
	}
	
	/*
	 * Ist ein Feld bereits besetzt, wird false zur�ckgegeben.
	 * Ansonsten wird das Symbol des aktuellen Spielers in das jeweilige Feld gesetzt.
	 * Danach werden die Siegesbedingungen gepr�ft, und gameOver, wenn n�tig, auf true gesetzt.
	 * Im anschluss wird der aktuelle Spieler gewechselt und true zur�ckgegeben.
	 */
	public abstract boolean makeTurn(int x, int y);
	
	/*
	 * Die Siegesbedingungen h�ngen von dem jeweiligen Spiel ab (Drei Gewinnt, Vier in einer Reihe, etc.)
	 * Sind die Siegesbedingungen erf�llt, wird ein int Array mit den Koordinaten der siegreichen Felder zur�ckgegeben.
	 * Dieser wird von der GUI verwendet um die Felder zu markieren.
	 * Ansonsten wird null zur�ckgegeben.
	 */
	public abstract int[][] checkVictoryCondition(Player player);
}
