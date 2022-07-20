package org.example;

public class Main {

    public static void main(String[] args) {
    	Logic logic = new LogicTicTacToe();
    	GUI gui = new GUI(logic);
    	gui.show();
    }
}
