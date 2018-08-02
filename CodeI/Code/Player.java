import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player implements GameConstants {
private int x;
private int y;
private int w ;
private int h;
private Image image;
private int playerDelay;
private int speed;
private int force;
private boolean isJump ;
private final int GRAVITY = 1;

public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
Player(){
	x = 100;
	speed = 0;
	image = new ImageIcon(Player.class.getResource(PLAYER_IMAGE)).getImage();
	w = h = 200;
	y = FLOOR - h;
}
public void move(){
	x+=speed;
}
public void jump(){
	if(!isJump){
	force = -20;
	y+=force;
	isJump  = true;
	}
}
public void fall(){
	if(y>=FLOOR - h){
		isJump = false;
		y = FLOOR - h;
		return;
	}
	force +=GRAVITY;
	y+=force;
}

public void drawPlayer(Graphics g){
	g.drawImage(image, x, y,w,h, null);
	move();
//	if(playerDelay>=2){
//	g.drawImage(image, x, y,w,h, null);
//	playerDelay=0;
//	}
//	else{
//		playerDelay++;
//	}
	//System.out.println();
}

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



}
