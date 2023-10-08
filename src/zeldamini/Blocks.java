package zeldamini;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle {

	private static final long serialVersionUID = -2901616582849126631L;
	
	public static final Integer WIDTH = 32;
	public static final Integer HEIGHT = 32;
	
	public Blocks (int x, int y) {
		super(x,y, WIDTH, HEIGHT);
	}
	
	public void render(Graphics g) {
		/*g.setColor(Color.magenta);
		g.fillRect(x,  y, width, height);
		
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);*/
		g.drawImage(Spritesheet.tileWall, x, y, WIDTH, HEIGHT, null);
	}
}
