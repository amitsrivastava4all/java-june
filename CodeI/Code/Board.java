import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants{
	Image image;
	Timer timer ;
	Player player ;
	Enemy enemy;
	
	
	private void gameLoop(){
		timer = new Timer(DELAY,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint(); // Call PaintComponent
				player.fall();
				
			}
		});
		timer.start();
	}
	
public Board(){
	 image = new ImageIcon(Board.class.getResource(BACKGROUND_IMAGE)).getImage();
	player = new Player();
	enemy = new Enemy();
	setFocusable(true);
	bindEvents();
	 this.setSize(GWIDTH, GHEIGHT);
	gameLoop();
}

public void gameOver(Graphics g){
	g.setColor(Color.YELLOW);
	g.setFont(new Font("Arial", Font.BOLD, 32));
	g.drawString("GAME OVER", 300, 500);
}

public void bindEvents(){
	this.addKeyListener(new KeyAdapter() {
		
		
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.setSpeed(0);
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyPress = e.getKeyCode();
			if(keyPress==KeyEvent.VK_RIGHT){
				player.setSpeed(5);
			}
			else if(keyPress==KeyEvent.VK_LEFT){
				player.setSpeed(-5);
			}
			else
			if(keyPress==KeyEvent.VK_SPACE){	
				player.jump();
			}
			
		}
	});
}

public boolean isCollide(){
	int xDistance = Math.abs(player.getX() - enemy.getX());
	int yDistance = Math.abs(player.getY() - enemy.getY());
	int maxW = Math.max(player.getW(), enemy.getW());
	int maxH = Math.max(player.getH(), enemy.getH());
	return xDistance<=(maxW-50) && yDistance<=(maxH-50);
			
}

@Override
public void paintComponent(Graphics g){
	g.drawImage(image, 0, 0, GWIDTH, GHEIGHT, null);
	player.drawPlayer(g);
	enemy.drawEnemy(g);
	if(isCollide()){
		gameOver(g);
		timer.stop();
	}
	//System.out.println("PAINT");
}
}
