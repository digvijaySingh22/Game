package org.dituniversity.game.live;

import javax.swing.ImageIcon;

public class Player extends Live{
	
	public Player() {
		w=120;
		h=120;
		x=570;
		y=550;
		image=new ImageIcon(Player.class.getResource("Player.png"));
	}
	public void move() {
		 x=x+speed;
	}
	
}
