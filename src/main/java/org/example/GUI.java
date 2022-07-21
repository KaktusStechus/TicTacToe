package org.example;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI {
	
	private JPanel gameField;
	private ImageIcon imageX;
	private ImageIcon imageO;
	private ImageIcon imageBG;
	private Logic logic;
	private JFrame window;

	public GUI(Logic logic) {
		this.logic = logic;
		try {
			imageX = new ImageIcon(Main.class.getResource("/pic_x.jpg"));
			imageO = new ImageIcon(Main.class.getResource("/pic_o.jpg"));
			imageBG = new ImageIcon(Main.class.getResource("/pic_bg.jpg"));

			window = new JFrame("Tic-Tac-Toe");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setBounds(0, 0, 200, 200);

			JPanel mainPanel = new JPanel();
			BoxLayout vertical = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
			mainPanel.setLayout(vertical);
			mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

			mainPanel.add(Box.createVerticalStrut(10));
			mainPanel.add(createCommandBar());
			mainPanel.add(Box.createVerticalStrut(10));
			mainPanel.add(createGameField());

			window.getContentPane().add(mainPanel);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
    }
	
	public void show() {
    	window.pack();
		window.setVisible(true);
	}
	
	public JPanel createCommandBar() {
		JPanel commandBar = new JPanel();
    	BoxLayout horizonal = new BoxLayout(commandBar, BoxLayout.X_AXIS);
    	commandBar.setLayout(horizonal);

		JButton newGameBtn = new JButton();
    	newGameBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
    	newGameBtn.setText("New Game");
    	newGameBtn.addActionListener(e -> {
			logic = new LogicTicTacToe();
			for (Component c : gameField.getComponents()) {
				if (c instanceof JLabel) {
					((JLabel) c).setIcon(imageBG);
					((JLabel) c).setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
				}
			}
		});
    	
    	commandBar.add(newGameBtn);
    	
    	return commandBar;
	}
	
	public JPanel createGameField() {
		gameField = new JPanel();
		GridLayout grid = new GridLayout(3, 3, 10, 10);
		gameField.setLayout(grid);
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				final int xCoord = x;
				final int yCoord = y;
				JLabel label = new MyJLabel(xCoord, yCoord);
				label.setIcon(imageBG);
				label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
				label.addMouseListener(new MouseListener() {					
					@Override
					public void mouseReleased(MouseEvent e) {}					
					@Override
					public void mousePressed(MouseEvent e) {}					
					@Override
					public void mouseExited(MouseEvent e) {}					
					@Override
					public void mouseEntered(MouseEvent e) {}					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!logic.isGameOver() && logic.makeTurn(xCoord, yCoord)){							
							if(logic.getCurrentPlayer() == Player.O){
								label.setIcon(imageX);
							}
							else if(logic.getCurrentPlayer() == Player.X){
								label.setIcon(imageO);
							}
						} 		
						if (logic.isGameOver() && logic.getCurrentPlayer() == Player.O){
							markVictoryFields(Color.GREEN, Player.X);
						} else if (logic.isGameOver() && logic.getCurrentPlayer() == Player.X){
							markVictoryFields(Color.RED, Player.O);							
						}			
					}

					private void markVictoryFields(Color color, Player player) {
						int[][] victoryFieldCoords = logic.checkVictoryCondition(player);
						for(int[] i : victoryFieldCoords){
							for (Component c : gameField.getComponents()) {
								if (c instanceof MyJLabel && ((MyJLabel) c).getXCoord() == i[0] && ((MyJLabel) c).getYCoord() == i[1]) {
									((JLabel) c).setBorder(BorderFactory.createLineBorder(color, 5));
								}
							}
						}
					}	
				});
				gameField.add(label);
			}
		}
		
		return gameField;
	}
}
