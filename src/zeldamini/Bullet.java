package zeldamini;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

public class Bullet extends Rectangle implements Serializable{

	private static final long serialVersionUID = 652636710177128480L;
	
	public int dir = 1;
	public int speed = 8;
	
	public Bullet(int x, int y, int dir) {
		super(x, y+10, 10, 10);
		this.dir = dir;
	}
	
	public void tick() {
		x += speed * dir;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, width, height);
	}
}
