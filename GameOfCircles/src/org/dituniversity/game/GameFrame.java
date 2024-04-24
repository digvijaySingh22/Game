package org.dituniversity.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public GameFrame() {
		new BorderLayout();
		Board board =new Board();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Game of Circles");
		this.setSize(1500,900);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(board);
		this.setVisible(true);
	}
	public static void gameStart() {
		new GameFrame();
	}
	public static void main(String[] args) {
		gameStart();
	}

}
