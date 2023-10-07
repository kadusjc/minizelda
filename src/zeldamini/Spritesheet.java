package zeldamini;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	
	public static BufferedImage[] playerFront;
	
	public static BufferedImage tileWall;
	
	public Spritesheet () {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
			playerFront = Spritesheet.createPlayerSprites();
			tileWall = Spritesheet.getSprite(276, 184, 16, 16);
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	public static BufferedImage[] createPlayerSprites() {
		BufferedImage [] playerFront = new  BufferedImage[2];
		playerFront[0] = spritesheet.getSubimage(0, 11, 16, 16);
		playerFront[1] = spritesheet.getSubimage(16, 11, 16, 16);
		return playerFront;
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
