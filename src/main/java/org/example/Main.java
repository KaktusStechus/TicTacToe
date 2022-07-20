package org.example;

public class Main {

	/*
	 * This is the Main class with the main method... yay!
	 */
    public static void main(String[] args) {
    	Logic logic = new LogicTicTacToe();
    	GUI gui = new GUI(logic);
    	gui.show();
    }
}
