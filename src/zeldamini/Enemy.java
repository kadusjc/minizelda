package zeldamini;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle implements Serializable {

	private static final long serialVersionUID = -8519257606945002403L;
	public static final Integer WIDTH = 32;
	public static final Integer HEIGHT = 32;

	public int life = 3;
	public int currAnimation = 0;  
	public int currFrames = 0;
	public int targetFrames = 60/4; //15s 
			
	public int speed = 2;
	public int right = 1, up = 0, down = 0, left = 0;
	public boolean shoot = false;
	public int dir = 1;
	
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	
	public Enemy (int x, int y) {
		super(x,y, WIDTH, HEIGHT);
	}
	
	public void followPlayer() {
		Player player = Game.player;
		if (x < player.x && !World.isCollidedWith(x+speed, y)) {
			if (new Random().nextInt(100) > 50) x+= speed;
			
		} else if (x > player.x && !World.isCollidedWith(x-speed, y)) {
			if (new Random().nextInt(100) > 60) x-= speed;
		}
		
		if (y < player.y && !World.isCollidedWith(x, y+speed)) {
			if (new Random().nextInt(100) > 55) y+= speed;
			
		} else if (y > player.y && !World.isCollidedWith(x, y-speed)) {
			if (new Random().nextInt(100) > 62) y-= speed;
		}
	}
	
	
	public void tick() {
		followPlayer();
		
		//if (isMoving) runAnimation();
		for(int i = 0; i < Player.bullets.size(); i++) { 
			Bullet bullet = Player.bullets.get(i);
			bullet.tick();
			
			if (bullet.intersects(this)) {
				System.out.println("Acertou a bala no maluco");
				Player.bullets.remove(bullet);
				this.life --;
				if (life == 0) Game.enemies.remove(this);
			}
		}
	}

	@SuppressWarnings("unused")
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
		g.drawImage(Spritesheet.enemyFront[currAnimation], x, y, WIDTH, HEIGHT, null);
		for(int i = 0; i < bullets.size(); i++) { bullets.get(i).render(g); }
	}

}
