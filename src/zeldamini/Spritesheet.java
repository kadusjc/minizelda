package zeldamini;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	
	public static BufferedImage[] playerFront;
	
	public static BufferedImage[] enemyFront;
	
	public static BufferedImage tileWall;
	
	public Spritesheet () {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
			playerFront = Spritesheet.createPlayerSprites();
			enemyFront = Spritesheet.createEnemySprites();
			tileWall = Spritesheet.getSprite(279, 240, 16, 16);
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

	public static BufferedImage[] createEnemySprites() {
		BufferedImage [] enemyFront = new  BufferedImage[2];
		enemyFront[0] = spritesheet.getSubimage(277, 213, 16, 16);
		enemyFront[1] = spritesheet.getSubimage(295, 213, 16, 16);
		return enemyFront;
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
