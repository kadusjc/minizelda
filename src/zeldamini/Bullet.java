package zeldamini;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

public class Bullet extends Rectangle implements Serializable{

	private static final long serialVersionUID = 652636710177128480L;
	
	public int dir = 1;
	public int speed = 8;
	
	public int frames = 0;
	
	public Bullet(int x, int y, int dir) {
		super(x+16, y+16, 10, 10);
		this.dir = dir;
	}
	
	public void tick() {
		x += speed * dir;
		frames++;
		//Se passou 1 segundo de renderizacao
		if (frames == 60) {
			Player.bullets.remove(this);
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
}
