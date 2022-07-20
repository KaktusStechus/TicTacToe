package org.example;

import javax.swing.JLabel;

public class MyJLabel extends JLabel {
	private final int xCoord;
	private final int yCoord;
	
	public MyJLabel(int x, int y) {
		xCoord = x;
		yCoord = y;
	}
	
	public int getXCoord() {
		return xCoord;
	}
	
	public int getYCoord() {
		return yCoord;
	}
}
