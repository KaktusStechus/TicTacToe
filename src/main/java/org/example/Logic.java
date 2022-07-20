package implementation;

public abstract class Logic {


	protected String[][] board;			// unser logisches Spielbrett, Felder werden standardmäßig mit "-" besetzt
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
	 * Ist ein Feld bereits besetzt, wird false zurückgegeben.
	 * Ansonsten wird das Symbol des aktuellen Spielers in das jeweilige Feld gesetzt.
	 * Danach werden die Siegesbedingungen geprüft, und gameOver, wenn nötig, auf true gesetzt.
	 * Im anschluss wird der aktuelle Spieler gewechselt und true zurückgegeben.
	 */
	public abstract boolean makeTurn(int x, int y);
	
	/*
	 * Die Siegesbedingungen hängen von dem jeweiligen Spiel ab (Drei Gewinnt, Vier in einer Reihe, etc.)
	 * Sind die Siegesbedingungen erfüllt, wird ein int Array mit den Koordinaten der siegreichen Felder zurückgegeben.
	 * Dieser wird von der GUI verwendet um die Felder zu markieren.
	 * Ansonsten wird null zurückgegeben.
	 */
	public abstract int[][] checkVictoryCondition(Player player);
}
