package org.dituniversity.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.dituniversity.game.live.Enemy;
import org.dituniversity.game.live.Player;

public class Board extends JPanel{
	Timer timer;
	BufferedImage backgroundImage;
	Player player;
	Enemy enemies[]=new Enemy[5];
	
	ScoreCard scorecard = new ScoreCard();
	public Board() {
		new BorderLayout();
		setSize(1500,900);
		loadBackgroundImage();
		player = new Player();
		loadEnemies();
		gameLoop();
		bindEvents();
		setFocusable(true);
		add(scorecard,BorderLayout.NORTH);
	}
	private void gameOver(Graphics pen) {
		for(Enemy enemy:enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("Yatra One",Font.BOLD,40));
				pen.setColor(Color.BLACK);
				pen.drawString("Game Over!",530, 300);
				
				timer.stop();
				scorecard.stopScoring();	
			}
		}
	}
	private boolean isCollide(Enemy enemy) {
		int xDistance=Math.abs(player.x-enemy.x);
		int yDistance=Math.abs(player.y-enemy.y);
		int maxH=Math.max(player.h,enemy.h);
		int maxW=Math.max(player.w,enemy.w);
		return xDistance<=maxW-75 && yDistance<=maxH-75; 
	}
	
	private void bindEvents() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					player.speed =10;
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					player.speed=-10;
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					player.speed =10;
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					player.speed=-10;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				player.speed=0;
			}
		});
	}
	private void gameLoop() {
		timer=new Timer(50,(e)-> repaint());
		timer.start();
	}
	private void loadEnemies() {
		int x=50;
		int gap=250;
		int speed=2 + (int)(Math.random() * 2);
		for(int i=0;i<enemies.length;i++) {
			enemies[i]=new Enemy(x,speed);
			x=x+gap;
			speed=speed+3+ (int)(Math.random() * 3);
		}
	}
	private void loadBackgroundImage() {
		try {
			backgroundImage=ImageIO.read(Board.class.getResource("background4.png"));
		} catch (IOException e) {
			System.out.println("Backgoround was not found");
			System.exit(1);
			e.printStackTrace();
		}
	}
	private void printEnemies(Graphics pen) {
		for(Enemy enemy:enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);//clean up
		pen.drawImage(backgroundImage,0,0,1275,700,null);
		player.draw(pen);
		player.move();
		printEnemies(pen);
		gameOver(pen);
	}
}
