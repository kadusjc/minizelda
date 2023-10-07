
package zeldamini;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	public static List<Blocks> blocks;
	
	public static final int BLOCKS_TOTAL = (int) Game.WIDTH/Blocks.WIDTH;
	public World() {
		
		blocks = new ArrayList<Blocks>();
		
		//Preenchendo com blocos em cima
		for ( int i = 0; i < BLOCKS_TOTAL; i++) {
			blocks.add(new Blocks(i * 32, 0));
		}
		
		//Preenchendo com blocos embaixo
		for ( int i = 0; i < BLOCKS_TOTAL; i++) {
			blocks.add(new Blocks(i * 32, Game.WIDTH-Blocks.WIDTH));
		}
		
		//Preenchendo com blocos nas laterais
		for ( int i = 0; i < BLOCKS_TOTAL; i++) {
			blocks.add(new Blocks(0, i*Blocks.WIDTH));
		}
		
		for ( int i = 0; i < BLOCKS_TOTAL; i++) {
			blocks.add(new Blocks(Game.WIDTH-Blocks.WIDTH, i*Blocks.WIDTH));
		}
	}
	
	public static boolean isCollidedWith(int x, int y){
		
		Rectangle playerPosition = new Rectangle(x, y, Player.WIDTH, Player.HEIGHT);
		for (Blocks block : blocks) {
			if (block.intersects(playerPosition)) return true;
		}
		return false;
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < blocks.size(); i++) {
			Blocks block = blocks.get(i);
			block.render(g);
		}
		
	}

}
