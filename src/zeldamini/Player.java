package zeldamini;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle implements Serializable {

	private static final long serialVersionUID = -8519257606945002403L;
	public static final Integer WIDTH = 32;
	public static final Integer HEIGHT = 32;

	public int currAnimation = 0;  
	public int currFrames = 0;
	public int targetFrames = 60/4; //15s 
			
	public int speed = 4;
	public boolean right, up, down, left;
	public boolean shoot = false;
	public int dir = 1;
	
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	
	public Player (int x, int y) {
		super(x,y, WIDTH, HEIGHT);
	}
	
	public void tick() {
		boolean isMoving = false;
		if ( right && !World.isCollidedWith(x+speed, y)) { x+= speed; isMoving = true; dir = 1; }
		else if ( left && !World.isCollidedWith(x-speed, y)) { x-= speed; isMoving = true; dir = -1; }
		else if ( up && !World.isCollidedWith(x, y-speed)) { y-= speed; isMoving = true; }
		else if ( down && !World.isCollidedWith(x, y+speed)) {  y+= speed; isMoving = true; }
		else if (!right && !left && !up && !down && shoot) { shoot = false; bullets.add(new Bullet(x,y,dir)); }
		
		if (isMoving) runAnimation();
		for(int i = 0; i < bullets.size(); i++) { bullets.get(i).tick(); }
	}

	private void runAnimation() {
		currFrames++;
		
		if (currFrames == targetFrames) {
			currFrames = 0;
			currAnimation++;
			
			if (currAnimation == Spritesheet.playerFront.length) {
				currAnimation = 0;
			}
		}
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x, y, WIDTH, HEIGHT);
		g.drawImage(Spritesheet.playerFront[currAnimation], x, y, WIDTH, HEIGHT, null);
		for(int i = 0; i < bullets.size(); i++) { bullets.get(i).render(g); }
	}

}
