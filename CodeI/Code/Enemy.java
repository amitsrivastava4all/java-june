import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy implements GameConstants {
	private int x;
	private int y;
	private int w ;
	private int h;
	private int speed;
	private Image image;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	Enemy(){
		speed =-2;
		x = GWIDTH - 200;
		image = new ImageIcon(Player.class.getResource(ENEMY_IMAGE)).getImage();
		w = h = 200;
		y = FLOOR - h;
	}
	public void move(){
		if(x<0){
			x = GWIDTH ;
			speed*=2;
		}
		x+=speed;
	}
	public void drawEnemy(Graphics g){
		g.drawImage(image, x, y,w,h, null);
		move();

	}
	
}
