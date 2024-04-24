package org.dituniversity.game.live;
import javax.swing.ImageIcon;
public class Enemy extends Live {
	
	public Enemy(int x,int speed) {
		w=150;
		h=150;
		this.x=x;
		this.speed=speed;
		y=20;
		image=new ImageIcon(Player.class.getResource("Enemy.png"));
	}
	public void move() {
		if(y>600) {
			y=-50 + (int)(Math.random() * 51);
		}
		y=y+speed;
	}
	
}
