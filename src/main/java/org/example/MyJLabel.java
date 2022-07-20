package implementation;

import javax.swing.JLabel;

public class MyJLabel extends JLabel {
	private int xCoord;
	private int yCoord;
	
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
